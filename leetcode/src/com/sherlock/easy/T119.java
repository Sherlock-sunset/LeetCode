package com.sherlock.easy;

import java.util.ArrayList;
import java.util.List;

public class T119 {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (i == 0 || i == 1 || j == 0 || j == i){
                    list.add(1);
                }else
                    list.add(result.get(i-1).get(j-1)+result.get(i-1).get(j));
            }
            result.add(list);
        }
        return result.get(rowIndex);
    }
}
