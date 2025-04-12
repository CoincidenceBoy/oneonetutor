package org.example.algorithms.tree;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
        this(-1, null);
    }

    ListNode(int x) {
        this(x, null);
    }

    ListNode(int x, ListNode next) {
        val = x;
        this.next = next;
    }
}

