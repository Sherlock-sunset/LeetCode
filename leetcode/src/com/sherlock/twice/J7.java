package com.sherlock.twice;

import java.util.ArrayList;
import java.util.List;

public class J7 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length < 1) return null;
        TreeNode root = new TreeNode(preorder[0]);
        findChild(root, preorder, inorder, 0, inorder.length - 1, 0);
        return root;
    }

    private void findChild(TreeNode parent, int[] preorder, int[] inorder, int start, int end, int preindex) {
        if (end - start < 1) return;
        //找到父节点位置在中序遍历的位置
        int pIndex = -1;
        for (int i = start; i <= end; i++) {
            if (parent.val == inorder[i]) {
                pIndex = i;
                break;
            }
        }
        //start~pIndex是他的左子树
        if (pIndex > start) {//存在左子树
            int leftNode = preindex + 1;//父节点先序遍历下一个节点就是左子树根节点
            TreeNode left = new TreeNode(preorder[leftNode]);
            findChild(left, preorder, inorder, start, pIndex - 1, leftNode);
            parent.left = left;
        }
        //pIndex~end 是他的左子树

        if (end > pIndex) {//存在右子树
            int rightNode = preindex + 1 + (pIndex - start);//（先序遍历）右子树根节点 = 父节点index + 左子树长度 +1
            TreeNode right = new TreeNode(preorder[rightNode]);
            findChild(right, preorder, inorder, pIndex + 1, end, rightNode);
            parent.right = right;
        }

    }


}
