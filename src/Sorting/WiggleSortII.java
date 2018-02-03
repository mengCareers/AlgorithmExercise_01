package Sorting;


import java.util.Arrays;

/* 324.Wiggle Sort II
input : nums
output: nums sorted wigglely, that is, a < b > c < d > e
 * Thought Process:
e.g. 1 5 1 1 6 4
if 3-way-partition quick sort, will be 1 1 1 4 5 6
 * Get:
e.g. 1 2 3 4 5 6
aim  3 6 2 5 1 4
idx  2 5 1 4 0 3
to achieve aim, mid = 3
     2 x 1 y 0 z
       5   4   3
How about len 7?  1 2 3 4 5 6 7
mid = 3,
idx 3 x 2 y 1 z 0
      6   5   4  
 * 
 */

/**
 *
 * @author xinrong
 */
public class WiggleSortII {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 4, 5, 6};
        new WiggleSortII().wiggleSort(nums);
        for (int i : nums)
            System.out.print(i + " ");
    }
    
    public void wiggleSort(int[] nums) {
        int len = nums.length;
        int mid = len % 2 == 0 ? len / 2 - 1 : len / 2;
        quickSortUtil(nums, 0, len - 1);
        int[] tmp = Arrays.copyOf(nums, len);
        int idx = 0;
        for (int i = 0; i <= mid; i++) {
            nums[idx] = tmp[mid - i];
            if (idx + 1 < len)
                nums[idx + 1] = tmp[len - i - 1];
            idx += 2;
//            for (int j : nums) {
//                System.out.print(j + " ");
//            }
//            System.out.println();
        }
    }   
    
    void quickSortUtil(int[] arr, int lo, int hi) {
        if (lo < hi) {
            int wall = threeWayPartition(arr, lo, hi);
            quickSortUtil(arr, lo, wall - 1);
            quickSortUtil(arr, wall + 1, hi);
        }
    }
    
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
    
    void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
