package com.maang.goal.trees;

public class TreeHeight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int solve(TreeNode A) {

		int leftNodeHieght = 0, rightNodeHieght = 0;
		if (A.left != null)
			leftNodeHieght = solve(A.left);
		if (A.right != null)
			rightNodeHieght = solve(A.right);

		return Math.max(leftNodeHieght, rightNodeHieght) + 1;
	}

}
