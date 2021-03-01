package com.sherlock.normal;

import java.util.ArrayList;
import java.util.HashMap;

public class J48 {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 1;
        char[] charsStr = s.toCharArray();
        if (charsStr.length == 1)
            return 1;
        else if (charsStr.length == 0)
            return 0;

        ArrayList<Character> enqueue = new ArrayList<>();
        enqueue.add(charsStr[0]);

        for (int i = 1, temp = 1; i < charsStr.length; i++) {


            if (!enqueue.contains(charsStr[i])) {
                //进队
                if (++temp > maxLen)
                    maxLen = temp;
                enqueue.add(charsStr[i]);
            } else {
                while (enqueue.get(0) != charsStr[i]) {
                    //出队
                    enqueue.remove(0);
                }
                enqueue.remove(0);//不要漏了这句
                enqueue.add(charsStr[i]);
                temp = enqueue.size();
            }
        }

        return maxLen;
    }
}
