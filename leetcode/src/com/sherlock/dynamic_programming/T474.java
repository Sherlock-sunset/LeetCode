package com.sherlock.dynamic_programming;

/**
 * 在计算机界中，我们总是追求用有限的资源获取最大的收益。
 * <p>
 * 现在，假设你分别支配着 m 个 0 和 n 个 1。另外，还有一个仅包含 0 和 1 字符串的数组。
 * <p>
 * 你的任务是使用给定的 m 个 0 和 n 个 1 ，找到能拼出存在于数组中的字符串的最大数量。每个 0 和 1 至多被使用一次。
 */
public class T474 {
    public static void main(String[] args) {
        Solution so = new Solution();
        String[] strs = {"10", "0001", "111001", "1", "0"};
        System.out.println(so.findMaxForm(strs, 5, 3));
    }

    public static class Solution {
        //需要从大到小进行枚举，从小到大开始会影响后面的答案
        public int findMaxForm(String[] strs, int m, int n) {
            if (strs.length < 1)
                return 1;
            int[][] dp = new int[m + 1][n + 1];
            int max = 0;
            for (int k = 0; k < strs.length; k++) {
                int[] costZeroAndOne = countZeroAndOne(strs[k]);
                int zeroCost = costZeroAndOne[0], oneCost = costZeroAndOne[1];
                for (int i = m; i >= zeroCost; i--) {
                    for (int j = n; j >= oneCost; j--) {
                        if (k == 0) {
                            //初始化第一个字符串
                            dp[i][j]++;
                        } else {
                            // a = 添加当前,b = 不添加当前
                            if (i - zeroCost >= 0 && j - oneCost >= 0)
                                dp[i][j] = Math.max(1 + dp[i - zeroCost][j - oneCost], dp[i][j]);
                        }

                        max = Math.max(dp[i][j], max);
                    }
                }
            }
            return max;
        }

        public int[] countZeroAndOne(String strs) {
            int zeroNum = 0, oneNum = 0;
            int[] result = new int[2];

            char[] chars = strs.toCharArray();
            for (int j = 0; j < chars.length; j++)
                if (chars[j] == '0')
                    zeroNum++;
                else
                    oneNum++;


            result[0] = zeroNum;
            result[1] = oneNum;
            return result;
        }
    }
}
