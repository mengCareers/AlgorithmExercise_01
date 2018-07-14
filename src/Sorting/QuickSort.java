/*
 * Get :
+ partitionPivotHi:   wall = lo - 1;
    loop starts from wall,
    SWAP  1st num <= pivot on the right of wall 
    WITH  1st num >  pivot on the left  of wall
+ partitionPivotLo:   wall = hi + 1;
    loop starts from wall,
    SWAP  1st num >  pivot on the left  of wall
    WITH  1st num <= pivot on the right of wall 
+ threeWayPartition
    Best when there are many duplicates in arr
  v is the val of pivot, we enable [lo, lt-1] < v
                                 [lt, i-1] = v
                                 [i, gt] x
                                 [gt+1, hi] > v
                                 v is at the right point
    if a[i] < v, swap(a, lt++, i++);
    if a[i] > v, swap(a, gt--, i);
    if a[i] == v, i++;
    we manage to shrink [i,gt], and skip element equals to pivot

 */
package Sorting;

/**
 *
 * @author xinrong
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {6, 5, 3, 1, 2, 7, 8, 4};
        new QuickSort().quickSort(arr);
        for (int i : arr)
            System.out.print(i + " ");
    }
    
    void quickSort(int[] arr) {
        quickSortUtil(arr, 0, arr.length - 1);
    }
    
    void quickSortUtil(int[] arr, int lo, int hi) {
        if (lo < hi) {
            // int wall = partitionPivotHi(arr, lo, hi);
            // int wall = partitionPivotLo(arr, lo, hi);
            // int wall = partitionPivotLoUpgrade(arr, lo, hi);
            int wall = threeWayPartition(arr, lo, hi);
            quickSortUtil(arr, lo, wall - 1);
            quickSortUtil(arr, wall + 1, hi);
        }
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
            while (arr[++i] < pivot)
                if (i == hi)
                    break;
            while (arr[--wall] >= pivot)
                if (wall == lo)
                    break;
            if (i >= wall)
                break;
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
