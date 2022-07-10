package com.maang.goal.recursion;

public class FindSumOfDigitsUsingRecursion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solve(46));
	}
	
	public static int solve(int A) {
		if(A<10)
			return A;
		return A%10+ solve(A/10);
    }

}
