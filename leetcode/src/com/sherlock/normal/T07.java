package com.sherlock.normal;

import com.sherlock.data_structure.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class T07 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        levelOrderBottom(ans, root, 0);
        Collections.reverse(ans);
        return ans;
    }

    public void levelOrderBottom(List<List<Integer>> ans, TreeNode root, int level) {
        if (root == null) return;
        if (ans.size() <= level) ans.add(new ArrayList<>());
        ans.get(level).add(root.val);
        levelOrderBottom(ans, root.left, level + 1);
        levelOrderBottom(ans, root.right, level + 1);

    }
}
