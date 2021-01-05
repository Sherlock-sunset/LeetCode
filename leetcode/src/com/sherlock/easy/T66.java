package com.sherlock.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T66 {
    public int[] plusOne(int[] digits) {
        int[] result = new int[digits.length+1];
        for (int i = digits.length-1; i >= 0 ; i--) {
            if (digits[i] + 1 >9){
                digits[i] = 0;
                result[i+1] = digits[i];
                if (i == 0){
                    result[0] = 1;
                    return result;
                }
            }else {
                digits[i] +=1;
                break;
            }
        }
        return digits;
    }
}
