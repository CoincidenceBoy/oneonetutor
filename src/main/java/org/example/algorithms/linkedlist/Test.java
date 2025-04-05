package org.example.algorithms.linkedlist;

public class Test {

public static void find_element(char[] A) {
    char candidate = '0';
    int max_count = 0;
//        for (int k = 0; k < A.length; k++) {
    for (int i = 0; i < A.length; i++) {
        int count = 0;
        for (int j = 0; j < A.length; j++) {
            if (A[i] == A[j]) {
                count++;
            }
        }
        if (count > max_count) {
            candidate = A[i];
            max_count = count;
        }
    }
//        }
    System.out.println(candidate);
}

}
