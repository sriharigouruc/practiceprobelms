package com.sample.project.random;

import java.util.Arrays;

public class AirthameticProgression {

	public static void main (String[] args)
	{
		int a[]= {3, 5, 1};
		System.out.println(solve(a));
		int b[]= {2, 4, 1};
		System.out.println(solve(b));
	}
	public static int solve(int[] A) {
		int returnValue = 0;

		Arrays.sort(A);
		int difference = 0;
		if (A.length > 2) {
			difference = A[0] - A[1];
		}
		else {
			return 1;
		}
		for (int counter = 1; counter < A.length-1; ++counter) {
			if(A[counter] - A[counter+1] != difference) {
				returnValue=0;
				break;
			}
			else {
				returnValue=1;
			}
				
		}
		return returnValue;

	}
}
