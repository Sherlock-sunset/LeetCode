package com.sherlock.normal;

public class T198 {
//    public int rob(int[] nums) {
//        if (nums.length < 1) return 0;
//        if (nums.length == 1) return  nums[0];
//        int[] dpr = new int[nums.length];
//        int[] dpn = new int[nums.length];
//        dpr[0] = nums[0];
//        dpn[0] = 0;
//        dpr[1] = nums[1];
//        dpn[1] = nums[0];
//        int ans = Math.max(nums[0],nums[1]);
//
//        for (int i = 2; i < nums.length; i++) {
//            dpr[i] = dpn[i-1] + nums[i];
//            ans = Math.max(ans,dpr[i]);
//            dpn[i] = Math.max(dpr[i-1],dpn[i-1]);
//            ans = Math.max(ans,dpn[i]);
//        }
//
//        return ans;
//    }
    public int rob(int[] nums) {


        if (nums.length < 1) return 0;
        if (nums.length == 1) return  nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        //int ans = dp[1];

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }

        return dp[nums.length-1];
    }
}
