package org.example.demos.testpaper1;

public class PrintLeavesRightToLeft {
    static class Node {
        int data;
        Node left, right;

        Node(int value) {
            data = value;
            left = right = null;
        }
    }

    // 递归打印叶子节点（右子树优先）
    public static void printLeavesRightToLeft(Node node) {
        if (node == null) return;

        // 如果是叶子节点则打印
        if (node.left == null && node.right == null) {
            System.out.print(node.data + " ");
            return;
        }

        // 先递归右子树
        printLeavesRightToLeft(node.right);
        // 再递归左子树
        printLeavesRightToLeft(node.left);
    }

    public static void main(String[] args) {
        /* Tree A */
        Node treeA = new Node(1);
        treeA.left = new Node(2);
        treeA.right = new Node(3);
        treeA.left.left = new Node(4);
        treeA.left.right = new Node(5);
        treeA.right.right = new Node(6);
        treeA.left.right.left = new Node(7);

        /* Tree B */
        Node treeB = new Node(1);
        treeB.left = new Node(2);
        treeB.right = new Node(5);
        treeB.left.right = new Node(3);
        treeB.left.right.left = new Node(4);
        treeB.left.right.right = new Node(11);
        treeB.right.left = new Node(6);
        treeB.right.right = new Node(10);
        treeB.right.left.right = new Node(7);
        treeB.right.left.right.right = new Node(8);
        treeB.right.right.right = new Node(9);

        System.out.print("Tree A 叶子节点（右→左）: ");
        printLeavesRightToLeft(treeA);  // 输出: 7 5 6 4

        System.out.print("\nTree B 叶子节点（右→左）: ");
        printLeavesRightToLeft(treeB);  // 输出: 11 8 9 4
    }
}
