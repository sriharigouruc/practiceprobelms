package com.sample.project;

import java.util.Scanner;

public class MinMax {

	public static void main(String[] args) {
		Scanner inputScanner = new Scanner(System.in);

		
		String line = inputScanner.nextLine();
		
		
		String[] array =line.split("\\s+");

		int[] inputArray = new int[Integer.parseInt(array[0])];

		int min, max;

		for (int counter = 0; counter < array.length-1; ++counter) {
			inputArray[counter] = Integer.parseInt(array[counter+1]);
		}

		min = inputArray[0];
		max = inputArray[0];

		for (int counter = 1; counter < inputArray.length; ++counter) {
			if (min > inputArray[counter])
				min = inputArray[counter];
			if (max < inputArray[counter])
				max = inputArray[counter];
		}
		System.out.println(max + " " + min);
	}

}
