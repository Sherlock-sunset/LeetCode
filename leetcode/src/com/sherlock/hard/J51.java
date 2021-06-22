package com.sherlock.hard;

import java.util.ArrayList;

public class J51 {
    public int reversePairs(int[] nums) {
        int ans = mergesort(nums, 0, nums.length-1);
        return ans;
    }

    private int mergesort(int[] nums, int left, int right) {
        if (right <= left) return 0;
        if (right - left == 1) {
            if (nums[left] > nums[right]) {
                swap(nums, left, right);
                return 1;
            } else return 0;
        }


        int mid = (left + right) / 2;
        int ans = mergesort(nums, left, mid);
        ans += mergesort(nums, mid + 1, right);
        //归并
        ArrayList<Integer> arr = new ArrayList<>();
        int pl = left, pr = mid + 1, p = left;

        while (pl <= mid || pr <= right) {
            if (pl <= mid && pr <= right) {
                if (nums[pl] <= nums[pr]) {

                    arr.add(nums[pl++]);
                } else {
                    if (pr != p) ans += pr-p;

                    arr.add(nums[pr++]);

                }
            } else if (pl <= mid) {
                arr.add(nums[pl++]);

            } else {
                if (pr != p){ ans += pr-p;}
                arr.add(nums[pr++]);

            }
            p++;

        }
        for (Integer n : arr) {
            nums[left++] = n;
        }
        return ans;
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
