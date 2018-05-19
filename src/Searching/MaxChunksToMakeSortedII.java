/*
input : arr may not distinct
        split into chunks, sort individually, after concatenating, result equals to the sorted array
output: maximum # of chunks 
 * Thought Process:
 * GOT:
a new chunk <= all elements to the left <= all elements to the right (including)
               leftmax <= rightmin
 */
package Searching;

/**
 *
 * @author xinrong
 */
public class MaxChunksToMakeSortedII {

    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int[] maxOfLeft = new int[n];
        maxOfLeft[0] = arr[0];
        int[] minOfRight = new int[n];
        minOfRight[n - 1] = arr[n - 1];

        for (int i = 1; i < n; i++) {
            maxOfLeft[i] = Math.max(maxOfLeft[i - 1], arr[i]);
        }
        for (int i = n - 2; i >= 0; i--) {
            minOfRight[i] = Math.min(minOfRight[i + 1], arr[i]);
        }

        int maxChunks = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (maxOfLeft[i] <= minOfRight[i + 1]) {
                maxChunks++;
            }
        }
        return maxChunks + 1;
    }
}
