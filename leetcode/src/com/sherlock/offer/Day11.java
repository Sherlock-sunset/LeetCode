package com.sherlock.offer;

import com.sherlock.data_structure.ListNode;

public class Day11 {
    /**
     * 剑指 Offer 18. 删除链表的节点
     * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
     * 返回删除后的链表的头节点。
     */
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) return head;
        if (head.val == val) return head.next;
        ListNode node = head;

        while (node.next != null && node.next.val != val) {
            node = node.next;
        }
        if (node.next != null) node.next = node.next.next;
        return head;

    }
    /**
     * 剑指 Offer 22. 链表中倒数第k个节点
     * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
     * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode tail = head;
        while (tail.next != null) {
            if (k>1){
                tail = tail.next;
                k--;
            }else {
                head = head.next;
                tail = tail.next;
            }
        }

        return head;
    }
}
