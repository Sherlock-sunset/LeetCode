package com.sherlock.normal;

import java.util.ArrayList;
import java.util.List;

public class T95 {
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

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> result = new ArrayList<>();
        List<TreeNode> nodes = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            TreeNode root = new TreeNode(i);
            nodes.add(root);
        }
        for (int i = 1; i <= n; i++) {
            generateTree(nodes.get(i - 1), nodes.get(i - 1), n, 1, result, nodes);
        }
        return result;
    }

    private void generateTree(TreeNode root, TreeNode parent, int n, int num, List<TreeNode> result, List<TreeNode> nodes) {
        //left
        for (int i = 0; i < parent.val; i++) {
            parent.left = nodes.get(i);
            if (num + 1 == n) {
                generateTree(result, root, nodes);
            } else generateTree(root, parent.left, n, num + 1, result, nodes);
        }
        //right
        for (int i = parent.val; i < n; i++) {
            parent.right = nodes.get(i);
            if (num + 1 == n) {
                generateTree(result, root, nodes);
            } else generateTree(root, parent.right, n, num + 1, result, nodes);
        }
    }

    private void generateTree(List<TreeNode> result, TreeNode root, List<TreeNode> nodes) {
        List<TreeNode> buff = new ArrayList<>();
        for (int i = 0; i < nodes.size(); i++) {
            TreeNode node = nodes.get(i);
            buff.add(new TreeNode(node.val));
        }
        for (int i = 0; i < nodes.size(); i++) {
            TreeNode node = nodes.get(i);
            buff.get(i).left = node.left == null ? null : buff.get(node.left.val - 1);
            buff.get(i).right = node.right == null ? null : buff.get(node.right.val - 1);
        }
        result.add(buff.get(root.val - 1));
    }
}
