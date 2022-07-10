/**
 * 
 */
package com.maang.goal.stacks;

/**
 * @author SGouru
 *
 */
public class BalancedParanthesis {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solve("(())(())"));
	}

	public static int solve(String A) {
		int returnValue = 0;
		char[] chars = A.toCharArray();
		int leftParanCount = 0, rightPranCount = 0;

		for (char a : chars) {
			if (a == '(')
				++leftParanCount;
			else
				++rightPranCount;

			if (leftParanCount < rightPranCount)
				return 0;
		}

		if (leftParanCount != rightPranCount)
			return 0;
		else
			return 1;

	}

}
