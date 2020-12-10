package com.sherlock.dynamic_programming;
/**
 * 爱丽丝参与一个大致基于纸牌游戏 “21点” 规则的游戏，描述如下：
 * 爱丽丝以 0 分开始，并在她的得分少于 K 分时抽取数字。 抽取时，她从 [1, W] 的范围中随机获得一个整数作为分数进行累计，其中 W 是整数。 每次抽取都是独立的，其结果具有相同的概率。
 * 当爱丽丝获得不少于 K 分时，她就停止抽取数字。 爱丽丝的分数不超过 N 的概率是多少？
 */

/**
 * 爱丽丝获胜的概率只和下一轮开始前的得分有关，因此根据得分计算概率。
 */
//倒数第二次分数累加为K-1，游戏结束时最大分数可能为K-1+W   maxScore = K-1+W,长度为K-1+W+1（含从0开始）
//游戏开始就结束的胜利概率
public class T837 {

    public double new21Game(int N, int K, int W) {
        if (K == 0)
            return 1.0;
        double[] dp = new double[K+W];
        for (int i = K ;i <= Math.min(K + W - 1, N); i++) {
            dp[i] = 1.0;
        }
        dp[K - 1] = 1.0 * Math.min(N - K + 1, W) / W;
        for (int i = K - 2; i >= 0; i--) {
            dp[i] = dp[i + 1] - (dp[i + W + 1] - dp[i + 1]) / W;
        }
//        for (int i = K - 1; i >= 0; i--) {
//            for (int j = 1; j <= W; j++) {
//                dp[i] += dp[i+j] / W;
//            }
////            dp[i] /= W;
//        }
        return dp[0];
    }
}
