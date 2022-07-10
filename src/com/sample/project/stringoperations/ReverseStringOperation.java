package com.sample.project.stringoperations;

import java.util.Scanner;

public class ReverseStringOperation {

	public static void main(String[] args) {
		Scanner inputScanner = new Scanner(System.in);
		String line = inputScanner.nextLine();
		int start = 0, end = line.length();
		char[] charArray = line.toCharArray();

		if (end - start < 2) {
			System.out.println(String.valueOf(charArray));
		}

		int size = end - start;

		for (int i = start; i < (start + end) / 2; ++i) {
			// System.out.println(Arrays.toString(charArray));
			char charact = charArray[i];
			charArray[i] = charArray[start + end - i - 1];
			charArray[start + end - i - 1] = charact;

		}
		System.out.println(String.valueOf(charArray));

	}

}
