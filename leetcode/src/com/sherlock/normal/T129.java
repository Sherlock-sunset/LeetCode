package com.sherlock.normal;

import com.sherlock.data_structure.TreeNode;

public class T129 {
    public int sumNumbers(TreeNode root) {

        return levelorder(root, 0);
    }

    private int levelorder(TreeNode root, int pre) {
        if (root == null) return pre;
        pre = pre * 10 + root.val;
        if (root.left != null && root.right != null) return levelorder(root.left, pre) + levelorder(root.right, pre);
        else if (root.left != null) return levelorder(root.left, pre);
        else if (root.right != null) return levelorder(root.right, pre);
        return pre;
    }
}
