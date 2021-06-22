package com.sherlock.normal;

import com.sherlock.data_structure.ListNode;
import com.sherlock.data_structure.TreeNode;

public class T109 {
    public TreeNode sortedListToBST(ListNode head) {
        return buildTree(head, null);
    }

    public TreeNode buildTree(ListNode left, ListNode right) {
        if (left == right) {
            return null;
        }
        ListNode mid = getMedian(left, right);
        TreeNode root = new TreeNode(mid.val);
        root.left = buildTree(left, mid);
        root.right = buildTree(mid.next, right);
        return root;
    }

    public ListNode getMedian(ListNode left, ListNode right) {
        ListNode fast = left;
        ListNode slow = left;
        while (fast != right && fast.next != right) { //slow走一步，fast走两步寻找中位节点
            fast = fast.next;
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }


}
