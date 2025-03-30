package org.example.algorithms.linkedlist;

public class SwapInt {
    public static void main(String[] args) {
        int a = 5;
        int b = 6;
        System.out.println(a);
        System.out.println(b);

        // 通过临时变量直接交换
        int temp = a;
        a = b;
        b = temp;
        System.out.println(a);
        System.out.println(b);
    }
}
