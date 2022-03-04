package com.sherlock.offer;

import com.sherlock.data_structure.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Day7 {
    /**
     * 剑指 Offer 26. 树的子结构
     * <p>
     * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
     * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
     */

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null && A == null) return true;
        else if (A == null || B == null) return false;

        if (isSameStructure(A, B)) {
            return true;
        } else {
            return isSubStructure(A.left, B) || isSubStructure(A.right, B);
        }

    }

    public boolean isSameStructure(TreeNode A, TreeNode B) {
        if (B == null) return true;
        if (A == null || A.val != B.val) {
            return false;
        } else {
            return isSameStructure(A.left, B.left) && isSameStructure(A.right, B.right);
        }
    }


    /**
     * 剑指 Offer 27. 二叉树的镜像
     * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
     */
    public TreeNode mirrorTree(TreeNode root) {
        mirror(root);
        return root;
    }

    public void mirror(TreeNode root) {
        if (root == null) return;
        if (root.left != null || root.right != null) {
            TreeNode node = root.left;
            root.left = root.right;
            root.right = node;
            mirror(root.left);
            mirror(root.right);
        }
    }

    /**
     * 剑指 Offer 28. 对称的二叉树
     * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        else if (root.left == null || root.right == null) return false;
        else return isSameTree(root.left, mirrorTree(root.right));

    }

    private boolean isSameTree(TreeNode A, TreeNode B) {
        if (A == null && B == null) return true;
        if (A == null || B == null || A.val != B.val) {
            return false;
        } else {
            return isSameTree(A.left, B.left) && isSameTree(A.right, B.right);
        }
    }

}
