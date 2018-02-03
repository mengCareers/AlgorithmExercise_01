/*
 * Thought Process:
 * 
 */
package Searching;

/**
 *
 * @author xinrong
 */
public class WiggleSortLinearNoDup {

    public static void main(String[] args) {
        int[] a = {5, 8, 3, 2, -1};
        new WiggleSortLinearNoDup().waveSort(a);
        for (int i : a) {
            System.out.print(i + " ");
        }
    }

    /**
     * To sort unsorted arr[] in Wave form in O(n). Assume there are no duplicates 
     * @param arr 
     */
    void waveSort(int[] arr) {
        int i = 0;
        boolean flag = true; // set flag true if we want the 1st to be smaller than the 2nd one
                            
        while (i < arr.length - 1) {
            if (!flag) {
                if (arr[i + 1] > arr[i]) {
                    swap(arr, i, i + 1);
                }
            }
            else {
                if (arr[i + 1] < arr[i]) {
                    swap(arr, i, i + 1);
                }
            }
            flag = !flag;
            i++;
        }
    }

    /**
     * To swap arr[i] and arr[j]
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
