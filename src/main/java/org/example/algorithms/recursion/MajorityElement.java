package org.example.algorithms.recursion;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    // 最笨的解法：暴力方法
    public static int naiveSolution1(int[] arr) {
        int n = arr.length;

        // 对每个元素进行计数
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }

            // 如果出现次数超过 n/2，返回该元素
            if (count > n / 2) {
                return arr[i];
            }
        }

        // 如果没有找到，返回 -1
        return -1;
    }

    // 朴素解法：计算每个元素出现的次数  使用 hash表空间换时间 最终的时间复杂度也是 O(n)
    public static int naiveSolution2(int[] arr) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : arr) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // 查找出现次数超过 n/2 次的元素
        int n = arr.length;
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > n / 2) {
                return entry.getKey();
            }
        }

        // 如果没有找到，返回 -1
        return -1;
    }

    // 分治法：递归解决多数元素问题
    public static int divideAndConquerSolution(int[] arr) {
        return findMajorityElement(arr, 0, arr.length - 1);
    }

    // 分治法的递归函数
    private static int findMajorityElement(int[] arr, int left, int right) {
        if (left == right) {
            return arr[left];  // 基本情况：数组只有一个元素
        }

        // 递归分成两部分
        int mid = (left + right) / 2;
        int leftMajority = findMajorityElement(arr, left, mid);
        int rightMajority = findMajorityElement(arr, mid + 1, right);

        // 处理 -1 情况，如果一侧返回 -1，则多数元素只能来自另一侧
        if (leftMajority == -1) return rightMajority;
        if (rightMajority == -1) return leftMajority;

        // 如果两个部分的多数元素相同，直接返回
        if (leftMajority == rightMajority) {
            return leftMajority;
        }

        // 否则，统计两个候选元素在整个区间的出现次数
        int leftCount = countInRange(arr, left, right, leftMajority);
        int rightCount = countInRange(arr, left, right, rightMajority);

        // 计算当前数组段的大小
        int n = right - left + 1;

        // 返回真正的多数元素，若都不超过 n/2，则返回 -1
        if (leftCount > n / 2) return leftMajority;
        if (rightCount > n / 2) return rightMajority;
        return -1;
    }


    // 计算某个元素在区间 [left, right] 中出现的次数
    private static int countInRange(int[] arr, int left, int right, int element) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            if (arr[i] == element) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 2, 2, 5, 4, 2}; // 示例数组

        // 使用朴素解法
        int resultNaive = naiveSolution1(arr);
//        int resultNaive = naiveSolution2(arr);
        System.out.println("Naive Solution: Majority Element is " + resultNaive);

        // 使用分治法
        int resultDivideAndConquer = divideAndConquerSolution(arr);
        System.out.println("Divide and Conquer Solution: Majority Element is " + resultDivideAndConquer);
    }
}

