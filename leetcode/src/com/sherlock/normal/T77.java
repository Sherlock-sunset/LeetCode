package com.sherlock.normal;

import java.util.ArrayList;
import java.util.List;

public class T77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(i);
            if (list.size() == k) result.add(list);
            else combine(list, i, n, k, result);
        }

        return result;

    }

    public void combine(List<Integer> ori, int start, int n, int k, List<List<Integer>> result) {
        for (int i = start + 1; i <= n; i++) {
            List<Integer> list = new ArrayList<>();
            list.addAll(ori);
            list.add(i);
            if (list.size() == k) result.add(list);
            else combine(list, i, n, k, result);
        }

    }
}
