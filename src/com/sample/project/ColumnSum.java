package com.sample.project;

public class ColumnSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] A = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 2, 3, 4 } };

		System.out.println(solve(A));
	}

	public static int[] solve(int[][] A) {
		int[] returnValue = new int[A[0].length];

		for (int i = 0; i < A[0].length; ++i) {
			int columnSum = 0;

			for (int j = 0; j < A.length; ++j) {
				columnSum += A[j][i];
			}
			returnValue[i]=columnSum;
		}

		return returnValue;
	}

}
