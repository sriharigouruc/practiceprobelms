package com.sample.project;

public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(recursiveReverse("MyString"));
	}

	public static String recursiveReverse(String string) {

		String s = "";

		if (string.length() > 1) {

			s = string.substring(string.length() - 1) + recursiveReverse(string.substring(0, string.length() - 1));

		}
		if (string.length() == 1) {
			return string;
		}

		return s;

	}

}
