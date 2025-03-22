package org.example.base;

public class GenericsBox<K> {  // K 作为类型参数
    private K value;     // 泛型类型
    private int value2;  // 普通的 int 类型

    // 设置泛型类型的值
    public void setValue(K value) {
        this.value = value;
    }

    // 获取泛型类型的值
    public K getValue() {
        return value;
    }

    // 设置 int 类型的值
    public void setValue2(int value2) {
        this.value2 = value2;
    }

    // 获取 int 类型的值
    public int getValue2() {
        return value2;
    }

    public static void main(String[] args) {
        // 使用 Integer 类型替代泛型类型 K
        GenericsBox<Integer> box = new GenericsBox<>();
        box.setValue(123);  // 设置泛型类型的值
        box.setValue2(456); // 设置普通 int 类型的值

        System.out.println("泛型类型的值: " + box.getValue());   // 输出: 123
        System.out.println("普通 int 类型的值: " + box.getValue2()); // 输出: 456
    }
}


