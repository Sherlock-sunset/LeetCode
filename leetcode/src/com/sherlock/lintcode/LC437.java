package com.sherlock.lintcode;
//书籍复印不会，后面记得在学习

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LC437 {
    public int copyBooks(int[] pages, int k) {
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        if (pages == null || pages.length == 0) {
            return 0;
        }
        if (k == 0) {
            return -1;
        }

        int start = 0, end = getSum(pages);

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (getNumberOfCopiers(pages, mid) <= k) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (getNumberOfCopiers(pages, start) <= k) {
            return start;
        }
        return end;
    }

    private int getNumberOfCopiers(int[] pages, int limit) {
        int copiers = 0;
        int lastCopied = limit;

        for (int page : pages) {
            if (page > limit) {//如果有一本书复制时间超过限制直接返回
                return Integer.MAX_VALUE;
            }
            if (lastCopied + page > limit) {
                copiers++;
                lastCopied = 0;
            }

            lastCopied += page;
        }

        return copiers;
    }

    private int getSum(int[] pages) {
        int sum = 0;
        for (int page : pages) {
            sum += page;
        }
        return sum;
    }
}
