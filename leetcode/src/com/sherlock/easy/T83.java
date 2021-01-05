package com.sherlock.easy;


public class T83 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return head;
        ListNode node = head;
        ListNode nextNode = node.next;
        if (nextNode == null)
            return head;
        int lastVal = node.val;
        while (nextNode.next != null){
            if (nextNode.val != lastVal){
                node.next = nextNode;
                node = nextNode;
                nextNode = nextNode.next;
                lastVal = node.val;
            }else {
                nextNode = nextNode.next;
            }
        }
        nextNode = nextNode.val == lastVal? null :nextNode;
        node.next = nextNode;
        return head;
    }
}
