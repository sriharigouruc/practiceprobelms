package com.sample.project;

public class MatrixSubstraction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int[][] solve(int[][] A, int[][] B) {
		int[][] returnValue = new int[A.length][A[0].length];
		
		for(int rowCounter=0;rowCounter<returnValue.length;++rowCounter)
		{
			for(int columnCounter=0;columnCounter<returnValue[0].length;++columnCounter)
			{
				returnValue[rowCounter][columnCounter]=A[rowCounter][columnCounter]-B[rowCounter][columnCounter];
			}
		}
		return returnValue;
				
	}

}
