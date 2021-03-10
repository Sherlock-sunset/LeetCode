package com.sherlock.normal;

public class T82 {
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

    public ListNode deleteDuplicates(ListNode head) {
        if (head==null ||head.next==null) return head;
        boolean flag = false;
        while (head.next != null) {
            if (head.val == head.next.val) {
                head.next = head.next.next;
                flag = true;
            } else {
                if (flag) {
                    head = head.next;
                    flag = false;
                }else break;
            }
        }
        if (flag) return null;
        ListNode node = head,node2 = head.next;
        if (node2==null) return head;
        while (node2.next != null) {
            if (node2.val == node2.next.val) {
                node2.next = node2.next.next;
                flag=true;
            } else {
                if (!flag){
                    node.next = node2;
                    node2 = node2.next;
                    node = node.next;
                }else {
                    node.next = node2.next;
                    node2 = node.next;
                    flag = false;
                }
            }
        }
        if (flag) node.next = null;

        return head;
    }
}
