package org.example.algorithms.linkedlist;

public class Node<T> {
    T data;          // 节点存储的数据
    Node<T> next;    // 指向下一个节点的引用

    public Node() {
        this(null, null);
    }

    public Node(T data) {
        this(data, null);
    }

    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }
}
