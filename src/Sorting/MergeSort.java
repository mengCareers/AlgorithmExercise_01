/*
 * Thought Process:
 * 
 */
package Sorting;

/**
 *
 * @author xinrong
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {6, 5, 3, 1, 2, 7, 8, 4};
        new MergeSort().sort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    void sort(int[] arr) {
        locate(arr, 0, arr.length - 1);
    }

    /**
     * Divide the arr
     *
     * @param arr
     * @param lo
     * @param hi
     */
    void locate(int[] arr, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int mid = (lo + hi) / 2;
        locate(arr, lo, mid);
        locate(arr, mid + 1, hi);
        mergesort(arr, lo, hi);
    }

    void mergesort(int[] arr, int lo, int hi) {
        int mid = (lo + hi) / 2;
        int[] tmp = new int[hi - lo + 1];
        int i = lo, j = mid + 1, k = 0;
        while (i <= mid && j <= hi) {
            if (arr[i] < arr[j]) {
                tmp[k] = arr[i++];
            } else {
                tmp[k] = arr[j++];
            }
            k++;
        }
        while (i <= mid) {
            tmp[k++] = arr[i++];
        }
        while (j <= hi) {
            tmp[k++] = arr[j++];
        }
        int m = lo;
        for (int n = 0; n < tmp.length; n++) {
            arr[m++] = tmp[n];
        }
    }
}
