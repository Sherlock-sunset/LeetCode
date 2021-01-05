package com.sherlock.easy;

import java.util.ArrayList;
import java.util.List;

public class T110 {
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

    //层次遍历
    public class TreeQueue {
        private List<TreeNode> queue;

        public TreeQueue() {
            this.queue = new ArrayList<>();
        }

        public void enqueue(TreeNode node) {
            queue.add(0, node);
        }

        public TreeNode dequeue() {
            TreeNode node = queue.get(queue.size() - 1);
            queue.remove(queue.size() - 1);
            return node;
        }

        public boolean isEmpty() {
            return queue.size() == 0;
        }
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public int height(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(height(root.left),height(root.right))+1;
    }

}
