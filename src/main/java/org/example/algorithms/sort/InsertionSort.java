package org.example.algorithms.sort;

import java.util.Arrays;

public class InsertionSort {
    public static void insertSort(int[] A, int n) {
        int i, j, temp;

        // 从第二个元素开始，因为第一个元素认为已经排序好了
        for (i = 1; i < n; i++) {
            // 如果当前元素小于前一个元素，则需要将其插入前面的有序数组中
            if (A[i] < A[i - 1]) {
                temp = A[i];  // 用 temp 保存当前元素
                // 将所有大于 temp 的元素向右移动
                for (j = i - 1; j >= 0 && A[j] > temp; --j) {
                    A[j + 1] = A[j];  // 移动元素
                }
                A[j + 1] = temp;  // 将 temp 插入到正确的位置
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {5, 2, 9, 1, 5, 6};
        System.out.println(Arrays.toString(array));
        insertSort(array, array.length);
        System.out.println(Arrays.toString(array));
    }
}

