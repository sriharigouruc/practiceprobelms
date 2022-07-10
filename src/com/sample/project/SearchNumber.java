package com.sample.project;

import java.util.Scanner;

public class SearchNumber {

static Scanner inputScanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int numberOfCases = Integer.parseInt(inputScanner.nextLine());
		int array[] = new int[numberOfCases];
		for(int counter=0;counter<numberOfCases;++counter)
		{
			array[counter]= takeInput();
		}
		for(int counter=0;counter<numberOfCases;++counter)
		{
			System.out.println(array[counter]);
		}
		
	}
	
	public static int takeInput() {
		
		
		String line = inputScanner.nextLine();

		String[] array = line.split("\\s+");

		int[] inputArray = new int[Integer.parseInt(array[0])];

		for (int counter = 0; counter < array.length - 1; ++counter) {
			inputArray[counter] = Integer.parseInt(array[counter + 1]);
		}

		int findNumber = Integer.parseInt(inputScanner.nextLine());

		return searchNumber(inputArray, findNumber);

	}
	

	public static int searchNumber(final int[] inputArray, int searchNumber) {
		boolean found = false;

		for (int counter = 0; counter < inputArray.length; ++counter) {
			if (inputArray[counter] == searchNumber) {
				found = true;
				break;
			}
		}
		return (found ? 1 : 0);
	}

}
