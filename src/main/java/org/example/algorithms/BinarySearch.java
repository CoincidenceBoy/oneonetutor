package org.example.algorithms;

public class BinarySearch {

    // 标准的二分查找方法
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        // left <= right
        while (left != right + 1) {
            int mid = left + (right - left) / 2; // 防止溢出的计算中点方法

            // 检查中点的元素是否是目标值
            if (arr[mid] == target) {
                return mid;  // 找到了，返回索引
            }

            // 如果目标值大于中点元素，继续在右半部分查找
            if (arr[mid] < target) {
                left = mid + 1;
            }
            // 如果目标值小于中点元素，继续在左半部分查找
            else {
                right = mid - 1;
            }
        }

        // 如果数组中没有找到目标元素，返回 -1
        return -1;
    }

    // 递归实现的二分查找方法
    public static int binarySearchRecursive(int[] arr, int target, int left, int right) {
        // 基本情况：如果左指针大于右指针，则表示没有找到
        if (left > right) {
            return -1;
        }

        // 计算中点
        int mid = left + (right - left) / 2;

        // 检查中点的元素是否是目标值
        if (arr[mid] == target) {
            return mid;  // 找到了，返回索引
        }

        // 如果目标值大于中点元素，继续在右半部分查找
        if (arr[mid] < target) {
            return binarySearchRecursive(arr, target, mid + 1, right);
        }
        // 如果目标值小于中点元素，继续在左半部分查找
        else {
            return binarySearchRecursive(arr, target, left, mid - 1);
        }
    }

    public static void main(String[] args) {
        // 测试数组，必须是已排序的
        int[] arr = {-10, -5, 0, 3, 7, 12, 15};

        int target = 0;
//        int result = binarySearch(arr, target);
        int result = binarySearchRecursive(arr, target, 0, arr.length - 1);

        // 打印结果
        if (result != -1) {
            System.out.println("Element " + target + " is found at index: " + result);
        } else {
            System.out.println("Element " + target + " is not found in the array.");
        }
    }
}

