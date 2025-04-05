package com.ollierupprecht.dsa;

import com.ollierupprecht.dsa.data_structures.arrays.DynamicArray;

public class Main {
    public static void main(String[] args) {
        int[] pArray = {1, 2, 3, 4, 5, 6};
        DynamicArray array = new DynamicArray(pArray);

        array.print();
        System.out.println(array.size);

        array.delete(2);
        array.print();

        array.insert(2, 69);
        array.print();
    }
}
