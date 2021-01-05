package com.sherlock.easy;

import java.util.HashMap;

public class J3 {
    public int findRepeatNumber(int[] nums) {
        HashMap<Integer,Boolean> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.getOrDefault(nums[i],false)){
                return nums[i];
            }else{
                map.put(nums[i],true);
            }
        }
        return 0;
    }
}
