package org.example.algorithms.tree;

public class BinaryTreeNode {
    int val;
    BinaryTreeNode left;
    BinaryTreeNode right;

    BinaryTreeNode() {
        this(-1, null, null);
    }

    BinaryTreeNode(int x) {
        this(x, null, null);
    }

    BinaryTreeNode(int x, BinaryTreeNode left, BinaryTreeNode right) {
        val = x;
        this.left = left;
        this.right = right;
    }
}
