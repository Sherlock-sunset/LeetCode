package com.sherlock.normal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class T120 {
    public int minimumTotal(List<List<Integer>> triangle) {

        int result = Integer.MAX_VALUE;

        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> data = triangle.get(i - 1);
            List<Integer> dp = triangle.get(i);

            for (int j = 0; j < dp.size(); j++) {

                if (j == 0) dp.set(j, dp.get(j) + data.get(j));
                else if (j >= data.size()) dp.set(j, dp.get(j) + data.get(j - 1));
                else dp.set(j, dp.get(j) + Math.min(data.get(j), data.get(j - 1)));

                if (i == triangle.size() - 1) result = Math.min(result, dp.get(j));
            }
            triangle.set(i, dp);
        }

        return triangle.size() > 1 ? result : triangle.get(0).get(0);
    }
}
