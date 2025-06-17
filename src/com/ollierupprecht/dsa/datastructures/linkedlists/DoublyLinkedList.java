package com.ollierupprecht.dsa.datastructures.linkedlists;

public class DoublyLinkedList {
    public AdvNode head;
    public AdvNode tail;
    public int size;

    public DoublyLinkedList(int value) {
        this.head = new AdvNode(value);
        this.tail = head;
        this.size = 1;
    }

    public DoublyLinkedList(int[] array) {
        this.tail = new AdvNode(array[array.length - 1]);
        this.size = 1;

        load(array);
    }

    public void addFront(int value) {
        if (head == null) {
            head = new AdvNode(value, null, null);
            size++;
            return;
        }

        AdvNode old = head;
        head = new AdvNode(value, old, null);

        if (old.prev != null)  old.prev = head;

        size++;
    }

    public void addEnd(int value) {
        if (tail == null) {
            this.tail = new AdvNode(value, null, null);
            this.head = tail;
        } else {
            AdvNode oldTail = tail;
            tail = new AdvNode(value, null, oldTail);
            oldTail.next = tail;
            size++;
        }
    }

    public void load(int[] array) {
        for (int i = 0; i < array.length; i++) {
            addEnd(array[i]);
        }
    }

    public void print() {
        if (size == 1) System.out.println("{" + head.value + "}");

        AdvNode current = head;
        String out = "{";

        while (current != null) {
            if (current.next == null) out += current.value;
            else out += current.value + ",";
            current = current.next;
        }

        System.out.println(out + "}");
    }
}
