package com.sample.project.majorityelements;

import java.util.Arrays;
import java.util.List;

public class MajorityOperations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(majorityElement(Arrays.asList(2, 1, 2)));
		
	}

	public static int majorityElement(final List<Integer> A) {

		int returnValue = A.get(0);
		int counter = 1;

		for (int i = 1; i < A.size(); ++i) {
			if (counter >= 1) {
				if (A.get(i) == returnValue) {
					counter++;
				} else {
					--counter;
				}
			} else {
				returnValue = A.get(i);
				counter = 1;
			}

		}

		int currentCount = 0;

		for (int ii = 0; ii < A.size(); ++ii) {

			if (returnValue == A.get(ii)) {
				currentCount++;
			}

		}

		if (!(currentCount > A.size() / 2)) {
			returnValue = -1;
		}

		return returnValue;
	}
}
