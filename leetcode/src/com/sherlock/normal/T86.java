package com.sherlock.normal;

public class T86 {
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

    public ListNode partition(ListNode head, int x) {
        ListNode ps1 = null, pe1 = null, ps2 = null, pe2 = null;
        while (head != null) {
            if (head.val >= x) {
                if (ps2 == null) {
                    ps2 = head;
                    pe2 = ps2;
                } else {
                    pe2.next = head;
                    pe2 = pe2.next;
                }
            } else {
                if (ps1 == null) {
                    ps1 = head;
                    pe1 = ps1;
                } else {
                    pe1.next = head;
                    pe1 = pe1.next;
                }
            }
            head = head.next;
        }
        if (pe1 != null) pe1.next = ps2;
        if (ps1 == null) ps1 = ps2;
        if (pe2 != null) pe2.next = null;
        return ps1;
    }
}
