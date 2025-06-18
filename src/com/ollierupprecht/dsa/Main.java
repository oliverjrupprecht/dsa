package com.ollierupprecht.dsa;

import com.ollierupprecht.dsa.algorithms.searching.*;
import com.ollierupprecht.dsa.algorithms.sorting.BubbleSort;
import com.ollierupprecht.dsa.algorithms.utils.ArrayGenerator;

public class Main {
    public static void main(String[] args) {
        int[] array = ArrayGenerator.generate(5, 10);

        int[] arr = {1,2,3,4};

        BubbleSort.display(array);

    }
}
