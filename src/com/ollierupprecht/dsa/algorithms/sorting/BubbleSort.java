package com.ollierupprecht.dsa.algorithms.sorting;

public class BubbleSort {
    /*
    The bubble sort algorithm iterates over the array comparing neighboring elements and swapping if
    the leftmost is greater than the other.
    The outer loop ensures already sorted elements are not compared again.
    The best case is O(n^2), unless a flag is used (like our implementation) in which case it is O(n).
    The worst case is O(n^2) and the average is O(n^2).
     */
    public static int[] sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean swapped = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {// subtracting i, stops us from having to compare previously sorted values
                if (arr[j] > arr[j+1]) { // swap elements if out of order
                    int tmp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = tmp;
                    swapped = true;
                }

                if (!swapped) return arr; // returns early if no swaps made
            }
        }
        return arr;
    }

    public static void display(int[] arr) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            if (i < arr.length - 1) sb.append("\n\nIteration ").append(i + 1).append(": ");
            for (int j = 0; j < arr.length - 1 - i; j++) { // subtracting i, stops us from having to sort previously sorted values
                printHelper(sb, arr, j, arr.length - i);
                if (arr[j] > arr[j+1]) { // swap elements if out of order
                    sb.append(" -> (").append(arr[j]).append(" > ").append(arr[j + 1]).append("), therefore SWAP elements.");
                    int tmp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = tmp;
                } else if (arr[j] == arr[j+1]) sb.append(" -> (").append(arr[j]).append(" == ").append(arr[j + 1]).append("), therefore leave elements.");
                else sb.append(" -> (").append(arr[j]).append(" < ").append(arr[j + 1]).append("), therefore leave elements.");
            }
        }

        sb.append("\n\nSorted array: ");
        printHelper(sb, arr);
        System.out.println(sb);
    }

    private static void printHelper(StringBuilder sb, int[] arr, int j, int k) {
        sb.append("\n{");
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) sb.append(", "); // add comma *before* element (except first)

            // Add markers
            if (i == j) sb.append("[");
            if (i == k) sb.append("|"); // sorted portion

            sb.append(arr[i]);  // actual value

            if (i == j + 1) sb.append("]");
        }
        sb.append("}");
    }

    private static void printHelper(StringBuilder sb, int[] arr) {
        sb.append("{");
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) sb.append(", "); // add comma *before* element (except first)
            sb.append(arr[i]);  // actual value
        }
        sb.append("}");
    }
}
