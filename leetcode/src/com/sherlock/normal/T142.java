package com.sherlock.normal;

import com.sherlock.data_structure.ListNode;

import java.util.HashMap;

public class T142 {
    public ListNode detectCycle(ListNode head) {
        if (head==null) return null;
        HashMap<ListNode,Boolean> map = new HashMap<>();
        ListNode node = head,next = head.next;
        map.put(node,true);
        while (next!=null){
            if (map.getOrDefault(next,false)){
                return next;
            }else {
                map.put(node,true);
                node = node.next;
                next = next.next;
            }
        }
        return null;
    }
}
