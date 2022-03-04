package com.sherlock.offer;

import com.sherlock.data_structure.Node;
import com.sherlock.data_structure.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Day15 {
    /**
     * 剑指 Offer 34. 二叉树中和为某一值的路径
     * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
     * 叶子节点 是指没有子节点的节点。
     */
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        trackPath(root, target, 0, list, ans);
        return ans;
    }

    public void trackPath(TreeNode root, int target, int sum, List<Integer> list, List<List<Integer>> ans) {
        if (root == null) return;
        sum += root.val;
        list.add(root.val);
        if (sum == target && root.left == null && root.right == null) {
            List<Integer> data = new ArrayList<>();
            data.addAll(list);
            ans.add(data);
            list.remove(list.size() - 1);
            return;
        }
        trackPath(root.left, target, sum, list, ans);
        trackPath(root.right, target, sum, list, ans);
        list.remove(list.size() - 1);
    }


    /**
     * 剑指 Offer 36. 二叉搜索树与双向链表
     * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
     */
    public Node treeToDoublyList(Node root) {
        if (root==null) return root;
        //Node head = new Node();
        List<Node> nodes = new ArrayList<>();
        mid(nodes, root);
        //head.next = nodes.get(0);
        for (int i = 0; i < nodes.size(); i++) {
            nodes.get(i).right = nodes.get(i + 1 < nodes.size() ? i + 1 : 0);
            nodes.get(i).left = nodes.get(i - 1 >= 0 ? i - 1 : nodes.size() - 1);
        }
        return nodes.get(0);
    }

    private void mid(List<Node> nodes, Node root) {
        if (root == null) return;
        mid(nodes, root.left);
        nodes.add(root);
        mid(nodes, root.right);
    }

    /**
     * 剑指 Offer 54. 二叉搜索树的第k大节点
     * 给定一棵二叉搜索树，请找出其中第k大的节点。
     */
    public int kthLargest(TreeNode root, int k) {
        Deque<TreeNode> stack = new LinkedList<>();
        Deque<Integer> ansQue = new LinkedList<>();
        stack.push(root);
        while (stack.peek().left != null) {
            stack.push(stack.peek().left);
        }
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            ansQue.add(node.val);
            if (ansQue.size() > k) {
                ansQue.remove();
            }
            if (node.right != null) {
                stack.push(node.right);
                while (stack.peek().left != null) {
                    stack.push(stack.peek().left);
                }
            }
        }

        return ansQue.getFirst();
    }


}
