package com.sherlock.easy;

public class J53 {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length < 1) return 0;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                int count = 1;
                left = mid - 1;
                right = mid + 1;
                while ((left >= 0 && nums[left] == target) || (right < nums.length && nums[right] == target)) {
                    if (left >= 0 && nums[left] == target) {
                        count++;
                        left--;
                    }
                    if (right < nums.length && nums[right] == target) {
                        count++;
                        right++;
                    }
                }
                return count;
            }
            if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return 0;
    }
}
