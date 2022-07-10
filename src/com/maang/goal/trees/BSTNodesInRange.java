package com.maang.goal.trees;

public class BSTNodesInRange {

	public int solve(TreeNode A, int B, int C) {

		if (A == null)
			return 0;

		if (A.val >= B && A.val <= C) {
			return 1 + solve(A.left, B, C) + solve(A.right, B, C);
		}
		if (A.val < B)
			return solve(A.right, B, C);
		else
			return solve(A.left, B, C);

	}

}
