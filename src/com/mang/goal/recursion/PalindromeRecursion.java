package com.mang.goal.recursion;

public class PalindromeRecursion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solve("aaanamanaaa"));
		System.out.println(solve("aabbccbbaa"));
	}

	public static int solve(String A) {

		if (A.length() <= 1)
			return 1;
		else {
			
			if (A.charAt(0) == A.charAt(A.length()-1))
				return solve(A.substring(1, A.length()-1));
			else
				return 0;
		}

	}

}
