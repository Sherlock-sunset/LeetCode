package com.sherlock.normal;

import java.util.*;

public class J60 {
    public double[] dicesProbability(int n) {
        HashMap<Integer, Double>[] dp = new HashMap[n];
        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
        }
        for (int i = 1; i <= 6; i++) {//初始化第一个骰子
            dp[0].put(i, 1.0);
        }

        for (int i = 1; i < n; i++) {//记录骰子出现次数
            for (Map.Entry<Integer, Double> entry : dp[i - 1].entrySet()) {
                for (int j = 1; j <= 6; j++) {
                    dp[i].put(entry.getKey() + j, dp[i].getOrDefault(entry.getKey() + j, 0.0) + entry.getValue());
                }
            }
        }
        //计算骰子点数概率
        double[] ans = new double[6 * n - n + 1];
        double sum = Math.pow(n, 6);//计算总点数次数

        for (int i = n; i <= 6 * n; i++) {

            ans[i - n] = dp[n - 1].getOrDefault(i, 0.0) / sum;
        }

        return ans;
    }


}
