/* 769.Max Chunks To Make Sorted
Given an array arr that is a permutation of [0, 1, ..., arr.length - 1], 
we split the array into some number of "chunks" (partitions), and individually sort each chunk.  
After concatenating them, the result equals the sorted array.
 * Thought Process:
if
 * 
 */
package Sorting;

/**
 *
 * @author xinrong
 */
public class MaxChunksToMakeSorted {

    public int maxChunksToSorted(int[] arr) {
        int chunks = 0;
        int curMax = 0;
        for (int i = 0; i < arr.length; i++) {
            curMax = Math.max(curMax, arr[i]);
            if (curMax == i) {
                chunks++;
            }
        }
        return chunks;
    }
}
