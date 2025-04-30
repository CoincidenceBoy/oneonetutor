package org.example.algorithms.hash;

import java.util.Arrays;

public class Lab8_2_new {
    /**
     * 对任意值域的整数数组执行计数排序，时间 O(n + M)，空间 O(M)。
     * @param arr 待排序的整数数组
     */
    public static void countSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;

        // 1. 找到最小值和最大值
        int minVal = arr[0], maxVal = arr[0];
        for (int x : arr) {
            if (x < minVal) minVal = x;
            else if (x > maxVal) maxVal = x;
        }
        int range = maxVal - minVal + 1;  // 键值范围 M

        // 2. 申请计数数组并统计频次
        int[] count = new int[range];
        for (int x : arr) {
            count[x - minVal]++;
        }

        // 3. 按频次将元素写回原数组
        int idx = 0;
        for (int offset = 0; offset < range; offset++) {
            while (count[offset]-- > 0) {
                arr[idx++] = offset + minVal;
            }
        }
    }

    // ---------- 测试 main 方法 ----------
    public static void main(String[] args) {
        int[] arr1 = {4, 2, 2, 8, 3, 3, 1};
        System.out.println("原始数组: " + Arrays.toString(arr1));
        countSort(arr1);
        System.out.println("计数排序后: " + Arrays.toString(arr1));
        // 输出: [1, 2, 2, 3, 3, 4, 8]

        // 测试负数和更大范围
        int[] arr2 = { -5, 0, 5, -2, 3, -5, 2, 0 };
        System.out.println("\n原始数组: " + Arrays.toString(arr2));
        countSort(arr2);
        System.out.println("计数排序后: " + Arrays.toString(arr2));
        // 输出: [-5, -5, -2, 0, 0, 2, 3, 5]
    }
}
