package com.maang.goal.trees;

public class IdenticalTrees {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int isSameTree(TreeNode A, TreeNode B) {

		int returnValue = 1;
		if (A == null && B == null)
			return 1;
		if (A != null && B == null || A == null && B != null)
			return 0;
		if (A.val != B.val)
			return 0;
		int leftEquality = isSameTree(A.left, B.left);
		int rightEquality = isSameTree(A.right, B.right);
		if (leftEquality == 0 || rightEquality == 0)
			return 0;
		return returnValue;

	}

}
