package com.maang.goal.linkedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LinkedListOperations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] array = { { 3, 1, -1 }, { 2, 12, 0 }, { 3, 0, -1 }, { 2, 11, 0 }, { 0, 15, -1 }, { 2, 19, 0 },
				{ 2, 4, 2 }, { 1, 1, -1 }, { 3, 4, -1 }, { 3, 1, -1 }, { 1, 4, -1 }, { 3, 2, -1 }, { 0, 12, -1 },
				{ 0, 7, -1 }, { 0, 17, -1 }, { 2, 9, 6 }, { 0, 6, -1 }, { 3, 0, -1 }, { 1, 10, -1 }, { 3, 5, -1 },
				{ 2, 19, 3 }, { 1, 19, -1 }, { 0, 12, -1 }, { 1, 2, -1 }, { 2, 7, 11 }, { 3, 9, -1 }, { 3, 8, -1 },
				{ 2, 8, 3 }, { 0, 7, -1 }, { 2, 13, 8 }, { 3, 9, -1 }, { 1, 5, -1 }, { 2, 7, 6 }, { 2, 11, 0 },
				{ 3, 9, -1 }, { 0, 3, -1 }, { 0, 1, -1 }, { 0, 1, -1 }, { 2, 3, 11 }, { 0, 4, -1 }, { 2, 6, 19 } };

		List<List<Integer>> A = Arrays.asList(Arrays.asList(3, 1, -1), Arrays.asList(2, 12, 0), Arrays.asList(3, 0, -1),
				Arrays.asList(2, 11, 0), Arrays.asList(0, 15, -1), Arrays.asList(2, 19, 0), Arrays.asList(2, 4, 2),
				Arrays.asList(1, 1, -1), Arrays.asList(3, 4, -1), Arrays.asList(3, 1, -1), Arrays.asList(1, 4, -1),
				Arrays.asList(3, 2, -1), Arrays.asList(0, 12, -1), Arrays.asList(0, 7, -1), Arrays.asList(0, 17, -1),
				Arrays.asList(2, 9, 6), Arrays.asList(0, 6, -1), Arrays.asList(3, 0, -1), Arrays.asList(1, 10, -1),
				Arrays.asList(3, 5, -1), Arrays.asList(2, 19, 3), Arrays.asList(1, 19, -1), Arrays.asList(0, 12, -1),
				Arrays.asList(1, 2, -1), Arrays.asList(2, 7, 11), Arrays.asList(3, 9, -1), Arrays.asList(3, 8, -1),
				Arrays.asList(2, 8, 3), Arrays.asList(0, 7, -1), Arrays.asList(2, 13, 8), Arrays.asList(3, 9, -1),
				Arrays.asList(1, 5, -1), Arrays.asList(2, 7, 6), Arrays.asList(2, 11, 0), Arrays.asList(3, 9, -1),
				Arrays.asList(0, 3, -1), Arrays.asList(0, 1, -1), Arrays.asList(0, 1, -1), Arrays.asList(2, 3, 11),
				Arrays.asList(0, 4, -1), Arrays.asList(2, 6, 19));
		ListNode answer = solve(A);
		extracted(answer);
	}

	private static void extracted(ListNode answer) {
		StringBuilder answerVal = new StringBuilder();
		while (answer != null && answer.next != null) {
			answerVal.append(answer.value + " -> ");
			answer = answer.next;
		}
		if (answer != null) {
			answerVal.append(answer.value + " -> NULL");
		}

		System.out.println(answerVal.toString());
	}

	public static ListNode solve(List<List<Integer>> A) {
		/*
		 * [[0, 1, -1], [1, 2, -1], [2, 3, 1]]
		 */
		ListNode ln = null;

		for (List<Integer> operationsList : A) {
//			extracted(ln);
	//		System.out.println(operationsList.get(0) + " " + operationsList.get(1) + " " + operationsList.get(2));

			if (operationsList.get(0) == 0 && operationsList.get(2) == -1) {
				ListNode tempNode = new ListNode(operationsList.get(1));
				tempNode.next = ln;
				ln = tempNode;
			}

			/*
			 * if (operationsList.get(0) == 1 && operationsList.get(0) == -1) { ListNode
			 * tempNode = new ListNode(operationsList.get(1)); ListNode secondTempNode = ln;
			 * 
			 * while (secondTempNode.next != null) secondTempNode = secondTempNode.next;
			 * 
			 * secondTempNode.next = tempNode;
			 * 
			 * }
			 */
			if (operationsList.get(0) == 1 && operationsList.get(2) == -1) {
				ListNode tempNode = new ListNode(operationsList.get(1));

				if (ln == null) {
					ln = tempNode;
					continue;
				}
				ListNode secondTempNode = ln;

				while (secondTempNode != null && secondTempNode.next != null)
					secondTempNode = secondTempNode.next;

				secondTempNode.next = tempNode;
				/*
				 * extracted(ln); extracted(secondTempNode);
				 */
			}

			if (operationsList.get(0) == 2) {

				ListNode tempNode = new ListNode(operationsList.get(1));

				ListNode secondTempNode = ln;
				if (ln == null && operationsList.get(2) == 0) {
					ln = tempNode;
					continue;
				}

				if (operationsList.get(2) == 0) {
					tempNode.next = ln;
					ln = tempNode;
					continue;
				}

				int counter = 0;

				while (counter < operationsList.get(2) - 1 && secondTempNode.next != null) {
					secondTempNode = secondTempNode.next;
					++counter;
				}

				if (counter == operationsList.get(2) - 1) {
					ListNode secondTemp = secondTempNode.next;
					secondTempNode.next = tempNode;
					tempNode.next = secondTemp;
					continue;

				}
				if (counter == operationsList.get(2) - 2) {

					secondTempNode.next = tempNode;
					continue;

				}

			}

			if (operationsList.get(0) == 3) {
				int indexTobeDeleted = operationsList.get(1);

				if (ln == null)
					continue;

				ListNode lastButNode = ln;
				ListNode lastNode = null;

				if (lastButNode.next != null) {
					lastNode = lastButNode.next;
				}
				if (indexTobeDeleted == 0) {
					ln = ln.next;
					continue;
				}

				int counter = 0;

				while (counter < indexTobeDeleted-1 && lastNode != null) {
					lastButNode = lastNode;
					lastNode = lastNode.next;
					counter++;
				}

				if (counter == indexTobeDeleted-1) {
					if (lastNode != null)
						lastButNode.next = lastNode.next;
					else
						lastButNode.next = null;

				}

			}

		}
		return ln;
	}
}

/*
 * class ListNode { public int val; public ListNode next;
 * 
 * ListNode(int x) { val = x; next = null; } }
 */