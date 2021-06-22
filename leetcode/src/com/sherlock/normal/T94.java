package com.sherlock.normal;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class T94 {
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

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inorderTraversalWithStack(root, ans);
        return ans;
    }

    public void inorderTraversal(TreeNode root, List<Integer> ans) {
        if (root == null) return;
        if (root.left != null) inorderTraversal(root.left, ans);
        ans.add(root.val);
        if (root.right != null) inorderTraversal(root.right, ans);
    }

    public void inorderTraversalWithStack(TreeNode root, List<Integer> ans) {
        if (root == null) return;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (stack.peek().left != null) stack.push(stack.peek().left);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            ans.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
                while (stack.peek().left != null) stack.push(stack.peek().left);
            }
        }

    }
}
