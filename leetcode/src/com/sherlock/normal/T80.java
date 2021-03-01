package com.sherlock.normal;

public class T80 {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length;
        int p = 0, duplicates = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[p] == nums[i]) {
                duplicates++;
                if (duplicates <= 1) {//去重
                    nums[++p] = nums[i];
                }
            } else {
                nums[++p] = nums[i];
                duplicates = 0;
            }
        }

        return p+1;
    }
}
