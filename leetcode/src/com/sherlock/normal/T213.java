package com.sherlock.normal;

public class T213 {
    public int rob(int[] nums) {
        if (nums.length < 1) return 0;
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        int ans = dp[1];
        if (nums.length==2) return ans;
        for (int i = 2; i < nums.length - 1; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
            ans = Math.max(dp[i], ans);
        }
        dp[1] = nums[1];
        dp[2] = Math.max(nums[1], nums[2]);
        for (int i = 3; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
            ans = Math.max(dp[i], ans);
        }
        return ans;

    }

    private int myRob(int[] nums) {
        int pre = 0, cur = 0, tmp;
        for (int num : nums) {
            tmp = cur;
            cur = Math.max(pre + num, cur);
            pre = tmp;
        }
        return cur;
    }


}
