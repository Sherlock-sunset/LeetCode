package com.sherlock.normal;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.StringStack;

import java.util.ArrayList;
import java.util.List;

public class T92 {
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

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null || right == left) return head;
        ListNode leftHead = head, node = null;
        for (int i = 1; i < left; i++) {
            node = leftHead;
            leftHead = leftHead.next;
        }
        List<ListNode> list = new ArrayList<>();
        //reverse
        for (int i = 0; i < right - left + 1; i++) {
            list.add(0, leftHead);
            leftHead = leftHead.next;
        }


        if (node == null) {
            node = list.get(0);
            head = node;
            list.remove(0);
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println();
            node.next = list.get(i);
            node = node.next;
        }
        node.next = leftHead;
        return head;
    }
}
