package com.sherlock.normal;

import java.util.*;

public class J59 {
    class MaxQueue {
        Queue<Integer> qeque;
        Deque<Integer> orderQueue;
        List<Integer> buff;

        public MaxQueue() {
            qeque = new LinkedList<>();
            orderQueue = new LinkedList<>();
            buff = new ArrayList<>();
        }

        public int max_value() {

            return orderQueue.isEmpty() ? -1 : orderQueue.peek();
        }

        public void push_back(int value) {
            if (orderQueue.isEmpty() || value >= orderQueue.peek()) {
                orderQueue.push(value);
                buff.clear();
            } else {
                buff.add(value);
            }
            qeque.add(value);
            System.out.println("After push Q:" + qeque.size());
            System.out.println("After push DQ:" + orderQueue.size());
        }

        public int pop_front() {
            if (qeque.isEmpty()) return -1;
            int pop = qeque.remove();
            if (orderQueue.isEmpty()) {
                int p = 0;
                for (int i = 0; i < buff.size(); i++) {
                    if (i == 0 || buff.get(i) >= orderQueue.peek()) {
                        orderQueue.push(buff.get(i));
                        p = i;
                    }
                }
                if (p == buff.size() - 1) buff.clear();
                else {
                    for (int j = 0; j <= p; j++) {
                        buff.remove(0);
                    }
                }

            } else if (pop == orderQueue.peekLast()) orderQueue.removeLast();
            System.out.println("After pop Q:" + qeque.size());
            System.out.println("After pop DQ:" + orderQueue.size());
            return pop;
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 0) return new int[0];
        if (nums.length < k) return null;
        int[] result = new int[nums.length - k + 1];
        int max = Integer.MIN_VALUE;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                max = Math.max(max, nums[i]);
                queue.add(nums[i]);
            } else if (i == k - 1) {
                max = Math.max(max, nums[i]);
                queue.add(nums[i]);
                result[i - k + 1] = max;
            } else {
                int head = queue.remove();
                if (head == max) {
                    max = nums[i];
                    for (int j = i - k; j < i; j++) {
                        max = Math.max(max, nums[j]);
                    }
                } else {
                    max = Math.max(max, nums[i]);
                }
                queue.add(nums[i]);
                result[i - k + 1] = max;
            }
        }

        return result;
    }
}
