package com.sample.project;

import java.util.Scanner;

public class FindPair {

	public static void main(String[] args) {

		Scanner inputScanner = new Scanner(System.in);
		String line = inputScanner.nextLine();

		char firstChar = 'a';
		char secondChar = 'a';
		int[] firstCharindex = new int[line.length()];
		int firstCharcounter = 0;
		int secondCharcounter = 0;
		int[] secondCharindex = new int[line.length()];

		for (int counter = 0; counter <= line.length(); ++counter) {
			
			if(line.charAt(counter) == firstChar) {
				firstCharindex[firstCharcounter]= counter;
				firstCharcounter++;
			}
			if(line.charAt(counter) == secondChar) {
				secondCharindex[secondCharcounter]= counter;
				secondCharcounter++;
			}

		}
		
		for(int counter=0; counter<firstCharcounter;++counter)
		{
			
		}

	}

}
