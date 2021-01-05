package com.sherlock.easy;

import java.util.ArrayList;
import java.util.List;

public class T168 {
    public String convertToTitle(int n) {
        if (n == 0)
            return "";
        List<Integer> list = new ArrayList<>();
        while (n > 26) {
            if (n % 26 == 0) {
                list.add(26);
                n = n / 26 - 1;
            } else {
                list.add(n % 26);
                n = n / 26;
            }
        }
        if (n > 0)
            list.add(n % 27);

        StringBuilder sb = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            char c = (char) ('A' - 1 + list.get(i));
            sb.append(c);
        }
        return sb.toString();
    }
}

