package org.example.algorithms.linkedlist;

public class SwapInt {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        System.out.println("(" + a + ", " + b + ")");

        // 通过临时变量直接交换
        int temp = a;
        a = b;
        b = temp;

        System.out.println("(" + a + ", " + b + ")");
    }
}
