/**
 * 
 */
package com.maang.goal.arraysmaths;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author SGouru
 *
 */
public class FirstMissingInteger {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = { 2, 3, 1, -2, 4, 1 };
		List<Integer> list = Arrays.stream(A).boxed().collect(Collectors.toList());

		// System.out.println(firstMissingPositive(list));
		System.out.println(firstMissingPositiveN(list));
	}

	public static int firstMissingPositiveN(List<Integer> A) {

		System.out.println(toStringString(A));

		for (int i = 0; i < A.size(); i++) {
			if (A.get(i) <= 0) {
				A.set(i, A.size() + 2);
			}

		}

		for (int i = 0; i < A.size(); i++) {

			if (Math.abs(A.get(i)) <= A.size()) {

				A.set(Math.abs(A.get(i)) - 1, (Math.abs(A.get(Math.abs(A.get(i)) - 1))) * -1);
			}

		}

		for (int i = 0; i < A.size(); i++) {

			if (A.get(i) > 0)
				return i + 1;
		}

		return A.size() + 1;
	}

	public static int firstMissingPositive(List<Integer> A) {

		int firstMissingInteger = -1;

		int positiveEnd = partition(A);

		System.out.println(positiveEnd + " ** " + toStringString(A));

		for (int counter22 = 0; counter22 < positiveEnd; ++counter22) {

			System.out.println(A.get(counter22) - 1 + " **** " + toStringString(A));

			if (Math.abs(A.get(counter22)) - 1 < positiveEnd && (A.get(counter22) - 1) >= 0) {

				A.set(Math.abs(A.get(counter22)) - 1, -(A.get(Math.abs(A.get(counter22)) - 1)));

			}
		}

		for (int counter = 0; counter < positiveEnd; ++counter) {
			if (A.get(counter) > 0) {
				firstMissingInteger = counter + 1;
				break;
			}
		}

		return firstMissingInteger;

	}

	public static int partition(List<Integer> A) {

		int start = 0, end = A.size() - 1;

		while (start <= end) {

			if (A.get(start) < 0) {

				int temp = A.get(start);
				A.set(start, A.get(end));
				A.set(end, temp);
				--end;

			} else {
				start += 1;
			}
		}

		return start;

	}

	public static String toStringString(List<?> list) {
		return list.stream().map(Object::toString).collect(Collectors.joining(","));
	}

}
