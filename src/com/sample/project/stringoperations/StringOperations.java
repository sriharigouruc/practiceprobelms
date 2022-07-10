package com.sample.project.stringoperations;

import java.util.Arrays;
import java.util.List;

public class StringOperations {
/**
 * concatenate the string with self.
 * remove the capital letters
 * replace each vowel with #
 */
		
	public static void main(String args[])
	{
		String operatingString = "AbcaZeoB";
		String vowelsString = "a,e,i,o,u";
		System.out.println(vowelsString.split(","));
		List<String> vowelsList =  Arrays.asList( vowelsString.split(","));
		System.out.println(vowelsList);
		String outputString ="";
		
		for(int i=0;i<operatingString.length(); ++i)
		{
			char currentChar = operatingString.charAt(i);
			if( Character.isUpperCase(currentChar))
				continue;
			if( vowelsList.contains(currentChar+""))
				outputString += "#" ;
			else
				outputString += currentChar;
		}
		
		outputString += outputString;
		System.out.println(outputString);
				
	}
	
}


