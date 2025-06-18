package com.ollierupprecht.dsa;

import com.ollierupprecht.dsa.algorithms.searching.*;
import com.ollierupprecht.dsa.algorithms.sorting.BubbleSort;
import com.ollierupprecht.dsa.algorithms.sorting.InsertionSort;
import com.ollierupprecht.dsa.algorithms.sorting.MergeSort;
import com.ollierupprecht.dsa.algorithms.utils.ArrayGenerator;

public class Main {
    public static void main(String[] args) {
        int[] array = ArrayGenerator.generateSorted(5);


        LinearSearch.display(array, 8);
    }
}
