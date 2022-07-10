package com.sample.project;

public class SubArrayWithLeastAvg {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = { 335, 206, 63, 275, 213, 232, 171, 56, 461, 435, 380, 219, 186, 466, 455, 228, 310, 231, 54, 418,
				333, 355, 53, 61, 363, 250, 315, 405, 369, 385, 113, 229, 342, 490, 358, 454, 441, 374, 24, 412, 73,
				497, 175, 488, 303, 152, 47, 399, 185, 493, 461, 165, 293, 384, 100, 252, 458, 357, 157, 267, 470, 322,
				320, 352, 59, 402 };

		System.out.println(solve(A, 57));
	}

	public static int solve(int[] A, int B) {

		int index = 0;

		long[] sumArray = new long[A.length];

		sumArray[0] = A[0];

		for (int i = 1; i < A.length; ++i) {
			sumArray[i] = sumArray[i - 1] + A[i];

		}

		double minimumAvg = sumArray[B - 1] / B;

		for (int counter = 1; counter + B - 1 < A.length; ++counter) {

			double currentSum = sumArray[counter + B - 1] - sumArray[counter - 1];

			System.out.println("minimumAvg" + minimumAvg + " currentSum / B " + currentSum / B + " counter " + counter);

			if (minimumAvg > (currentSum / B)) {

				minimumAvg = currentSum * 1.0 / B;
				index = counter;
			}
		}
		return index;

	}
}
