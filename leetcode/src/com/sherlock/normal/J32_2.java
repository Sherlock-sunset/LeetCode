package com.sherlock.normal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class J32_2 {
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
        breadthSearch(result, queue);

        return result;
    }

    public void breadthSearch(List<List<Integer>> result, Queue<TreeNode> queue) {
        if (queue.isEmpty())
            return;
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> nextQue = new LinkedList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null)
                nextQue.offer(node.left);
            if (node.right != null)
                nextQue.offer(node.right);
        }
        result.add(list);
        breadthSearch(result,nextQue);
    }

}
