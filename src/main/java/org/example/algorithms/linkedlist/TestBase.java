package org.example.algorithms.linkedlist;

import javafx.beans.binding.When;

public class TestBase {
    public static void main(String[] args) {


        int i = 0;
//        // 只执行一次 初始化
//        // 条件过了 才可以 进入循环体
//        // 循环体结束后 执行 迭代后处理
//        for (i = 0; i < 2; System.out.println("Hello, World!")) {
//            i++;
//        }

        while (i<2) {
            i++;
            System.out.println("Hello, World");
        }




//
//        for (i = 8; i < 10; ) {
//            i++;
//            System.out.println("Hello, World!");
//        }


        while (i<10) {
            i++;
            System.out.println("Hello, World");
        }


//
//        for (i = 8; i < 10; i++) {
//            System.out.println("Hello, World!");
//        }


        while (i<10) {
            System.out.println("Hello, World");
            i++;
        }

//        for (int i = 8; i < 10; System.out.println("Hello, World!"), i++)
//        {
//
//        }

        while (i<10) {
            System.out.println("Hello, World");
            i++;
        }

//        int j = 0;
//        while (j < 3) {
//            System.out.println("Hello, World!");
//            j++;
//        }



    }
}
