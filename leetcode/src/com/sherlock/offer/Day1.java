package com.sherlock.offer;

import java.util.Deque;
import java.util.LinkedList;

public class Day1 {
    /**
     * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
     * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead操作返回 -1 )
     */
    class CQueue {
        Deque<Integer> appendStack, deleteStack;

        public CQueue() {
            appendStack = new LinkedList<>();
            deleteStack = new LinkedList<>();
        }

        /**
         * 在队列尾部插入整数
         */
        public void appendTail(int value) {
            appendStack.push(value);
        }

        /**
         * 在头部删除整数
         */
        public int deleteHead() {
            if (!deleteStack.isEmpty()) {
                return deleteStack.pop();
            } else {
                while (!appendStack.isEmpty()) {
                    deleteStack.push(appendStack.pop());
                }
            }

            return deleteStack.isEmpty() ? -1 : deleteStack.pop();
        }
    }

    /**
     * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，
     * 调用 min、push 及 pop 的时间复杂度都是 O(1)
     * */
    class MinStack {
        Deque<Integer> dataStack,minStack;
        /** initialize your data structure here. */
        public MinStack() {
            dataStack = new LinkedList<>();
            minStack = new LinkedList<>();
        }

        public void push(int x) {
            dataStack.push(x);
            if (minStack.isEmpty() || x <= minStack.peek() ){
                minStack.push(x);
            }
        }

        public void pop() {
            int popData = dataStack.pop();
            if (popData == minStack.peek()){
                minStack.pop();
            }
        }


        public int min() {
            return minStack.peek();
        }

        public int top() {
            return dataStack.peek();
        }

    }
}
