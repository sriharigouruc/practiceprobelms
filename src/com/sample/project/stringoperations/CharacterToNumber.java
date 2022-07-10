package com.sample.project.stringoperations;

public class CharacterToNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(titleToNumber("AB"));
		System.out.println(titleToNumber("ABCD"));

	}

	public static int titleToNumber(String A) {

		char[] charArray = A.toCharArray();
		int retrunValue = 0;

		int counter = charArray.length - 1;

		int exponential = 0;

		while (counter >= 0) {

			if (charArray.length - 1 - counter == 0) {
				exponential = 1;
			} else {

				exponential = exponential * 26;
			}
			retrunValue += (charArray[counter] - 64) * exponential;
			--counter;
		}
		return retrunValue;
	}

}
