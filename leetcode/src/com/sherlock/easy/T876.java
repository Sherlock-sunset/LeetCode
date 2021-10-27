package com.sherlock.easy;

import com.sherlock.data_structure.ListNode;

public class T876 {
    //快慢指针
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast.next != null) {
                fast = fast.next;
            }
        }
        return slow;
    }
}
