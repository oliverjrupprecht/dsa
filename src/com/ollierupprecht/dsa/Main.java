package com.ollierupprecht.dsa;

import com.ollierupprecht.dsa.algorithms.searching.*;
import com.ollierupprecht.dsa.algorithms.sorting.BubbleSort;
import com.ollierupprecht.dsa.algorithms.sorting.InsertionSort;

public class Main {
    public static void main(String[] args) {
        int[] arr = {9,8,7,6,5};

        InsertionSort.sort(arr);

        for (int i: arr) {
            System.out.println(i);
        }
    }
}
