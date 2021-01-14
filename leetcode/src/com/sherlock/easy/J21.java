package com.sherlock.easy;

public class J21 {
    public int[] exchange(int[] nums) {
        int l = 0, r = nums.length-1;
        while (l<r){
            if (nums[r] % 2 ==0){
                r--;
            }else if (nums[l] % 2 ==1 ){
                l++;
            }else {
                int b = nums[l];
                nums[l] = nums[r];
                nums[r] = b;
                l++;
            }

        }

        return nums;

    }

}
