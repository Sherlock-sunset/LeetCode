package com.sherlock.easy;

import java.util.Arrays;

public class T977 {
    public int[] sortedSquares(int[] nums) {
        int index = Arrays.binarySearch(nums, 0);
        int left = 0, right = 0, p = 0;
        int[] ans = new int[nums.length];
        if (index < 0) {
            index = -index - 1;
            left = index - 1;
            right = index;
        } else {
            left = index;
            right = index + 1;
        }
        while (left >= 0 || right < nums.length) {
            if (left < 0) {
                ans[p++] = nums[right] * nums[right];
                right++;
            } else if (right >= nums.length) {
                ans[p++] = nums[left] * nums[left];
                left--;
            } else {
                if (Math.abs(nums[left])<=nums[right]){
                    ans[p++] = nums[left] * nums[left];
                    left--;
                }else {
                    ans[p++] = nums[right] * nums[right];
                    right++;
                }
            }


        }
        return ans;
    }
}
