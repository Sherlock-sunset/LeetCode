package com.sherlock;

import com.sherlock.data_structure.QuickSort;
import com.sherlock.data_structure.RainbowSort;
import com.sherlock.easy.*;
import com.sherlock.hard.*;
import com.sherlock.lintcode.*;
import com.sherlock.normal.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;


public class Main {

    public static void main(String[] args) {


        //Integer[] nums1 = {2, 2, 2, 1, 3, 1, 3, 4, 3, 2, 4, 1, 3, 4, 4, 2, 2, 1, 1, 3, 3};
        Integer[] nums1 = {1, 7, 9, 2, 5, 3, 4, 8, 0, 6};
        //System.out.println(new J51().reversePairs(nums1));
//        for (int i = 0; i < nums1.length; i++) {
//            System.out.print(nums1[i] + " ");
//
//        }
        //new RainbowSort().rainbowSort(nums1,4);
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < nums1.length; i++) {
            heap.add(nums1[i]);
        }
//        for (int i = 0; i < nums1.length; i++) {
//            System.out.println(heap.poll());
//        }
        nums1 = heap.toArray(new Integer[0]);
        //new QuickSort().sort(nums1);
        System.out.println(Arrays.toString(nums1));

    }


}
