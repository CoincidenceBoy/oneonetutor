package org.example.algorithms.linkedlist;

public class TestSingleLinkedList {
    public static void main(String[] args) {
//        LinkedListWithDummyHead<Integer> list = new LinkedListWithDummyHead<>();
        // Code Completion - 取消勾选Match case
        LinkedList<Integer> list = new LinkedList<>();

        // 在头部插入
        list.addAtHead(10);
        list.addAtHead(20);
        list.print(); // 输出: 20 -> 10 -> null

        // 在尾部插入
        list.addAtTail(30);
        list.addAtTail(40);
        list.print(); // 输出: 20 -> 10 -> 30 -> 40 -> null

        // 在指定位置插入
        list.addAtIndex(2, 50);
        list.print(); // 输出: 20 -> 10 -> 50 -> 30 -> 40 -> null

        // 获取数据
        System.out.println("Head: " + list.getHead()); // 输出: Head: 20
        System.out.println("Tail: " + list.getTail()); // 输出: Tail: 40
        System.out.println("Index 2: " + list.getAtIndex(2)); // 输出: Index 2: 50

        // 删除操作
        list.deleteAtHead();
        list.print(); // 输出: 10 -> 50 -> 30 -> 40 -> null

        list.deleteAtTail();
        list.print(); // 输出: 10 -> 50 -> 30 -> null

        list.deleteAtIndex(1);
        list.print(); // 输出: 10 -> 30 -> null

        // 修改操作
        list.setHead(100);
        list.print(); // 输出: 100 -> 30 -> null

        list.setTail(200);
        list.print(); // 输出: 100 -> 200 -> null

        list.setAtIndex(1, 300);
        list.print(); // 输出: 100 -> 300 -> null

        // 获取链表大小
        System.out.println("Size: " + list.size()); // 输出: Size: 2
    }
}
