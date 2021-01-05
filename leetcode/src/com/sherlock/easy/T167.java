package com.sherlock.easy;

public class T167 {
    public int[] twoSum(int[] numbers, int target) {

        int l = 0,r = numbers.length -1;
        int [] result = new int[2];
        while (l<r){
            if (numbers[l] +numbers[r] == target){
                result[0] = l+1;
                result[1] = r +1;
                return result;
            }else if (numbers[l]+numbers[r]< target){
                l++;
            }else {
                r--;
            }
        }

        return null;
    }
}
