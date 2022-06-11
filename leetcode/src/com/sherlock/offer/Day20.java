package com.sherlock.offer;

import com.sherlock.data_structure.TreeNode;

import java.util.HashMap;

public class Day20 {

    /**
     * 剑指 Offer 07. 重建二叉树
     * 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
     * <p>
     * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     */

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {
        if (preRight < preLeft) return null;
        TreeNode root = new TreeNode(preorder[preLeft]);
        int mid = 0;
        for (int i = inLeft; i <= inRight; i++) {
            if (inorder[i] == preorder[preLeft]) {
                mid = i;
                break;
            }
        }
        int leftChildLength = mid - inLeft, rightChildLength = inRight - mid;
        root.left = buildTree(preorder, inorder, preLeft + 1, preLeft + leftChildLength, inLeft, mid - 1);
        root.right = buildTree(preorder, inorder, preLeft + leftChildLength + 1, preRight, mid + 1, inRight);

        return root;
    }

    /**
     * 剑指 Offer 16. 数值的整数次方
     * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。
     */
    public double myPow(double x, int n) {
        if (n == 0 || x == 1.0) return 1;
        boolean flag = n == Integer.MIN_VALUE;
        if (flag) n++;
        HashMap<Integer, Double> map = new HashMap<>();
        int absn = Math.abs(n), current = 1;
        map.put(current, x);
        double ans = x;

        while (absn > 1) {
            if (absn > current) {
                absn -= current;
                ans *= map.get(current);
                current *= 2;
                map.put(current, ans);
            } else if (current > 1) {
                current/=2;
            } else {
                ans *= x;
                absn--;
            }
        }
        if (flag) ans *= x;
        return n > 0 ? ans : 1 / ans;
    }

    /**
     * 剑指 Offer 33.二叉搜索树的后序遍历序列
     * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。
     * 如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
     */
    public boolean verifyPostorder(int[] postorder) {
        return verifyPostorder(postorder, 0, postorder.length - 1);
    }

    private boolean verifyPostorder(int[] postorder, int left, int right) {
        if (right - left < 3) return true;

        boolean flag = false;
        int mid = left;//
        for (int i = left; i < right; i++) {
            if (!flag) {
                if (postorder[i] > postorder[right]) {//右子树
                    flag = true;
                    mid = i;
                }
            } else {
                if (postorder[i] < postorder[right]) return false;
            }
        }
        return verifyPostorder(postorder, left, mid - 1) && verifyPostorder(postorder, mid, right - 1);
    }
}
