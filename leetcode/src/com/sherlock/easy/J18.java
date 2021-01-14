package com.sherlock.easy;

public class J18 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteNode(ListNode head, int val) {
        ListNode node = head;
        if (val == node.val)
            return head.next;
        while (node.next!=null){
            if (node.next.val == val){
                node.next = node.next.next;
                return head;
            }
            node = node.next;
        }
        return head;
    }
}
