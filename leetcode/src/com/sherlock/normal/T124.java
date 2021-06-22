package com.sherlock.normal;

import com.sherlock.data_structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class T124 {
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return root.val;

        return 0;
    }


}
