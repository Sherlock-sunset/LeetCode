package com.sherlock.offer;

import com.sherlock.data_structure.ListNode;

public class Day12 {

    /**
     * 剑指 Offer 25. 合并两个排序的链表
     * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(), node = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                node.next = l1;
                l1 = l1.next;
            } else {
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
        }
        if (l1 != null) {
            node.next = l1;
        }
        if (l2 != null) {
            node.next = l2;
        }

        return head.next;
    }

    /**
     * 剑指 Offer 52. 两个链表的第一个公共节点
     * 输入两个链表，找出它们的第一个公共节点。
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len1 = 0, len2 = 0;
        ListNode n1 = headA, n2 = headB;
        while (n1 != null || n2 != null) {
            if (n1 != null) {
                len1++;
                n1 = n1.next;
            }
            if (n2 != null) {
                len2++;
                n2 = n2.next;
            }
        }
        if (len1 < len2) {
            n1 = headB;
            headB = headA;
            headA = n1;
        }
        for (int i = 0; i < Math.abs(len1 - len2); i++) {
            headA = headA.next;
        }
        while (headA != null && headB != null) {
            if (headA == headB) return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}
