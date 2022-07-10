package com.sample.project.advanced.sorting;

import java.util.Arrays;
import java.util.List;

public class SubArrayToSortArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

			System.out.println(solve(Arrays.asList(10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60)));
	}

	public static int solve(List<Integer> A) {

		int maxValue = Integer.MIN_VALUE;
		int minValue = Integer.MAX_VALUE;

		int startIndex = -1, endIndex = -1;
		// find minimum value which is not in order

		for (int i = 0; i < A.size() - 1; ++i) {
			if (A.get(i) > A.get(i + 1)) {
				minValue = Math.min(minValue, A.get(i + 1));
			}
		}

		for (int i = A.size() - 1; i > 1; --i) {
			if (A.get(i) < A.get(i - 1)) {
				maxValue = Math.max(maxValue, A.get(i - 1));
			}
		}

		for (int i = 0; i < A.size(); ++i) {
			if (A.get(i) > minValue) {
				startIndex = i;
				break;
			}
		}

		for (int i = A.size() - 1; i >= 0; --i) {
			if (A.get(i) < maxValue) {
				endIndex = i;
				break;
			}
		}
		if (startIndex == -1 && endIndex == -1)
			return 0;

		return endIndex - startIndex + 1;
	}

}
