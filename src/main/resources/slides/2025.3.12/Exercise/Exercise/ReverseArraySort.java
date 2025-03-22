package Exercise;
/*
将一个数组中的值按逆序重新存放。例如，原来的顺序为 8,6,5,4,1。要求改为 1,4,5,6,8。

输入格式
输入为两行：第一行数组中元素的个数 n（1<n≤100)，第二行是 n 个整数，每两个整数之间用空格分隔。

输出格式
输出为一行：输出逆序后数组的整数，每两个整数之间用空格分隔。
*/

import java.util.Scanner;
import java.util.Arrays;

public class ReverseArraySort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("请输入数组元素个数：");
        int n = sc.nextInt();

        //定义一个数组
        int[] arr = new int[n];

        System.out.println("请输入 " + n + " 个整数，用空格隔开：");
        for (int i = 0; i < n; i++) {  //循环遍历N个整数并存入数组
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr); // Java内置排序方法，自动升序从小到大排列

        //
        System.out.print("排序后的数组：");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]);
            if (i < n - 1) System.out.print(" ");
        }
        System.out.println();
    }
}
