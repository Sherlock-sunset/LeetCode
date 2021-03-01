package com.sherlock.easy;

import java.util.Deque;
import java.util.LinkedList;

public class J68 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val == p.val || root.val == q.val) return root;
        if (Math.max(p.val, q.val) > root.val && Math.min(p.val, q.val) < root.val) return root;
        if (p.val > root.val) return lowestCommonAncestor(root.right, p, q);
        else return lowestCommonAncestor(root.left, p, q);

    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val == p.val || root.val == q.val) return root;
        TreeNode left = dfs(root.left, p, q);
        TreeNode right = dfs(root.right, p, q);
        if (left != null && right != null) return root;
        if (left != null) return lowestCommonAncestor2(root.left, p, q);
        if (right != null) return lowestCommonAncestor2(root.right, p, q);
        return null;
    }

    private TreeNode dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root.val == p.val || root.val == q.val) return root;
        TreeNode node = dfs(root.left, p, q);
        return node == null ? dfs(root.right, p, q) : node;
    }


    //暂时还有错误，
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val == p.val || root.val == q.val) return root;
        boolean flagL = false;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        TreeNode pre = null;
        TreeNode ans = null;
        while (stack.peek().left != null) {
            stack.push(stack.peek().left);
        }
        while (!stack.isEmpty()) {
            if (flagL && pre == ans) {
                ans = stack.peek();
            }
            if (stack.peek().right != null && pre != stack.peek().right) {
                stack.push(stack.peek().right);
                while (stack.peek().left != null) {
                    stack.push(stack.peek().left);
                }
            } else {
                //访问

                TreeNode node = stack.pop();


                if (node.val == p.val || node.val == q.val) {
                    if (flagL) return ans;
                    else flagL = true;
                    ans = node;
                }

//                System.out.println(node.val);
                pre = node;
            }
        }

        return ans;
    }
}
