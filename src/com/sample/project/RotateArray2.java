package com.sample.project;

import java.util.Scanner;

public class RotateArray2 {

	public static int[] solve(final int[] A) {
		for (int counter = 0; counter < A.length / 2; ++counter) {
			int temp = A[counter];

			A[counter] = A[A.length - 1 - counter];

			A[A.length - 1 - counter] = temp;
		}
		return A;
	}

	public static void main(String args[]) {
		Scanner inputScanner = new Scanner(System.in);

		String line = inputScanner.nextLine();

		String[] array = line.split("\\s+");

		int[] inputArray = new int[Integer.parseInt(array[0])];

		for (int counter = 0; counter < array.length - 1; ++counter) {
			inputArray[counter] = Integer.parseInt(array[counter + 1]);
		}

		int[] outputArray = solve(inputArray);
		for (int counter = 0; counter < outputArray.length; ++counter) {
			System.out.print(outputArray[counter] + " ");
		}

	}
}
