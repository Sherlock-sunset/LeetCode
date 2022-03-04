package com.sherlock.offer;

import java.util.HashMap;

public class Day4 {

    /**
     * 剑指 Offer 03. 数组中重复的数字
     * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，
     * 但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
     */
    public int findRepeatNumber(int[] nums) {

        HashMap<Integer, Boolean> dic = new HashMap<>();
        for (int num : nums) {
            if (dic.getOrDefault(num, false)) return num;
            else dic.put(num, true);
        }

        return 0;
    }

    /**
     * 剑指 Offer 53 - I. 在排序数组中查找数字 I
     * 统计一个数字在排序数组中出现的次数。
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length < 1) return 0;
        int left = 0, right = nums.length - 1, mid = 0, ans = 0;

        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) break;
            else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (nums[mid] == target) {
            left = mid - 1;
            right = mid + 1;
            ans++;
            while (left >= 0 || right < nums.length) {
                if (left < 0 && right >= nums.length) break;
                if (left >= 0 && nums[left--] == target) ans++;
                if (right < nums.length && nums[right++] == target) ans++;
            }
        }
        return ans;
    }

    /**
     * 剑指 Offer 53 - II. 0～n-1中缺失的数字
     * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
     * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
     */
    public int missingNumber(int[] nums) {
        int left = 0, right = nums.length - 1, mid = 0;

        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == mid) {
                left = mid + 1;
            } else { //
                right = mid - 1;
            }
        }
        return left;
    }
}
