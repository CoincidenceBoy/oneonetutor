package org.example.algorithms.linkedlist;

import java.util.Scanner;

public class test0402 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int i = sc.nextInt();
        int j = sc.nextInt();

        for (int x = 1; x <= n; x++) {
            System.out.print("(" + i + "," + x + ")");
        }
        System.out.println();

        for (int y = 1; y <= n; y++) {
            System.out.print("(" + y + "," + j + ")");
        }

    }
}
