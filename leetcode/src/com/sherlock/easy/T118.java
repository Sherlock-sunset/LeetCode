package com.sherlock.easy;

import java.util.ArrayList;
import java.util.List;

public class T118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (i == 0 || i == 1 || j == 0 || j == i){
                    list.add(1);
                }else
                list.add(result.get(i-1).get(j-1)+result.get(i-1).get(j));
            }
            result.add(list);
        }
        return result;
    }
}
