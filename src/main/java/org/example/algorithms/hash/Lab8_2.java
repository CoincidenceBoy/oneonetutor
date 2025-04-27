package org.example.algorithms.hash;

import java.util.*;

public class Lab8_2 {
    /**
     * 对最多含 K 个不同值的数组排序（使用哈希表）
     * @param arr 输入数组
     */
    public static void countSort(int[] arr) {
        if (arr == null || arr.length == 0) return;

        // 1. 统计频率
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : arr) {
//            int count = freq.getOrDefault(num, 0);
            int count;
            if (freq.containsKey(num)) {
                count = freq.get(num);
            } else {
                count = 0;
            }
            freq.put(num, count + 1);
        }

        // 2. 提取并排序键
        List<Integer> sortedKeys = new ArrayList<>(freq.keySet()); // set是不能排序的,转成数组 [4,8,2,3,1]
        Collections.sort(sortedKeys); // [1,2,3,4,8]

        // 3.加上频率填充数组[1,2,2,3,3,4,8]
        int index = 0;
        for (int num : sortedKeys) {
            int cnt = freq.get(num);
            for (int i = 0; i < cnt; i++) {
                arr[index++] = num;
            }
        }
    }

    public static void main(String[] args) {
        // 测试 countSort
        int[] arr2 = {4, 2, 2, 8, 3, 3, 1};
        countSort(arr2);
        System.out.println("countSort 结果: " + Arrays.toString(arr2));
        // 输出: [1, 2, 2, 3, 3, 4, 8]
    }
}