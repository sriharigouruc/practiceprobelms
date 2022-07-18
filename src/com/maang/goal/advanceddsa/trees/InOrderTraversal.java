package com.maang.goal.advanceddsa.trees;

import java.util.ArrayList;

public class InOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ArrayList<Integer> inorderTraversal(TreeNode A) {

		ArrayList<Integer> list = new ArrayList<Integer>();

		if (A == null)
			return list;

		if (A.left != null)
			list.addAll(inorderTraversal(A.left));
		list.add(A.val);

		if (A.right != null)
			list.addAll(inorderTraversal(A.right));

		return list;
	}

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
		left = null;
		right = null;
	}
}