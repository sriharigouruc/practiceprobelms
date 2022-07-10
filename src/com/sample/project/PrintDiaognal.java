package com.sample.project;

public class PrintDiaognal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] A = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		int[][] outputArray = diagonal(A);
		for (int[] innerArray : outputArray) {
			for (int i : innerArray) {
				System.out.print(i);
			}
			System.out.println();
		}
	}

	public static int[][] diagonal(int[][] A) {
		int[][] returnArray = new int[(A.length * 2) - 1][A[0].length];

		int outputArracCounter = 0;

		for (int columnCounter = 0; columnCounter < A[0].length; ++columnCounter) {

			int columnCounter2 = columnCounter;
			int specificCoulumC = 0;

			for (int rowCounter = 0; rowCounter <= columnCounter; ++rowCounter) {

				returnArray[outputArracCounter][specificCoulumC] = A[rowCounter][columnCounter2];

				--columnCounter2;
				++specificCoulumC;

			}
			++outputArracCounter;

		}

		for (int rowCounter = 1; rowCounter < A.length; ++rowCounter) {

			int rowCounter2 = rowCounter;
			int innercoulumnCounter = 0;

			for (int columnCounter = A.length - 1; columnCounter >= 0 && rowCounter2 < A.length; --columnCounter) {

				returnArray[outputArracCounter][innercoulumnCounter] = A[rowCounter2][columnCounter];
				++rowCounter2;
				++innercoulumnCounter;

			}
			++outputArracCounter;
		}

		return returnArray;
	}
}
