package com.sherlock.normal;

/**
 * 这题用双指针解法最优
 * */
public class T11 {
    public int maxArea(int[] height) {
        if (height.length < 2)
            return 0;
        int result = 0;

        for (int i = 0; i < height.length-1; i++) {
            for (int j = i+1; j < height.length ; j++) {
                result = Math.max(result,computeArea(i,height[i],j,height[j]));
            }
        }
        return  result;
    }
    public int  computeArea(int i1,int ai1,int i2,int ai2){
        return (i2 - i1) * Math.min(ai1,ai2);
    }
}
