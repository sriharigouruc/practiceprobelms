package com.sample.project;

public class MaxOnesByReplacingZeroFromGivenString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int[] A = { 0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 0, 1 };
		System.out.println(solve("111011010010100000011010011001000100101110010000010"));
	}

	public static int solve(String A) {
		int returnValue = -1;

		int leftCount = 0;
		int rightCount = 0;
		int counter = 0;
		int zeroIndex = 0;
		int lastZeroIndex = 0;

		int maxOnesCount = 0;
		int totalOnes = 0;

		for (int innerCounter = 0; innerCounter < A.length(); ++innerCounter) {
			if (A.charAt(innerCounter) == '1') {
				++totalOnes;
			}

		}
		System.out.println("totalOnes" + totalOnes);
		while (counter < A.length()) {

			if (A.charAt(counter) == '0' && zeroIndex < 1) {
				++zeroIndex;
				lastZeroIndex = counter;
			} else {
				if (A.charAt(counter) == '0' && zeroIndex == 1) {
					++zeroIndex;
					break;
				} else {
					if (A.charAt(counter) == '1' && zeroIndex == 0) {
						++leftCount;

					} else {
						if (A.charAt(counter) == '1' && zeroIndex == 1) {
							++rightCount;
						}
					}
				}
			}

			++counter;

		}

		while (counter < A.length()) {
			/*
			 * System.out.println("leftCount " + leftCount + " rightCount " + rightCount +
			 * " counter " + counter + "maxOnesCount"+ maxOnesCount);
			 */

			if (A.charAt(counter) == '0') {
				System.out.println("counter" + counter + " leftCount " + leftCount + "rightCount " + rightCount );
				int currentOnesCount = leftCount + rightCount;
				if (totalOnes > currentOnesCount) {
					currentOnesCount = currentOnesCount + 1;
				}
				if (currentOnesCount > maxOnesCount) {
					returnValue = lastZeroIndex;
					maxOnesCount = currentOnesCount;
				}
				leftCount = rightCount;
				rightCount = 0;
				lastZeroIndex = counter;
			} else {
				++rightCount;
			}

			++counter;

		}

		int currentOnesCount = leftCount + rightCount;

		if (totalOnes > currentOnesCount) {
			currentOnesCount = currentOnesCount + 1;
		}
		if (currentOnesCount > maxOnesCount) {
			returnValue = lastZeroIndex;
			maxOnesCount = currentOnesCount;
		}

		// System.out.println("returnValue" + returnValue);
		return maxOnesCount;
	}
}
