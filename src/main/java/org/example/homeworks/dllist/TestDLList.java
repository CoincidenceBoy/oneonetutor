package org.example.homeworks.dllist;

public class TestDLList {

    // 工具方法：将可变参数转换为 DLList
    public static <T> DLList<T> fromArray(T... elements) {
        DLList<T> list = new DLList<>();
        for (T element : elements) {
            list.push_back(element);
        }
        return list;
    }

    public static void main(String[] args) {
        // 测试空链表
        DLList<Integer> emptyList = new DLList<>();
        System.out.println("空链表: " + emptyList); // []

        // 测试 push_back 和 push_front
        DLList<Integer> list = new DLList<>();
        list.push_back(3);
        list.push_front(1);
        list.push_back(5);
        list.push_front(0);
        System.out.println("push_back/push_front 后: " + list); // [0, 1, 3, 5]

        // 测试 pop_front
        Integer popped = list.pop_front();
        System.out.println("pop_front 返回值: " + popped); // 0
        System.out.println("pop_front 后链表: " + list); // [1, 3, 5]

        // 测试空链表 pop_front
        DLList<Integer> emptyList2 = new DLList<>();
        System.out.println("空链表 pop_front: " + emptyList2.pop_front()); // null

        // 测试 concatenate
        DLList<Integer> listA = new DLList<>(2, 4);
        DLList<Integer> listB = new DLList<>(6, 8);
        listA.concatenate(listB);
        System.out.println("concatenate 后 listA: " + listA); // [2, 4, 6, 8]

        // 测试空链表 concatenate
        DLList<Integer> emptyList3 = new DLList<>();
        emptyList3.concatenate(listA);
        System.out.println("空链表 concatenate: " + emptyList3); // [2, 4, 6, 8]

        // 测试 get
        System.out.println("get(0): " + listA.get(0)); // 2
        System.out.println("get(3): " + listA.get(3)); // 8
        System.out.println("越界 get(4): " + listA.get(4)); // null

        // 测试 flatten
        DLList<DLList<Integer>> listOfLists = new DLList<>();
        listOfLists.push_back(new DLList<>(1, 3));
        listOfLists.push_back(new DLList<>(5, 7));
        listOfLists.push_back(new DLList<>());
        listOfLists.push_back(new DLList<>(9));
        DLList<Integer> flattened = DLList.flatten(listOfLists);
        System.out.println("flatten 结果: " + flattened); // [1, 3, 5, 7, 9]

        // 测试 mergeSort（不同场景）
        testMergeSort(fromArray(5, 3, 8, 1, 2), "随机顺序链表");
        testMergeSort(fromArray(1, 2, 3, 4, 5), "已排序链表");
        testMergeSort(fromArray(5, 4, 3, 2, 1), "逆序链表");
        testMergeSort(fromArray(2, 2, 2, 2), "重复元素链表");
        testMergeSort(new DLList<>(), "空链表");
        testMergeSort(fromArray(10), "单元素链表");
    }

    // 测试 mergeSort 的辅助方法
    private static void testMergeSort(DLList<Integer> list, String testCase) {
        System.out.println("\n测试 mergeSort: " + testCase);
        System.out.println("排序前: " + list);
        DLList<Integer> sorted = DLList.mergeSort(list);
        System.out.println("排序后: " + sorted);
    }
}