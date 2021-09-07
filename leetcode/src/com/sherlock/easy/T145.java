package com.sherlock.easy;

import com.sherlock.data_structure.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class T145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (root.left != null) {
            stack.push(root.left);
            root = root.left;
        }
        TreeNode lastVisited = null;
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (node.right == null || lastVisited == node.right) {
                ans.add(node.val);
                lastVisited = stack.pop();
            } else {
                TreeNode right = node.right;
                stack.push(right);
                while (right.left != null) {
                    stack.push(right.left);
                    right = right.left;
                }
            }
        }
        return ans;
    }
}
