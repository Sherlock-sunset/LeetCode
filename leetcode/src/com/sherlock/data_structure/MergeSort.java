package com.sherlock.data_structure;

public class MergeSort {
    public void merge(int[] arr, int left, int right) {
        if (right - left == 1) {//两个
            if (arr[left] > arr[right])
                swapValue(arr, left, right);
        } else if (right - left <= 0) {
            return;
        } else {
            int mid = (left + right) / 2;
            merge(arr, left, mid);
            merge(arr, mid + 1, right);

            //两堆归并
            int[] ans = new int[right - left + 1];
            int lp = left, rp = mid + 1;

            for (int i = left; i <= right; i++) {
                if (lp <= mid && rp <= right) {
                    ans[i - left] = arr[rp] > arr[lp] ? arr[lp++] : arr[rp++];
                } else if (lp > mid) {
                    ans[i - left] = arr[rp++];
                } else {
                    ans[i - left] = arr[lp++];
                }
            }
            for (int i = left; i <= right; i++) {
                arr[i] = ans[i - left];
            }
        }

    }

    private void swapValue(int[] arr, int i, int j) {
        int buff = arr[i];
        arr[i] = arr[j];
        arr[j] = buff;
    }
    public int reversePairs(int[] nums) {
        int len = nums.length;

        if (len < 2) {
            return 0;
        }

        int[] copy = new int[len];
        for (int i = 0; i < len; i++) {
            copy[i] = nums[i];
        }

        int[] temp = new int[len];
        return reversePairs(copy, 0, len - 1, temp);
    }

    private int reversePairs(int[] nums, int left, int right, int[] temp) {
        if (left == right) {
            return 0;
        }

        int mid = left + (right - left) / 2;
        int leftPairs = reversePairs(nums, left, mid, temp);
        int rightPairs = reversePairs(nums, mid + 1, right, temp);

        if (nums[mid] <= nums[mid + 1]) {
            return leftPairs + rightPairs;
        }

        int crossPairs = mergeAndCount(nums, left, mid, right, temp);
        return leftPairs + rightPairs + crossPairs;
    }

    private int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }

        int i = left;
        int j = mid + 1;

        int count = 0;
        for (int k = left; k <= right; k++) {

            if (i == mid + 1) {
                nums[k] = temp[j];
                j++;
            } else if (j == right + 1) {
                nums[k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                nums[k] = temp[i];
                i++;
            } else {
                nums[k] = temp[j];
                j++;
                count += (mid - i + 1);
            }
        }
        return count;
    }
}
