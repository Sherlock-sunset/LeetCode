package com.sherlock.easy;

import java.util.Deque;
import java.util.LinkedList;

public class J30 {
    class MinStack {
        Deque<Integer> valStack;
        Deque<Integer> minStack;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            valStack = new LinkedList<>();
            minStack = new LinkedList<>();
        }

        public void push(int x) {
            valStack.push(x);
            if (minStack.isEmpty() || x <= minStack.peek())
                minStack.push(x);
        }

        public void pop() {
            int x = valStack.pop();
            if (!minStack.isEmpty() && minStack.peek() == x)
                minStack.pop();
        }

        public int top() {
            return valStack.isEmpty() ? 0 : valStack.peek();
        }

        public int min() {
            return minStack.isEmpty() ? 0 : minStack.peek();
        }
    }
}
