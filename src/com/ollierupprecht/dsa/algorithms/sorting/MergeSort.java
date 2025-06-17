package com.ollierupprecht.dsa.algorithms.sorting;

public class MergeSort {
    public static void sort(int[] arr) {
        if (arr.length <= 1) return; // already sorted

        int mid = arr.length / 2;

        int[] right = new int[arr.length - mid];
        int[] left = new int[mid];

        int j = 0;
        for (int i = 0; i < arr.length; i++) { // split the array
            if (i < mid) left[i] = arr[i];
            else {
                right[j] = arr[i];
                j++;
            }
        }

        sort(left); // recurse on left until singleton
        sort(right); // recurse on right until singleton

        merge(arr, right, left); // pushed to stack until all arrays are singleton (return) and start to unwind the stack
    }

    public static void merge(int[] arr, int[] right, int[] left) {
        int i = 0; int j = 0; int k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        while (i < left.length) {
            arr[k++] = left[i++];
        }

        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }
}
