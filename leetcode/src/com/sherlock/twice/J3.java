package com.sherlock.twice;

import java.util.HashMap;

public class J3 {
    public int findRepeatNumber(int[] nums) {
        HashMap<Integer,Boolean> dict = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (dict.getOrDefault(nums[i],false)){
                return nums[i];
            }else {
                dict.put(nums[i],true);
            }
        }

        return  -1;
    }
}
