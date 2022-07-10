package com.sample.project;

public class MaxOnesByReplacingZero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = { 0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 0, 1 };
		solve(A);
	}

	public static int solve(int A[]) {
		int returnValue = -1;

		int leftCount = 0;
		int rightCount = 0;
		int counter = 0;
		int zeroIndex = 0;
		int lastZeroIndex = 0;
		int maxOnesCount = 0;

		while (counter < A.length) {

			if (A[counter] == 0 && zeroIndex < 1) {
				++zeroIndex;
				lastZeroIndex = counter;
			} else {
				if (A[counter] == 0 && zeroIndex == 1) {
					++zeroIndex;
					break;
				} else {
					if (A[counter] == 1 && zeroIndex == 0) {
						++leftCount;

					} else {
						if (A[counter] == 1 && zeroIndex == 1) {
							++rightCount;
						}
					}
				}
			}

			++counter;

		}

		while (counter < A.length) {
			/*
			 * System.out.println("leftCount " + leftCount + " rightCount " + rightCount +
			 * " counter " + counter + "maxOnesCount"+ maxOnesCount);
			 */

			if (A[counter] == 0) {

				if (leftCount + rightCount + 1 > maxOnesCount) {
					returnValue = lastZeroIndex;
					maxOnesCount = leftCount + rightCount + 1;
				}
				leftCount = rightCount;
				rightCount = 0;
				lastZeroIndex = counter;
			} else {
				++rightCount;
			}
			++counter;

		}
		// System.out.println("returnValue" + returnValue);
		return returnValue;
	}
}
