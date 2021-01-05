package com.sherlock.normal;

public class T61 {
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

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null)
            return head;
        ListNode node = head;
        int s =  1;
        while ( node.next != null){
            node = node.next;
            s++;
        }
        k =  k % s;
        node.next = head;
        for (int i = 1; i < s-k; i++) {
            head = head.next;
        }
        node = head;
        head = head.next;
        node.next = null;

        return head;
    }
}
