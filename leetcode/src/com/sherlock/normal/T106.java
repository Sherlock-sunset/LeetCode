package com.sherlock.normal;

import com.sherlock.data_structure.TreeNode;

public class T106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        findChild(root, inorder, postorder, 0, inorder.length - 1, postorder.length - 1);
        return root;
    }

    private void findChild(TreeNode root, int[] inorder, int[] postorder, int start, int end, int index) {
        if (end - start < 1) return;

        for (int i = start; i <= end; i++) {
            if (inorder[i] == root.val) {

                if (i < end) {//存在右子树
                    root.right = new TreeNode(postorder[index - 1]);
                    findChild(root.right, inorder, postorder, i + 1, end, index - 1);
                }
                if (i > start) {//存在左子树
                    int len = end - i;
                    root.left = new TreeNode(postorder[index - 1 - len]);
                    findChild(root.left, inorder, postorder, start, i - 1, index - 1 - len);
                }
                break;
            }
        }
    }
}
