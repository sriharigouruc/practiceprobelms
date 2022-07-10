package com.maang.goal.arraysmaths;

public class FindNthNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solve(5));
	}

	public static int solve(int A) {
		int n = A;

		int retrunValue = 0;

		int currentPow = 1;

		while (n > 0) {
			currentPow = currentPow * 5;
			if ((n & 1) == 1)
				retrunValue += currentPow;
			n = n >> 1;
		}

		return retrunValue;
	}

}
