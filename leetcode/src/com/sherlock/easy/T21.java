package com.sherlock.easy;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class T21 {
    public static void main(String[] args) {

    }

    public static class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null && l2 == null)
                return null;
            if (l1 == null)
                return l2;
            if (l2 == null)
                return l1;
            ListNode result = null;//结果的第一个节点
            if (l1.data > l2.data) {
                result = l2;
                l2 = l1;
                l1 = result.next;
            } else {
                result = l1;
                l1 = l1.next;
            }
            ListNode temp = result;
            while (l1 != null && l2 != null) {
                if (l1.data > l2.data) {
                    temp.next = l2;
                    l2 = l2.next;
                } else {
                    temp.next = l1;
                    l1 = l1.next;
                }
                temp = temp.next;
            }
            temp.next = l1 == null ? l2 : l1;
            return result;
        }


        /**
         * 不带头节点的单向链接
         */
        public class ListNode {
            int data;
            ListNode next;

            public ListNode(int data) {
                this.data = data;
            }
        }
    }
}
