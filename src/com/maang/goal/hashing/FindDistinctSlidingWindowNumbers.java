/**
 * 
 */
package com.maang.goal.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author SGouru
 *
 */
public class FindDistinctSlidingWindowNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> numbers = List.of(31, 51, 31, 51, 31, 31, 31, 31, 31, 31, 51, 31, 31);
		System.out.println(Arrays.toString(dNums(numbers, 3).toArray()));
	}

	public static List<Integer> dNums(List<Integer> A, int B) {

		if (A.size() < B)
			return null;

		ArrayList<Integer> returnList = new ArrayList<Integer>();

		Map<Integer, Integer> distinctCount = new HashMap<Integer, Integer>();

		for (int i = 0; i < B; ++i) {
			if (distinctCount.get(A.get(i)) != null) {
				distinctCount.put(A.get(i), distinctCount.get(A.get(i)) + 1);
			} else {
				distinctCount.put(A.get(i), 1);
			}

		}
		returnList.add(distinctCount.size());
		for (int i = B; i < A.size(); ++i) {
			Integer firstInt = A.get(i - B);
			Integer newInt = A.get(i);

			if (firstInt.equals(newInt)) {
				returnList.add(distinctCount.size());
				continue;
			}

			if (distinctCount.get(firstInt).equals(1)) {
				distinctCount.remove(firstInt);
			} else {
				distinctCount.put(firstInt, (distinctCount.get(firstInt) - 1));
			}

			if (distinctCount.get(newInt) != null) {
				distinctCount.put(newInt, distinctCount.get(A.get(i)) + 1);
			} else {
				if (distinctCount.get(newInt) != null) {
					distinctCount.put(newInt, distinctCount.get(newInt) + 1);
				} else {
					distinctCount.put(newInt, 1);
				}

			}
			System.out.println(Arrays.toString(distinctCount.keySet().toArray()) + " "
					+ Arrays.toString(distinctCount.values().toArray()));

			returnList.add(distinctCount.size());
		}
		return returnList;

	}

}
