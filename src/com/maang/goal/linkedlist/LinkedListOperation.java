package com.maang.goal.linkedlist;

public class LinkedListOperation {

	static ListNodeO head = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		insert_node(1, 23);
		insert_node(2, 24);
		print_ll();
	}

	public static void insert_node(int position, int value) {
		// @params position, integer
		// @params value, integer
		
		if (head == null) {
			head = new ListNodeO(value);
			System.out.println("here1");
		}
		if (head != null) {
			ListNodeO tempNode = head;
			int counter = 1;
			while (tempNode.next != null && counter <= position) {
				tempNode = tempNode.next;
				++counter;
			}
			if(counter == position)
			{
				ListNodeO listNode = new ListNodeO(value);
				
						
			}
			System.out.println("here2");
		}
	}

	public static void delete_node(int position) {
		// @params position, integer
	}

	public static void print_ll() {
		// Output each element followed by a space
		System.out.println("here3");
		if (head != null) {
			ListNodeO tempNode = head;
			System.out.println("here33");
			
			StringBuffer output = new StringBuffer();

			while (tempNode.next != null) {
				output.append(tempNode.value + " ");
				tempNode = tempNode.next;

			}

			System.out.println(output.toString().trim());

		}
	}

}

class ListNodeO {
	int value;
	ListNodeO next;

	ListNodeO(int value) {
		this.value = value;
	}
}
