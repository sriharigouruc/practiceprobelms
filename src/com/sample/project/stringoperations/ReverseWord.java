package com.sample.project.stringoperations;

import java.util.Arrays;

public class ReverseWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(solve("scaler"));
	}

	public static String solve(String A) {

		if (A.length() < 2) {
			return A;
		}

		char[] charArray = A.toCharArray();
		int size = charArray.length;

		for (int i = 0; i < size / 2; ++i) {
			//System.out.println(Arrays.toString(charArray));
			char charact = charArray[i];
			charArray[i] = charArray[size - i-1];
			charArray[size - i-1] = charact;
			
		}
		return String.valueOf(charArray);
	}

}
