package com.sherlock.dynamic_programming;

/**
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * 说明:
 * <p>
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 */
public class T300 {
    public static void main(String[] args) {
        Solution so = new Solution();
        System.out.println(so.lengthOfLIS(10, 9, 2, 5, 3, 7, 101, 18));
    }

    /**
     * 定义 dp[i]dp[i] 为考虑前 ii 个元素，以第 ii 个数字结尾的最长上升子序列的长度，注意 \textit{nums}[i]nums[i] 必须被选取。
     */

    public static class Solution {
        public int lengthOfLIS(int... nums) {
            if (nums.length==0)
                return 0;
            int max = 1;
            int[] dp = new int[nums.length];
            for (int i = 1; i < nums.length; i++) {
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (nums[j] < nums[i])
                        dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
                max = Math.max(dp[i],max);
            }

            return max;
        }

    }
}
