package com.sherlock.normal;

public class T34 {

    public int[] searchRange(int[] nums, int target) {
        //二分查找
        int l = 0, r = nums.length - 1;
        int[] result = {-1, -1};

        while (l <= r) {
            if (nums[l] == target && nums[r] == target) {
                result[0] = l;
                result[1] = r;
                return result;
            }

            if (nums[l] <target)
                l++;
            if (nums[r]>target)
                r--;
        }

        return result;
    }

}
