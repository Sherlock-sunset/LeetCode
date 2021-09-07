package com.sherlock.easy;

import com.sherlock.data_structure.ListNode;

public class T141 {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode node = head.next;

        while (node != null) {
            if (node == head) return true;
            ListNode next = node.next;
            node.next = head;
            node = next;
        }
        return false;
    }
}
