package org.example.homeworks.dllist;

public class DLList<T> {

    public Node<T> first;
    public Node<T> last;
    public int length;

    public int size() {
        return length;
    }

    // Constructor that generates an empty list
    public DLList() {
        length = 0;
        first = null;
        last = null;
    }

    // Constructor that generates a list with a single element
    public DLList(T e) {
        initializeDLListWithSingleNode(e);
    }

    /**
     * Initializes the doubly-linked list with a single node containing the specified element.
     *
     * @param e the element to be stored in the single node
     */
    private void initializeDLListWithSingleNode(T e) {
        length = 1;
        first = new Node<T>();
        first.val = e;
        last = first;
    }

    // Constructor that generates a list with two elements
    public DLList(T e, T e2) {
        length = 2;
        first = new Node<T>();
        first.val = e;
        last = new Node<T>();
        last.val = e2;
        first.next = last;
        last.prev = first;
    }

    // Method that allows to display a DLList; use liberally to test your
    // functions!
    public String toString() {
        String res = "[";
        Node<T> it = first;
        if (it != null) {
            res += it.val;
            it = it.next;
            while (it != null) {
                res += ", " + it.val;
                it = it.next;
            }
        }
        return res + "]";
    }

    // QUESTION 1 use Javadoc

    /**
     * Adds the specified element to the end of the doubly-linked list.
     * If the list is empty, it initializes the list with the new node.
     *
     * @param x the element to be added to the list
     */
    public void push_back(T x) {
        // Your code goes here
        // Note: If the list is empty, initialize
        if (this.length == 0) {
            initializeDLListWithSingleNode(x);
            return;
        }
        // Let's start newNode with the new element
        Node<T> newNode = new Node<>();
        newNode.val = x;
        this.last.next = newNode;
        // Then the newNode joins the last
        newNode.prev = this.last;
        // Update the last Node
        this.last = newNode;
        this.length++;
    }

    // QUESTION 2

    /**
     * Adds the specified element to the front of the doubly-linked list.
     * If the list is empty, it initializes the list with the new node.
     *
     * <p>
     * This method is essentially the same as {@link #push_back(T x)}, as the list is doubly-linked
     * and the operation depends on the direction from which the list is viewed.
     * </p>
     *
     * @param x the element to be added to the front of the list
     */
    public void push_front(T x) {
        // Your code goes here
        // Note: If the list is empty, initialize
        if (this.length == 0) {
            initializeDLListWithSingleNode(x);
            return;
        }
        // Let's start newNode with the new element
        Node<T> newNode = new Node<>();
        newNode.val = x;
        this.first.prev = newNode;
        // Then the newNode joins the first
        newNode.next = this.first;
        // Update the first Node
        this.first = newNode;
        this.length++;
    }

    // QUESTION 3

    /**
     * Removes and returns the element at the front of the doubly-linked list.
     * If the list is empty, it returns null.
     *
     * <p>
     * Steps:
     * 1. Check if the list is empty. If so, return null.
     * 2. If the list has only one element, remove it and update the list to be empty.
     * 3. If the list has more than one element:
     * - Save the value of the first node.
     * - Update the first pointer to the next node.
     * - Disconnect the removed node from the list.
     * - Decrement the length of the list.
     * 4. Return the value of the removed node.
     * </p>
     *
     * @return the value of the removed element, or null if the list is empty
     */
    public T pop_front() {
        // Your code goes here
        // The next line should be replaced by something sensible once you're done!
        // If the list is empty, return null
        if (this.length == 0) {
            return null;
        }

        // If the list has only one element, remove it and update the list to be empty
        // and update the first and last elements to null
        if (this.length == 1) {
            Node<T> head = this.first;
            this.first = this.last = null;
            this.length = 0;

            // Return the value of the removed node
            return head.val;
        }

        // Save the value of the first node
        Node<T> head = this.first;
        // Update the first pointer to the next node (forward)
        this.first = this.first.next;
        // Disconnect the removed node from the list (backward)
        this.first.prev = null;
        head.next = null;
        // Decrement the length of the list
        this.length--;

        // Return the value of the removed node
        return head.val;
    }

    // QUESTION 4

    /**
     * Concatenates the current doubly-linked list with another list {@code xs} by adding {@code xs} at the end.
     * This method may break the invariant that {@code xs} is a correct doubly-linked list.
     *
     * <p>
     * Steps:
     * 1. If the input list {@code xs} is null or empty, return immediately.
     * 2. If the current list is empty, replace it entirely with {@code xs}.
     * 3. Otherwise:
     * - Connect the last node of the current list to the first node of {@code xs}.
     * - Connect the first node of {@code xs} to the last node of the current list.
     * - Update the last node of the current list to the last node of {@code xs}.
     * - Update the length of the current list.
     * </p>
     *
     * @param xs the another list to be concatenated to the end of the current list
     */
    public void concatenate(DLList<T> xs) {
        // Your code goes here
        // If the input list is null or empty, return (void) immediately
        if (xs == null || xs.length == 0) {
            return;
        }
        // If the current list is empty, replace it entirely with the input list
        if (this.length == 0) {
            this.first = xs.first;
            this.last = xs.last;
            this.length = xs.length;
            return;
        }

        // Connect the last node of the current list to the first node of the input list (forward)
        this.last.next = xs.first;
        // Connect the first node of the input list to the last node of the current list (backward)
        xs.first.prev = this.last;
        // Update the last node of the current list to the last node of the input list
        this.last = xs.last;
        // Update the length of the current list
        this.length += xs.length;
    }

    // QUESTION 5

