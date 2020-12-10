package com.sherlock.normal;

import java.util.ArrayList;
import java.util.List;

public class T19 {

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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = head;
        List<ListNode> nodes = new ArrayList<>();
        nodes.add(node);
        while (node.next != null){
            node = node.next;
            nodes.add(node);
        }
        int delete = nodes.size() - n;
        if (delete==0){
            return  nodes.size()>1?nodes.get(1):null;
        }
        nodes.get(delete-1).next = delete+1>=nodes.size()? null: nodes.get(delete+1);
        return nodes.get(0);
    }
}
