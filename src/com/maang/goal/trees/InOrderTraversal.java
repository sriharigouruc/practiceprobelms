package com.maang.goal.trees;

import java.util.ArrayList;

public class InOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static ArrayList<Integer> inorderTraversal(TreeNode A) {
		ArrayList<Integer> returnList = new ArrayList<Integer>();
		if (A.left != null)
			returnList.addAll(inorderTraversal(A.left));
		returnList.add(A.val);
		if (A.right != null)
			returnList.addAll(inorderTraversal(A.right));

		return returnList;
	}

}

//  Definition for binary tree
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
