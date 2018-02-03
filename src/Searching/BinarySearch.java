/*
 * Thought Process:
 * 
 */
package Searching;

/**
 *
 * @author xinrong
 */
public class BinarySearch {
    boolean bsIterative(int[] a, int x) {
        int lo = 0, hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo / 2 + hi / 2;
            if (a[mid] == x)
                return true;
            else if (a[mid] < x) 
                lo = mid + 1;
            else 
                hi = mid - 1;
        }
        return false;
    }
    boolean bsRecursive(int[] a, int x) {
        return bsRecursiveUtil(a, x, 0, a.length - 1);
    }
    boolean bsRecursiveUtil(int[] a, int x, int lo, int hi) {
        if (lo > hi)
            return false;
        int mid = lo / 2 + hi / 2;
        if (a[mid] == x)
            return true;
        else if (a[mid] < x) 
            return bsRecursiveUtil(a, x, mid + 1, hi);
        else 
            return bsRecursiveUtil(a, x, lo, mid - 1);
    }
}
