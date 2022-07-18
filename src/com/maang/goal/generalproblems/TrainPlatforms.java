package com.maang.goal.generalproblems;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class TrainPlatforms {

	/*
	 * * Train: trainname, arrival, depature T1, 900, 930 T2, 1000, 1058 T3, 1030,
	 * 1240 T4, 1100, 1400 T5, 800, 1330
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Train t1 = new Train(900, 930, "T1");
		Train t2 = new Train(1000, 1058, "T2");
		Train t3 = new Train(1030, 1240, "T3");
		Train t4 = new Train(1100, 1400, "T4");
		Train t5 = new Train(800, 1330, "T5");
		Set<Train> trainList = new TreeSet<Train>();

		trainList.add(t1);
		trainList.add(t2);
		trainList.add(t3);
		trainList.add(t4);
		trainList.add(t5);

		trainList.forEach(System.out::println);
		System.out.println(identifyNumberOfPlatforms(trainList));
	}

	public static int identifyNumberOfPlatforms(Set<Train> trainList) {

		Set<Train> platFormList = new TreeSet<Train>();
		int maxNOfPlatforms = 0;

		for (Train currentTrain : trainList) {
			flushOutTrains(platFormList, currentTrain.startTime);
			int numberOfPlatforms = platFormList.size() + 1;
			platFormList.add(currentTrain);
			maxNOfPlatforms = maxNOfPlatforms > numberOfPlatforms ? maxNOfPlatforms : numberOfPlatforms;
		}
		return maxNOfPlatforms;
	}

	public static void flushOutTrains(Set<Train> platFormList, Integer startTime) {

		platFormList.removeIf(train -> startTime.compareTo(train.endTime) > 0);

	}

}

class Train implements Comparable {
	Integer startTime;
	Integer endTime;
	String trainName;

	Train(int startTime, int endTime, String trainName) {
		this.startTime = startTime;
		this.endTime = endTime;
		this.trainName = trainName;

	}

	public int hashCode() {

		int hashcode = 0;
		hashcode = startTime + endTime + trainName.hashCode();
		return hashcode;
	}

	public boolean equals(Object t) {

		if (!(t instanceof Train))
			return false;
		Train compObject = (Train) t;
		boolean startTimeEquality = (startTime == compObject.startTime) ? true : false;
		boolean endTimeEquality = (endTime == compObject.endTime) ? true : false;
		boolean trainNameEquality = (trainName != null && trainName.equals(compObject.trainName)) ? true : false;

		return startTimeEquality && endTimeEquality && trainNameEquality;

	}

	@Override
	public String toString() {
		return "Train [startTime=" + startTime + ", endTime=" + endTime + ", trainName=" + trainName + "]";
	}

	@Override
	public int compareTo(Object o) {

		if (!(o instanceof Train))
			return -1;

		Train tempObject = (Train) o;
		int equality = this.startTime.compareTo(tempObject.startTime);
		if (equality != 0)
			return equality;
		equality = this.endTime.compareTo(tempObject.endTime);

		return equality;

	}
}