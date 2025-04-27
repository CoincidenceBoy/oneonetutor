package org.example.algorithms.hash;

import java.util.LinkedList;
import java.util.List;

public class Lab8_3 {

    /**
            * 手动计算 LinkedList 的哈希值（与 Java 官方实现逻辑一致）
            */
    public static int calculateHashCode(LinkedList<Integer> list) {
        // 入参 list [0, 1] 返回hashCode 962
        // 入参 list [1, 0] 返回hashCode 992
        // 入参 list [1, 0, 0] 返回hashCode 992 * 31
        // 入参 list [1, 0, 2] 返回hashCode 992 * 31 + 2
        int hashCode = 1;
        for (Integer e : list) {
            hashCode = 31 * hashCode + (e == null ? 0 : e.hashCode());
        }
        return hashCode;
    }

    /**
            * 验证 LinkedList 的哈希值计算
     */
    public static void verifyHashCode() {
        // 1. 验证单层列表 [0, 1]
        LinkedList<Integer> list1 = new LinkedList<>(List.of(0, 1));
        int manualHash1 = calculateHashCode(list1);
        System.out.println("手动计算 [0, 1].hashCode(): " + manualHash1); // 应为 962
        System.out.println("实际调用 [0, 1].hashCode(): " + list1.hashCode()); // 验证一致性

        // 1. 验证单层列表 [1, 0]
        LinkedList<Integer> list11 = new LinkedList<>(List.of(1, 0));
        int manualHash11 = calculateHashCode(list11);
        System.out.println("手动计算 [0, 1].hashCode(): " + manualHash11); // 992
        System.out.println("实际调用 [0, 1].hashCode(): " + list11.hashCode()); // 验证一致性

//        // 2. 验证嵌套列表 [[0], []]
//        LinkedList<LinkedList<Integer>> list2 = new LinkedList<>();
//        list2.add(new LinkedList<>(List.of(0)));
//        list2.add(new LinkedList<>());
//        int manualHash2 = calculateHashCode(list2);
//        System.out.println("手动计算 [[0], []].hashCode(): " + manualHash2); // 应为 1923
//        System.out.println("实际调用 [[0], []].hashCode(): " + list2.hashCode()); // 验证一致性
    }
//
//    /**
//            * 构造 LinkedList<LinkedList<Integer>> 的哈希碰撞
//     */
//    public static void demonstrateCollision() {
//        // 碰撞示例：[[1, 0], []] 和 [[31], [1]]
//        LinkedList<LinkedList<Integer>> listA = new LinkedList<>();
//        listA.add(new LinkedList<>(List.of(1, 0))); // 内层哈希值 = 31 * 1 + 0 = 31 → 31 * 31 + 1 = 962
//        listA.add(new LinkedList<>());              // 内层哈希值 = 1
//        // 外层哈希值: 31 * 1 + 962 = 993 → 31 * 993 + 1 = 30784
//
//        LinkedList<LinkedList<Integer>> listB = new LinkedList<>();
//        listB.add(new LinkedList<>(List.of(31)));   // 内层哈希值 = 31
//        listB.add(new LinkedList<>(List.of(1)));    // 内层哈希值 = 1
//        // 外层哈希值: 31 * 1 + 31 = 62 → 31 * 62 + 1 = 1923
//
//        // 修正碰撞示例：需满足 31*A + B = 31*C + D
//        // 例如 [[31, 0], []] 和 [[31], [0]] 的哈希值均为 30784
//        LinkedList<LinkedList<Integer>> collision1 = new LinkedList<>();
//        collision1.add(new LinkedList<>(List.of(31, 0))); // 内层: 31 * 31 + 0 = 961
//        collision1.add(new LinkedList<>());               // 内层: 1
//        // 外层: 31 * 1 + 961 = 992 → 31 * 992 + 1 = 30753
//
//        LinkedList<LinkedList<Integer>> collision2 = new LinkedList<>();
//        collision2.add(new LinkedList<>(List.of(31)));     // 内层: 31
//        collision2.add(new LinkedList<>(List.of(0)));     // 内层: 0
//        // 外层: 31 * 1 + 31 = 62 → 31 * 62 + 0 = 1922
//
//        System.out.println("[[31, 0], []].hashCode(): " + calculateHashCode(collision1));
//        System.out.println("[[31], [0]].hashCode(): " + calculateHashCode(collision2));
//    }

    public static void main(String[] args) {
        verifyHashCode();
//        demonstrateCollision();
    }
}