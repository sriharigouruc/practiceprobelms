package com.sample.project;

import java.util.Scanner;

public class FindGoodPair {

	public static void main(String[] args) {

		Scanner inputScanner = new Scanner(System.in);

		String line = inputScanner.nextLine();

		String[] array = line.split("\\s+");

		int[] inputArray = new int[array.length];

		for (int counter = 0; counter < array.length - 1; ++counter) {
			inputArray[counter] = Integer.parseInt(array[counter]);
		}

		Integer sumNumber = Integer.parseInt(inputScanner.nextLine());

		int found = solve(inputArray, sumNumber);

		System.out.println(found>0 ? "1" : "0");

	}

	private static int solve(int[] inputArray, Integer sumNumber) {
		int found = 0;

		for (int counter = 0; counter < inputArray.length - 1; ++counter) {

			int toBeFindNumber = sumNumber - inputArray[counter];

			for (int interalCounter = counter; interalCounter < inputArray.length - 1; ++interalCounter) {
				if (toBeFindNumber == inputArray[interalCounter]) {
					found = 1;
					break;
				}
				if (found>0)
					break;
			}

		}
		return found;
	}

}
/*
 * Problem Description
 * 
 * Given an array A and a integer B. A pair(i,j) in the array is a good pair if
 * i!=j and (A[i]+A[j]==B). Check if any good pair exist or not.
 * 
 * 
 * Problem Constraints
 * 
 * 1 <= A.size() <= 104
 * 
 * 1 <= A[i] <= 109
 * 
 * 1 <= B <= 109
 * 
 * 
 * 
 * Input Format
 * 
 * First argument is an integer array A.
 * 
 * Second argument is an integer B.
 * 
 * 
 * 
 * Output Format
 * 
 * Return 1 if good pair exist otherwise return 0.
 * 
 * 
 * Example Input
 * 
 * Input 1:
 * 
 * A = [1,2,3,4] B = 7
 * 
 * Input 2:
 * 
 * A = [1,2,4] B = 4
 * 
 * Input 3:
 * 
 * A = [1,2,2] B = 4
 * 
 * 
 * 
 * Example Output
 * 
 * Output 1:
 * 
 * 1
 * 
 * Output 2:
 * 
 * 0
 * 
 * Output 3:
 * 
 * 1
 */