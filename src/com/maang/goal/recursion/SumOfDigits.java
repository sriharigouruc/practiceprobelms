package com.maang.goal.recursion;

public class SumOfDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(solveR(1));
		System.out.println(solveR(0));
		System.out.println(solveR(23423432));

	}

	public static int solveR(int A) {
		if (A < 10)
			return A;

		return A % 10 + solveR(A / 10);

	}

}
