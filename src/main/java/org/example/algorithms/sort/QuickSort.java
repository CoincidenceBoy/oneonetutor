package org.example.algorithms.sort;

public class QuickSort {
    // 进行划分的操作
    public static int partition(int[] A, int low, int high) {
        int pivot = A[low];  // 设置基准元素
        while (low < high) {
            // 通过low, high来找到基准元素的最终位置
            while (low < high && A[high] >= pivot) {
                high--;  // 比基准大的元素移动到右边
            }
            A[low] = A[high];  // 将大于基准的元素放到左边

            while (low < high && A[low] <= pivot) {
                low++;  // 比基准小的元素移动到左边
            }
            A[high] = A[low];  // 将小于基准的元素放到右边
        }
        A[low] = pivot;  // 将基准元素放到最终位置
        return low;  // 返回基准元素的最终位置
    }

    // 快速排序的实现
    public static void quickSort(int[] A, int low, int high) {
        if (low < high) {  // 如果还有元素需要排序
            int pivotPos = partition(A, low, high);  // 获取基准元素位置
            quickSort(A, low, pivotPos - 1);  // 递归排序左子数组
            quickSort(A, pivotPos + 1, high);  // 递归排序右子数组
        }
    }

    // 测试代码
    public static void main(String[] args) {
        int[] arr = { 4, 6, 2, 8, 1, 3, 7, 5 };
        quickSort(arr, 0, arr.length - 1);
        // 打印排序后的数组
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
