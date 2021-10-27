package com.sherlock.normal;

import com.sherlock.data_structure.ListNode;

import java.util.ArrayList;
import java.util.List;

public class T19 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head, fast = head;
        for (int i = 0; i < n - 1; i++) {
            fast = fast.next;
        }
        if (fast.next == null) {   //首先要解决删除第一个指针的情况
            return head.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            if (fast.next == null) {
                fast = slow.next.next;
                slow.next = fast;
                break;
            }
            slow = slow.next;
        }

        return head;
    }
}
