package org.example.algorithms;

import java.util.Arrays;

public class MergeSort {

    // 主方法，负责调用合并排序
    public static void mergeSort(int[] A, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;  // 计算中间位置
            mergeSort(A, low, mid);  // 递归排序左半部分
            mergeSort(A, mid + 1, high);  // 递归排序右半部分
            merge(A, low, mid, high);  // 合并两个已排序的部分
        }
//        return;

//        if (low >= high) { //直接取反最简单,但是如果你非常自信 直接写 low == high
//            return;
//        }
//        int mid = (low + high) / 2;  // 计算中间位置
//        mergeSort(A, low, mid);  // 递归排序左半部分
//        mergeSort(A, mid + 1, high);  // 递归排序右半部分
//        merge(A, low, mid, high);  // 合并两个已排序的部分
    }

    // 合并操作：将A[low..mid]和A[mid+1..high]合并为一个有序数组
    public static void merge(int[] A, int low, int mid, int high) {
        int[] B = new int[high - low + 1];  // 临时数组B，存储排序结果
        int i = low, j = mid + 1, k = 0;

        // 将A[low..mid]和A[mid+1..high]的元素复制到B中
        while (i <= mid && j <= high) {
            if (A[i] <= A[j]) {
                B[k++] = A[i++];
            } else {
                B[k++] = A[j++];
            }
        }

        // 将左半部分剩余的元素复制到B
        while (i <= mid) {
            B[k++] = A[i++];
        }

        // 将右半部分剩余的元素复制到B
        while (j <= high) {
            B[k++] = A[j++];
        }

        // 使用循环将排序结果从B复制回A
        for (int m = 0; m < B.length; m++) {
            A[low + m] = B[m];
        }
    }


    // 主函数
    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 5, 6};  // 测试数组
        System.out.println("Original Array:");
        System.out.println(Arrays.toString(arr));  // 使用Arrays.toString打印数组

        // 调用归并排序
        mergeSort(arr, 0, arr.length - 1);

        System.out.println("Sorted Array:");
        System.out.println(Arrays.toString(arr));  // 使用Arrays.toString打印排序后的数组
    }
}

