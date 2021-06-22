package com.sherlock.lintcode;

public class LC312 {
    /**
     * @param n: the number
     * @param m: the number of cards in hand
     * @return: the number of different types of cards
     */
    public int bullCards(int n, int m) {
        // Write your code here.
        int[] nums = new int[n];
        return trackback(n, m, 0, 1, 0, 0);
    }

    private int trackback(int n, int m, int lastSum, int p, int ans, int last) {
        for (int i = last; i < n; i++) {
            if (i != last || lastSum < 4) {


                if (p == m) {//
                    ans++;
                } else {
                    ans += trackback(n, m, i == last ? lastSum + 1 : 0, p + 1, ans, i);
                }
            }
        }
        return ans;
    }
}
