package com.ollierupprecht.dsa.datastructures.linkedlists;

public class AdvNode {
    public int value;
    public AdvNode next;
    public AdvNode prev;

    public AdvNode(int value) {
        this.value = value;
        this.next = null;
        this.prev = null;
    }

    public AdvNode(int value, AdvNode next, AdvNode prev) {
        this.value = value;
        this.next = next;
        this.prev = prev;
    }
}
