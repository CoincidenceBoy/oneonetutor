package org.example.algorithms.linkedlist;

import java.util.Arrays;

public class TestSwap {
    public static void main(String[] args) {
        // 交换a和b
        int a = 5;
        // int a;
        // a = 5;
        int b = 6;

        int[] arr = {1, 2, 3, 4, 5}; //new了一个int类型数组 并给它赋值
        int i = 0;
        int j = 2;
        swapOneArr(arr, i, j);

        int[][] arr2 = {
                {1, 2},
                {4, 5, 6},
                {7, 8, 9, 10}
        }; //二维数组

        System.out.println(Arrays.deepToString(arr2)); //打印二维数组
        swapTwoArr(arr2, i, j);
        System.out.println(Arrays.deepToString(arr2)); //打印二维数组

//        changeInt(a,b);
        // int a_copy = a;
        // int b_copy = b;



    }

    private static void swapTwoArr(int[][] arr2_copy, int i_copy, int j_copy) {
        // arr2_copy[i_copy] = arr2; 隐式调用了这一行进行初始化
        // i_copy = i; 隐式调用了这一行进行初始化
        // j_copy = j; 隐式调用了这一行进行初始化
        // 都是赋值
        int[] temp;
        temp = arr2_copy[i_copy];
        arr2_copy[i_copy] = arr2_copy[j_copy];
        arr2_copy[j_copy] = temp;
    }

    private static void swapOneArr(int[] arr_copy, int i_copy, int j_copy) {
        int temp;
        temp = arr_copy[i_copy];
        arr_copy[i_copy] = arr_copy[j_copy];
        arr_copy[j_copy] = temp;
    }

    private static void swapInt(int a_copy, int b_copy) {
        // int a_copy = a; 相当于a_copy = 5 以后修改的都是 a_copy
        int temp;
        temp = a_copy;
        a_copy = b_copy;
        b_copy = temp;
        //java只有赋值 a里面的东西和b里面的东西交换
    }
}
