package com.sherlock.offer;

public class Day8 {

    /**
     * 剑指 Offer 10- I. 斐波那契数列
     * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
     */
    public int fib(int n) {
        if (n < 2) return n;
        int a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            int temp = (a + b) % 1000000007;
            a = b;
            b = temp;
        }
        return b;
    }

    /**
     * 剑指 Offer 10- II. 青蛙跳台阶问题
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n级的台阶总共有多少种跳法。
     * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
     */
    public int numWays(int n) {
        if (n == 0) return 1;
        int a = 1, b = 2;
        if (n <= 2) return n;
        for (int i = 3; i <= n; i++) {
            int temp = (a + b) % 1000000007;
            a = b;
            b = temp;
        }
        return b;
    }

    /**
     * 剑指 Offer 63. 股票的最大利润
     * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int ans = 0,dp = 0;
        for (int i = 1; i < prices.length; i++) {
            dp = Math.max(dp + prices[i] - prices[i - 1], prices[i] - prices[i - 1]);
            ans = Math.max(dp, ans);
        }
        return ans;
    }
}
