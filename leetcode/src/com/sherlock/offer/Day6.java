package com.sherlock.offer;

import com.sherlock.data_structure.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Day6 {
    /**
     * 剑指 Offer 32 - I. 从上到下打印二叉树
     * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
     */
    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[0];
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            ans.add(node.val);
            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
        }
        int[] arr = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            arr[i] = ans.get(i);
        }
        return arr;
    }

    /**
     * 剑指 Offer 32 - II. 从上到下打印二叉树 II
     * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int size = 1;
        List<Integer> currentLevel = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            currentLevel.add(node.val);

            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);

            if (--size == 0) {
                ans.add(currentLevel);
                currentLevel = new ArrayList<>();
                size = queue.size();
            }
        }

        return ans;
    }

    /**
     * 剑指 Offer 32 - II. 从上到下打印二叉树 III
     * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，
     * 第三行再按照从左到右的顺序打印，其他行以此类推。
     */
    public List<List<Integer>> levelOrder3(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int size = 1;
        List<Integer> currentLevel = new ArrayList<>();
        boolean flag = true;
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if (flag) {
                currentLevel.add(node.val);
            } else {
                currentLevel.add(0, node.val);
            }

            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);

            if (--size == 0) {
                ans.add(currentLevel);
                currentLevel = new ArrayList<>();
                size = queue.size();
                flag = !flag;
            }
        }

        return ans;
    }
}
