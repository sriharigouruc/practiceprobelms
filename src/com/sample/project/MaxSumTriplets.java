package com.sample.project;

public class MaxSumTriplets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = { 2, 4, 5, 4, 10 };
		int[] B = { 40, 30, 20, 10, 40 };
		System.out.println(solve2(A, B));

	}

	// brute force

	public static int solve(int[] A, int[] B) {

		int returnValue = Integer.MAX_VALUE;

		for (int i = 0; i < B.length; ++i) {

			for (int j = i + 1; j < B.length; ++j)

			{
				for (int k = j + 1; k < B.length; ++k) {

					if (A[i] < A[j] && A[j] < A[k]) {
						System.out.println("returnValue" + returnValue + " B[i] + B[j] + B[k]" + (B[i] + B[j] + B[k]));
						if (returnValue > B[i] + B[j] + B[k]) {
							returnValue = B[i] + B[j] + B[k];
						}
					}

				}
			}
		}
		return returnValue == Integer.MAX_VALUE ? -1 : returnValue;
	}

	// brute force

	public static int solve2(int[] A, int[] B) {

		int returnValue = Integer.MAX_VALUE;

		for (int i = 0; i < B.length; ++i) {

			int smallerLeftCost = Integer.MAX_VALUE;

			for (int leftCounter = 0; leftCounter < i; ++leftCounter) {

				if (A[leftCounter] < A[i]) {
					if (smallerLeftCost > B[leftCounter]) {
						smallerLeftCost = B[leftCounter];
					}
				}
			}
			int smallerRightCost = Integer.MAX_VALUE;

			for (int rightCounter = i + 1; rightCounter < A.length; ++rightCounter) {

				if (A[rightCounter] > A[i]) {
					if (smallerRightCost > B[rightCounter]) {
						smallerRightCost = B[rightCounter];
					}
				}
			}

			/*
			 * System.out.println("returnValue " + returnValue +
			 * " B[i] + smallerLeftCost + smallerRightCost" + (B[i] + " " + smallerLeftCost
			 * + " " + smallerRightCost));
			 */
			if (returnValue > (smallerLeftCost + B[i] + smallerRightCost) && smallerLeftCost != Integer.MAX_VALUE
					&& Integer.MAX_VALUE != smallerRightCost) {
				returnValue = smallerLeftCost + B[i] + smallerRightCost;
				/* System.out.println(returnValue); */
			}
		}
		return returnValue == Integer.MAX_VALUE ? -1 : returnValue;
	}

}
