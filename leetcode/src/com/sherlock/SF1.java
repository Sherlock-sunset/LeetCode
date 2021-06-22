package com.sherlock;

import java.util.HashMap;
import java.util.Scanner;

public class SF1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[10];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < 10; i++) {
            b[i] = sc.nextInt();
        }
        System.out.println(solution(a, b, n));
        sc.close();
    }
    public static int solution(int[] a, int[] b, int n) {
        int ans = Integer.MIN_VALUE;
        HashMap<Integer, Boolean> isUsed = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            ans = Math.max(ans, profit(i, a, b, 0, n, isUsed, 0));
        }
        return Math.max(0, ans);
    }


    private static int profit(int car, int[] a, int[] b, int num, int n,
                              HashMap<Integer, Boolean> isUsed, int cprofit) {
        //i是车,num是运输总量
        HashMap<Integer, Boolean> map = new HashMap<>();
        int profit = cost(num, num + car, a);
        if (!isUsed.getOrDefault(car, false)) {
            profit -= b[car];
            map.putAll(isUsed);
            map.put(car, true);
        }
        if (profit < 0) return  0;
        profit += cprofit;
        if (num + car >= n-1) return profit;

        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < 10; i++) {
            ans = Math.max(ans, profit(i, a, b, num+car+1, n, map,profit));
        }
        return ans+profit;
    }

    public static int cost(int start, int end, int[] a) {
        int cost = 0;
        for (int i = start; i <= end && i < a.length; i++) {
            cost += a[i];
        }
        return cost * cost;
    }

}
