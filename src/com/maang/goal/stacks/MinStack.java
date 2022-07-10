/**
 * 
 */
package com.maang.goal.stacks;

/**
 * @author SGouru
 *
 */
public class MinStack {

	int[] stack = new int[(int) Math.pow(10, 7)];
	int currentTop = -1;
	int[] minStack = new int[(int) Math.pow(10, 7)];
	int minSoFar = Integer.MIN_VALUE;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 9 8 7 6 7 8 9 10 -1
		MinStack minStack = new MinStack();
		minStack.push(9);
		System.out.println(minStack.getMin());
		minStack.push(8);
		System.out.println(minStack.getMin());
		minStack.push(7);
		System.out.println(minStack.getMin());
		minStack.push(10);
		System.out.println(minStack.getMin());
		minStack.push(-1);
		System.out.println(minStack.getMin());
	}

	public void push(int x) {
		if (currentTop == -1)
			minStack[currentTop + 1] = x;
		else
			minStack[currentTop + 1] = x < minStack[currentTop] ? x : minStack[currentTop];

		stack[++currentTop] = x;

	}

	public void pop() {
		if (currentTop > -1)
			--currentTop;
	}

	public int top() {
		return currentTop > -1 ? stack[currentTop] : -1;
	}

	public int getMin() {
		return currentTop > -1 ? minStack[currentTop] : -1;
	}
}
