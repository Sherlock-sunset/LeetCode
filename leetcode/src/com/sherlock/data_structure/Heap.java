package com.sherlock.data_structure;

import java.util.Arrays;

public class Heap { //大顶堆

    void build(int[] arr, int n) { //建堆 O(N)
        //找到第一个具有子节点堆
        int first = findParent(n - 1);
        for (int i = first; i >= 0; i--) {
            heapify(arr, n, i);
        }

    }

    public void sort(int[] arr, int n) { //o(NlogN),不稳定
        build(arr, n);  //建堆
        for (int i = n - 1; i >= 0; i--) {//
            swapValue(arr, i, 0);
            heapify(arr, i, 0);
        }
    }

    private void swapValue(int[] arr, int i, int j) {
        int buff = arr[i];
        arr[i] = arr[j];
        arr[j] = buff;
    }

    int findParent(int p) {
        return (p - 1) / 2;
    }

    void heapify(int[] arr, int n, int p) {//O(logN)
        int largest = p;
        int lson = p * 2 + 1;
        int rson = p * 2 + 2;

        if (lson < n && arr[largest] < arr[lson])
            largest = lson;
        if (rson < n && arr[largest] < arr[rson])
            largest = rson;

        if (largest != p) {
            swapValue(arr, largest, p);
            heapify(arr, n, largest);
        }
    }
}
