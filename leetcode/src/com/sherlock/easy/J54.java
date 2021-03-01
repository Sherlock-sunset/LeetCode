package com.sherlock.easy;

import java.util.Deque;
import java.util.LinkedList;

public class J54 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int kthLargest(TreeNode root, int k) {
        Deque<TreeNode> stack = new LinkedList<>();

        stack.push(root);
        while (stack.peek().right != null) stack.push(stack.peek().right);

        int count = 0;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.println(node.val);
            if (++count == k) return node.val;
            if (node.left!=null) {
                stack.push(node.left);
                while (stack.peek().right != null) stack.push(stack.peek().right);
            }
        }
        return 0;
    }

}
