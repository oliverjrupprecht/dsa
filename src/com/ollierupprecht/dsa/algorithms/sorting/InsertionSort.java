package com.ollierupprecht.dsa.algorithms.sorting;

public class InsertionSort {
    /*
    The insertion sort algorithm iterates up the array, selecting a new key each iteration. This key is compared
    with each element in the sorted portion of the array, if the element is greater than it is shifted up an index.
    Once an element is less than the key, the key is inserted into the array.

    I low-key think that it should be called shift sort because I believe it better describes the algorithm behavior.

     Worst case time performance is O(n^2), best case is O(n). It performs better than bubble sort in the real world,
     because its more performant on nearly sorted arrays.
     */
    public static void sort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int key = arr[i]; // element to be inserted
            int j = i - 1; // j init as the largest sorted index

            // while sorted element is greater than the key, shift it up
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            // once while loop is broken the key can be inserted
            arr[j + 1] = key;
        }
    }
}
