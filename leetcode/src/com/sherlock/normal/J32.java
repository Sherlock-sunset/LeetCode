package com.sherlock.normal;

import java.util.*;

public class J32 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[0];
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        ArrayList<Integer> result = new ArrayList<>();
        while (!q.isEmpty()) {
            TreeNode node = q.remove();
            result.add(node.val);
            if (node.left != null)
                q.add(node.left);
            if (node.right != null)
                q.add(node.right);
        }
        int[] arr = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            arr[i] = result.get(i);
        }
        return arr;
    }




}
