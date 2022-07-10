CREATE OR REPLACE FUNCTION public.multiweekseasonalforecast(_requestedweek integer, _weeks integer)
 RETURNS void
 LANGUAGE plpgsql
AS $function$
DECLARE RequestedWeekStartDate DATE;
        PreviousWeek           INTEGER;
BEGIN

    SELECT INTO RequestedWeekStartDate ForecastWeekToDate(_RequestedWeek);

    SELECT INTO PreviousWeek ForecastWeekAdd(-1, _RequestedWeek);

    DELETE
    FROM   zipcodebestmodelseasonalforecast ZBMSF
    WHERE  ZBMSF.forecastrunweek = _RequestedWeek;

    /*
    WITH ForecastWeekSeriesRaw AS (SELECT DateToForecastWeek(TheDate::DATE)                                  AS ForecastWeek,
                                          TheDate - (EXTRACT(DOW FROM TheDate) * INTERVAL '1 Day')           AS WeekStartDate,
                                          TheDate + ((6 - EXTRACT(DOW FROM TheDate)) * INTERVAL '1 Day')     AS WeekEndDate,       
                                          LEFT(DateToForecastWeek(TheDate::DATE)::VARCHAR, 4)::INTEGER       AS ForecastWeekYear,      
                                          RIGHT(DateToForecastWeek(TheDate::DATE)::VARCHAR, 2)::INTEGER      AS ForecastWeekNumber
                                   FROM   Generate_Series(RequestedWeekStartDate - INTERVAL '1 Week', ForecastWeekToDate(ForecastWeekAdd(_Weeks, DateToForecastWeek(RequestedWeekStartDate))), '1 Week') AS TheDate),
         ForecastWeekSeries AS (SELECT FWSR.ForecastWeek,
                                       MIN(FWSR.WeekStartDate)                            AS WeekStartDate,
                                       MAX(FWSR.WeekEndDate)                              AS WeekEndDate,
                                       FWSR.ForecastWeekYear,
                                       FWSR.ForecastWeekNumber,
                                       Row_Number() OVER (ORDER BY FWSR.ForecastWeek) - 1 AS RelativeForecastNumber
                                FROM   ForecastWeekSeriesRaw FWSR
                                GROUP BY FWSR.ForecastWeek,
                                         FWSR.ForecastWeekYear,
                                         FWSR.ForecastWeekNumber), */
    WITH ForecastWeekSeries AS (SELECT (DR.WeekYear::VARCHAR || LPAD(DR.WeekNumber::TEXT, 2, '0'))::INTEGER AS ForecastWeek,
                                       DR.WeekStartDate                                                     AS WeekStartDate,
                                       DR.WeekEndDate                                                       AS WeekEndDate,
                                       DR.WeekYear                                                          AS ForecastWeekYear,
                                       DR.WeekNumber                                                        AS ForecastWeekNumber,
                                       Row_Number() OVER (ORDER BY (DR.WeekYear::VARCHAR || LPAD(DR.WeekNumber::TEXT, 2, '0'))::INTEGER) - 1 AS RelativeForecastNumber
                                FROM   (SELECT  MIN(WeekStartDate) as WeekStartDate, 
                                                MAX(WeekEndDate) AS WeekEndDate, 
                                                WeekYear, 
                                                WeekNumber
                                        FROM
                                        (SELECT WeekStartDate, 
                                                WeekEndDate,  
                                                CASE WHEN EXTRACT(Year FROM WeekStartDate)::INTEGER <> EXTRACT(Year FROM WeekEndDate)::INTEGER AND WeekNumber = 52 
                                                        THEN EXTRACT(Year FROM WeekStartDate)::INTEGER
                                                     WHEN EXTRACT(Year FROM WeekStartDate)::INTEGER <> EXTRACT(Year FROM WeekEndDate)::INTEGER AND WeekNumber = 1
                                                        THEN EXTRACT(Year FROM WeekEndDate)::INTEGER
                                                     ELSE EXTRACT(Year FROM WeekStartDate)::INTEGER
                                                     END AS WeekYear,
                                                WeekNumber
                                         FROM
                                            (SELECT TheDate - (EXTRACT(DOW FROM TheDate) * INTERVAL '1 Day')        AS WeekStartDate,
                                                    TheDate + ((6 - EXTRACT(DOW FROM TheDate)) * INTERVAL '1 Day')  AS WeekEndDate,       
                                                    LEFT(DateToForecastWeek(TheDate::DATE)::VARCHAR, 4)::INTEGER    AS WeekYear,      
                                                    RIGHT(DateToForecastWeek(TheDate::DATE)::VARCHAR, 2)::INTEGER   AS WeekNumber                                                        
                                             FROM Generate_Series(RequestedWeekStartDate - INTERVAL '1 Week', 
                                                  ForecastWeekToDate(ForecastWeekAdd(_Weeks, DateToForecastWeek(RequestedWeekStartDate))), '1 Week') AS TheDate
                                            ) Eliminate_53_Week 
                                         ) Combine_53_Week_to_52_Week
                                        GROUP BY WeekYear, WeekNumber
                                        ) DR ORDER BY 1),                                        
         BestModelList AS (SELECT ESF.zipcode,
                                  ESF.bedrooms,
                                  ESF.forecastrunweek,
                                  ESF.forecastmodelid,
                                  CASE WHEN ESF.forecastmodelid = 6
                                           THEN RunNaiveForecast(ESF.forecastrentweek1, _Weeks) 
                                       ELSE RunForecast(ESF.forecastfactorlist, ESF.forecastmodelid, _Weeks) 
                                  END AS ForecastResult
                           FROM   (SELECT ESF2.zipcode,
                                          ESF2.bedrooms,
                                          ESF2.forecastrunweek,
                                          MIN(ESF2.forecastmodelid) AS SimplestModelID
                                   FROM   (SELECT ESF3.zipcode,
                                                  ESF3.bedrooms,
                                                  ESF3.forecastrunweek,
                                                  MIN(ESF3.masescore) AS MinMASEScore
                                           FROM   evaluativeseasonalforecast ESF3
                                           WHERE  ESF3.forecastrunweek = _RequestedWeek
                                           GROUP BY ESF3.zipcode,
                                                    ESF3.bedrooms,
                                                    ESF3.forecastrunweek) MinMASE
                                          JOIN evaluativeseasonalforecast ESF2
                                            ON ESF2.zipcode = MinMASE.zipcode
                                               AND ESF2.bedrooms = MinMASE.bedrooms
                                               AND ESF2.forecastrunweek = MinMASE.forecastrunweek
                                               AND ESF2.masescore = MinMASE.MinMASEScore
                                   GROUP BY ESF2.zipcode,
                                            ESF2.bedrooms,
                                            ESF2.forecastrunweek) TMP
                                  JOIN evaluativeseasonalforecast ESF
                                    ON ESF.zipcode = TMP.zipcode
                                       AND ESF.bedrooms = TMP.bedrooms
                                       AND ESF.forecastrunweek = TMP.forecastrunweek
                                       AND ESF.forecastmodelid = TMP.SimplestModelID)
    INSERT INTO zipcodebestmodelseasonalforecast(zipcode, bedrooms, forecastrunweek, forecastweek, forecastweeknumber, forecastmodelid, forecastrent, forecastweekstartdate, forecastweekenddate, addeddate, addedby)
    SELECT BML.zipcode,
           BML.bedrooms,
           BML.forecastrunweek,
           FWS.ForecastWeek,
           FWS.RelativeForecastNumber AS ForecastWeekNumber,
           BML.forecastmodelid,
           (BML.ForecastResult).PointForecast AS ForecastRent,
           FWS.WeekStartDate,
           FWS.WeekEndDate,
           NOW() AS AddedDate,
           'MultiWeekSeasonalForecast' AS AddedBy
    FROM   BestModelList BML
           JOIN ForecastWeekSeries FWS
             ON FWS.RelativeForecastNumber = (BML.ForecastResult).RowNumber
    UNION ALL 
    SELECT DISTINCT BML.zipcode,
           BML.bedrooms,
           BML.forecastrunweek,
           FWS.ForecastWeek AS ForecastWeek,
           FWS.RelativeForecastNumber AS ForecastWeekNumber,
           BML.forecastmodelid,
           ZBAER.avgexecutedrent AS ForecastRent,
           FWS.WeekStartDate,
           FWS.WeekEndDate,
           NOW() AS AddedDate,
           'MultiWeekSeasonalForecast' AS AddedBy
    FROM   BestModelList BML
           JOIN zipcodebedroomavgexecutedrent ZBAER
             ON ZBAER.zipcode = BML.zipcode
                AND ZBAER.bedrooms = BML.bedrooms
                AND ZBAER.observationweek = PreviousWeek
           JOIN ForecastWeekSeries FWS
             ON FWS.ForecastWeek = ZBAER.observationweek;

END;
$function$
;
