package com.sample.project;

public class MatrixSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[][] solve(int[][] A, int[][] B) {
		int returnSum[][] = new int[A.length][A[0].length];
		for (int rowCounter = 0; rowCounter <= A.length; ++rowCounter) {
			for (int columnCounter = 0; columnCounter <= A[rowCounter].length; ++columnCounter) {
				returnSum[rowCounter][columnCounter] = A[rowCounter][columnCounter]+B[rowCounter][columnCounter];
			}

		}

		return returnSum;

	}
}
