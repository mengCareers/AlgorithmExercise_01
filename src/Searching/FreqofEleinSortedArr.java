/*
+ getF()
input : a[], x
output: freq
+ getFirstOccurance()
input : a[], x
output: 1st occurance idx
 * Thought Process:
 * 
 */
package Searching;

/**
 *
 * @author xinrong
 */
public class FreqofEleinSortedArr {
    int getF(int[] a, int x) {
        return getFUtil(a, x, 0, a.length - 1);
    }
    int getFUtil(int[] a, int x, int lo, int hi) {
        // base cases
        if (lo > hi)
            return 0;
        if (a[lo] > x)
            return 0;
        if (a[hi] < x)
            return 0;
        if (a[lo] == x && a[hi] == x)
            return hi - lo + 1;
        int mid = lo / 2 + hi / 2;
        if (a[mid] == x)
            return 1 + getFUtil(a, x, lo, mid - 1)
                     + getFUtil(a, x, mid + 1, hi);
        else if (a[mid] < x)
            return getFUtil(a, x, mid + 1, hi);
        else
            return getFUtil(a, x, lo, mid - 1);
    }

    int getFirstOccurance(int[] a, int x) {
        return getFirstOccuranceUtil(a, x, 0, a.length - 1);
    }
    int getFirstOccuranceUtil(int[] a, int x, int lo, int hi) {
        // base cases
        if (lo > hi)
            return -1;
        if (a[lo] > x)
            return -1;
        if (a[hi] < x)
            return -1;
        if (a[lo] == x && a[hi] == x)
            return lo;
        int mid = lo / 2 + hi / 2;
        if (a[mid] == x)
            return getFirstOccuranceUtil(a, x, lo, mid);
        else if (a[mid] < x)
            return getFirstOccuranceUtil(a, x, mid + 1, hi);
        else
            return getFirstOccuranceUtil(a, x, lo, mid - 1);
    }

}
