package com.sherlock.offer;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;

public class Day16 {
    /**
     * 剑指 Offer 45. 把数组排成最小的数
     * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
     */
    public String minNumber(int[] nums) {
        StringBuilder ans = new StringBuilder();
        String[] arrNum = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arrNum[i] = String.valueOf(nums[i]);
        }
        for (int i = 0; i < arrNum.length; i++) {
            for (int j = 1; j < arrNum.length - i; j++) {
                long x = Long.parseLong(arrNum[j - 1] + arrNum[j]);
                long y = Long.parseLong(arrNum[j] + arrNum[j - 1]);
                if (x > y) {
                    String temp = arrNum[j - 1];
                    arrNum[j - 1] = arrNum[j];
                    arrNum[j] = temp;
                }
            }
        }


        for (String s : arrNum) {
            ans.append(s);
        }
        return ans.toString();
    }


    /**
     * 剑指 Offer 61. 扑克牌中的顺子
     * 从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，
     * A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
     */
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int dis = 0;
        Integer last = null;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                dis--;
                continue;
            }
            if (last != null) {
                if (last == nums[i]) return false;
                dis += nums[i] - last - 1;
            }
            last = nums[i];

        }
        return dis <= 0;
    }
}
