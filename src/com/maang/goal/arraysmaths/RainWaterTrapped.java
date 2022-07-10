/**
 * 
 */
package com.maang.goal.arraysmaths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author SGouru
 *
 */
public class RainWaterTrapped {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(trap(Arrays.asList(56, 6, 52, 43)));
	}

	public static int trap(final List<Integer> A) {

		int trappedValue = 0;
		if (A.size() <= 2)
			return trappedValue;

		List<Integer> prefixMaxList = new ArrayList<Integer>();
		prefixMaxList.add(A.get(0));
		List<Integer> sufffixMaxList = new ArrayList<Integer>();
		sufffixMaxList.add(A.get(A.size() - 1));

		for (int counter = 1; counter < A.size(); ++counter) {
			if (prefixMaxList.get(counter - 1) > A.get(counter)) {
				prefixMaxList.add(prefixMaxList.get(counter - 1));

			} else {
				prefixMaxList.add(A.get(counter));
			}
		}

		for (int counter = A.size() - 2; counter >= 0; --counter) {

			if (sufffixMaxList.get(0) > A.get(counter)) {
				sufffixMaxList.add(0, sufffixMaxList.get(0));
			} else {
				sufffixMaxList.add(0, A.get(counter));
			}
		}
		StringBuffer suffix = new StringBuffer();
		StringBuffer prefix = new StringBuffer();

		for (int counter = 0; counter < A.size(); ++counter) {
			suffix.append(sufffixMaxList.get(counter) + " ->");
			prefix.append(prefixMaxList.get(counter) + " ->");
		}
		System.out.println(suffix.toString() + " ***********" + prefix.toString());
		for (int counter = 1; counter < A.size() - 1; counter++) {

			trappedValue += A.get(counter) < Math.min(prefixMaxList.get(counter), sufffixMaxList.get(counter))
					? Math.min(prefixMaxList.get(counter), sufffixMaxList.get(counter)) - A.get(counter)
					: 0;
		}

		return trappedValue;

	}

}
