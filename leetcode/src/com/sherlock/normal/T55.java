package com.sherlock.normal;

public class T55 {
    //    public boolean canJump(int[] nums) {
//        if (nums.length <= 1) return true;
//        return trackBack(nums, 0);
//    }
//
//    public boolean trackBack(int[] nums, int p) {
//        if (p == nums.length - 1 || p + nums[p] >= nums.length - 1)
//            return true;
//        for (int i = p+nums[p]; i >p ; i--) {
//
//        }
//    }
    public boolean canJump(int[] nums) {
        if (nums.length <= 1) return true;
        for (int i = nums[0]; i >= 0; i--) {
            if (trackBack(nums, i)) return true;
        }

        return false;
    }

    public boolean trackBack(int[] nums, int p) {
        if (p >= nums.length - 1 || nums.length <= p + nums[p] + 1) return true;
        for (int i = nums[p] + p; i > p; i--) {
            if (trackBack(nums, i)) return true;
        }
        return false;
    }
}
