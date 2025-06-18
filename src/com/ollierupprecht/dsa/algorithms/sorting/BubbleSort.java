package com.ollierupprecht.dsa.algorithms.sorting;

public class BubbleSort {
    public static int[] sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) { // subtracting i, stops us from having to sort previously sorted values
                if (arr[j] > arr[j+1]) { // swap elements if out of order
                    int tmp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        return arr;
    }

    public static int[] display(int[] arr) {
        int j = 0;
        StringBuilder sb = new StringBuilder();
        int bubble;

        for (int i = 0; i < arr.length; i++) {
            printHelper(sb, arr, bubble, arr.length - 1 - j);
            for (; j < arr.length - 1 - i; j++) { // subtracting i, stops us from having to sort previously sorted values

                if (arr[j] > arr[j+1]) { // swap elements if out of order
                    int tmp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = tmp;
                    bubble = j;
                }
            }
        }
        return arr;
    }

    private static void printHelper(StringBuilder sb, int[] arr, int bubble, int sorted) {

        sb.append("\n{");
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) sb.append(", "); // add comma *before* element (except first)

            // Add markers
            if (i == bubble) sb.append("(");

            sb.append(arr[i]);  // actual value

            if (i == bubble) sb.append(")");
        }
        sb.append("}");

        System.out.println(sb);
        sb.setLength(0); // clear sb object for reuse
    }
}
