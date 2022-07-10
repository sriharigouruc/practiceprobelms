/**
 * 
 */
package com.sample.project;

/**
 * @author SGouru
 *
 */
public class TransposeMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[][] = { { 1, 2, 3,4 }, { 4, 5, 6,9 }, { 7, 8, 9 ,10} };
		int B[][] = solve(A);
		System.out.println(B.toString());
		
	}

	public static int[][] solve(int[][] A) {

		if (A.length == A[0].length) {
			for (int counter = 1; counter < A.length; ++counter) {
				int columnCounter = counter;

				for (int rowNumber = 0; rowNumber < counter; ++rowNumber) {
					int temp = A[rowNumber][columnCounter];
					A[rowNumber][columnCounter] = A[columnCounter][rowNumber];
					A[columnCounter][rowNumber] = temp;
				}
			}
			return A;
		}		
		else
		{
			int[][] B = new int[A[0].length][A.length];
			
			for(int columnCounter = 0;columnCounter< A[0].length;++columnCounter)
			{
				for(int rowCounter=0;rowCounter<A.length;++rowCounter)
				{
					B[columnCounter][rowCounter] = A[rowCounter][columnCounter];
				}
			}
			
			return B;
 		}

		
	}

}
