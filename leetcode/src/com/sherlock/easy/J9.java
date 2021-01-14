package com.sherlock.easy;

import com.sherlock.data_structure.IntStack;

import java.util.Deque;

public class J9 {
    class CQueue {
        boolean isReverse = false;
        private IntStack stack1, stack2;

        public CQueue() {
            isReverse = false;
            stack1 = new IntStack(10000);
            stack2 = new IntStack(10000);
        }

        public void appendTail(int value) {
            if (isReverse)
                reverse();
            stack1.push(value);
        }

        private void reverse() {
            if (isReverse) {
                stack1.clear();
                while (!stack2.isEmpty()) {
                    stack1.push(stack2.pop());
                }
            } else {
                stack2.clear();
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            isReverse = !isReverse;
        }

        public int deleteHead() {
            if (!isReverse)
                reverse();
            return stack2.isEmpty() ? -1 : stack2.pop();
        }
    }
}
