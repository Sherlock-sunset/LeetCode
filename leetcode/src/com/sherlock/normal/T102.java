package com.sherlock.normal;


import java.util.ArrayList;
import java.util.List;

public class T102 {
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

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        orderWithLevel(ans, root, 0);
        return ans;
    }

    private void orderWithLevel(List<List<Integer>> ans, TreeNode root, int level) {
        if (level == ans.size()) {
            ans.add(new ArrayList<>());
        }
        ans.get(level).add(root.val);
        if (root.left != null) orderWithLevel(ans, root.left, level + 1);
        if (root.right != null) orderWithLevel(ans, root.right, level + 1);

    }
}
