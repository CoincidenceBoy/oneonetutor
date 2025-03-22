package org.example.algorithms.linkedlist;

class LinkedList<T> {
    private Node<T> head; // 头节点（没有 dummy node）
    private int length;   // 链表长度

    // 构造函数：初始化链表
    public LinkedList() {
        head = null; // 头节点初始化为 null
        length = 0;
    }

    // 在头部插入
    public void addAtHead(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
        length++;
    }

    // 在尾部插入
    public void addAtTail(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        length++;
    }

    // 在指定位置插入
    public void addAtIndex(int index, T data) {
        if (index < 0 || index > length) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (index == 0) {
            addAtHead(data);
        } else {
            Node<T> newNode = new Node<>(data);
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
            length++;
        }
    }

    // 获取头部数据
    public T getHead() {
        if (length == 0) {
            throw new IllegalStateException("List is empty");
        }
        return head.data;
    }

    // 获取尾部数据
    public T getTail() {
        if (length == 0) {
            throw new IllegalStateException("List is empty");
        }
        Node<T> current = head;
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
        Node<T> current = head;
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
        head = head.next;
        length--;
    }

    // 在尾部删除
    public void deleteAtTail() {
        if (length == 0) {
            throw new IllegalStateException("List is empty");
        }
        if (length == 1) {
            head = null;
        } else {
            Node<T> current = head;
            while (current.next.next != null) {
                current = current.next;
            }
            current.next = null;
        }
        length--;
    }

    // 在指定位置删除
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (index == 0) {
            deleteAtHead();
        } else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
            length--;
        }
    }

    // 在头部修改
    public void setHead(T data) {
        if (length == 0) {
            throw new IllegalStateException("List is empty");
        }
        head.data = data;
    }

    // 在尾部修改
    public void setTail(T data) {
        if (length == 0) {
            throw new IllegalStateException("List is empty");
        }
        Node<T> current = head;
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
        Node<T> current = head;
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
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}