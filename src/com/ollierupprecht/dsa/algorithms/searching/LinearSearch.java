package com.ollierupprecht.dsa.algorithms.searching;

public class LinearSearch {
    public static int search(int[] array, int numElements, int target) {
        for (int i = 0; i < numElements; i++) {
            if (array[i] == target) return i;
        }

        return -1;
    }
}
