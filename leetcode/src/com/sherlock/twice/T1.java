package com.sherlock.twice;

import java.util.HashMap;

public class T1 {
    public int[] twoSum(int[] nums, int target) {
        int [] ans = new int[2];
        HashMap<Integer,Integer> location = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (location.getOrDefault(nums[i],-1) != -1 && target == nums[i] * 2){
                ans[0] = location.getOrDefault(nums[i],-1);
                ans[1] = i;
                return ans;
            }
            location.put(nums[i],i);
        }
        for (int n : nums) {
            ans[1] = location.getOrDefault(target-n,-1);
            if (ans[1] != -1 && location.get(n) != ans[1]){
                ans[0] = location.get(n);
                return ans;
            }
        }


        return ans;
    }
}
