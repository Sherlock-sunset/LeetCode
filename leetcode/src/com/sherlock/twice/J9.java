package com.sherlock.twice;

import java.util.Deque;
import java.util.LinkedList;

public class J9 {
    Deque<Integer> input, output;

    public J9() {
        input = new LinkedList<>();
        output = new LinkedList<>();
    }

    public void appendTail(int value) {
        input.push(value);
    }

    public int deleteHead() {
        if (!output.isEmpty()) {
            return output.pop();
        }
        while (!input.isEmpty()) {
            int v = input.pop();
            if (input.isEmpty()) return v;
            else output.push(v);
        }
        return -1;

    }
}
