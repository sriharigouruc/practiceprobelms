package com.maang.goal.linkedlist;

public class KReverseLinkedList {

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
		ListNode result = reverseList(LinkedListOperation.head,2);
		
		LinkedListOperation.print_ll(result);
	}

	public static ListNode reverseList(ListNode A, int B) {

		if (A == null)
			return null;

		ListNode newHead = null, tempHead =A;
		
		ListNode currentHead = A, tempNode = null;

		int counter = 0;

		while (counter < B && currentHead != null) {
			tempNode = currentHead;
			currentHead = currentHead.next;
			tempNode.next = newHead;
			newHead = tempNode;
			counter++;
		}

		A.next = reverseList(currentHead, B);

		return newHead;
	}
}
