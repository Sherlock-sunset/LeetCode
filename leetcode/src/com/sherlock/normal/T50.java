package com.sherlock.normal;

import java.util.ArrayList;
import java.util.List;

public class T50 {
    public double myPow(double x, int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return x;
        if (x == 1.0 || x == 0.0)
            return x;

        boolean po = n > 0;
        List<Double> list = new ArrayList<>();
        list.add(x);
        int max = 1;
        for (int i = 2; i <= (po ? n : -n); i *= i) {
            double last = list.get(list.size()-1);
            list.add(last * last);
            max = i;
        }

        double result = 0.0;
        for (int i = list.size()-1; i >=0 ;) {
//            result +=
        }
        return 0.0;
    }
}
