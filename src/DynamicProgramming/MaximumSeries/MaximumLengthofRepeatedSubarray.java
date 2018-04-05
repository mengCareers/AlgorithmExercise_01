/*
Given two integer arrays A and B, return the maximum length of an subarray that appears in both arrays.

Example 1:
Input:
A: [1,2,3,2,1]
B: [3,2,1,4,7]
Output: 3
Explanation: 
The repeated subarray with maximum length is [3, 2, 1].

 * Thought Process:
Similar to LCS : Longest Common Substring
 * 
 */
package DynamicProgramming.MaximumSeries;

/**
 *
 * @author xinrong
 */
public class MaximumLengthofRepeatedSubarray {

    public int findLength(int[] A, int[] B) {
        int[][] tmp = new int[A.length + 1][B.length + 1];
        int maxLen = 0;
        for (int i = 1; i < tmp.length; i++) {
            for (int j = 1; j < tmp[0].length; j++) {
                if (A[i - 1] == B[j - 1]) {
                    tmp[i][j] = tmp[i - 1][j - 1] + 1;
                    if (maxLen < tmp[i][j]) {
                        maxLen = tmp[i][j];
                    }
                }
            }
        }
        return maxLen;
    }
}
