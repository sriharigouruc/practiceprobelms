package com.sample.project.matrix;

public class MultiplicationOfMatrices {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] A = { { 1, 2, 3 }, 
					  { 3, 4, 5 } };
		int[][] B = { { 11, 22, 33 }, 
					  { 7, 8, 9 } };
		solve(A, B);

		/*
		 * { {-85, -23, -70, -20, 64, 47, 59, -60, 57, 97, 43, -45, -25, 39, -42, 61,
		 * -32, 76, -32, 32, 14, 26, -22, 36, 25, 58, -14, 80, -34, -24, -4, -75, 78,
		 * -11, -30, 82, 30, -85, 90, -3, 5, 98, 74, 87, -96, -22, 51, -43}
		 */
	}

	public static int[][] solve(int[][] A, int[][] B) {

		int[][] returnValue = new int[A.length][B[0].length];
		
		for (int rowcounter = 0; rowcounter < A.length; ++rowcounter) {
			int currentsum = 0;
			int columnCounter = 0;

			while (columnCounter < B[0].length) {

				for (int incrementC = 0; incrementC < B.length; ++incrementC) {
					
					System.out.println(rowcounter + " " + columnCounter +" "+ incrementC);
					
					System.out.println(A[rowcounter][columnCounter]);
					System.out.println(B[incrementC][columnCounter]);

					currentsum += A[rowcounter][incrementC] * B[incrementC][columnCounter];
					
				}
				
				returnValue[rowcounter][columnCounter] = currentsum;
				
				++columnCounter;
			}
			
			
		}

		return returnValue;
	}

}
