package org.example.demos.testpaper1;

import java.util.ArrayList;

class Node {
    int val;
    Node left, right;
    Node(int x) { val = x; }
}

public class TreeDeserializer {
    // 主方法（题目给出的模板）
    public Node deSerialise(ArrayList<String> list) {
        return deSerialiseRecursive(list);
    }

    // 递归核心方法
    private Node deSerialiseRecursive(ArrayList<String> list) {
        if (list.isEmpty()) {
            return null;
        }

        String val = list.remove(0);
        if (val.equals("$")) {
            return null;
        }

        Node node = new Node(Integer.parseInt(val));
        node.left = deSerialiseRecursive(list);
        node.right = deSerialiseRecursive(list);
        return node;
    }

    public static void main(String[] args) {
        //  上述示例进行反序列化
        ArrayList<String> list = new ArrayList<>();
        // ["2","4","$","$","1","7","10","$","$","$","5","$","$"]
        String str = "[\"2\",\"4\",\"$\",\"$\",\"1\",\"7\",\"10\",\"$\",\"$\",\"$\",\"5\",\"$\",\"$\"]";
        // ["1","2","4","$","$","8","7","$","$","$","3","$","6","$","$"]
        str = "[\"1\",\"2\",\"4\",\"$\",\"$\",\"8\",\"7\",\"$\",\"$\",\"$\",\"3\",\"$\",\"6\",\"$\",\"$\"]";
        str = str.replaceAll("[\\[\\]\"]", ""); // 去掉中括号和双引号
        String[] arr = str.split(",");
        for (String s : arr) {
            list.add(s);
        }
        TreeDeserializer deserializer = new TreeDeserializer();
        Node root = deserializer.deSerialise(list);
        // 给出root的前序遍历
        preOrderTraversal(root);

    }

    private static void preOrderTraversal(Node root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }
}