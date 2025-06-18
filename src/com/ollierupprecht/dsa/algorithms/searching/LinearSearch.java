package com.ollierupprecht.dsa.algorithms.searching;

public class LinearSearch {
    public static int search(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }

        return -1;
    }

    public static void display(int[] arr, int target) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            printHelper(sb, arr, i);
            System.out.println(target + " =! " + arr[i] + " Therefore we iterate to the next value");
            if (arr[i] == target) {
                System.out.println("Target hit");
                return;
            }
        }

        System.out.println("\nNo element in the array equals the target");
    }

    private static void printHelper(StringBuilder sb, int[] arr, int curr) {

        sb.append("\n{");
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) sb.append(", "); // add comma *before* element (except first)

            // Add markers
            if (i == curr) sb.append("(");

            sb.append(arr[i]);  // actual value

            if (i == curr) sb.append(")");
        }
        sb.append("}");

        System.out.println(sb);
        sb.setLength(0); // clear sb object for reuse
    }
}
