package com.maang.goal.linkedlist;

public class SelectiveReverseLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListOperation.insert_node(1, 10);

		LinkedListOperation.insert_node(2, 20);
		LinkedListOperation.insert_node(3, 30);
		/*
		 * LinkedListOperation.insert_node(4, 40); LinkedListOperation.insert_node(5,
		 * 50); LinkedListOperation.insert_node(6, 60);
		 * 
		 * LinkedListOperation.insert_node(7, 70);
		 */
		// LinkedListOperation.insert_node(8, 80);

		LinkedListOperation.print_ll(LinkedListOperation.head);
		ListNode result = reverseBetween(LinkedListOperation.head, 1, 2);
		LinkedListOperation.print_ll(result);

	}

	public static ListNode reverseBetween(ListNode A, int B, int C) {

		int counter = 1;
		ListNode temp = A;
		ListNode prev = null;

		if (temp.next == null)
			return A;

		while (counter < B && temp != null) {
			prev = temp;
			temp = temp.next;
			counter++;
		}

		// //System.out.println("here we goooo");

		ListNode firstNodeFromReversedList = temp;
		ListNode nodesAferReversal = temp;
		ListNode nodesRemaining = temp.next;

		//System.out.println( "firstNodeFromReversedList  " + firstNodeFromReversedList.value);

		while (counter < C && nodesRemaining != null) {

			ListNode currentNode = nodesRemaining;

			nodesRemaining = nodesRemaining.next;
			counter++;
			
			//System.out.println("currentNode" + " " + currentNode.value);
			currentNode.next = nodesAferReversal;
			//System.out.println("nodesAferReversal " + nodesAferReversal.value);
			nodesAferReversal = currentNode;
			//System.out.println("nodesAferReversal after currentNode" + nodesAferReversal.value);
			

			//if (nodesRemaining != null)
				//System.out.println("nodesRemaining" + nodesRemaining.value + " counter " + counter);

		}

		// //System.out.println("here we goooo **** ");

		firstNodeFromReversedList.next = nodesRemaining;
		if (prev != null)
			prev.next = nodesAferReversal;
		else
			return nodesAferReversal;

		return A;
	}

}
