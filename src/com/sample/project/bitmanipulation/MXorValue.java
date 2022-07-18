package com.sample.project.bitmanipulation;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MXorValue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] input = {0, 2, 5, 7};
		System.out.println(findMinXor(Arrays.asList(input)));
	}

	public static int findMinXor(List<Integer> A) {
		int returnValue = Integer.MAX_VALUE;

		Collections.sort(A);
		for (int i = 0; i < A.size() - 1; ++i) {
			int currentXorValue = A.get(i) ^ A.get(i + 1);
			returnValue = returnValue>currentXorValue?currentXorValue:returnValue;
		}
		return returnValue;
	}
}
