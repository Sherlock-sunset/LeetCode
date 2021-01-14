package com.sherlock.normal;

public class J26 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null)
            return false;
        if (A.val == B.val && preorder(A.left, B.left)&& preorder(A.right, B.right)) return true;
        if (isSubStructure(A.left, B)) return true;
        if (isSubStructure(A.right, B)) return true;
        return false;
    }

    public boolean preorder(TreeNode A, TreeNode B) {
        if (B == null)
            return true;
        if (A == null)
            return false;
        if (A.val != B.val) return false;
        return preorder(A.left,B.left) && preorder(A.right,B.right);
    }
}
