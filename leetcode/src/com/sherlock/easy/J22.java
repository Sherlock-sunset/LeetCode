package com.sherlock.easy;

public class J22 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode node = head;
        while (node != null) {
            if (k-- > 0)
                node = node.next;
            else {
                head = head.next;
                node = node.next;
            }
        }
        return head;
    }
}
