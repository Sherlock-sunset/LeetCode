package com.sherlock.hard;

public class T23 {
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

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length < 1) return null;
        if (lists.length == 1) return lists[0];
        ListNode head = null, current = null;
        int l = lists.length;
        while (l > 1) {
            l = lists.length;
            int p = -1;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] == null) {
                    l--;
                } else {
                    ListNode node = lists[i];
                    if (node.val < min) {
                        p = i;
                        min = node.val;
                    }
                }
            }
            //
            System.out.println(l);
            if (l == 1) {
                if (head == null) head = lists[p];
                else current.next = lists[p];
            } else if (l == 0) {
                break;
            } else {
                if (head == null) {
                    head = lists[p];
                    current = head;
                    lists[p] = lists[p].next;
                } else {
                    current.next = lists[p];
                    lists[p] = lists[p].next;
                    current = current.next;
                }
            }

        }
        return head;

    }
}
 