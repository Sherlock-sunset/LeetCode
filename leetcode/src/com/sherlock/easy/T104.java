package com.sherlock.easy;

public class T104 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public int maxDepth(TreeNode root) {
        if (root==null)
            return 0;
        int dep = 1;
        return Math.max(maxDepth(root.left)+dep,maxDepth(root.right)+dep);
    }
    //
}
