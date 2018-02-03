/* repeatly finding the minimum (ascending order) from unsorted part and put 
   maintain 2 subarrays (sorted, unsorted)
 * e.g. 64 25 12 22 11
 * 11 | 25 12 22 64
   11 12 | 25 22 64
   11 12 22 | 25 64
 */
package Sorting;

/**
 *
 * @author xinrong
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 1, 2, 3};
        new SelectionSort().sort(arr);
        for (int i : arr)
            System.out.print(i + " ");
    }
    
    public void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {  
            int minidx = findMinIdx(arr, i, arr.length - 1);
            if (minidx != i)
                swap(arr, i, minidx);           
        }
        
    }
    
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
    
    void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }    
}
