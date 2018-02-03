/*
input : a[] rotated sorted arr
output: min
 * Thought Process:
 * 
 */
package Searching;

/**
 *
 * @author xinrong
 */
public class FindMininRotatedSortedArr {
    int findM(int[] a) {
        int lo = 0, hi = a.length - 1;
        while (a[lo] > a[hi]) {
            int mid = lo / 2 + hi / 2;
            if (a[mid] > a[hi])
                lo = mid + 1;
            else
                hi = mid;            
        }
        return a[lo];
    }
}
