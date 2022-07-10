package com.maang.goal.advancedmaths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MaximizeGCD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solve(Arrays.asList(12, 6, 30, 45, 5)));
	}

	public static int solve(List<Integer> A) {

		int result = A.get(0);

		int size = A.size();

		List<Integer> suffix = new ArrayList<Integer>(size);
		List<Integer> prefix = new ArrayList<Integer>(size);
		prefix.add(A.get(0));

		for (int i = 1; i < size; ++i) {

			prefix.add(i, gcd(prefix.get(i - 1), A.get(i)));
		}
		for (int i = 0; i < size; ++i) {
			suffix.add(0);
		}

		suffix.set(size - 1, A.get(size - 1));

		for (int i = size - 2; i >= 0; --i) {

			suffix.set(i, gcd(suffix.get(i + 1), A.get(i)));
		}

		result = suffix.get(size - 1);
		print(prefix);
		
		print(suffix);

		for (int counter = 1; counter < size; ++counter) {
			if (counter == size - 1) {
				result = Math.max(prefix.get(counter - 1), result);
			} else {
				result = gcd(result, Math.max(prefix.get(counter - 1), suffix.get(counter + 1)));
			}

		}

		return result;
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

	public static void print(List<?> list) {

		System.out.println(list.stream().map(Object::toString).collect(Collectors.joining("-")));
	}

}
