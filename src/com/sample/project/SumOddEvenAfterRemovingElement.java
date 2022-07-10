package com.sample.project;

import java.util.Scanner;

public class SumOddEvenAfterRemovingElement {

	public static void main(String[] args) {

		Scanner inputScanner = new Scanner(System.in);

		String line = inputScanner.nextLine();

		String[] array = line.split("\\s+");

		int[] inputArray = new int[array.length];

		for (int counter = 0; counter < array.length - 1; ++counter) {
			inputArray[counter] = Integer.parseInt(array[counter]);
		}

		int found = solve(inputArray);

		System.out.println(found > 0 ? found : 0);

	}

	private static int solve(int[] inputArray) {
		int countOfInstances = 0;

		int[] evenArray = new int[inputArray.length];
		int[] oddArray = new int[inputArray.length];

		evenArray[0] = inputArray[0];
		oddArray[0] = 0;

		for (int counter = 1; counter < inputArray.length; ++counter) {
			if (counter % 2 == 0) {
				evenArray[counter] = evenArray[counter - 1] + inputArray[counter];
				oddArray[counter] = oddArray[counter - 1];
			} else {
				oddArray[counter] = oddArray[counter - 1] + inputArray[counter];
				evenArray[counter] = evenArray[counter - 1];
			}
		}

		for (int counter = 0; counter < inputArray.length; counter++) {

			if (counter == 0) {
				int sumOffOdd = evenArray[inputArray.length - 1] - evenArray[counter];
				int sumOffEven = oddArray[inputArray.length - 1] - oddArray[counter];
				if (sumOffOdd == sumOffEven)
					countOfInstances++;
			}
			if (counter == inputArray.length - 1) {
				if (evenArray[inputArray.length - 2] == evenArray[inputArray.length - 2])
					++countOfInstances;
			}
			if (counter != inputArray.length - 1 && counter != 0) {

				int sumOffOdd = oddArray[counter - 1] + evenArray[inputArray.length - 1] - evenArray[counter];
				int sumOffEven = evenArray[counter - 1] + oddArray[inputArray.length - 1] - oddArray[counter];
				if (sumOffOdd == sumOffEven)
					countOfInstances++;
			}
		}

		return countOfInstances;
	}

}
