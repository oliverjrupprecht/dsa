package com.ollierupprecht.dsa.algorithms.utils;

import com.ollierupprecht.dsa.algorithms.sorting.InsertionSort;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class ArrayGenerator {
    public static int[] generate(int length) {
        int[] arr = new int[length];
        int i = 0;

        Random r = new Random();
        while (i < arr.length) {
            arr[i] = r.nextInt();
            i++;
        }

        return arr;
    }

    public static int[] generateSorted(int length) {
        int[] arr = new int[length];
        int i = 0;

        Random r = new Random();
        while (i < arr.length) {
            arr[i] = r.nextInt(90);
            i++;
        }

        return InsertionSort.sort(arr);
    }

    public static int[] generateSorted(int length, int bound) {
        int[] arr = new int[length];
        int i = 0;

        Random r = new Random();
        while (i < arr.length) {
            arr[i] = r.nextInt(bound);
            i++;
        }

        return InsertionSort.sort(arr);
    }

    public static int[] generate(int length, int bound) {
        if (length > bound) throw new IllegalArgumentException("Cannot generate more unique values than the bound.");
        HashSet<Object> seen = new HashSet<>();
        Random r = new Random();
        int[] arr = new int[length];
        int i = 0;

        while (seen.size() < length) {
            int tmp = r.nextInt(bound);
            if (seen.add(tmp)) {
                arr[i++] = tmp;
            }
        }

        return arr;
    }
}