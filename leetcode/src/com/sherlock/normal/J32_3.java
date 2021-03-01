package com.sherlock.normal;

import java.util.*;

public class J32_3 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        breadthSearchWithOrder(result, queue, true);

        return result;
    }

    public void breadthSearchWithOrder(List<List<Integer>> result, Queue<TreeNode> queue, boolean flag) {
        if (queue.isEmpty())
            return;
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> nextQue = new LinkedList<>();
        List<TreeNode> nodes = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            nodes.add(node);
            if (node.left != null)
                nextQue.offer(node.left);
            if (node.right != null)
                nextQue.offer(node.right);
        }
        for (int i = flag ? 0 : nodes.size() - 1; flag ? i < nodes.size() : i >= 0; i += flag ? 1 : -1) {
            list.add(nodes.get(i).val);
        }
        result.add(list);
        breadthSearchWithOrder(result, nextQue, !flag);
    }
}
