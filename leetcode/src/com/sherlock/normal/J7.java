package com.sherlock.normal;

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
        if (preorder == null || preorder.length == 0)
            return null;
        TreeNode head = new TreeNode(preorder[0]);
        findChild(preorder, inorder, head, 0,preorder.length - 1);
        return head;
    }

    public void findChild(int[] preorder, int[] inorder, TreeNode parent, int start,int end) {
        int indexPre = -1,inOrder = -1, left = 0, right = 0;
        boolean flag = false;
        for (int i = 0; i < preorder.length; i++) {
            if (indexPre !=-1 && inOrder!=-1)
                break;
            if (preorder[i] == parent.val)
                indexPre = i;
            if (inorder[i] == parent.val)
                inOrder = i;

        }
        for (int i = start; i <= end; i++) {
            if (inorder[i] == parent.val) {
                flag = true;
            } else {
                if (!flag) {
                    left++;
                } else {
                    right++;
                }
            }
        }
        if (left > 0) {
            TreeNode leftNode = new TreeNode(preorder[indexPre + 1]);
            if (left - 1 > 0)
                findChild(preorder, inorder, leftNode,start,inOrder-1);
            parent.left = leftNode;

        }
        if (right > 0) {
            TreeNode rightNode = new TreeNode(preorder[indexPre + left + 1]);
            if (right - 1 > 0)
                findChild(preorder, inorder, rightNode,inOrder+1,end);
            parent.right = rightNode;

        }
    }

}
