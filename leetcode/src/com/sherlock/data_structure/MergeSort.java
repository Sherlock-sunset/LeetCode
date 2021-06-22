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
}
