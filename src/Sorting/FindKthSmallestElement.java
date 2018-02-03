/*
 * Thought Process:
 * 
 */
package Sorting;

/**
 *
 * @author xinrong
 */
public class FindKthSmallestElement {

    public static void main(String[] args) {
        int[] arr = {12, 3, 5, 7, 4, 19, 26};
        int ans = new FindKthSmallestElement().findKthSmallestElement(arr, 3);
        System.out.println(ans);
        for (int i : arr)
            System.out.print(i + " ");
//        ans = new FindKthSmallestElement().findKthSmallestElement(arr, 2);
//        System.out.println(ans);
//        ans = new FindKthSmallestElement().findKthSmallestElement(arr, 3);
//        System.out.println(ans);
//        ans = new FindKthSmallestElement().findKthSmallestElement(arr, 4);
//        System.out.println(ans);
//        ans = new FindKthSmallestElement().findKthSmallestElement(arr, 5);
//        System.out.println(ans);
//        ans = new FindKthSmallestElement().findKthSmallestElement(arr, 6);
//        System.out.println(ans);
//        ans = new FindKthSmallestElement().findKthSmallestElement(arr, 7);
//        System.out.println(ans);
//        ans = new FindKthSmallestElement().findKthSmallestElement(arr, 8);
//        System.out.println(ans);
    }
    
    public int findKthSmallestElement(int[] arr, int k) {
        return quickSortUtil(arr, 0, arr.length - 1, k);
    }

    int quickSortUtil(int[] arr, int lo, int hi, int k) {
        if (k > 0 && k <= hi - lo + 1) {
            int wall = threeWayPartition(arr, lo, hi);
            // wall is wall + 1 th smallest absolutely
            //      is wall - lo + 1 th smallest relatively
            if (k == wall - lo + 1)
                return arr[wall];
            if (k < wall - lo + 1)
                return quickSortUtil(arr, lo, wall - 1, k);
            return quickSortUtil(arr, wall + 1, hi, k - (wall - lo + 1));
        }
        return Integer.MAX_VALUE;
    }

    /**
     * The three-way-partition method
     * @param a
     * @param lo
     * @param hi
     * @return 
     */
    private int threeWayPartition(int[] a, int lo, int hi) {
        int v = a[lo];
        int lt = lo, i = lo + 1, gt = hi;
        while (i <= gt) { // to shrink [i, gt]
            if (a[i] < v)
                swap(a, lt++, i++);
            else if (a[i] > v) 
                swap(a, gt--, i);
            else 
                i++;
        }
        return i - 1;
    }
    
    /**
     * The partition method that takes arr[hi] as pivot
     *
     * @param arr
     * @param lo
     * @param hi
     * @return
     */
    int partitionPivotHi(int[] arr, int lo, int hi) {
        int pivot = arr[hi];
        int wall = lo - 1;

        for (int i = lo; i < hi; i++) {
            if (arr[i] <= pivot) {
                wall++;
                swap(arr, i, wall);
            }
        }
        swap(arr, hi, wall + 1);

        return wall + 1;
    }

    /**
     * The partition method that takes arr[lo] as pivot
     *
     * @param arr
     * @param lo
     * @param hi
     * @return
     */
    int partitionPivotLo(int[] arr, int lo, int hi) {
        int pivot = arr[lo];
        int wall = hi + 1;

        for (int i = hi; i > lo; i--) {
            if (arr[i] >= pivot) {
                wall--;
                swap(arr, i, wall);
            }
        }
        swap(arr, lo, wall - 1);

        return wall - 1;
    }

    /**
     * The upgraded partition method that takes arr[lo] as pivot
     *
     * @param arr
     * @param lo
     * @param hi
     * @return
     */
    int partitionPivotLoUpgrade(int[] arr, int lo, int hi) {
        int pivot = arr[lo];
        int wall = hi + 1;
        int i = lo;

        while (true) {
            while (arr[++i] < pivot) {
                if (i == hi) {
                    break;
                }
            }
            while (arr[--wall] >= pivot) {
                if (wall == lo) {
                    break;
                }
            }
            if (i >= wall) {
                break;
            }
            swap(arr, i, wall);
        }
        swap(arr, lo, wall);

        return wall;
    }

    void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
