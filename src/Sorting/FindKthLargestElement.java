/*
 * Thought Process:
 * 
 */
package Sorting;

/**
 *
 * @author xinrong
 */
public class FindKthLargestElement {
    
    public static void main(String[] args) {
        int[] arr = {6, 5, 3, 1, 2, 7, 8, 4};
        int ans = new FindKthLargestElement().findKthLargestElement(arr, 1);
        System.out.println("The 1st largest element is " + ans);
        ans = new FindKthLargestElement().findKthLargestElement(arr, 2);
        System.out.println("The 2nd largest element is " + ans);
        ans = new FindKthLargestElement().findKthLargestElement(arr, 3);
        System.out.println("The 3rd largest element is " + ans);
        ans = new FindKthLargestElement().findKthLargestElement(arr, 4);
        System.out.println("The 4th largest element is " + ans);
        ans = new FindKthLargestElement().findKthLargestElement(arr, 5);
        System.out.println("The 5th largest element is " + ans);
        ans = new FindKthLargestElement().findKthLargestElement(arr, 6);
        System.out.println("The 6th largest element is " + ans);
        ans = new FindKthLargestElement().findKthLargestElement(arr, 7);
        System.out.println("The 7th largest element is " + ans);
        ans = new FindKthLargestElement().findKthLargestElement(arr, 8);
        System.out.println("The 8th largest element is " + ans);
    }
    
    public int findKthLargestElement(int[] arr, int k) {
        return quickSortUtil(arr, 0, arr.length - 1, arr.length + 1 - k);
    }
    
    /**
     * The utility method to find the Kth Smallest Element based on Quick Sort
     * @param arr
     * @param lo
     * @param hi
     * @param k
     * @return The value of the the kth Smallest Element. Return Integer.MIN_VALUE if k is invalid
     */
    int quickSortUtil(int[] arr, int lo, int hi, int k) {
        if (k > 0 && k <= hi - lo + 1) {
            int wall = partitionPivotHi(arr, lo, hi);            
            if (k == wall - lo + 1) { // wall is wall - lo + 1 th smallest relatively
                return arr[wall];
            }
            if (k < wall - lo + 1) {
                return quickSortUtil(arr, lo, wall - 1, k);
            }
            return quickSortUtil(arr, wall + 1, hi, k - (wall - lo + 1));
        }
        return Integer.MIN_VALUE;
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

    /**
     * The method to swap arr[i] and arr[j]
     * @param arr
     * @param i
     * @param j 
     */
    void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }    

}
