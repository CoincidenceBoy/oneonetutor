package Exercise;

/*
题目描述
给定一个 5×5 的矩阵(数学上，一个 r×c 的矩阵是一个由 r 行 c 列元素排列成的矩形阵列)，将第 n 行和第 m 行交换，输出交换后的结果。

输入格式
输入共 6 行，前 5 行为矩阵的每一行元素,元素与元素之间以一个空格分开。

第 6 行包含两个整数 m、n，以一个空格分开（1≤m,n≤5）。

输出格式
输出交换之后的矩阵，矩阵的每一行元素占一行，元素之间以一个空格分开。

*/


import java.util.Scanner;

public class Matrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //定义5✖️5二维数组
        int[][] matrix = new int[5][5];

        // 用循环遍历输入5行数据，每行5个
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        // 输入交换的行号
        int m = sc.nextInt();
        int n = sc.nextInt();

        //用条件判断解决输出错误行号的问题
        if (m < 1 || m > 5 || n < 1 || n > 5) {
            System.out.println("输入行号必须在 1~5 之间！");
            return;
        }

        //数组索引从0开始，5行下标事0-4，所以要-1
        m = m - 1;
        n = n - 1;

        // 设定目标值temp，用于交换第m行和第n行
        int[] temp = matrix[m];
        matrix[m] = matrix[n];
        matrix[n] = temp;

        // 输出结果
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(matrix[i][j]);
                if (j < 4) System.out.print(" ");
            }
            System.out.println();
        }
    }
}