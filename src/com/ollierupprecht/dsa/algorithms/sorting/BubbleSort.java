package com.ollierupprecht.dsa.algorithms.sorting;

public class BubbleSort {
    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) { // subtracting i, stops us from having to sort previously sorted values
                if (arr[j] > arr[j+1]) { // swap elements if out of order
                    int tmp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }
}
