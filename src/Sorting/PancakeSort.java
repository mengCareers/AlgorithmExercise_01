/*
 * Thought Process:
 * 
 */
package Sorting;

/**
 *
 * @author xinrong
 */
public class PancakeSort {
    
    public static void main(String[] args) {
        int[] arr = {6, 5, 3, 1, 2, 7, 8, 4};
        new PancakeSort().pancakeSort(arr);
        for(int i : arr)
            System.out.print(i + " ");
    }
    
    void pancakeSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = findMinIdx(arr, i, arr.length - 1);
            flip(arr, i, min);
//            for(int z : arr) 
//                System.out.print(z + " ");
//            System.out.println();
        }
    }
    
    /**
     * The method to flip the array from index lo to hi (both inclusive)
     * @param arr
     * @param lo
     * @param hi 
     */
    void flip(int[] arr, int lo, int hi) {
        while (lo <= hi) {
            swap(arr, lo++, hi--);
        }
    }
    
    /**
     * The method to find the index of the minimum value in the array from index lo to hi (both inclusive)
     * @param arr
     * @param lo
     * @param hi
     * @return the index of the minimum value
     */
    int findMinIdx(int[] arr, int lo, int hi) {
        int min = arr[lo];
        int minIdx = lo;
        for (int i = lo + 1; i <= hi; i++) {
            if (arr[i] < min) {
                min = arr[i];
                minIdx = i;
            }
        }
        return minIdx;
    }
    
    /**
     * The method to swap arr[i] with arr[j]
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
