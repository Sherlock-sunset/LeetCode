package com.sherlock.easy;

import com.sherlock.data_structure.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class T144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root==null) return ans;
//        if (root!=null) preorderTraversal(root,ans);//递归的方法
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            ans.add(node.val);
            if (node.right!= null) stack.push(node.right);
            if (node.left!= null) stack.push(node.left);
        }

        return ans;
    }
    public void preorderTraversal(TreeNode root,List<Integer> ans) {
        ans.add(root.val);
        if (root.left!=null) preorderTraversal(root.left,ans);
        if (root.right!=null) preorderTraversal(root.right,ans);
    }
}
