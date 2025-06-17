package com.ollierupprecht.dsa.algorithms.searching;

import com.ollierupprecht.dsa.algorithms.sorting.BubbleSort;

public class BinarySearch {
    // array must be sorted for this method to work
    public static int search(int[] arr, int target) {

        int front = 0;
        int end = arr.length;
        int mid;

        while (front < end) { // if front == end, then the target hasn't been found
            mid = (end + front) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) { // if the element at middle is less than the target, then  target is in right
                front = mid + 1; // move front to the mid + 1 (since we know mid isn't target)
            } else { // if the element at middle is greater than the target, target is in left
                end = mid; // move end to the middle
            }
        }

        return -1;
    }

    public static int searchUnsorted(int[] arr, int target) {
        BubbleSort.sort(arr);
        return search(arr, target);
    }
}
