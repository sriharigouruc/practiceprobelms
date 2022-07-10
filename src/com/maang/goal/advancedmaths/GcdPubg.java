package com.maang.goal.advancedmaths;

import java.util.Arrays;
import java.util.List;

public class GcdPubg {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solve(Arrays.asList(16,32,24,48)));
	}

	public static int solve(List<Integer> A) {
		int returnValue = 1;

		if (A.size() == 1)
			return A.get(0);
		else
			returnValue = gcd(A.get(0), A.get(1));
		for (int i = 2; i < A.size(); ++i) {

			returnValue = gcd(returnValue, A.get(i));

		}
		return returnValue;
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
