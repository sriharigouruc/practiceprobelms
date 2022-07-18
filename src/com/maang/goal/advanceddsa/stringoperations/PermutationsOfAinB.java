package com.maang.goal.advanceddsa.stringoperations;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class PermutationsOfAinB {

	static Map map = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String B = "bcabaabaacabcabccccabaccabcccacacbbcaabcccaababccccbcaaacbccaaaabbbcbb";

		System.out.println(solve(B,
				"bacbbbacbaabbccaacbbbaabacbcacbbcbcbaacbbbbbbbbcabaacaacbabbaabbcaabcaaacbbacbacbacccbbabaccaaccbbabcabcbccabbcacccbabacccacbbaccccacbbbabbbaccbcacabaabcbaabacbbcbbaabbcbbccbaaccacacabcbbabbabbcabcbbaccbbcabcaccaabacbcbbbcabcabcccacaacbabaaccbbbccacabcbaccbaacbccabaabcabcacacaaabbcbbaaaacbbbbaaccbccbccbbbbccbcaaacbbbcaaabcbaacabbbcabcccaabbcacccccacccbccaaacbbbaaacbcbcaccacbbcaaaaabcaacacbacbbcccacccaabccbbabaabaccbabcbbbbcaccababcccbbbcabcccccccacacaccabbccabacaccbaaaccbcbbccacacabcacbccaacbcacacaaccaabbaabaccbcaababbbcbbababaaabacccabcaaabaaacbbbcabaaabaccbbccbccbcacacbbbcaabbbaacccaabacaaabccbaaaacccabaaacbbabbaabbcaccacbbcbabbbbbbbccacbabababbcccbbcacbbaabcbaabcbbbabbbbabaaacccacabaccabababbbaabacbacbaacbbaaabbcaacbacbaacaacabaccbcccccbcbbcccabcbcbabbabbbcbbccbbabaaaccbbacbacabacbcbabaccaaacbabccbccbaacccbccaaabababbcbaccbaccbbcccbcbcba"));

	}

	public static int solve(String B, String A) {

		int result = 0;

		int bIntValue = 0;
		for (char c : B.toCharArray()) {
			bIntValue += (c - 'a') * (c - 'a');
		}

		int counter = 0;
		int aIntValue = 0;
		for (; counter < B.length(); ++counter) {
			aIntValue += (A.charAt(counter) - 'a') * (A.charAt(counter) - 'a');
		}

		// System.out.println(counter + " " + aIntValue);
		if (aIntValue == bIntValue)
			++result;

		while (counter < A.length()) {
			int value = counter - B.length();
			aIntValue -= (A.charAt(value) - 'a') * (A.charAt(value) - 'a');
			aIntValue += (A.charAt(counter) - 'a') * (A.charAt(counter) - 'a');

			if (aIntValue == bIntValue) {
				++result;
				checkEquality(B, A.substring(value, counter));
				System.out.println(aIntValue);
			}

			++counter;
		}

		return result;
	}

	public static boolean checkEquality(String b, String input) {
		
		Map inputMap = null;

		if (map == null) {
			map = new HashMap();

			for (char a : b.toCharArray()) {
				if (!map.containsKey(a)) {
					map.put(a, 1);
				} else {
					map.put(a, (Integer) map.get(a) + 1);
				}
			}

		}
		inputMap = new HashMap();

		for (char a : b.toCharArray()) {
			if (!inputMap.containsKey(a)) {
				inputMap.put(a, 1);
			} else {
				inputMap.put(a, (Integer) inputMap.get(a) + 1);
			}
		}
		Iterator inputSetIterator  = inputMap.keySet().iterator();
		while(inputSetIterator.hasNext())
		{
			char charact = (char)inputSetIterator.next();
			if(inputMap.get(charact) !=map.get(charact)) 
				return false;
		}
		
		System.out.println(b+" " + input + " are equal");
		return true;
	}

}
