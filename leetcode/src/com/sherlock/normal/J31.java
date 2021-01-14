package com.sherlock.normal;

import java.util.Deque;
import java.util.LinkedList;

public class J31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0, j = 0; i < popped.length; i++) {
            if (!stack.isEmpty() && stack.peek() == popped[i]) {
                stack.pop();
            } else {
                if (j==pushed.length) return false;
                for (; j < pushed.length; j++) {
                    if (pushed[j] == popped[i]) {
                        j++;
                        break;
                    } else {
                        if (j == pushed.length - 1) return false;
                        else stack.push(pushed[j]);
                    }
                }
            }
        }
        return true;
    }
}
