package Exercise;

import java.util.Scanner;

public class SpecialNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 输入四位数的个数 n
        System.out.print("请输入四位数的个数：");
        int n = sc.nextInt();

        // 创建数组存储 n 个四位数
        int[] numbers = new int[n];

        System.out.println("请输入" + n + "个四位数：");
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }


        //用于统计满足条件的个数
        int count = 0;

        // 遍历数组，按位分别计算个十百千位
        for (int i = 0; i < n; i++) {
            int num = numbers[i];

            // 除法➕取余操作得出四位数的个十百千位
            int thousand = num / 1000;
            int hundred = (num / 100) % 10;
            int ten = (num / 10) % 10;
            int unit = num % 10;

            // 判断：个位 - 千位 - 百位 - 十位 > 0
            if ((unit - thousand - hundred - ten) > 0) {
                count++;
            }
        }

        System.out.println(count);
    }
}