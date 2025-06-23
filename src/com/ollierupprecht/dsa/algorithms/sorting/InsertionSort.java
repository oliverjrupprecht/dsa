package com.ollierupprecht.dsa.algorithms.sorting;

public class InsertionSort {
    /*
    The insertion sort algorithm iterates up the array, selecting a new key each iteration. This key is compared
    with each element in the sorted portion of the array, if the element is greater than it is shifted up an index.
    Once an element is less than the key, the key is inserted into the array.

    I low-key think that it should be called shift sort because I believe it better describes the algorithm behavior.

     Worst case time performance is O(n^2), best case is O(n). It performs better than bubble sort in the real world,
     because its more performant on nearly sorted arrays.
     */
    public static int[] sort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int key = arr[i]; // element to be inserted
            int j = i - 1; // j init as the largest sorted index

            // while sorted element is greater than the key, shift it up
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            // once while loop is broken the key can be inserted
            arr[j + 1] = key;
        }
        return arr;
    }

    public static void display(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < arr.length; i++) {
            sb.append("\n\nIteration: ").append(i).append(", ");
            int key = arr[i]; // element to be inserted
            int j = i - 1; // j init as the largest sorted index
            int k = j;

            // while sorted element is greater than the key, shift it up
            sb.append("Key: ").append(key);
            while (j >= 0 && arr[j] > key) {
                printHelper(sb, arr, j, i, k);

                sb.append(" -> (").append("Key").append(" < ").append(arr[j]).append("), so we shift the element up.");
                arr[j + 1] = arr[j];
                j--;
            }

            // once while loop is broken the key can be inserted
            printHelper(sb, arr, j, i, k);
            if (j >= 0) sb.append(" -> (").append("Key").append(" > ").append(arr[j]).append("), so we insert the key in-front of the current pointer.\n");
            else sb.append(" -> Pointer has reached the end of array so we insert the key at the beginning of the array.\n");
            arr[j + 1] = key;
            if (i < arr.length - 1) {
                sb.append("\nPartially sorted array: ");
                printHelper(sb, arr, k+1);
            }
        }

        sb.append("\n\nSorted array: ");
        printHelper(sb, arr, -1);
        System.out.println(sb);
    }

    private static void printHelper(StringBuilder sb, int[] arr, int curr) {

        sb.append("{");
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) sb.append(", "); // add comma *before* element (except first)

            sb.append(arr[i]);  // actual value
            if (i == curr && curr != -1) sb.append("|");

        }
        sb.append("}");
    }

    private static void printHelper(StringBuilder sb, int[] arr, int curr, int key, int sortedPartition) {

        sb.append("\n{");
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) sb.append(", "); // add comma *before* element (except first)

            if (i == curr) sb.append("<");
            if (i == key) sb.append("(");

            sb.append(arr[i]);  // actual value

            if (i == curr) sb.append(">");
            if (i == sortedPartition) sb.append("|");
            if (i == key) sb.append(")");

        }
        sb.append("}");
    }
}
