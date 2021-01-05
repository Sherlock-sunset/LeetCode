package com.sherlock.easy;

import com.sherlock.sort.BublleSort;

public class T169 {
    public int majorityElement(int[] nums) {
        if (nums.length <= 1)
            return nums[0];
        nums = new BublleSort().bubbleSort(nums);
        for (int i = 1, count = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] && ++count > nums.length / 2) {
                return nums[i];
            } else if (nums[i] != nums[i - 1]) {
                count = 1;
            }
        }
        return nums[nums.length - 1];
    }
}
