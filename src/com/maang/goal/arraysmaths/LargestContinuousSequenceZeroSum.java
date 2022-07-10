package com.maang.goal.arraysmaths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LargestContinuousSequenceZeroSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println((lszero(Arrays.asList(-8, 8, -1, -16, -28, -27, 15, -14, 14, -27, -5, -6, -25, -11, 28, 29,
				-3, -25, 17, -25, 4, -20, 2, 1, -17, -10, -25))).stream().map(Object::toString)
						.collect(Collectors.joining("-")));

	}

	public static ArrayList<Integer> lszero(List<Integer> A) {

		Map<String, Integer> returnListMap = new HashMap<String, Integer>();
		ArrayList<Integer> prefixSumList = new ArrayList<Integer>();
		ArrayList<Integer> returnList = new ArrayList<Integer>();
		int longestLength = Integer.MIN_VALUE;

		prefixSumList.add(A.get(0));
		if (A.get(0) == 0) {
			longestLength = 1;
			returnListMap.put("start", 0);
			returnListMap.put("end", 0);

		}

		Map<Integer, Integer> prefixSumMap = new HashMap<Integer, Integer>();
		prefixSumMap.put(A.get(0), 0);

		for (int counter = 1; counter < A.size(); ++counter) {

			int currentSum = prefixSumList.get(counter - 1) + A.get(counter);
			if (currentSum == 0) {
				if (longestLength < counter - 0 + 1) {
					longestLength = counter - 0 + 1;
					returnListMap.put("start", 0);
					returnListMap.put("end", counter);
				}

			}

			prefixSumList.add(currentSum);

			if (currentSum != 0 && prefixSumMap.containsKey(currentSum)) {
				if (longestLength < counter - prefixSumMap.get(currentSum)) {
					returnListMap.put("start", prefixSumMap.get(currentSum) + 1);
					returnListMap.put("end", counter);
					longestLength = counter - prefixSumMap.get(currentSum);
				}

			} else {
				prefixSumMap.put(currentSum, counter);
			}
		}

		if (returnListMap.containsKey("start") && returnListMap.containsKey("end")) {
			for (int counter = returnListMap.get("start"); counter <= returnListMap.get("end"); ++counter) {
				returnList.add(A.get(counter));
			}
		}

		return returnList;
	}
}
