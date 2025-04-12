package org.example.algorithms.tree;

public class CompleteBinaryTree {
    private int[] treeArray;
    private int size;
    private int capacity;

    // 构造函数，初始化二叉树
    public CompleteBinaryTree(int capacity) {
        this.capacity = capacity;
        this.treeArray = new int[capacity];
        this.size = 0;
    }

    // 插入节点
    public void insert(int value) {
        if (size >= capacity) {
            throw new IllegalStateException("Tree is full");
        }
        treeArray[size] = value;
        size++;
    }

    // 获取父节点值
    public int getParent(int index) {
        if (index <= 0 || index >= size) {
            throw new IllegalArgumentException("Invalid index");
        }
        return treeArray[(index - 1) / 2];
    }

    // 获取左子节点值
    public int getLeftChild(int index) {
        int left = 2 * index + 1;
        if (left >= size) {
            throw new IllegalArgumentException("No left child");
        }
        return treeArray[left];
    }

    // 获取右子节点值
    public int getRightChild(int index) {
        int right = 2 * index + 2;
        if (right >= size) {
            throw new IllegalArgumentException("No right child");
        }
        return treeArray[right];
    }

    // 层序遍历打印
    public void levelOrderTraversal() {
        for (int i = 0; i < size; i++) {
            System.out.print(treeArray[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CompleteBinaryTree tree = new CompleteBinaryTree(10);

        // 插入节点
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        tree.insert(6);
        tree.insert(7);

        // 打印树
        System.out.println("层序遍历:");
        tree.levelOrderTraversal();

        // 测试父子节点关系
        System.out.println("节点2的父节点: " + tree.getParent(1)); // 应该输出1
        System.out.println("节点1的左子节点: " + tree.getLeftChild(0)); // 应该输出2
        System.out.println("节点1的右子节点: " + tree.getRightChild(0)); // 应该输出3
    }
}
