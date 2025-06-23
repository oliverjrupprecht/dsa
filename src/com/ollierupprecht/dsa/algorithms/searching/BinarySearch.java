package com.ollierupprecht.dsa.algorithms.searching;

import com.ollierupprecht.dsa.algorithms.sorting.InsertionSort;

public class BinarySearch {
    /*
     The array must be sorted for this method to work.
     Finds the middle index of the array and checks for equality, if equal returns mid. Otherwise,
     it iterates on the left or right partition of the array. If it doesn't return within the while loop
     the target isn't in the array.

     best case is O(1), worst case is O(log n) and the average is O(log n).
     */

    public static int search(int[] arr, int target) {

        int front = 0;
        int end = arr.length;
        int mid;

        while (front < end) {
            mid = (end + front) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) { // if the element at middle is less than the target, then  target is in right
                front = mid + 1; // move front to the mid + 1 (since we know mid isn't target)
            } else { // if the element at middle is greater than the target, target is in left
                end = mid; // move end to the middle
            }
        }

        return -1;
    }

    public static int searchUnsorted(int[] arr, int target) {
        InsertionSort.sort(arr);
        return search(arr, target);
    }

    public static void display(int[] arr, int target) {
        int front = 0;
        int end = arr.length;
        int mid;
        StringBuilder sb = new StringBuilder();

        while (front < end) {

            mid = (end + front) / 2;
            printHelper(sb, arr, front, end, mid);

            if (arr[mid] == target) {
                System.out.println("Target hit");
                return;
            } else if (arr[mid] < target) { // if the element at middle is less than the target, then  target is in right
                front = mid + 1; // move front to the mid + 1 (since we know mid isn't target)
                System.out.println(arr[mid] + " < " + target + " therefore target must be in the RIGHT sub-array.");
            } else { // if the element at middle is greater than the target, target is in left
                end = mid; // move end to the middle
                System.out.println(arr[mid] + " > " + target + " therefore target must be in the LEFT sub-array");
            }
        }
        System.out.println("\nNo element in the array is equal to the target");
    }

    private static void printHelper(StringBuilder sb, int[] arr, int front, int end, int mid) {

        sb.append("\n{");
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) sb.append(", "); // add comma *before* element (except first)

            // Add markers
            if (i == front) sb.append("|");
            if (i == mid) sb.append("(");

            sb.append(arr[i]);  // actual value

            if (i == mid) sb.append(")");
            if (i == end - 1) sb.append("|");
        }
        sb.append("}");

        System.out.println(sb);
        sb.setLength(0); // clear sb object for reuse
    }
}
