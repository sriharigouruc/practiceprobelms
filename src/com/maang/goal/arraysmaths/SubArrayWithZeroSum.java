package com.maang.goal.arraysmaths;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SubArrayWithZeroSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int solve(ArrayList<Integer> A) {

		Map<String, Long> returnListMap = new HashMap<String, Long>();
		ArrayList<Long> prefixSumList = new ArrayList<Long>();

		prefixSumList.add(new Long(A.get(0)));
		if (A.get(0) == 0) {
			return 1;
		}

		Map<Long, Long> prefixSumMap = new HashMap<Long, Long>();
		prefixSumMap.put(new Long(A.get(0)), new Long(0l));

		for (long counter = 1; counter < A.size(); ++counter) {

			long currentSum = prefixSumList.get((int) (counter - 1)) + A.get((int) (counter));
			if (currentSum == 0) {
				return 1;
			}

			if (currentSum != 0 && prefixSumMap.containsKey(currentSum)) {
				return 1;

			} else {
				prefixSumMap.put(currentSum, counter);
			}
			prefixSumList.add(currentSum);
		}

		return 0;

	}

}
