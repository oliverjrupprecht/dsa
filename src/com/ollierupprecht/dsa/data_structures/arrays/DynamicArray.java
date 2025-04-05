package com.ollierupprecht.dsa.data_structures.arrays;

public class DynamicArray {
    public int[] array;
    public int size;
    public int numElements;

    public DynamicArray() {
        this.array = new int[size];
        this.size = 0;
        this.numElements = 0;
    }

    public DynamicArray(int[] pArray) {
        this.size = Math.max(256, pArray.length);
        this.array = new int[size];
        this.numElements = 0;

        for (int i = 0; i < pArray.length; i++) {
            array[i] = pArray[i];
            numElements++;
        }
    }

    public void insert(int index, int value) {
        if (index >= size) {
            grow();
        }

        shiftUp(1, index);
        array[index] = value;
        numElements++;
    }

    public void delete(int index) {
        if (index <= size / 2) {
            shrink();
        }

        if (index > size - 1) return;

        shiftDown(1,index);
        numElements--;
    }

    public void print() {
        String out = "{";

        for (int i = 0; i < numElements; i++) {
            if (i == numElements - 1) {
                out += array[i];
            } else {
                out += array[i] + ", ";
            }
        }

        System.out.println(out + "}");
    }

    private void grow() {
        size *= 2;
        int[] temp = new int[size];

        for (int i = 0; i < size; i++) {
            temp[i] = array[i];
        }

        array = temp;
    }

    private void shrink() {
        size /= 2;
        int[] temp = new int[size];

        for (int i = 0; i < size; i++) {
            temp[i] = array[i];
        }

        array = temp;
    }

    private void shiftUp(int space, int target) {
        for (int i = numElements; i > target - 1; i--) {
            array[i + space] = array[i];
        }
    }

    private void shiftDown(int space, int target) {
        for (int i = target; i < numElements; i++) {
            array[i] = array[i + space];
        }
    }


}
