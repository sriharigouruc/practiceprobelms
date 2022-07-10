package com.sample.project.stringoperations;

import java.util.Arrays;

public class ReverseSentence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solve("e jrkeymu coklj si vohl slje sxtpf xvak p kicqxoqaof uqwftidoi xixfvqbjey n tpkh ylqllzln ljo gvozwv ")+"*");
	}

	public static String solve(String A) {

		String reveresedString = reverseWord(A.toCharArray(), 0, A.length());

		StringBuilder outputString = new StringBuilder();

		int left = 0, right = 0;

		for (int counter = 0; counter < reveresedString.length(); ++counter) {

			if (reveresedString.toCharArray()[counter] != ' ') {
				++right;

				if (counter == reveresedString.length() - 1) {
					String reveresedStringO = reverseWord(reveresedString.substring(left, right).toCharArray(), 0,
							right - left);
					outputString.append(reveresedStringO + " ");

				}

				continue;
			} else {

				if (left == right) {
					right++;
					left = right;
					continue;

				}

				String reveresedStringO = reverseWord(reveresedString.substring(left, right).toCharArray(), 0,
						right - left);
				outputString.append(reveresedStringO + " ");

				right++;
				left = right;

			}
		}
		if(outputString.charAt(outputString.length()-1) == ' ')
		{
			return outputString.toString().substring(0,outputString.length()-2);
		}
		return outputString.toString();

	}

	public static String reverseWord(char[] charArray, int start, int end) {

		//System.out.println(Arrays.toString(charArray) + " " + start + "  " + end);
		if (end - start < 2) {
			return String.valueOf(charArray);
		}

		int size = end - start;

		for (int i = start; i < (start + end) / 2; ++i) {
			//System.out.println(Arrays.toString(charArray));
			char charact = charArray[i];
			charArray[i] = charArray[start + end - i - 1];
			charArray[start + end - i - 1] = charact;

		}
		//System.out.println(String.valueOf(charArray));
		return String.valueOf(charArray);
	}
}
