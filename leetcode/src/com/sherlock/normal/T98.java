package com.sherlock.normal;

import java.util.Deque;
import java.util.LinkedList;

public class T98 {
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

    public boolean isValidBST(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (stack.peek().left != null) stack.push(stack.peek().left);
        boolean flag = false;
        int last = Integer.MIN_VALUE;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (flag && node.val <= last) return false;
            if (!flag) flag = true;
            last = node.val;
            System.out.println(last);
            if (node.right != null) {
                stack.push(node.right);
                while (stack.peek().left != null) stack.push(stack.peek().left);
            }
        }

        return true;
    }
}
