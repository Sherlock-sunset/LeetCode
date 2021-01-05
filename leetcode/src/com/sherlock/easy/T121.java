package com.sherlock.easy;

public class T121 {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1)
            return 0;
        int minPrice = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int p = prices[i] - minPrice;
            profit = Math.max(p,profit);
            if (prices[i] < minPrice)
                minPrice = prices[i];

        }
        return profit;
    }
}
