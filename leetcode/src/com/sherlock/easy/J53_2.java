package com.sherlock.easy;

public class J53_2 {
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length < 1) return 0;
//        if (nums.length == 1) return nums[0] == 0 ? 1 : 0;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == mid) left = mid + 1;
//            else  (nums[mid > mid && ()]) right
            else {
                if ((mid - 1 >= 0 && nums[mid - 1] == mid - 1) || mid == 0) return mid;
                right = mid - 1;
            }
        }
        return nums.length;

    }
}
