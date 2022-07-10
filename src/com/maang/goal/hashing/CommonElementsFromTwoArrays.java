package com.maang.goal.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonElementsFromTwoArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> values = solve(Arrays.asList(1, 2, 2, 1), Arrays.asList(2, 3, 1, 2));
		for (Integer i : values) {
			System.out.println(i);
		}

	}

	public static List<Integer> solve(List<Integer> A, List<Integer> B) {
		List<Integer> returnList = new ArrayList<Integer>();
		Map<Integer, Integer> firstListMap = createOccurenceCountMap(A);
		Map<Integer, Integer> secondListMap = createOccurenceCountMap(B);
		for (Integer firstInt : firstListMap.keySet()) {
			Integer firstMapCount = firstListMap.get(firstInt);

			if (secondListMap.containsKey(firstInt))

			{
				int numTimes = firstMapCount < secondListMap.get(firstInt) ? firstMapCount
						: secondListMap.get(firstInt);
				while (numTimes > 0) {
					returnList.add(firstInt);
					numTimes--;
				}
			}

		}
		return returnList;
	}

	public static Map<Integer, Integer> createOccurenceCountMap(List<Integer> A) {
		Map<Integer, Integer> firstListMap = new HashMap<Integer, Integer>();
		for (Integer i : A) {
			if (firstListMap.containsKey(i)) {
				firstListMap.put(i, (firstListMap.get(i)) + 1);
			} else {
				firstListMap.put(i, 1);
			}
		}
		return firstListMap;
	}

}
