package org.example.algorithms.linkedlist;

public class TestBase {
    public static void main(String[] args) {


        int i = 0;
//        // 只执行一次 初始化
//        // 条件过了 才可以 进入循环体
//        // 循环体结束后 执行 迭代后处理
        for (i = 0; i < 2; System.out.println("Hello, World!")) {
            i++;
        }


        for (i = 8; i < 10; ) {
            i++;
            System.out.println("Hello, World!");
        }


        for (i = 8; i < 10; i++) {
            System.out.println("Hello, World!");
        }

        for (int x = 8; x < 10; x++) {
            System.out.println("Hello, World!");

        }

        int j = 0;
        while (j < 3) {
            System.out.println("Hello, World!");
            j++;
        }

    }
}
