package org.example.algorithms.sort;

public class BubbleSort {
    // 交换数组中的两个元素
    public static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    // 冒泡排序
    public static void bubbleSort(int[] A) {
        int n = A.length;
        for (int i = 0; i < n - 1; i++) {
            boolean flag = false; // 表示本趟冒泡是否发生交换的标志
            for (int j = n - 1; j > i; j--) { // 一趟冒泡过程
                if (A[j - 1] > A[j]) { // 若为逆序
                    swap(A, j - 1, j); // 交换
                    flag = true;
                }
            }
            if (!flag) {
                return; // 本趟遍历后没有发生交换，说明表已经有序
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Original array:");
        printArray(arr);

        bubbleSort(arr);

        System.out.println("\nSorted array:");
        printArray(arr);
    }

    // 打印数组
    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}

