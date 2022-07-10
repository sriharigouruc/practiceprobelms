package com.maang.goal.hashing;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DiffKII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(diffPossible(List.of(31, 1, 3, 5, 6, 7, 24), 7));
	}

	public static int diffPossible(final List<Integer> A, int B) {
		Set<Integer> countOfElements = new HashSet<Integer>();
		for (int i = 0; i < A.size(); ++i) {
			if (countOfElements.contains(A.get(i) +B) || countOfElements.contains(A.get(i) -B)) {
				return 1;
			} else {
				countOfElements.add(A.get(i));
			}
		}


		return 0;
	}
}
