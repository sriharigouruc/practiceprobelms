/**
 * 
 */
package com.maang.goal.arraysmaths;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SGouru
 *
 */
public class MergeIntervals {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1,5 2,3 -> 1,5 5,8 -> 3,4 1,6
		Interval i1 = new Interval(3, 6);
		Interval i2 = new Interval(8, 10);
		ArrayList<Interval> ilist = new ArrayList<Interval>();
		ilist.add(i1);
		ilist.add(i2);
		Interval iadd = new Interval(1, 12);

		List<Interval> resultingOne = insert(ilist, iadd);
		System.out.println(resultingOne);
	}

	// public static List<Interval> insert(List<Interval> intervals, Interval
	// newInterval) {

	public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {

		ArrayList<Interval> returnList = new ArrayList<Interval>();
		if (intervals.size() == 0) {
			returnList.add(newInterval);
			return returnList;
		}

		boolean merged = false;

		for (int counter = 0; counter < intervals.size(); ++counter) {

			Interval currentInterval = intervals.get(counter);
			if (merged) {
				returnList.add(currentInterval);
				continue;
			}

			if (currentInterval.end < newInterval.start) {
				returnList.add(currentInterval);
				continue;
			}
			if (currentInterval.start > newInterval.end) {
				merged = true;
				--counter;
				returnList.add(newInterval);
				continue;
			}

			// it means overlapping one

			newInterval = new Interval(Math.min(currentInterval.start, newInterval.start),
					Math.max(currentInterval.end, newInterval.end));
			// returnList.add(newInterval);
			// merged = true;

		}
		if (!merged)
			returnList.add(newInterval);

		return returnList;

	}

	/*
	 * -> 1,5 2,3 -> 1,5 5,8 -> 3,4 1,6
	 * 
	 * loop through the Intervals --> is the start of new interval in between start
	 * & end of current interval ---> if the start & end of new interval is between
	 * start & end of current interval ---> ignore the new interval and move on --->
	 * if the start between start & end of current interval & end of new interval is
	 * after the end of current interval ---> create the new interval with start of
	 * current interval , end of new interval as end of given interval ---> if the
	 * start is not in between start & end of current interval , ---> Please move to
	 * the next interval. ---> if the given interval is not merged, pleae add the
	 * new interval as the last item in the list.
	 * 
	 */

}

class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}

	@Override
	public String toString() {
		return "Interval [start=" + start + ", end=" + end + "]";
	}

}
