package com.ollierupprecht.dsa;

import com.ollierupprecht.dsa.algorithms.sorting.InsertionSort;
import com.ollierupprecht.dsa.algorithms.utils.ArrayGenerator;

public class Main {
    public static void main(String[] args) {
        int[] array = ArrayGenerator.generate(12, 20);

        InsertionSort.display(array);

    }
}
