package com.maang.goal.arraysmaths;

import java.util.Arrays;
import java.util.List;

public class KanadeMaxSumSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(maxSubArray(Arrays.asList(-2, -3, -4, -10, 1)));
	}

	public static int maxSubArray(final List<Integer> A) {

		int maxSum = 0;
		int maxSumEndingHere = 0;
		boolean allNegative = true;
		int maxNegative = Integer.MIN_VALUE;

		for (int counter = 0; counter < A.size(); ++counter) {

			maxSumEndingHere += A.get(counter);

			if (maxSum < maxSumEndingHere) {
				maxSum = maxSumEndingHere;
			}

			if (maxSumEndingHere < 0) {
				maxSumEndingHere = 0;
			}
			if (allNegative) {
				if (A.get(counter) >= 0) {
					allNegative = false;
				} else {
					if (maxNegative < A.get(counter)) {
						maxNegative = A.get(counter);
					}
				}
			}

		}

		return allNegative ? maxNegative : maxSum;
	}

}
