package com.sherlock.easy;

import java.util.ArrayList;
import java.util.List;

public class J6 {
    public int[] reversePrint(ListNode head) {
        List<Integer> list = new ArrayList<>();
        if (head ==null)
            return new int[0];
        while (head!=null){
            list.add(head.val);
            head = head.next;
        }
        int[] result = new int[list.size()];
        for (int i = 1; i <=list.size() ; i++) {
            result[list.size()-i] = list.get(i-1);
        }

        return  result;
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
