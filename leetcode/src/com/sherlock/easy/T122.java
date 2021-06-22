package com.sherlock.easy;

public class T122 {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1)
            return 0;
        int lastPrice = -1;
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (lastPrice == - 1){
                if (i + 1 < prices.length && prices[i + 1] > prices[i]) {
                    lastPrice = prices[i];//
                }
            } else if (i + 1 < prices.length) {
                if (prices[i] > lastPrice && prices[i + 1] < prices[i]) {
                    profit += prices[i] - lastPrice;
                    lastPrice = -1;
                }
            } else {
                if (prices[i] > lastPrice)
                    profit += prices[i] - lastPrice;
            }
        }
        return profit;
    }
}
