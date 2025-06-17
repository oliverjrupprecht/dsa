package com.ollierupprecht.dsa.algorithms.sorting;

public class InsertionSort {
    public static void sort(int[] arr) {
        // I low-key think that it should be called shift sort because it shifts up numbers greater than the key until it can insert
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i]; // current element being inserted
            int partition = i - 1; // index of sorted partition

            // shift along every element that is greater than the key
            while (partition >= 0 && arr[partition] > key) {
                arr[partition + 1] = arr[partition];
                partition--;
            }

            arr[partition + 1] = key; // insert the key into the array at correct position
        }
    }
}
