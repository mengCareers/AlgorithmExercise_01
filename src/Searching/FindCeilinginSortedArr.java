/*
ceiling of x is the 1st >= x
 * Thought Process:
 * 
 */
package Searching;

/**
 *
 * @author xinrong
 */
public class FindCeilinginSortedArr {

    public static void main(String[] args) {
        int[] a = {1, 5, 5, 7, 8, 10, 15};
        int x = 9;
        int ans = new FindCeilinginSortedArr().findCeiling(a, x);
        System.out.println(ans);
    }
    
    int findCeiling(int[] a, int x) {
        int lo = 0, hi = a.length - 1;
        if (x < a[lo]) {
            return a[lo];
        }
        if (x > a[hi]) {
            return -1;
        }
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (lo == mid)
                return a[hi];
            if (a[mid] < x) {
                lo = mid + 1;
            } else if (a[mid] > x) {
                hi = mid;
            } else {
                return a[mid];
            }
        }
        return -1;
    }

}
