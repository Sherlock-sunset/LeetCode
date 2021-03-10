package com.sherlock.normal;

public class T81 {
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target ||nums[right] == target ||nums[left] == target ) return true;

            if (nums[mid]>target&&nums[right]>=nums[left]) left++;
            else if (nums[mid]<target && nums[left]<target) left++;
            else right--;

        }
        return false;
    }
}
