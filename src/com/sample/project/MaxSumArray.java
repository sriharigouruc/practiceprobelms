package com.sample.project;

public class MaxSumArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = { 1, 2, 3, 5, 7, 8, 9, 10 };
		int A2[] = { 1, 2, 3, 4, -10 };
		System.out.println(maxSubarraySum(A));
		System.out.println(maxSubarraySum(A2));
		System.out.println(subarraySumA(A));
	}

	public static long maxSubarraySum(int[] A) {

		long maxSum = Long.MIN_VALUE;

		for (long counter = 0; counter < A.length; ++counter) {
			long innerSum = 0;

			for (long innerCounter = counter; innerCounter < A.length; ++innerCounter) {
				innerSum += A[(int) innerCounter];
				maxSum = Math.max(maxSum, innerSum);
			}

		}
		return maxSum;

	}

	public int maxSubarray(int A, int B, int[] C) {

		int maxSum = Integer.MIN_VALUE;

		for (long counter = 0; counter < C.length; ++counter) {
			int  innerSum = 0;

			for (long innerCounter = counter; innerCounter < C.length; ++innerCounter) {
				innerSum += C[(int) innerCounter];
				if(( B>=innerSum) ) {
					maxSum = Math.max(maxSum, innerSum);
				}
			}

		}
		return maxSum;
	}

	// N * (i + 1) - i * (i + 1)
	public static long subarraySumA(int[] A) {
		long outsum = 0;

		for (int counter = 0; counter < A.length; ++counter) {
			outsum += A[counter] * ((A.length * (counter + 1)) - (counter * (counter + 1)));

		}
		return outsum;
	}

}
