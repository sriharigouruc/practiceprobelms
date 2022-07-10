package com.maang.goal.recursion;

public class SumOfDigitsMagicNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(solve(1));
		System.out.println(solve(0));
		System.out.println(solve(23423432));
		

	}

	public static int solve(int A) {
		if (A < 10)
			return A == 1 ? 1 : 0;

		int currentDigitsSum = 0;
		while (A > 0) {
			currentDigitsSum += A % 10;
			A /= 10;
		}
		return solve(currentDigitsSum);

	}

	
}
