package com.sherlock.normal;

import java.util.ArrayList;
import java.util.List;

public class J34 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        if (root.left == null && root.right == null && root.val == sum) {
            result.add(list);
            return result;
        }
        pathSum(result,list, root.left, sum - root.val);
        pathSum(result, list,root.right, sum - root.val);
        return result;
    }

    public void pathSum(List<List<Integer>> result, List<Integer> path,TreeNode root, int sum) {
        if (root == null)
            return;
        List<Integer> list = new ArrayList<>();
        list.addAll(path);
        list.add(root.val);

        if (root.left == null && root.right == null && root.val == sum) {
            result.add(list);
            return;
        }
        pathSum(result,list, root.left, sum - root.val);
        pathSum(result,list, root.right, sum - root.val);
    }
}
