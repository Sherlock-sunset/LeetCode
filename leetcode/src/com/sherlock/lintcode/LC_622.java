package com.sherlock.lintcode;

import java.util.HashMap;

public class LC_622 {
    /**
     * @param stones: a list of stones' positions in sorted ascending order
     * @return: true if the frog is able to cross the river or false
     */
    public boolean canCross(int[] stones) {
        // write your code here
        if (stones.length <=1 ) return true;
        //第一次只能跳一个单位
        if (stones[1] > 1) return false;
        HashMap<Integer, Boolean>[] dp = new HashMap[stones.length];
        dp[0] = new HashMap<>();
        dp[0].put(0, true);
        dp[1] = new HashMap<>();
        dp[1].put(1, true);
        for (int i = 2; i < stones.length; i++) {
            dp[i] = new HashMap<>();
            for (int j = 1; j < i; j++) {
                int step = stones[i] - stones[j];//需要跳的步骤
                if (dp[j].getOrDefault(step - 1, false)
                        || dp[j].getOrDefault(step + 1, false)
                        || dp[j].getOrDefault(step, false)) {
                    dp[i].put(step, true);
                }
            }

        }
        return !dp[stones.length - 1].isEmpty();
    }
}
