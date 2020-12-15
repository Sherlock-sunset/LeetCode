package com.sherlock.normal;

public class T33 {
    public int search(int[] nums, int target) {
        if (nums.length == 1)
            return nums[0] == target ? 0 : -1;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target)
                return mid;

            if (nums[0] <= nums[mid]) {//没反转
                if (nums[0] <= target && target < nums[mid]) { //什么时候应该往左边找
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {//反转了
                if (nums[mid] < target && target <= nums[nums.length - 1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

        }

        return -1;
    }
}
