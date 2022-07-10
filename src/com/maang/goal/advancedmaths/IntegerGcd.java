package com.maang.goal.advancedmaths;

public class IntegerGcd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(gcd(5, 3));
		System.out.println(gcd(42, 21));
	}

	public static int gcd(int A, int B) {

		if (A == 1 || B == 1) {
			return 1;
		}

		if (A == 0 || B == 0) {
			return A == 0 ? B : A;
		}

		int min = Math.min(A, B);
		int max = Math.max(A, B);

		if (max % min == 0) {
			return min;
		} else {
			return gcd(min, max % min);
		}

	}
}
