package Exercise;

/*
题目描述
将正整数 m 和 n 之间（包括 m 和 n) 能被 17 整除的数累加，其中，0<m<n<1000。

输入格式
一行，包含两个整数 m 和 n，其间，以一个空格间隔。

输出格式
输出一行，包行一个整数，表示累加的结果。
*/

import java.util.Scanner;

public class SumDivisibleBy17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        int sum = 0;

        if (m <= 0 || n >= 1000 || m >= n) {
            System.out.println("请输入符合规定的数字 ");
            return;
        }

        // for循环遍历 m 到 n 之间所有整数，并判断是否能被17整除，满足条件就加入sum
        for (int i = m; i <= n; i++) {
            if (i % 17 == 0) {
                sum += i;
            }
        }
        System.out.println(sum);
    }
}

