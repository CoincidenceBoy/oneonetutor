package org.example.algorithms.hash;

import java.util.HashMap;
import java.util.Map;

public class Lab8_1 {
    public static Map<String, Integer> insert(int[] arr) {
        HashMap<String, Integer> map = new HashMap<>();
        // 遍历数组,使用put来插入元素 建立一个hash table
        for (int i = 0; i < arr.length; i++) {
            String key = String.valueOf(arr[i]);
            if (!map.containsKey(key)) { // 只保留第一次出现的索引
                map.put(key, i);
            }
        }
        return map;
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 5, 2};
        System.out.println(insert(arr).keySet());  // 输出 keySet [2, 3, 5] 是HashMap乱序的 -- LinkedHashMap
    }
}