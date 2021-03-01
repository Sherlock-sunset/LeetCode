package com.sherlock.normal;

import java.util.HashMap;

public class J56 {
    public int[] singleNumbers(int[] nums) {
        int[] results = {0,0};
        int r = 0;
        for (int n : nums) {
            r ^= n;
        }
        int div=1;//0001
        while ((div & r) ==0 )
            div <<=1;
        for (int i = 0; i < nums.length; i++) {
            if ((div & nums[i]) == div){
                results[0] ^= nums[i];
            }else {
                results[1] ^= nums[i];
            }
        }
        return results;
    }
}
