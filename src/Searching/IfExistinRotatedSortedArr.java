/*
 * Thought Process:
 * Use findMin() to find the minimum element's index minIdx, 
    because [minIdx, a.length) is ordered increasingly, 
            [0, minIdx) is ordered increasingly, 
            a[0] > a[minIdx],
 * Compare a[minIdx - 1] with a[0], and decide to do binarySearch() in which range
 *
 */
package Searching;

/**
 *
 * @author xinrong
 */
public class IfExistinRotatedSortedArr {

    public static void main(String[] args) {
        int[] a = {4, 5, 1, 2, 3};
        int t = 2;
        int ans = new IfExistinRotatedSortedArr().isExist(a, t);
        System.out.println(ans);
    }

    /**
     * To check if t exists in a, 
     * @param a
     * @param t
     * @return t's index or -1 if not exist
     */
    public int isExist(int[] a, int t) {
        if (a == null || a.length == 0)
            return -1;
        
        int lo = 0, hi = a.length - 1;
        
        int p = findMin(a) - 1;
        
        // a[] is ordered as a whole
        if (p == -1) {
            return binarySearch(a, t, lo, hi);
        }
        
        if (a[p] == t) {
            return p;
        }
        
        if (a[0] <= t) {
            return binarySearch(a, t, 0, p - 1);
        }
        
        return binarySearch(a, t, p + 1, a.length - 1);

    }

    /**
     * To find the minimum element's index in a[], [minIdx, a.length) is ordered, [0, minIdx) is ordered

     * @param a
     * @return 
     */
    private int findMin(int[] a) {
        int minIdx = 0, hi = a.length - 1;
        while (a[minIdx] > a[hi]) {
            int mid = minIdx / 2 + hi / 2;
            if (a[mid] > a[hi])
                minIdx = mid + 1;
            else
                hi = mid;            
        }
        return minIdx;
    }
    
    /**
     * Binary Search
     * @param a
     * @param t
     * @param lo
     * @param hi
     * @return 
     */
    private int binarySearch(int[] a, int t, int lo, int hi) {
        if (hi < lo) {
            return -1;
        }
        int mid = lo + (hi - lo) / 2;
        if (t == a[mid]) {
            return mid;
        }
        if (t > a[mid]) {
            return binarySearch(a, t, mid + 1, hi);
        }
        return binarySearch(a, t, lo, mid - 1);
    }
    
}
