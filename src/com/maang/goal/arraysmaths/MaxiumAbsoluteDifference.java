package com.maang.goal.arraysmaths;

import java.util.Arrays;
import java.util.List;

public class MaxiumAbsoluteDifference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(maxArr(Arrays.asList(-70, -64, -6, -56, 64, 61, -57, 16, 48, -98)));
		System.out.println(maxArr(Arrays.asList(-70, -64, -6)));
	}

	public static int maxArr(List<Integer> A) {

		int returnValue = 0;
		int max_value_addition = Integer.MIN_VALUE;
		int min_value_addition = Integer.MAX_VALUE;
		int max_value_substraction = Integer.MIN_VALUE;
		int min_value_substraction = Integer.MAX_VALUE;

		for (int i = 0; i < A.size(); ++i) {
			max_value_addition = Math.max(max_value_addition, A.get(i) + i);
			min_value_addition = Math.min(min_value_addition, A.get(i) + i);
			max_value_substraction = Math.max(max_value_substraction, A.get(i) - i);
			min_value_substraction = Math.min(min_value_substraction, A.get(i) - i);
		}
		returnValue = Math.max(max_value_addition - min_value_addition,
				max_value_substraction - min_value_substraction);
		return returnValue;
	}

}
