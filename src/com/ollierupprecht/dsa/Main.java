package com.ollierupprecht.dsa;

import com.ollierupprecht.dsa.algorithms.searching.BinarySearch;
import com.ollierupprecht.dsa.algorithms.searching.LinearSearch;
import com.ollierupprecht.dsa.algorithms.sorting.BubbleSort;
import com.ollierupprecht.dsa.algorithms.sorting.InsertionSort;
import com.ollierupprecht.dsa.algorithms.sorting.MergeSort;
import com.ollierupprecht.dsa.algorithms.utils.ArrayGenerator;

public class Main {
    public static void main(String[] args) {
        int[] array = ArrayGenerator.generate(15, 20);

        // Sorting algorithms
        //InsertionSort.display(array);
        //BubbleSort.display(array);
        MergeSort.display(array);

        // Searching algorithms
        //LinearSearch.display(array, 1);
        //BinarySearch.display(array, 1); // ensure the array being passed is sorted
    }
}
