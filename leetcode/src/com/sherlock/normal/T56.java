package com.sherlock.normal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class T56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]); //排序
        List<int[]> ansList = new ArrayList<>();
        int[] last = null;
        for (int i = 0; i < intervals.length; i++) {
            if (last == null) {
                last = intervals[i];
            } else if (intervals[i][0] > last[1]) {
                ansList.add(last);
                last = intervals[i];
            } else {
                last[1] = Math.max(last[1], intervals[i][1]);
            }
        }
        if (last != null) ansList.add(last);
        return ansList.toArray(new int[0][0]);
    }
}
