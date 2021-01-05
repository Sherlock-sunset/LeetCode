package com.sherlock.easy;

public class J11 {
    public int minArray(int[] numbers) {
        if (numbers.length == 0)
            return 0;
        for (int i = numbers.length-1; i >0 ; i--) {
            if (numbers[i-1]>numbers[i])
                return numbers[i];
        }
        return numbers[0];
    }
}
