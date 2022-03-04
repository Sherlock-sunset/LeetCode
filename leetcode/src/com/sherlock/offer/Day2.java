package com.sherlock.offer;

import com.sherlock.data_structure.ListNode;
import com.sherlock.data_structure.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Day2 {

    /**
     * 剑指 Offer 06. 从尾到头打印链表
     * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）
     */
    public int[] reversePrint(ListNode head) {
        if (head == null) return new int[0];
        int[] ans;
        int len = 1;
        ListNode newHead = head, node;
        head = head.next;
        newHead.next = null;

        while (head != null) {
            node = newHead;
            newHead = head;
            head = head.next;
            newHead.next = node;
            len++;
        }
        ans = new int[len];
        for (int i = 0; i < len; i++, newHead = newHead.next) {
            ans[i] = newHead.val;
        }
        return ans;
    }

    /**
     * 剑指 Offer 24. 反转链表
     * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) return head;
        ListNode newHead = head, node;
        head = head.next;
        newHead.next = null;

        while (head != null) {
            node = newHead;
            newHead = head;
            head = head.next;
            newHead.next = node;
        }

        return newHead;
    }


    /**
     * 剑指 Offer 35. 复杂链表的复制
     * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，
     * 还有一个 random 指针指向链表中的任意节点或者 null。
     */
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        HashMap<Node, Integer> dic = new HashMap<>();
        List<Node> nodes = copyList(head, dic);
        for (int i = 0; i < nodes.size(); i++, head = head.next) {
            if (head.random != null) {
                nodes.get(i).random = nodes.get(dic.get(head.random));
            }
        }
        return nodes.get(0);
    }

    private List<Node> copyList(Node head, HashMap<Node, Integer> dic) {
        int len = 0;
        List<Node> list = new ArrayList<>();
        Node node = new Node(head.val);
        list.add(node);
        dic.put(head, len++);
        while (head.next != null) {
            head = head.next;
            node.next = new Node(head.val);
            node = node.next;
            list.add(node);
            dic.put(head, len++);
        }
        return list;
    }


}
