package com.mang.goal.recursion;

public class FibonacciGenerator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println(findAthFibonacci(2));
System.out.println(findAthFibonacci(9));
	}

	public static int findAthFibonacci(int A) {
		if (A < 0)
			return -1;

		if (A == 1)
			return 1;
		if (A == 0)
			return 0;
		
		return findAthFibonacci(A-1)+findAthFibonacci(A-2);
	}
}
