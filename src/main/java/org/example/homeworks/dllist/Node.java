package org.example.homeworks.dllist;

public class Node<T> {
    public T val;
    public Node<T> next;
    public Node<T> prev;

    public Node() {
        this.val = null;
        this.next = null;
        this.prev = null;
    }

    public Node(T val) {
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}
