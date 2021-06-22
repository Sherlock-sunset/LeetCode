package com.sherlock.normal;

import com.sherlock.data_structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class T103 {


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new LinkedList<>();
        List<List<Integer>> ans = new LinkedList<>();
        orderWithLevel(ans, root, 0);
        return ans;
    }

    private void orderWithLevel(List<List<Integer>> ans, TreeNode root, int level) {
        if (level == ans.size()) {
            ans.add(new LinkedList<>());
        }
        if (level % 2 == 0)
            ans.get(level).add(root.val);
        else
            ans.get(level).add(0, root.val);
        if (root.left != null) orderWithLevel(ans, root.left, level + 1);
        if (root.right != null) orderWithLevel(ans, root.right, level + 1);


    }
}
