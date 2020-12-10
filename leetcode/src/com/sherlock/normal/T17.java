package com.sherlock.normal;

import java.util.ArrayList;
import java.util.List;

public class T17 {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits ==null || digits.isEmpty())
            return result;
        String[][] chars = {{"a", "b", "c"}, {"d", "e", "f"}, {"g", "h", "i"}, {"j", "k", "l"}, {"m", "n", "o"}, {"p", "q", "r", "s"}, {"t", "u", "v"}, {"w", "x", "y", "z"}};
        char [] nums = digits.toCharArray();
        for (int i = 0; i < chars[Integer.valueOf(nums[0]+"")].length; i++) {
            result.add(chars[Integer.valueOf(nums[0]+"")-2][i]);
        }
        for (int i = 1; i < nums.length; i++) {
            result = dker(result,chars[Integer.valueOf(nums[i]+"")-2]);
        }
        return result;
    }

    public List<String> dker(List<String> s1, String[] s2) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < s1.size(); i++) {
            for (int j = 0; j < s2.length; j++) {
                result.add(s1.get(i) + s2[j]);
            }
        }
        return result;
    }
}
