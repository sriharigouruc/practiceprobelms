package com.sample.project.bitmanipulation;

public class FindLastDigitValue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A = 8;
		System.out.println(solve(A));
	}

	public static int solve(int A) {
		int counter = 0;
		while (A > 0) {

			if ((A & 1) == 1) {
				++counter;
			}
			A = A >> 1;

		}
		return counter;
	}

}
