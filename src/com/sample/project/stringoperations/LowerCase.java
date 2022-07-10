package com.sample.project.stringoperations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class LowerCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Character[]  charArray = {Character.valueOf('A'),Character.valueOf('a'),Character.valueOf('1')};
		System.out.println(isAlphaNumeric(Arrays.asList(charArray)));
	}

	public ArrayList<Character> to_lower(ArrayList<Character> A) {

		A.replaceAll(
				i -> ((i.charValue() > 64 && i.charValue() < 91) ? Character.valueOf((char) (i.charValue() + 31)) : i));
		return A;
	}

	public static int isAlphaNumeric(List<Character> A) {
		int returnValue = 0;

		
		Iterator<Character> iterator = A.iterator();
		while (iterator.hasNext()) {
			int charValue = iterator.next().charValue();
			if (!((charValue > 64 && charValue < 91) || (charValue > 96 && charValue < 123)
					|| (charValue > 47 && charValue < 58))) {
				returnValue = 1;
				break;
			}
		}
		return returnValue;
	}
}
