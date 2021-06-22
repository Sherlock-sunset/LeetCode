package com.sherlock.normal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class T57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> ans = new ArrayList<>();
        boolean isAdd = false;
        int[] last = null;
        for (int i = 0; i < intervals.length; i++) {
            if (isAdd) { //排序
                if (intervals[i][0] > last[1]) {
                    ans.add(last);
                    last = intervals[i];
                } else {
                    last[1] = Math.max(last[1], intervals[i][1]);
                }
                continue;
            }
            if (newInterval[1] < intervals[i][0]) {
                ans.add(newInterval);
                isAdd = true;
            } else if (newInterval[0] > intervals[i][1]) {
            } else {
                intervals[i][0] = Math.min(intervals[i][0], newInterval[0]);
                intervals[i][1] = Math.max(intervals[i][1], newInterval[1]);
                isAdd = true;
            }
            if (!isAdd) ans.add(intervals[i]);
            else last = intervals[i];


        }


        if (!isAdd) ans.add(newInterval);
        else if (last != null) ans.add(last);
        return ans.toArray(new int[0][0]);
    }


}
