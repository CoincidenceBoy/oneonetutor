package org.example.algorithms.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreeUtils {
    /**
            * 先序遍历（递归实现，直接打印）
            * @param root 二叉树根节点
     */
    public static void preorderTraversal(BinaryTreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");  // 访问根节点
        preorderTraversal(root.left);      // 遍历左子树
        preorderTraversal(root.right);     // 遍历右子树
    }

    /**
            * 中序遍历（递归实现，直接打印）
            * @param root 二叉树根节点
     */
    public static void inorderTraversal(BinaryTreeNode root) {
        if (root == null) return;
        inorderTraversal(root.left);       // 遍历左子树
        System.out.print(root.val + " ");  // 访问根节点
        inorderTraversal(root.right);      // 遍历右子树
    }

    /**
            * 后序遍历（递归实现，直接打印）
            * @param root 二叉树根节点
     */
    public static void postorderTraversal(BinaryTreeNode root) {
        if (root == null) return;
        postorderTraversal(root.left);     // 遍历左子树
        postorderTraversal(root.right);    // 遍历右子树
        System.out.print(root.val + " ");  // 访问根节点
    }

    /**
            * 先序遍历（迭代实现，直接打印）
            */
    public static void preorderIterative(BinaryTreeNode root) {
        if (root == null) return;

        Stack<BinaryTreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            BinaryTreeNode node = stack.pop();
            System.out.print(node.val + " ");
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
    }

    /**
            * 中序遍历（迭代实现，直接打印）
            */
    public static void inorderIterative(BinaryTreeNode root) {
        Stack<BinaryTreeNode> stack = new Stack<>();
        BinaryTreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            System.out.print(curr.val + " ");
            curr = curr.right;
        }
    }

    /**
            * 后序遍历（迭代实现，直接打印）
            */
    public static void postorderIterative(BinaryTreeNode root) {
        if (root == null) return;

        Stack<BinaryTreeNode> stack = new Stack<>();
        stack.push(root);
        BinaryTreeNode prev = null;

        while (!stack.isEmpty()) {
            BinaryTreeNode curr = stack.peek();
            if ((curr.left == null && curr.right == null) ||
                    (prev != null && (prev == curr.right || (prev == curr.left && curr.right == null)))) {
                System.out.print(curr.val + " ");
                stack.pop();
                prev = curr;
            } else {
                if (curr.right != null) stack.push(curr.right);
                if (curr.left != null) stack.push(curr.left);
            }
        }
    }

    /**
            * 构建示例二叉树
             *       1
             *      / \
             *     2   3
             *    / \
             *   4   5
             */
    public static BinaryTreeNode buildSampleTree() {
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        BinaryTreeNode node2 = new BinaryTreeNode(2, node4, node5);
        BinaryTreeNode node3 = new BinaryTreeNode(3);
        return new BinaryTreeNode(1, node2, node3);
    }

    public static void main(String[] args) {
        BinaryTreeNode root = buildSampleTree();

        System.out.println("递归实现:");
        System.out.print("先序遍历: "); preorderTraversal(root); System.out.println();
        System.out.print("中序遍历: "); inorderTraversal(root); System.out.println();
        System.out.print("后序遍历: "); postorderTraversal(root); System.out.println();

        System.out.println("\n迭代实现:");
        System.out.print("先序遍历: "); preorderIterative(root); System.out.println();
        System.out.print("中序遍历: "); inorderIterative(root); System.out.println();
        System.out.print("后序遍历: "); postorderIterative(root); System.out.println();
    }
}