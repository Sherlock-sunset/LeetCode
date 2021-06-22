package com.sherlock.data_structure;

public class RainbowSort {
    public void rainbowSort(int[] arr, int k) {
        rainbowSort(arr, 0, arr.length - 1, 1, k);
    }

    public void rainbowSort(int[] arr, int start, int end, int from, int to) {
        if (from == to) return;
        //区别在于partition的判定条件变为了中间大小的元素而不是中间位置的元素
        int mid = (from + to) / 2;
        int left = start, right = end;
        while (left <= right) {
            //因此等号的取值可以只去一边也不会有影响
            while (left <= right && arr[left] <= mid) {
                left++;
            }
            while (left <= right && arr[right] > mid) {
                right--;
            }
            if (left <= right) {
                swapValue(arr,left,right);
                left++;
                right--;
            }
        }
        rainbowSort(arr, start, right, from, mid);
        rainbowSort(arr, left, end, mid + 1, to);

    }

    private void swapValue(int[] arr, int value1, int value2) {
        if (value1 == value2) return;
        int temp = arr[value1];
        arr[value1] = arr[value2];
        arr[value2] = temp;
    }
}
