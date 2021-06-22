package com.sherlock.data_structure;

public class QuickSort {
    public void sort(int[] arr) {

        qucickSort(arr, 0, arr.length - 1);

    }

    private void qucickSort(int[] arr, int left, int right) {
        if (left >= right) return;
        int pivot = parttion(arr, left, right);
        qucickSort(arr, left, pivot);
        qucickSort(arr, pivot + 1, right);
    }

    private int parttion(int[] arr, int left, int right) {
        int pivot = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= pivot) right--;
            if (left < right) swapValue(arr, left++, right);
            while (left < right && arr[left] <= pivot) left++;
            if (left < right) swapValue(arr, left, right--);
        }
        arr[left] = pivot;
        return left;
    }

    private void swapValue(int[] arr, int value1, int value2) {
        if (value1 == value2) return;
        int temp = arr[value1];
        arr[value1] = arr[value2];
        arr[value2] = temp;
    }
}
