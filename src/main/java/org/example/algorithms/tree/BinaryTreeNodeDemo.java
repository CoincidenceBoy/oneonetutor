package org.example.algorithms.tree;

public class BinaryTreeNodeDemo {
    public static void main(String[] args) {
        // https://pythontutor.com/render.html#mode=display
        BinaryTreeNode node1 = new BinaryTreeNode(1);
        BinaryTreeNode node2 = new BinaryTreeNode(2);
        BinaryTreeNode node3 = new BinaryTreeNode(3);

        node1.left = node2;
        node1.right = node3;

        System.out.println("Binary Tree Node:");
        System.out.println("Root: " + node1.val);
        System.out.println("Left Child: " + node1.left.val);
        System.out.println("Right Child: " + node1.right.val);
    }
}
