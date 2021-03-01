package com.sherlock.easy;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class J62 {
    public int lastRemaining(int n, int m) {
        if (m == 1) return n - 1;
        int start = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i == m - 1)
                start = i;
            else list.add(i);
        }
        while (list.size() > 1) {
            int p = m == list.size() ? m : m % list.size();

            int tail = list.size() - start;//尾部长度

            if (tail + 1 >= p) { //在后面
                start += p - 1;//-1是下标从0开始 -1是因为 长度3=3-1+1
            } else {
                p -= tail;
                start = p - 1;
            }

            list.remove(start);
            if (start >= list.size()) start = 0;//到头了
        }
        return list.get(0);
    }

}
