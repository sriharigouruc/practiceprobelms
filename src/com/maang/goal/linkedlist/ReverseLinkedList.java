package com.maang.goal.linkedlist;

public class ReverseLinkedList {

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
		ListNode result = reverseList(LinkedListOperation.head);
		LinkedListOperation.print_ll(result);
	}

	public static ListNode reverseList(ListNode A) {

		ListNode newHead = null;
		ListNode currentHead = A, tempNode = A;

		while (currentHead != null) {
			tempNode = currentHead;
			currentHead = currentHead.next;
			tempNode.next = newHead;
			newHead = tempNode;
		}
		return newHead;
	}

}
