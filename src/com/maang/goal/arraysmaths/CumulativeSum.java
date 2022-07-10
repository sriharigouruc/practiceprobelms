package com.maang.goal.arraysmaths;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class CumulativeSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * [1, 1, 5] [2, 2, 5] [3, 4, 5] [5, 5, 5]
		 */

		ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();

		ArrayList<Integer> one = new ArrayList<Integer>();
		one.add(1);
		one.add(1);
		one.add(5);
		B.add(one);
		one = new ArrayList<Integer>();
		one.add(2);
		one.add(2);
		one.add(5);
		B.add(one);
		one = new ArrayList<Integer>();
		one.add(3);
		one.add(4);
		one.add(5);
		B.add(one);
		one = new ArrayList<Integer>();
		one.add(5);
		one.add(5);
		one.add(5);
		B.add(one);
		solve(5, B);

	}

	public static ArrayList<Integer> solve(int A, ArrayList<ArrayList<Integer>> B) {

		ArrayList<Integer> resultsList = new ArrayList<Integer>(A);

		for (int currentCounter = 0; currentCounter < A; ++currentCounter) {
			resultsList.add(0);
		}

//		System.out.println(stringJoiner(resultsList));

		for (ArrayList<Integer> innerList : B) {
			int startCounter = innerList.get(0);
			int endCounter = innerList.get(1);
			int value = innerList.get(2);

			resultsList.set(startCounter - 1, resultsList.get(startCounter - 1) + value);
			if (endCounter != A) {
				resultsList.set(endCounter, resultsList.get(endCounter) - value);
			}
			// System.out.println(stringJoiner(resultsList));
		}

		// System.out.println(stringJoiner(resultsList));

		for (int counter = 1; counter < resultsList.size(); ++counter) {
			resultsList.set(counter, resultsList.get(counter) + resultsList.get(counter - 1));
		}
		// System.out.println(stringJoiner(resultsList));

		return resultsList;

	}

	public static String stringJoiner(List<Integer> resultsList) {
		StringJoiner joiner = new StringJoiner(",");
		resultsList.forEach(item -> joiner.add(item.toString()));
		return joiner.toString();
	}

}
