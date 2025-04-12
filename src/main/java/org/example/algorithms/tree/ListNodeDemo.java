package org.example.algorithms.tree;

public class ListNodeDemo {
    public static void main(String[] args) {
        // https://pythontutor.com/render.html#mode=display
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;

        ListNode current = node1;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}
