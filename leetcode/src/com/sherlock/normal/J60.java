package com.sherlock.normal;

public class J60 {
    public double[] dicesProbability(int n) {
        int max = 6 * n;
        double[] probs = new double[max - n + 1];//最小是n点，最大是n*6点
        int sum = 6;

        int[] points = new int[n];

        for (int i = 0; i < n; i++) {
            points[i] = 1;
        }
        probs[0] = 1;
        for (int i = 0; i < points.length; i++) {
            for (int j = 1; j < 6; j++) {
                if (points[i] < 6) {
                    points[i]++;
                    sum++;
                    probs[sum - n]++;
                }
            }
        }
        for (int i = 0; i < probs.length; i++) {
            probs[i] /= Math.pow(6,n);
        }
        return probs;
    }


}
