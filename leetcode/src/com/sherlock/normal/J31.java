package com.sherlock.normal;

import java.util.Deque;
import java.util.LinkedList;

public class J31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new LinkedList<>();
        int i = 0, j = 0;
        while (j < popped.length) {
            if (!stack.isEmpty() && stack.peek() == popped[j]) {
                j++;
                stack.pop();
            } else {
                if (i >= pushed.length) return false;
                stack.push(pushed[i++]);
            }
        }
        return j >= popped.length;
    }
}
