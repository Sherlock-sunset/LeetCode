package com.sherlock.easy;

public class J24 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode[] nodes = new ListNode[3];
        for (int i = 0; i < 3 && head != null; i++, head = head.next) {
            nodes[i] = head;
        }
        if (nodes[1] == null) {
            return nodes[0];
        }
        nodes[0].next = null;
        nodes[1].next = nodes[0];
        if (nodes[2] == null)
            return nodes[1];
        while (head!=null){
            nodes[0] = nodes[1];
            nodes[1] = nodes[2];
            nodes[2] = head;
            head = head.next;
            nodes[1].next = nodes[0];
        }
        nodes[2].next = nodes[1];
        return nodes[2];
    }
}
