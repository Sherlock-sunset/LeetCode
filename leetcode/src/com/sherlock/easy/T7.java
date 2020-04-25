package com.sherlock.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2的31次,  2的31次 − 1]。
 * 请根据这个假设，如果反转后整数溢出那么就返回 0。
 * <p>
 * 输入: 123
 * 输出: 321
 * <p>
 * 输入: -123
 * 输出: -321
 * <p>
 * 输入: 120
 * 输出: 21
 */
public class T7 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverse(-2147483648));
//        System.out.println(solution.reverse(-21483648));
        System.out.println(solution.reverse(-123));
        System.out.println(solution.reverse(120));
    }

    /**
     * 用栈的思路错了，应该用队列
     */
    public static class Solution {

        public int reverse(int x) {
            boolean isNegative = x < 0;
            List<Integer> enqueue = new ArrayList<>();
            if (isNegative && x / -10 > 0) {  //有这个步骤是因为考虑的32位的表示 负值能比正值多表示一个数字
                enqueue.add(-(x % -10));
                x = x / -10;
            }
            while (x / 10 > 0) {
                enqueue.add(x % 10);
                x = x / 10;
            }
            enqueue.add(x % 10);

            double temp = 0;
            for (int i = 0; i < enqueue.size(); i++) {
                if ((temp * 10 + enqueue.get(i)) > Integer.MAX_VALUE)
                    return 0;
                temp = temp * 10 + enqueue.get(i);
            }
            return isNegative ? -(int) temp : (int) temp;
        }
//        public int reverse(int x) {
//            System.out.println(x);
//
//            boolean isNegative = x < 0;
////            x = isNegative ? -x : x;
//            System.out.println(isNegative);
////            System.out.println(x);
//
////            Stack stack = new Stack(lenthInt(Integer.MAX_VALUE) + 1);//Inter
//            List<Integer> enqueue = new ArrayList<>();
//            if (isNegative && x / -10 > 0) {
//                enqueue.add(-(x % -10));
//                x = x / -10;
//            }
//            while (x / 10 > 0) {
////                stack.push(x % 10);
//                enqueue.add(x % 10);
//                x = x / 10;
//            }
////            stack.push(x);
////            stack.showElements();
//            enqueue.add(x % 10);
//
//            double temp = 0;
////            while (!stack.isEmpty()) {
////                if ((temp * 10 + stack.peek()) > Integer.MAX_VALUE)
////                    return 0;
////                temp = temp * 10 + stack.pop();
////            }
//            for (int i = 0; i < enqueue.size(); i++) {
//                System.out.println(enqueue.get(i));
//                if ((temp * 10 + enqueue.get(i)) > Integer.MAX_VALUE)
//                    return 0;
//                temp = temp * 10 + enqueue.get(i);
//            }
//            return isNegative ? -(int) temp : (int) temp;
//        }

        /**
         * 求整数长度
         */
        private int lenthInt(int value) {
            int len = 1;
            while (value / 10 > 0) {
                value = value / 10;
                len++;
            }
            return len;
        }

        class Stack {

            private int[] data;
            private int maxSize;
            private int top = -1;

            public Stack(int maxSize) {
                this.maxSize = maxSize;
                data = new int[maxSize];
            }

            /**
             * 栈内元素和
             */
            public int elementCount() {
                return top + 1;
            }

            public boolean push(int object) {
                if (top + 1 < maxSize) {
                    data[++top] = object;
                    return true;
                }
                return false;
            }

            public int pop() {
                top--;
                return data[top + 1];
            }

            public int peek() {
                return data[top];
            }

            public boolean isEmpty() {
                return top < 0;
            }

            public void showElements() {
                for (int i = 0; i <= top; i++) {
                    System.out.print(data[i] + " _ ");
                }
                System.out.println("  ");

            }
        }

        class Queue {

        }
    }

}
