package com.ollierupprecht.dsa.algorithms.sorting;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MergeSort {
    private static int depth = 0;
    private static int[][] array = new int[256][256];
    private static int rowPointer = 0;

    public static void sort(int[] arr) {
        if (arr.length <= 1) return; // already sorted

        int mid = arr.length / 2;

        int[] right = new int[arr.length - mid];
        int[] left = new int[mid];

        int j = 0;
        for (int i = 0; i < arr.length; i++) { // split the array
            if (i < mid) left[i] = arr[i];
            else {
                right[j] = arr[i];
                j++;
            }
        }

        sort(left); // recurse on left until singleton
        sort(right); // recurse on right until singleton

        merge(arr, right, left); // pushed to stack until all arrays are singleton (return) and start to unwind the stack
    }

    public static void merge(int[] arr, int[] right, int[] left) {
        int i = 0; int j = 0; int k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        while (i < left.length) {
            arr[k++] = left[i++];
        }

        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }

    public static void display(int[] arr) {
        if (!isPowerOfTwo(arr.length)) throw new IllegalStateException("This display method has undefined behavior for non power of 2 " +
                " array sizes");
        printByLevel(displaySort(new MergeTreeNode(arr)));
    }

    private static void printByLevel(MergeTreeNode root) {
        if (root == null) return;

        Queue<MergeTreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                MergeTreeNode node = q.poll();
                printHelper(sb, node.array);

                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            System.out.println(sb);
        }
    }

    private static MergeTreeNode displaySort(MergeTreeNode node) {
        if (node.array.length <= 1) return new MergeTreeNode(node.array);

        int mid = node.array.length / 2;

        node.left = new MergeTreeNode(Arrays.copyOfRange(node.array, 0, mid));
        node.right = new MergeTreeNode(Arrays.copyOfRange(node.array, mid, node.array.length));

        displaySort(node.left);
        displaySort(node.right);

        mergeDisplay(node.array, node.right.array, node.left.array);

        return node;
    }

    private static void mergeDisplay(int[] arr, int[] right, int[] left) {
        int i = 0; int j = 0; int k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        while (i < left.length) {
            arr[k++] = left[i++];
        }

        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }

    private static void printHelper(StringBuilder sb, int[] arr) {
        sb.append(" {");
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) sb.append(", "); // add comma *before* element (except first)
            sb.append(arr[i]);  // actual value
        }
        sb.append("} ");
    }

    private static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
