package com.maang.goal.linkedlist;

public class LinkedListOperation {

	static ListNode head = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		insert_node(1, 23);
		insert_node(2, 24);
		insert_node(3, 34);
		insert_node(4, 44);
		insert_node(5, 54);
		insert_node(6, 64);
		print_ll(head);
		delete_node(4);
		print_ll(head);
	}

	public static void insert_node(int position, int value) {
		// @params position, integer
		// @params value, integer

		ListNode listNode = new ListNode(value);

		if (head == null) {
			head = listNode;
			return;
		}
		if (head != null) {
			ListNode tempNode = head;
			int counter = 1;
			while (tempNode.next != null && counter < position) {
				tempNode = tempNode.next;
				++counter;
			}

			ListNode tail = tempNode.next;
			tempNode.next = listNode;
			tempNode = tempNode.next;
			tempNode.next = tail;

		}
	}

	public static void delete_node(int position) {

		if (position == 1 && head != null) {
			head = head.next;
			return;
		}

		if (head != null) {

			ListNode tempNode = head;
			int counter = 1;

			while (tempNode.next != null && counter < position) {
				tempNode = tempNode.next;
				++counter;
			}

			ListNode tail = tempNode.next;

			if (tail != null)
				tempNode.next = tail.next;
			else
				tempNode.next = null;

		}

	}

	public static void print_ll(ListNode heads) {
		// Output each element followed by a space

		if (heads != null) {
			ListNode tempNode = heads;

			StringBuffer output = new StringBuffer();

			while (tempNode != null) {
				output.append(tempNode.value + " ");
				tempNode = tempNode.next;

			}
			System.out.println(output.toString());
		}
	}

}

class ListNode {
	int value;
	ListNode next;

	ListNode(int value) {
		this.value = value;
	}
}
