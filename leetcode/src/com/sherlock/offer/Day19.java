package com.sherlock.offer;

import com.sherlock.data_structure.TreeNode;

public class Day19 {
    /**
     * 剑指 Offer 64.求1+2+…+n
     * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
     */
    public int sumNums(int n) {
        boolean flag = n > 1 && (n += sumNums(n - 1)) > 1;
        return n;
    }

    /**
     * 剑指 Offer 68 . 二叉搜索树的最近公共祖先
     * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
     * <p>
     * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，
     * 最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //后序遍历
        Boolean[] isVisited = new Boolean[]{false, false};
        TreeNode ans = postOrder(root, p, q, isVisited);

        return ans;
    }

    private TreeNode postOrder(TreeNode root, TreeNode p, TreeNode q, Boolean[] isVisited) {
        int count = count(isVisited);
        if (root == null) return null;
        TreeNode ans = postOrder(root.left, p, q, isVisited);
        if (ans != null) return ans;
        ans = postOrder(root.right, p, q, isVisited);
        if (ans != null) return ans;
        //visit
        if (!isVisited[0] && root == p) isVisited[0] = true;
        if (!isVisited[1] && root == q) isVisited[1] = true;
        return (isVisited[0] && isVisited[1] && Math.abs(count(isVisited)- count) == 2) ? root : null;
    }

    private int count(Boolean[] isVisited) {
        return isVisited[0] && isVisited[1] ? 2 : (!isVisited[0] && !isVisited[1]) ? 0 : 1;
    }

}
