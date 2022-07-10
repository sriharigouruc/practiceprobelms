package com.sample.project;

import java.util.Scanner;

public class PerfectNumber {

	public static void main(String[] args) {
		/*
		 * Integer numberOfInputs; Scanner inputScanner = new Scanner(System.in);
		 * 
		 * numberOfInputs = inputScanner.nextInt();
		 * 
		 * for (int i = 0; i < numberOfInputs; ++i) {
		 * 
		 * int sum = 1;
		 * 
		 * int nextNumber = inputScanner.nextInt();
		 * 
		 * if (nextNumber <= 2) { System.out.println("NO"); continue; }
		 * 
		 * for (int j = 2; j <= nextNumber / 2; ++j) { if (nextNumber % j == 0) {
		 * 
		 * sum = sum + j; } }
		 * 
		 * if (sum == nextNumber) {
		 * 
		 * System.out.println("YES"); } else { System.out.println("NO"); }
		 * 
		 * }
		 */

		int sum = -1;

		Scanner inputScanner = new Scanner(System.in);

		int number = inputScanner.nextInt();
		 

		for (int counter = 1; counter * counter <= number; ++number) {
			if(counter * counter == number)
			{
				sum =counter;
				break;
			}
		}
		System.out.println(sum);

	}

}
