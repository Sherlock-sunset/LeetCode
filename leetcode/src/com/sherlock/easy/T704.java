package com.sherlock.easy;

public class T704 {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length < 1) return -1;
        int left = 0, right = nums.length - 1, mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;

    }
}
