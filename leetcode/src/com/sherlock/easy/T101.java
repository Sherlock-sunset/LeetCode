package com.sherlock.easy;

public class T101 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if (root ==null)
            return true;
        return isSymmetricTree(root.left,root.right);

    }
    public boolean isSymmetricTree(TreeNode p, TreeNode q) {
        if (p == null && q != null)
            return false;
        if (q == null && p != null)
            return false;
        if (p == null && q == null)
            return true;
        if (p.val == q.val)
            return isSymmetricTree(p.left, q.right) && isSymmetricTree(p.right, q.left);
        return false;
    }
}
