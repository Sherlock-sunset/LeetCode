package com.sherlock.normal;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class T2 {
    public static void main(String[] args) {
        Solution so = new Solution();
//        System.out.println(so.addTwoNumbers());
    }

    public static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int num1 = l1.val, num2 = l2.val/*, i = 10*/;
            l1 = l1.next;
            l2 = l2.next;
            //有进位
            boolean isMore = (num1 + num2) >= 10;
            ListNode resultNode = new ListNode((num1 + num2) % 10);
            ListNode temp = resultNode;
            while (l1 != null || l2 != null) {
                num1 = 0;
                num2 = 0;
                if (l1 != null) {
                    num1 = l1.val;
                    l1 = l1.next;
                }
                if (l2 != null) {
                    num2 = l2.val;
                    l2 = l2.next;
                }
                int tempSum = isMore ? (num1 + num2 + 1) : (num1 + num2);
                temp.next = new ListNode(tempSum % 10);
                isMore = tempSum >= 10;
                temp = temp.next;
            }
            if (isMore)
                temp.next = new ListNode(1);
            return resultNode;
        }

        public class ListNode {
            int val;
            ListNode next;

            ListNode(int x) {
                val = x;
            }
        }
    }
}
