/*
Q: 164. Maximum Gap
unsorted arr
maximum gap between two adjacent elements
Get: logn 快于 n 快于 nlogn
     mergeSort, heapSort, quickSort cant do bettern than nlogn
     cntSort is n, O(n + k) when elements range 1 to k
        what if range 1 to n2?
     radixSort digit *(n + b), to replace Arrays.sort
     
Sort - can use Radix Sort based on Count Sort
and iterate
 */
package Sorting;

import java.util.Arrays;

/**
 *
 * @author xinrong
 */
public class MaximumGap {

    public int dif(int[] A) {
        if (A == null || A.length <= 1) {
            return 0;
        }
        Arrays.sort(A);
        int maxgap = 0;
        for (int i = 0; i < A.length - 1; i++) {
            int curgap = A[i + 1] - A[i];
            if (curgap > maxgap) {
                maxgap = curgap;
            }
        }
        return maxgap;
    }

    public static void main(String[] args) {
        int[] A = {1,10000000};
        int ans = new MaximumGap().dif(A);
        System.out.println(ans);
    }
}
