package com.sherlock.normal;

public class T38 {
    public String countAndSay(int n) {
        if (n<1)
            return "";
        if (n == 1)
            return "1";
        String result = "1";
        for (int i = 1; i < n; i++) {
            char [] chars = result.toCharArray();
            StringBuilder sb = new StringBuilder();
            char currentChar = chars[0];
            int count = 0;
            for (int j = 0; j < chars.length; j++) {
                if (count == 0){
                    currentChar = chars[j];
                    count++;
                }else {
                  if (chars[j] != currentChar){
                      sb.append(count+""+currentChar);
                      currentChar = chars[j];
                      count = 1;
                  }else
                      count++;
                }
            }
            sb.append(count+""+currentChar);
            result = sb.toString();
        }
        return result;
    }
}
