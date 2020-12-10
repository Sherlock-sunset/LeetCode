package com.sherlock.sort;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BublleSort {

    public int[] bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            boolean flag = false;

            for (int j = 1; j < nums.length - i; j++) {
                if (nums[j - 1] > nums[j]) {
                    int buff = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = buff;
                    flag = true;
                }
            }
//            System.out.print(nums[nums.length-1-i]);
            if (!flag)
                break;
        }
        return nums;
    }

//    public ArrayList<Integer> bubbleSort(ArrayList<Integer> nums) {
//        if (nums ==null)
//            return nums;
//        Iterator<Integer> it = nums.iterator();
//        while (it.hasNext()){
//            buff
//        }
//        for (int i = 0; i < nums.size() - 1; i++) {
//            int buff = nums.get(i);
//            if (nums.get(i) > nums.get(i + 1)) {
//
//                nums.get(i)= nums.get(i + 1);
//                nums.get(i + 1) = buff;
//            }
//        }
//        return nums;
//    }

}
