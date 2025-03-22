package org.example.algorithms.sort;

import java.util.Arrays;

public class QuickSortNetherlands {
    public int[] arr;

    public int[] sortArray(int[] nums) {
        arr = nums;
        quickSort(0, arr.length - 1);
        return arr;
    }

    public void quickSort(int l, int r) {
        if (l >= r) {
            return;
        }

        int target = arr[l + (int) (Math.random() * (r - l + 1))];
        tuple t = partition(l, r, target);
        quickSort(l, t.left);
        quickSort(t.right, r);
    }

    public tuple partition(int l, int r, int x) {
        int i = l;
        while (i <= r) {
            if (arr[i] < x) {
                swap(l, i);
                l++;
                i++;
            } else if (arr[i] == x) {
                i++;
            } else {
                swap(i, r);
                r--;
            }
        }
        // 荷兰国旗 [0, l-1] [l, r] [r+1, n-1]
        return new tuple(l - 1, r + 1);
    }

    class tuple {
        int left;
        int right;
        tuple(int l, int r) {
            left = l;
            right = r;
        }
    }

    public void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        QuickSortNetherlands quickSortNetherlands = new QuickSortNetherlands();
        int[] nums = {3, 6, 8, 10, 1, 2, 1};
        System.out.println("Original array: " + Arrays.toString(nums));

        int[] sortedArray = quickSortNetherlands.sortArray(nums);
        System.out.println("Sorted array: " + Arrays.toString(sortedArray));
    }
}