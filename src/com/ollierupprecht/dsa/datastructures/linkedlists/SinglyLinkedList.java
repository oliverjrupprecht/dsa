package com.ollierupprecht.dsa.datastructures.linkedlists;

public class SinglyLinkedList {
    public Node head;
    public int size;

    public SinglyLinkedList(int value) {
        this.head = new Node(value);
        this.size = 1;
    }

    public void addFront(int value) {
        Node temp = head;
        head = new Node(value, temp);
        size++;
    }

    public void addEnd(int value) {
        Node current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = new Node(value, null);
        size++;
    }

    public void addAt(int value, int index) {
        if (index > size) {
            System.out.println("Out of bounds.");
            return;
        }

        Node current = head;
        Node previous = head;

        for (int i = 0; i < index; i++) {
            previous = current;
            current = current.next;
        }

        previous.next = new Node(value, current);
        size++;
    }

    public void delFront() {
        head = head.next;
        size--;
    }

    public void delLast() {
        if (head.next == null) {
            head = null;
        }

        Node current = head;

        while (current.next.next != null) {
            current = current.next;
        }

        current.next = null;
        size--;
    }

    public void delAt(int index) {
        if (index > size) {
            System.out.println("Out of bounds");
            return;
        }

        Node current = head;
        Node previous = head;

        for (int i = 0; i < index; i++) {
            previous = current;
            current = current.next;
        }

        previous.next = current.next;
        size--;
    }

    public void search(int target) {
        Node current = head;
        int counter = 0;

        while (current != null) {
            if (current.value == target) {
                System.out.println("Target is at index " + counter);
                return;
            }
            counter++;
            current = current.next;
        }
    }

    public void print() {
        Node current = head;
        String out = "{";

        while (current != null) {
            if (current.next == null) {
                out += current.value;
                break;
            }

            out += current.value + ",";
            current = current.next;
        }
        System.out.println(out + "}");
    }

    public void reverse() {
        if (head.next == null) return;

        Node previous = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        head = previous;
    }

}
