package com.mang.goal.recursion;

public class FactorialRecursion {

	public static void main(String args[]) {
		System.out.println(solve(4));
		System.out.println(solve(1));
	}

	public static int solve(int A) {

		if (A <= 0)
			return 1;
		else
			return A * solve(A - 1);
	}
}
