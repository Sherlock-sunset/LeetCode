package com.sherlock.easy;

public class T283 {
    //1.排序的思想
    public void moveZeroesBySort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            boolean flag = false;
            for (int j = 1; j < nums.length - i; j++) {
                if (nums[j - 1] == 0) {
                    nums[j - 1] = nums[j];
                    nums[j] = 0;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }

    //双指针
    public void moveZeroes(int[] nums) {
        if (nums.length == 0) return;
        int left = 0, right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                nums[left++] = nums[right];
            }
            right++;
        }
        while (left < nums.length) {
            nums[left++] = 0;
        }
    }
}