    /**
     * Returns the i-th element of the list without modifying it, assuming that indexing starts at 0.
     *
     * <p>
     * Steps:
     * 1. Check if the index is out of bounds (negative or greater than or equal to the length of the list).
     *    If so, return null.
     * 2. Traverse the list from the head.
     * 3. Return the value of the node at the specified index.
     * </p>
     *
     * @param idx the index of the element to retrieve
     * @return the value of the element at the specified index, or null if the index is out of bounds
     */
    public T get(int idx) {
        // Your code goes here
        // The next line should be replaced by something sensible once you're done!
        // Check if the index is out of bounds
        if (idx < 0 || idx >= this.length) {
            return null;
        }

        // Traverse the list from the head
        Node<T> startNode = this.first;
        for (int i = 0; i < idx; i++) {
            startNode = startNode.next;
        }

        // Return the value of the node at the specified index
        return startNode.val;
    }

    /**
     * (private method)
     * like {@link #get(int idx)} but returns the Node at the specified index in the doubly-linked list.
     * If the index is out of bounds, returns null.
     *
     * @param idx the index of the Node to retrieve
     * @return the Node at the specified index, or null if the index is out of bounds
     */
    private Node<T> getNode(int idx) {
        if (idx < 0 || idx >= this.length) {
            return null;
        }
        Node<T> startNode = this.first;
        for (int i = 0; i < idx; i++) {
            startNode = startNode.next;
        }
        return startNode;
    }

    // QUESTION 6

    /**
     * Flattens a list of doubly-linked lists into a single doubly-linked list by concatenating all the lists.
     * The input list of lists may be modified and become invalid after this operation.
     *
     * <p>
     * Example:
     * Input: [[1, 5, 2], [0, 2, 2], [], [10]]
     * Output: [1, 5, 2, 0, 2, 2, 10]
     * </p>
     *
     * <p>
     * Steps:
     * 1. Create an empty result list.
     * 2. If the input list is null or empty, return the empty result list.
     * 3. Traverse the input list and concatenate each sublist to the result list.
     * 4. Return the flattened result list.
     * </p>
     *
     * @param xss the list of lists to be flattened
     * @return a single flattened doubly-linked list
     */
    static public <T> DLList<T> flatten(DLList<DLList<T>> xss) {
        // Your code goes here
        // Create an empty result list
        DLList<T> resultList = new DLList<>();

        // If the input list is null or empty, return the empty result list
        if (xss == null || xss.length == 0) {
            return resultList;
        }

        // Traverse the input list and concatenate each sublist to the result list
        // Node: The essence of a two-dimensional linked list is also a one-dimensional linked list,
        //       both of which are reference types.
        // And DLList<DLList<T>> xss is essentially a two-dimensional linked list where the val stores objects of type DLList<T>
        Node<DLList<T>> startNode = xss.first;
        while (startNode != null) {
            resultList.concatenate(startNode.val);
            startNode = startNode.next;
        }
        return resultList;
    }

    // QUESTION 7

    /**
     * Sorts a doubly-linked list of integers using the merge sort algorithm.
     * Similar to arrays, but linked lists need to be broken.
     *
     * <p>
     * Steps:
     * 1. Base Case: If the list is empty or has one element, return it.
     * 2. Split the list into left and right sublists.
     * 3. Recursively sort the left and right sublists.
     * 4. Merge the sorted sublists.
     * </p>
     *
     * @param xs the input list to be sorted
     * @return a new sorted doubly-linked list
     */
    static public DLList<Integer> mergeSort(DLList<Integer> xs) {
        // Your code goes here
        // empty list or single element
        if (xs == null || xs.size() <= 1) {
            return xs;
        }

        // Split the list into left and right sublists
        DLList<Integer> leftSublist = new DLList<>();
        DLList<Integer> rightSublist = new DLList<>();
        int mid = xs.size() / 2;
        Node<Integer> now = xs.first;

        // Build left sublist (first half)
        for (int i = 0; i < mid; i++) {
            leftSublist.push_back(now.val);
            now = now.next;
        }

        // Build right sublist (second half)
        while (now != null) {
            rightSublist.push_back(now.val);
            now = now.next;
        }

        // Recursively sort sublists
        leftSublist = mergeSort(leftSublist);
        rightSublist = mergeSort(rightSublist);

        // Merge the sorted sublists
        return merge(leftSublist, rightSublist);
    }

    /**
     * Merges two sorted doubly-linked lists into one sorted list.
     *
     * <p>
     * Steps:
     * 1. Compare the heads of both lists.
     * 2. Append the smaller value to the result list.
     * 3. Append remaining elements from the non-empty list.
     * </p>
     *
     * @param leftList  the first sorted list
     * @param rightList the second sorted list
     * @return a merged sorted list
     */
    static private DLList<Integer> merge(DLList<Integer> leftList, DLList<Integer> rightList) {
        DLList<Integer> result = new DLList<>();
        Node<Integer> leftNow = leftList.first;
        Node<Integer> rightNow = rightList.first;

        // Merge by comparing current nodes of both lists
        while (leftNow != null && rightNow != null) {
            if (leftNow.val < rightNow.val) {
                result.push_back(leftNow.val);
                leftNow = leftNow.next;
            } else {
                result.push_back(rightNow.val);
                rightNow = rightNow.next;
            }
        }

        // Append remaining elements from left list
        while (leftNow != null) {
            result.push_back(leftNow.val);
            leftNow = leftNow.next;
        }

        // Append remaining elements from right list
        while (rightNow != null) {
            result.push_back(rightNow.val);
            rightNow = rightNow.next;
        }

        return result;
    }
}

