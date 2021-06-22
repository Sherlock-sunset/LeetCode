package com.sherlock.normal;

public class T33 {
    public int search(int[] nums, int target) {
        if (nums.length == 1)
            return nums[0] == target ? 0 : -1;
        int l = 0, r = nums.length - 1,n = nums.length;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) return mid;
            if (nums[0] <= nums[mid]) {// {l,m}有序{m+1,r}旋转
                if (nums[0] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {// {l,m}旋转{m+1,r}有序
                if (nums[mid] < target && target <= nums[n - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }



        }
        return -1;
    }
}
