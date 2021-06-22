package com.sherlock.normal;

import java.util.LinkedList;
import java.util.Queue;

public class T162 {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) return 0;
        if (nums.length == 2) return nums[0] > nums[1] ? 0 : 1;
        if (nums[1] < nums[0]) return 0;
        int p = 1;
        while (p < nums.length && nums[p] > nums[p - 1]) p++;
        return p-1;

    }
}
