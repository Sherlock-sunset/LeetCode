package com.sherlock.dynamic_programming;

/**
 * 有 n 个城市通过 m 个航班连接。每个航班都从城市 u 开始，以价格 w 抵达 v。
 * <p>
 * 现在给定所有的城市和航班，以及出发城市 src 和目的地 dst，你的任务是找到从 src 到 dst 最多经过 k 站中转的最便宜的价格。 如果没有这样的路线，则输出 -1
 */
public class T787 {
    public static void main(String[] args) {
        Solution so = new Solution();
        int n = 3, src = 0, dst = 2, k = 1;
        int[][] edges = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
        System.out.println(so.findCheapestPrice(n, edges, src, dst, k));
        System.out.println(so.findCheapestPrice(n, edges, src, dst, k));

    }


    public static class Solution {
        //解法2
        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
            if (src == dst)
                return 0;
            K++;//最多经过 k 站“中转”
            int[][] dp = new int[n][flights.length];
            int SRC = 0, DST = 1, PRICE = 2, NO_CHOOSE = -1, minPrice = NO_CHOOSE;

            //初始化航班
            for (int i = 0; i < flights.length; i++) {
                dp[0][i] = -1;
                if (flights[i][SRC] == src) {
                    dp[0][i] = flights[i][PRICE];
                    if (flights[i][DST] == dst)
                        minPrice = minPrice == NO_CHOOSE ? dp[0][i] : Math.min(minPrice, dp[0][i]);
                }
            }
            for (int i = 1; i < K; i++) { //行 K
                for (int j = 0; j < flights.length; j++) {
                    dp[i][j] = NO_CHOOSE;
                    for (int k = 0; k < flights.length; k++) {
                        if (dp[i - 1][k] != -1 && flights[k][DST] == flights[j][SRC]) { //在第i个航班中 能到这个城市

                            dp[i][j] = dp[i][j] == NO_CHOOSE ? dp[i - 1][k] + flights[j][PRICE] : Math.min(dp[i - 1][k] + flights[j][2], dp[i][j]);
                            //如果是到终点的航班记录价格
                            if (flights[j][DST] == dst)
                                minPrice = minPrice == NO_CHOOSE ? dp[i][j] : Math.min(minPrice, dp[i][j]);
                        }
                    }
                }
            }
            return minPrice;
        }

        //解法1
        public int findCheapestPrice1(int n, int[][] flights, int src, int dst, int K) {
            if (src == dst)
                return 0;
            K++;//最多经过 k 站“中转”
            int[][] dp = new int[K][flights.length];
            int SRC = 0, DST = 1, PRICE = 2, NO_CHOOSE = -1, minPrice = NO_CHOOSE;
            //初始化航班
            for (int i = 0; i < flights.length; i++) {
                dp[0][i] = -1;
                if (flights[i][SRC] == src) {
                    dp[0][i] = flights[i][PRICE];
                    if (flights[i][DST] == dst)
                        minPrice = minPrice == NO_CHOOSE ? dp[0][i] : Math.min(minPrice, dp[0][i]);
                }
            }
            for (int i = 1; i < K; i++) { //行 K
                for (int j = 0; j < flights.length; j++) {
                    dp[i][j] = NO_CHOOSE;
                    for (int k = 0; k < flights.length; k++) {
                        if (dp[i - 1][k] != -1 && flights[k][DST] == flights[j][SRC]) { //在第i个航班中 能到这个城市

                            dp[i][j] = dp[i][j] == NO_CHOOSE ? dp[i - 1][k] + flights[j][PRICE] : Math.min(dp[i - 1][k] + flights[j][2], dp[i][j]);
                            //如果是到终点的航班记录价格
                            if (flights[j][DST] == dst)
                                minPrice = minPrice == NO_CHOOSE ? dp[i][j] : Math.min(minPrice, dp[i][j]);
                        }
                    }
                }
            }
            return minPrice;
        }
    }
}
