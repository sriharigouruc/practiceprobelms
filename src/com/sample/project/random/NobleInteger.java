package com.sample.project.random;

import java.util.Arrays;
import java.util.Collections;

public class NobleInteger {
	public static void main(String args[]) {
		int[] b = { -4, 7, 5, 3, 5, -4, 2, -1, -9, -8, -3, 0, 9, -7, -4, -10, -4, 2, 6, 1, -2, -3, -1, -8, 0, -8, -7,
				-3, 5, -1, -8, -8, 8, -1, -3, 3, 6, 1, -8, -1, 3, -9, 9, -6, 7, 8, -6, 5, 0, 3, -4, 1, -10, 6, 3, -8, 0,
				6, -9, -5, -5, -6, -3, 6, -5, -4, -1, 3, 7, -6, 5, -8, -5, 4, -3, 4, -6, -7, 0, -3, -2, 6, 8, -2, -6,
				-7, 1, 4, 9, 2, -10, 6, -2, 9, 2, -4, -4, 4, 9, 5, 0, 4, 8, -3, -9, 7, -8, 7, 2, 2, 6, -9, -10, -4, -9,
				-5, -1, -6, 9, -10, -1, 1, 7, 7, 1, -9, 5, -1, -3, -3, 6, 7, 3, -4, -5, -4, -7, 9, -6, -2, 1, 2, -1, -7,
				9, 0, -2, -2, 5, -10, -1, 6, -7, 8, -5, -4, 1, -9, 5, 9, -2, -6, -2, -9, 0, 3, -10, 4, -6, -6, 4, -3, 6,
				-7, 1, -3, -5, 9, 6, 2, 1, 7, -2, 5 };
		int[] a= { -4, -2, 0, -1, -6 };
		System.out.println(solve(a));
	}

	public static int solve(int[] a) {

		int returnValue = -1;

		Integer[] A = new Integer[a.length];
		Arrays.setAll(A, i -> a[i]);

		Arrays.sort(A, Collections.reverseOrder());
		
		
		
			
		for (int counter = 0; counter < A.length; ++counter) {

			boolean boolValue = true;
			
			if(counter==0)
				boolValue = true;
			else
				boolValue  = (A[counter] != A[counter-1]);
			
			if (A[counter] == counter && boolValue) {
				returnValue = counter;
			}
		}
		return returnValue;

	}
}
