/*
 * Thought Process:
 * 
 */
package Searching;

/**
 *
 * @author xinrong
 */
public class MoveAll0ToEnd {
    void moveZero(int[] a) {
        int s = 0, e = a.length - 1;
        while (s < e) {
            if (a[s] == 0) {
                swap(a, s, e);
                e--;
            } 
            else {
                s++;
            }
        }
    }
    void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
