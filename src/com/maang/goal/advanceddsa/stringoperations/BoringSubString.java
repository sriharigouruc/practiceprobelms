package com.maang.goal.advanceddsa.stringoperations;

import java.util.Arrays;

public class BoringSubString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(removeBoringSubstring("zmzbuwfbvsxtqplkojgjqn"));
		// System.out.println(removeBoringSubstring("abcd"));

	}

	public static boolean check(String string) {
		boolean result = true;

		for (int i = 1; i < string.length(); ++i) {
			if (Math.abs(string.charAt(i) - string.charAt(i - 1)) == 1) {
				return false;
			}

		}

		return result;

	}

	public static String removeBoringSubstring(String s) {

		String evenChars = "", oddChars = "";

		if (!check(s)) {
			for (char charact : s.toCharArray()) {

				if (charact % 2 == 0) {
					evenChars += charact;
				} else {
					oddChars += charact;
				}
			}
			char[] evenCharsArray = evenChars.toCharArray();
			Arrays.sort(evenCharsArray);
			evenChars = new String(evenCharsArray);

			char[] oddCharsArray = oddChars.toCharArray();
			Arrays.sort(oddCharsArray);
			oddChars = new String(oddCharsArray);

			s = evenChars + oddChars;
		}

		if (check(s))
			return s;
		else {
			if (check(oddChars + evenChars))
				return oddChars + evenChars;
			else {
				return "0";

			}
		}

	}

	public int solve(String s) {

		String evenChars = "", oddChars = "";

		if (!check(s)) {
			for (char charact : s.toCharArray()) {

				if (charact % 2 == 0) {
					evenChars += charact;
				} else {
					oddChars += charact;
				}
			}
			char[] evenCharsArray = evenChars.toCharArray();
			Arrays.sort(evenCharsArray);
			evenChars = new String(evenCharsArray);

			char[] oddCharsArray = oddChars.toCharArray();
			Arrays.sort(oddCharsArray);
			oddChars = new String(oddCharsArray);

			s = evenChars + oddChars;
		}

		if (check(s))
			return 1;
		else {
			if (check(oddChars + evenChars))
				return 1;
			else {
				return 0;

			}
		}

	}

}
