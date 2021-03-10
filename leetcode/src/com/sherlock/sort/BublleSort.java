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
    public int[] MySort (int[] arr) {
        // write code here
        if(arr.length<=1) return arr;
        quickSort(arr,0,arr.length-1);
        return arr;
    }
    public void quickSort(int[] arr,int low,int high){
        if(high<=low+1) return;
        int pivot = arr[low], ol = low,oh = high;
        while(low < high){
            while(arr[high]>pivot && high>low) high--;
            if(high>low)arr[low++] = arr[high];

            while(arr[low]<pivot && high>low) low++;
            if(high>low) arr[high--] = arr[low];
        }
        arr[low] = pivot;
        pivot = low;
        quickSort(arr,ol,pivot-1);
        quickSort(arr,pivot+1,oh);
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
