package com.sherlock.easy;

public class J55 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int dep = 1;
        return Math.max(maxDepth(root.left) + dep, maxDepth(root.right) + dep);
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        int dep = 1;
        return isBalanced(root.left) && isBalanced(root.right) && Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1;

    }
}
