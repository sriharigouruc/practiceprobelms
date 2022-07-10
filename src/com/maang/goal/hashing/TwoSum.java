/**
 * 
 */
package com.maang.goal.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author SGouru
 *
 */
public class TwoSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> inputList = Arrays.asList(4, 7, -4, 2, 2, 2, 3, -5, -3, 9, -4, 9, -7, 7, -1, 9, 9, 4, 1, -4, -2,
				3, -3, -5, 4, -7, 7, 9, -4, 4, -8);
		System.out.println(Arrays.asList(twoSum(inputList, -3).toArray()));
	}

	public static ArrayList<Integer> twoSum(final List<Integer> A, int B) {

		Map<Integer, Integer> elementsPresence = new HashMap<Integer, Integer>();
		ArrayList<Integer> returnList = new ArrayList<Integer>();
		for (int i = 0; i < A.size(); ++i) {
			if (elementsPresence.containsKey(B - A.get(i))) {
				returnList.add(elementsPresence.get(B - A.get(i)) + 1);
				returnList.add(i + 1);
				return returnList;
			} else {
				if (!elementsPresence.containsKey(A.get(i)))
					elementsPresence.put(A.get(i), i);
			}
		}

		return returnList;
	}
}
