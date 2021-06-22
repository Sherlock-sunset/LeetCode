package com.sherlock.normal;

import com.sherlock.data_structure.TreeNode;

public class T05 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = new TreeNode(preorder[0]);
        findChild(root, preorder, inorder, 0, inorder.length - 1, 0);
        return root;
    }

    private void findChild(TreeNode root, int[] preorder, int[] inorder, int start, int end, int index) {
        if (end - start <1) return;

        for (int i = start; i <= end; i++) {
            if (inorder[i] == root.val) {
                if (i > start) {//存在左子树
                    root.left = new TreeNode(preorder[index + 1]);
                    findChild(root.left, preorder, inorder, start, i - 1, index + 1);
                }
                if (i < end) {//存在右子树
                    int len = i - start;
                    root.right = new TreeNode(preorder[index + 1 + len]);
                    findChild(root.right, preorder, inorder, i + 1, end, index + 1 + len);
                }
                break;
            }
        }
    }
}
