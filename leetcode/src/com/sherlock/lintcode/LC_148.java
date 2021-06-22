package com.sherlock.lintcode;

public class LC_148 {
    public void sortColors(int[] nums) {
        // write your code here
        if (nums.length <= 1) return;
        int p0 = 0, p2 = nums.length - 1;
        for (int i = 0; i <= p2; i++) {
            if (nums[i]==0){
                int b = nums[p0];
                nums[p0++] = nums[i];
                nums[i] = b;
            }else if (nums[i]==2){
                int b = nums[p2];
                nums[p2--] = nums[i];
                nums[i--] = b;
            }
        }
    }
}
