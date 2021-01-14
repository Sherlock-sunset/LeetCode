package com.sherlock.normal;

import java.util.ArrayList;
import java.util.List;

public class T50 {
    public double myPow(double x, int n) {
        double res = 1.0;
        for (int i = n; i != 0; i /= 2) {
            if (i % 2 != 0) {
                res *= x;
            }
            x *= x;
        }
        return n >= 0 ? res : 1 / res;
    }

}
