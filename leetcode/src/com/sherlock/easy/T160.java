package com.sherlock.easy;

public class T160 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Integer al = 0;
        Integer bl = 0;
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        ListNode result,lasta = null,lastb =null;

        while (nodeA != null || nodeB != null) {
            if (nodeA != null) {
                al++;
                lasta = nodeA;
                nodeA = nodeA.next;
            }
            if (nodeB != null) {
                bl++;
                lastb = nodeB;
                nodeB = nodeB.next;
            }
        }
        if (lasta != lastb)
            return null;
        nodeA = headA;
        nodeB = headB;
        boolean flag = al > bl;
        for (int i = 0; i < (flag ? al - bl : bl - al); i++) {
            if (flag)
                nodeA = nodeA.next;
            else
                nodeB = nodeB.next;
        }
        result = nodeA;
        while (nodeA != null || nodeB != null) {
            if (nodeA != nodeB){
                result = nodeA.next;
            }
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }
        return result;
    }
}
