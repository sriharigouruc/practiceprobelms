package com.maang.goal.arraysmaths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class MajorityTwoElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> numbers = List.of(1000441, 1000441, 1000994);

		System.out.println(repeatedNumber(numbers));
	}

	public static int repeatedNumber(final List<Integer> a) {

		Iterator<Integer> iterator = a.iterator();
		Integer majorityInteger1 = null;
		int majorityInteger1Counter = 0;
		Integer majorityInteger2 = null;
		int majorityInteger2Counter = 0;

		while (iterator.hasNext()) {
			System.out.println(majorityInteger1 + " " + majorityInteger1Counter + " " + majorityInteger2 + "  "
					+ majorityInteger2Counter);
			Integer currentInteger = iterator.next();

			if (currentInteger.equals(majorityInteger1) || currentInteger.equals(majorityInteger2)) {
				if (currentInteger.equals(majorityInteger1)) {
					majorityInteger1Counter++;

				}
				if (currentInteger.equals(majorityInteger2)) {
					majorityInteger2Counter++;

				}
				continue;
			}
			if (majorityInteger1 == null) {
				majorityInteger1 = currentInteger;
				majorityInteger1Counter++;
				continue;
			}
			if (majorityInteger2 == null) {
				majorityInteger2 = currentInteger;
				majorityInteger2Counter++;
				continue;
			}
			--majorityInteger1Counter;
			--majorityInteger2Counter;
			if (majorityInteger1Counter == 0) {
				majorityInteger1 = null;
			}
			if (majorityInteger2Counter == 0) {
				majorityInteger2 = null;
			}

		}
		System.out.println(majorityInteger1 + " " + majorityInteger1Counter + " " + majorityInteger2 + "  "
				+ majorityInteger2Counter);
		majorityInteger1Counter = 0;
		majorityInteger2Counter = 0;

		Iterator<Integer> iterator1 = a.iterator();
		while (iterator1.hasNext()) {
			Integer currentInteger = iterator1.next();
			if (currentInteger.equals(majorityInteger1)) {
				majorityInteger1Counter++;
			}
			if (currentInteger.equals(majorityInteger2)) {
				majorityInteger2Counter++;
			}
		}

		if (majorityInteger1Counter > a.size() / 3) {
			return majorityInteger1;
		}
		if (majorityInteger2Counter > a.size() / 3) {
			return majorityInteger2;
		}

		return -1;
	}

}
