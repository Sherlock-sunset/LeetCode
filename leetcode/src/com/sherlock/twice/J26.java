package com.sherlock.twice;

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
        if (isSame(A, B)) return true;
        if (A.left != null && isSubStructure(A.left, B)) return true;
        if (A.right != null && isSubStructure(A.right, B)) return true;
        return false;
    }

    public boolean isSame(TreeNode A, TreeNode B) {
        if (A == null && B == null) return true;
        if (A == null) return false;
        if (B == null) return false;
        if (A.val == B.val) {
            return (B.left == null || isSame(A.left, B.left)) && (B.right == null || isSame(A.right, B.right));
        }
        return false;
    }
}
