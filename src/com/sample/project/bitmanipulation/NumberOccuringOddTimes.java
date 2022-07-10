package com.sample.project.bitmanipulation;

public class NumberOccuringOddTimes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] A= {1, 2, 2, 3, 1};
		int[] B= {1, 2, 2};
		
		System.out.println(singleNumber(A));
		System.out.println(singleNumber(B));
	}

	public static int singleNumber(final int[] A) {

		int returnValue = A[0];

		for (int counter = 1; counter < A.length; ++counter) {
			returnValue = A[counter]^returnValue;
		}

		return returnValue;
	}

}
