package com.sherlock.normal;

import java.util.Deque;
import java.util.LinkedList;

public class J40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0) return new int[0];
        if (k == arr.length) return arr;
        int[] results = new int[k];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (i < k) {
                results[i] = arr[i];
                max = Math.max(max, results[i]);
            } else if (arr[i] < max) {

                int cmax = Integer.MIN_VALUE;
                boolean flag = true;
                for (int j = 0; j < k; j++) {
                    if (results[j] == max && flag) {
                        results[j] = arr[i];
                        flag = false;
                    }
                    cmax = Math.max(cmax, results[j]);
                }
                max = cmax;
            }
        }

        return results;
    }
}
