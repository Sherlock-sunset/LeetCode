package com.sherlock.easy;

import java.util.ArrayList;
import java.util.List;

public class T155 {
    class MinStack {
        /**
         * initialize your data structure here.
         */
        List<Integer> array;
        int min;
        int index;

        public MinStack() {
            array = new ArrayList<>();
            index = -1;
            min = Integer.MAX_VALUE;
        }

        public void push(int x) {
            array.add(x);
            if (min > x) {
                min = x;
                index = array.size() - 1;
            }
        }

        public void pop() {
            array.remove(array.size() - 1);
            if (index == array.size()) {
                findMin();
            }
        }

        private void findMin() {
            min = Integer.MAX_VALUE;
            index = -1;
            for (int i = 0; i < array.size(); i++) {
                if (min > array.get(i)) {
                    min = array.get(i);
                    index = i;
                }
            }
        }

        public int top() {
            return array.get(array.size() - 1);
        }

        public int getMin() {
            return array.size()> 0 ? min : 0;
        }
    }
}
