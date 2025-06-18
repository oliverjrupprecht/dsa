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
        System.out.println("{a, b, ..., c} -> array" +
                "\n[a, b] - > items being compared" +
                "\n| -> sorted portion of the array");

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) { // subtracting i, stops us from having to sort previously sorted values
                printHelper(sb, arr, j, arr.length - i);
                if (arr[j] > arr[j+1]) { // swap elements if out of order
                    System.out.println(arr[j] + " > " + arr[j + 1] + " therefore SWAP elements...");
                    int tmp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = tmp;
                } else if (arr[j] == arr[j+1]) System.out.println(arr[j] + " == " + arr[j + 1] + " therefore leave elements...");
                else System.out.println(arr[j] + " < " + arr[j + 1] + " therefore leave elements...");
            }
        }

        printHelper(sb, arr);
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

        System.out.println(sb);
        sb.setLength(0); // clear sb object for reuse

    }

    private static void printHelper(StringBuilder sb, int[] arr) {

        sb.append("\nSorted Array: {");
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) sb.append(", "); // add comma *before* element (except first)
            sb.append(arr[i]);  // actual value
        }
        sb.append("}");

        System.out.println(sb);
        sb.setLength(0); // clear sb object for reuse
    }
}
