package com.sherlock.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Day17 {
    /**
     * 剑指 Offer 40. 最小的k个数
     * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] ans = new int[k];
        //快排
        quickSortStopWithK(arr, 0, arr.length - 1, k);
        for (int i = 0; i < k; i++) {
            ans[i] = arr[i];
        }
        return ans;
    }

    private void quickSortStopWithK(int[] arr, int left, int right, int k) {
        if (left >= right) return;
        int pivot = parttion(arr, left, right);
        if (pivot == k) return;
        quickSortStopWithK(arr, left, pivot - 1, k);
        quickSortStopWithK(arr, pivot + 1, right, k);
    }

    private int parttion(int[] arr, int left, int right) {
        int pivot = arr[left];

        while (left < right) {
            while (left < right && arr[right] >= pivot) right--;
            if (left < right) arr[left++] = arr[right];
            while (left < right && arr[left] <= pivot) left++;
            if (left < right) arr[right--] = arr[left];
        }
        arr[left] = pivot;
        return left;
    }

    /**
     * 剑指 Offer 41. 数据流中的中位数
     * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
     * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
     * <p>
     * 例如，
     * <p>
     * [2,3,4]的中位数是 3
     * <p>
     * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
     * <p>
     * 设计一个支持以下两种操作的数据结构：
     * <p>
     * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
     * double findMedian() - 返回目前所有元素的中位数。
     */

    class MedianFinder {

        /**
         * initialize your data structure here.
         */
        List<Integer> nums;

        public MedianFinder() {
            nums = new ArrayList<>();
        }

        public void addNum(int num) {
            int index = Collections.binarySearch(nums, num);
            //otherwise, (-(insertion point) - 1).
            if (index < 0) {
                index = -index - 1;
            }
            nums.add(index, num);
        }

        public double findMedian() {
            //4/2 = 2
            if ((nums.size() % 2) == 0) {
                return (double) (nums.get(nums.size() / 2) + nums.get(nums.size() / 2 - 1)) / 2;
            } else {
                return Double.valueOf(nums.get(nums.size() / 2));
            }
        }
    }
}
