package com.sherlock.easy;

import java.util.Arrays;

public class J61 {
    public boolean isStraight(int[] nums) {
        int distance = 0;
        Arrays.sort(nums);
        if (nums[0] == 0) distance--;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 0) {
                distance--;
                continue;
            } else if (nums[i - 1] == 0) continue;
            if (nums[i] == nums[i - 1]) return false;
            distance += nums[i] - nums[i - 1] - 1;
        }

        return distance <= 0;
    }
}
