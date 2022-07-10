/**
 * 
 */
package com.sample.project.sorting;

import java.util.Arrays;

/**
 * @author SGouru
 *
 */
public class MergeSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// int[] A = { 1, 23, 4, 5, 6, 7, 8, };
		int[] A = { 1, 23, 4 };
		sortColors(A);
	}

	public static int[] sortColors(int[] A) {

		int[] returnArray = new int[A.length];

		System.out.println(Arrays.toString(A) + " ** ");

		if (A.length > 1) {

			int[] firstSubArray = Arrays.copyOfRange(A, 0, A.length / 2);
			int[] secondSubArray = Arrays.copyOfRange(A, A.length / 2, A.length);

			int[] firstReturnArray = sortColors(firstSubArray);
			int[] secondReturnArray = sortColors(secondSubArray);

			/*
			 * System.out.println("firstReturnArray" + Arrays.toString(firstReturnArray));
			 * System.out.println("secondReturnArray" + Arrays.toString(secondReturnArray));
			 */
			int firstCounter = 0, secondCounter = 0, returnCounter = 0;

			while (firstCounter < firstReturnArray.length && secondCounter < secondReturnArray.length) {

				if (firstReturnArray[firstCounter] > secondReturnArray[secondCounter]) {
					returnArray[returnCounter] = secondReturnArray[secondCounter];
					++secondCounter;
					++returnCounter;
					continue;
				}
				if (firstReturnArray[firstCounter] <= secondReturnArray[secondCounter]) {
					returnArray[returnCounter] = firstReturnArray[firstCounter];
					++firstCounter;
					++returnCounter;
					continue;
				}
			}
			
			

			while (firstCounter == firstReturnArray.length && secondCounter < secondReturnArray.length) {
//				System.out.println("++--> " + Arrays.toString(returnArray)+ " secondCounter " + secondCounter + " firstCounter " + firstCounter);
				returnArray[returnCounter] = secondReturnArray[secondCounter];
				++secondCounter;
				++returnCounter;
			}

			while (secondCounter == secondReturnArray.length && firstCounter < firstReturnArray.length) {
	//			System.out.println("++--<<<> " + Arrays.toString(returnArray)+ " secondCounter " + secondCounter + " firstCounter " + firstCounter);
				returnArray[returnCounter] = firstReturnArray[firstCounter];
				++firstCounter;
				++returnCounter;
			}

		} else {
			return A;
		}

		System.out.println(Arrays.toString(returnArray));

		return returnArray;
	}

}
