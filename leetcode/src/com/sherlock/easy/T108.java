package com.sherlock.easy;

public class T108 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length< 1)
            return null;
        return sortedArrayToBST(nums,0,nums.length-1);
    }
    public TreeNode sortedArrayToBST(int[] nums,int start ,int end) {
        int mid = (start + end)/2;
        TreeNode root = new TreeNode(nums[mid]);
        if (mid>start)
            root.left = sortedArrayToBST(nums,start,mid-1);
        if (mid<end)
            root.right = sortedArrayToBST(nums,mid+1,end);
        return root;
    }
}
