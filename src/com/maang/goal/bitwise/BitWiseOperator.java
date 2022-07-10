package com.maang.goal.bitwise;

public class BitWiseOperator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(solve(5));
		System.out.print(solve(3));

	}

	public static int solve(int A) {
		int returnValue = 0;
		while (A > 0) {
			if ((A & 1) == 1)
				returnValue++;
			A = A >> 1;
		}
		return returnValue;
	}
}
