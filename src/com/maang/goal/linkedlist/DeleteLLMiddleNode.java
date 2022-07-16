package com.maang.goal.linkedlist;

public class DeleteLLMiddleNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListOperation.insert_node(1, 10);
		LinkedListOperation.insert_node(2, 20);
		LinkedListOperation.insert_node(3, 30);
		LinkedListOperation.insert_node(4, 40);
		LinkedListOperation.insert_node(5, 50);
		LinkedListOperation.insert_node(6, 60);
		
		LinkedListOperation.insert_node(7, 70);
		//LinkedListOperation.insert_node(8, 80);
		
		LinkedListOperation.print_ll(LinkedListOperation.head);
		solve(LinkedListOperation.head);
	}

	public static int solve(ListNode A) {

		ListNode returnValue = null;
		ListNode fast = A, slow = A;

		while (fast != null && fast.next != null) {
			slow = slow.next;

			fast = fast.next.next;
		}		
		return slow.value;
	}

}

/*
 * Definition for singly-linked list. class ListNode {
 * 
 * public int val; public ListNode next;
 * 
 * ListNode(int x) { val = x; next = null; } }
 */