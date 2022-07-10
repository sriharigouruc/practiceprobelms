package com.sample.project;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class RotateArray {

	public static void main(String[] args) {
		Scanner inputScanner = new Scanner(System.in);

		String line = inputScanner.nextLine();

		String[] array = line.split("\\s+");

		int[] inputArray = new int[Integer.parseInt(array[0])];

		for (int counter = 0; counter < array.length - 1; ++counter) {
			inputArray[counter] = Integer.parseInt(array[counter + 1]);
		}

		int rotateNumber = inputScanner.nextInt();
		/* rotate the array here */
		for (int counter = 0; counter < inputArray.length / 2; ++counter) {
			int temp = inputArray[counter];

			inputArray[counter] = inputArray[inputArray.length - 1 - counter];

			inputArray[inputArray.length - 1 - counter] = temp;

		}

		if (rotateNumber % inputArray.length > 0)
			rotateNumber = rotateNumber % inputArray.length;

		for (int counter = 0; counter < rotateNumber / 2; ++counter) {
			int temp = inputArray[counter];

			inputArray[counter] = inputArray[rotateNumber - 1 - counter];

			inputArray[rotateNumber - 1 - counter] = temp;

		}

		for (int counter = rotateNumber ; counter < (rotateNumber + inputArray.length) / 2; ++counter) {
			int temp = inputArray[counter];

			inputArray[counter] = inputArray[inputArray.length - 1 - counter+rotateNumber];

			inputArray[inputArray.length - 1 - counter+rotateNumber] = temp;

		}

		/*
		 * IntStream stream = Arrays.stream(inputArray); stream.forEach(value ->
		 * System.out.print(value + " "));
		 */
		
		for(int counter =0; counter< inputArray.length; ++counter)
		{
			System.out.print(inputArray[counter] + " ");
		}
	}

}
