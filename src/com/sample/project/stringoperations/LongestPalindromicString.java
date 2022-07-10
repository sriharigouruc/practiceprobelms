package com.sample.project.stringoperations;

public class LongestPalindromicString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longestPalindrome("babcaacbccccccabbbbbcabaacbaacacccaaabcacbcc"));
	}

	/*
	 * palindromicstring -- even start with 0,1 and keep moving to the right are the
	 * characters are equal. yes --> decrease leftcount, increase the right counter
	 * and check the equality find the length of string and identify the maximum
	 * one. no --> move to next characters. increase the left and right counters and
	 * start again. palindromicstring -- odd are the characters left of & right of
	 * selected index equal. yes --> decrease the leftcount increase the rightcount
	 * 
	 */

	public static String longestPalindrome(String A) {

		String longestPalinDrome = "";

		if (A.length() == 1) {
			return A;
		}

		// even sized string
		for (int counter = 0; counter + 1 < A.length(); ++counter) {
			//System.out.println(counter);
			String currentString = isPalindrome(A, counter, counter + 1);
			//System.out.println("currentString " + currentString + " longestPalinDrome " + longestPalinDrome);
			longestPalinDrome = currentString.length() > longestPalinDrome.length() ? currentString : longestPalinDrome;
		}

		// odd sized string
		for (int counter = 0; counter + 1 < A.length(); ++counter) {
			//System.out.println(counter);
			String currentString = isPalindrome(A, counter - 1, counter + 1);
			//System.out.println("currentString " + currentString + " longestPalinDrome " + longestPalinDrome);
			longestPalinDrome = longestPalinDrome.length() < currentString.length() ? currentString : longestPalinDrome;
		}

		return longestPalinDrome;
	}

	public static String isPalindrome(String A, int startCounter, int endCounter) {
		StringBuffer palinDrome = new StringBuffer();

		while (startCounter >= 0 && endCounter < A.length()) {

			if (A.charAt(endCounter) == A.charAt(startCounter)) {
				++endCounter;
				--startCounter;
			} else {
				break;
			}
		}
		if (startCounter != endCounter - 1) {
			palinDrome.append(A.substring(startCounter + 1, endCounter));
		}

		return palinDrome.toString();
	}
}
