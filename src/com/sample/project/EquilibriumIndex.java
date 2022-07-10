package com.sample.project;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EquilibriumIndex {

	public static int solve(int[] array) {

		int[] sumArray = new int[array.length];

		sumArray[0] = array[0];

		for (int i = 1; i < array.length; ++i) {
			sumArray[i] = sumArray[i - 1] + array[i];

		}
		if (sumArray[0] == 0)
			return 0;
		if (sumArray[array.length - 1] == 0)
			return array.length - 1;
		int found = -1;
		for (int counter = 1; counter < array.length; ++counter) {
			int sumBefore = sumArray[counter - 1];
			int sumAfter = sumArray[array.length - 1] - sumArray[counter];
			if (sumBefore == sumAfter) {
				return found = counter;
			}
		}
		return found;
	}

	public static void main(String[] args) {

		Scanner inputScanner = new Scanner(System.in);

		String line = inputScanner.nextLine();

		String[] array = line.split("\\s+");

		int[] inputArray = new int[Integer.parseInt(array[0])];

		for (int counter = 0; counter < array.length - 1; ++counter) {
			inputArray[counter] = Integer.parseInt(array[counter + 1]);
		}

		int found = solve(inputArray);

		System.out.println(found > 0 ? found : -1);

	}

}

/**
 * Problem Description

You are given an array A of integers of size N.

Your task is to find the equilibrium index of the given array

Equilibrium index of an array is an index such that the sum of elements at lower indexes is equal to the sum of elements at higher indexes.

NOTE:

Array indexing starts from 0.
If there is no equilibrium index then return -1.
If there are more than one equilibrium indexes then return the minimum index.



Problem Constraints

1<=N<=1e5
-1e5<=A[i]<=1e5



Input Format

First arugment contains an array A .


Output Format

Return the equilibrium index of the given array. If no such index is found then return -1.


Example Input

Input 1:

A=[-7, 1, 5, 2, -4, 3, 0]

Input 2:

A=[1,2,3]



Example Output

Output 1:

3

Output 2:

-1



Example Explanation

Explanation 1:

3 is an equilibrium index, because: 
A[0] + A[1] + A[2] = A[4] + A[5] + A[6]

Explanation 1:

There is no such index.

 * */
 