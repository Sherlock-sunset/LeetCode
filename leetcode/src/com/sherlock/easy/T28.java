package com.sherlock.easy;

import java.util.ArrayList;
import java.util.List;

public class T28 {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.isEmpty())
            return 0;
        char[] hay = haystack.toCharArray(), needles = needle.toCharArray();
        if (hay.length < needles.length) {
            return -1;
        }
        int[] pro = new int[hay.length - needles.length + 1];
//        List<Integer> startProbs = new ArrayList<>();
        int result = -1;
        for (int i = 0; i < pro.length; i++) {
            if (hay[i] == needles[0] && hay.length - i >= needles.length) {
                pro[i] = 1;
                if (result == -1 && needles.length == 1)
                    result = i;
            } else
                pro[i] = 0;

        }
        for (int i = 1; i < needles.length; i++)
            for (int j = 0; j < pro.length; j++) {
                if (pro[j] == 1) {
                    if (hay[j + i] != needles[i]) {
                        pro[j] = -1;
                    } else {
                        result = j;
                        if (i == needles.length-1)
                            break;
                    }
                }

            }


        return result;

    }
}
