package com.sample.project;

public class SpecialSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String a="AABGAAG";
		System.out.println(solve(a));
				
	}

	
	public static int solve(String A) {
		
		int returnvalue = 0;
		
		char achar='A';
		char gchar='G';
		int acharcount=0;
		int gcharcount=0;
		
		
		for(int counter=0; counter< A.length();++counter)
		{
			if(A.charAt(counter)==achar)
			{
				++acharcount;
			}
			
			if(A.charAt(counter)==gchar)
			{
				++gcharcount;
				returnvalue+=acharcount;
			}
		}
		
		return returnvalue;
				
    }
	
}
