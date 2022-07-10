package com.maang.goal.trees;

import java.util.ArrayList;

public class PreOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static ArrayList<Integer> preorderTraversal(TreeNode A) {
		ArrayList<Integer> returnList = new ArrayList<Integer>();
		returnList.add(A.val);

		if (A.left != null)
			returnList.addAll(preorderTraversal(A.left));

		if (A.right != null)
			returnList.addAll(preorderTraversal(A.right));

		return returnList;
	}

	public static ArrayList<Integer> postorderTraversal(TreeNode A) {
		ArrayList<Integer> returnList = new ArrayList<Integer>();

		if (A.left != null)
			returnList.addAll(postorderTraversal(A.left));

		if (A.right != null)
			returnList.addAll(postorderTraversal(A.right));

		returnList.add(A.val);
		return returnList;
	}

}
