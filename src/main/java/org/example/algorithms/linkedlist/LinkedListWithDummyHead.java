package org.example.algorithms.linkedlist;

class LinkedListWithDummyHead<T> {
    private final Node<T> dummyHead; // 头节点（dummy node）final表引用地址不可变
    private int length;        // 链表长度

    // 构造函数：初始化链表
    public LinkedListWithDummyHead() {
        dummyHead = new Node<>(null); // 创建头节点，数据为 null
        length = 0;
    }

    // 在头部插入
    public void addAtHead(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = dummyHead.next;
        dummyHead.next = newNode;
        length++;
    }

    // 在尾部插入
    public void addAtTail(T data) {
        Node<T> newNode = new Node<>(data);
        Node<T> current = dummyHead;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        length++;
    }

    // 在指定位置插入
    public void addAtIndex(int index, T data) {
        if (index < 0 || index > length) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Node<T> newNode = new Node<>(data);
        Node<T> current = dummyHead;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
        length++;
    }

    // 获取头部数据
    public T getHead() {
        if (length == 0) {
            throw new IllegalStateException("List is empty");
        }
        return dummyHead.next.data;
    }

    // 获取尾部数据
    public T getTail() {
        if (length == 0) {
            throw new IllegalStateException("List is empty");
        }
        Node<T> current = dummyHead;
        while (current.next != null) {
            current = current.next;
        }
        return current.data;
    }

    // 获取指定位置数据
    public T getAtIndex(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Node<T> current = dummyHead.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    // 在头部删除
    public void deleteAtHead() {
        if (length == 0) {
            throw new IllegalStateException("List is empty");
        }
        dummyHead.next = dummyHead.next.next;
        length--;
    }

    // 在尾部删除
    public void deleteAtTail() {
        if (length == 0) {
            throw new IllegalStateException("List is empty");
        }
        Node<T> current = dummyHead;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
        length--;
    }

    // 在指定位置删除
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Node<T> current = dummyHead;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.next = current.next.next;
        length--;
    }

    // 在头部修改
    public void setHead(T data) {
        if (length == 0) {
            throw new IllegalStateException("List is empty");
        }
        dummyHead.next.data = data;
    }

    // 在尾部修改
    public void setTail(T data) {
        if (length == 0) {
            throw new IllegalStateException("List is empty");
        }
        Node<T> current = dummyHead;
        while (current.next != null) {
            current = current.next;
        }
        current.data = data;
    }

    // 在指定位置修改
    public void setAtIndex(int index, T data) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Node<T> current = dummyHead.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.data = data;
    }

    // 返回链表大小
    public int size() {
        return length;
    }

    // 打印链表
    public void print() {
        Node<T> current = dummyHead.next;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
