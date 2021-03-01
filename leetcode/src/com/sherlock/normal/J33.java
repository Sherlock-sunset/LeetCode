package com.sherlock.normal;

import java.util.ArrayList;
import java.util.List;

public class J33 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean verifyPostorder(int[] postorder) {
        if (postorder.length < 1) return true;
        return buildBiSearchTree(postorder, 0, postorder.length - 1, postorder[postorder.length - 1]);
    }

    public boolean buildBiSearchTree(int[] postorder, int start, int end, int val) { //左子树小于root
        if (end - start < 2)
            return true;

        boolean flag = false;//用来找到第一个右子树节点
        int root = end - 1; //切分左右子树
        for (int j = start; j < end; j++) {
            if (postorder[j] > val && !flag) {
                flag = true;
                root = j;
            }
            if (flag && postorder[j] < val)
                return false;
        }
        if (root == end - 1) return buildBiSearchTree(postorder, start, root, postorder[root]);//只有左子树时
        else return buildBiSearchTree(postorder, start, root, postorder[root]) && buildBiSearchTree(postorder, root, end-1, postorder[end-1]);
    }
}
