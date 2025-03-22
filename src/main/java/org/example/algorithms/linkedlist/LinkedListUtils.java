package org.example.algorithms.linkedlist;

// 单链表工具类
public class LinkedListUtils<T> {

    // 头插法原地翻转单链表（静态方法）
    public static <T> Node<T> reverseListByHeadInsert(Node<T> head) {
        if (head == null || head.next == null) {
            return head; // 空链表或只有一个节点，直接返回
        }

        // 虚拟头结点是一种思想,实际传给你的肯定是头结点,多数情况需要自己手动创建虚拟头节点来辅助操作
        Node<T> dummy = new Node<>(null);
        Node<T> now = head; // 当前节点
        Node<T> next; // 下一个节点

        while (now != null) {
            next = now.next; // 保存下一个节点

            // 头插法：将当前节点插入到 dummy 和 dummy.next 之间
            now.next = dummy.next;
            dummy.next = now;

            now = next; // 移动到下一个节点
        }

        return dummy.next; // 返回翻转后的链表头节点
    }

//    public static <T> Node<T> reverseListByHeadInsert(Node<T> head) {
//        if (head == null || head.next == null) {
//            return head; // 空链表或只有一个节点，直接返回
//        }
//
//        Node<T> prev = null; // 前驱节点
//        Node<T> now = head; // 当前节点
//        Node<T> next; // 下一个节点
//
//        while (now != null) {
//            next = now.next; // 保存下一个节点
//
//            // 头插法：将当前节点插入到 prev 和 head 之间
//            now.next = prev;
//            prev = now;
//
//            now = next; // 移动到下一个节点
//        }
//
//        return prev; // 返回翻转后的链表头节点
//    }

    // 尾插法原地翻转单链表（静态方法）
    public static <T> Node<T> reverseListByTailInsert(Node<T> head) {
        if (head == null || head.next == null) {
            return head; // 空链表或只有一个节点，直接返回
        }

        Node<T> dummy = new Node<>(null, head); // 创建虚拟头节点，指向原链表
        Node<T> last = dummy; // 指向翻转后链表的尾部

        // 找到原链表的最后一个节点
        while (last.next != null) {
            last = last.next;
        }

        // 尾插法翻转链表
        while (dummy.next != last) {
            Node<T> now = dummy.next; // 当前节点
            dummy.next = now.next; // 将当前节点从原链表中移除
            now.next = last.next; // 将当前节点插入到翻转后链表的尾部
            last.next = now;
        }

        return dummy.next; // 返回翻转后的链表头节点
    }

    // 打印链表（静态方法）
    public static <T> void printList(Node<T> head) {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // 测试头插法翻转单链表
        Node<Integer> head = new Node<>(1);
        head.next = new Node<>(2);
        head.next.next = new Node<>(3);
        head.next.next.next = new Node<>(4);

        System.out.println("原链表：");
        printList(head);

        Node<Integer> reversedHeadByHeadInsert = reverseListByHeadInsert(head);
        System.out.println("头插法翻转后的链表：");
        printList(reversedHeadByHeadInsert);

        // 测试尾插法翻转单链表
        Node<Integer> head2 = new Node<>(1);
        head2.next = new Node<>(2);
        head2.next.next = new Node<>(3);
        head2.next.next.next = new Node<>(4);

        System.out.println("原链表：");
        printList(head2);

        Node<Integer> reversedHeadByTailInsert = reverseListByTailInsert(head2);
        System.out.println("尾插法翻转后的链表：");
        printList(reversedHeadByTailInsert);
    }
}