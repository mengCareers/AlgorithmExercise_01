/* 378. Kth Smallest Element in a Sorted Matrix
input : matrix with duplicates, k
output: kth smallest element
 * Thought Process:
 * eac of the rows and cols are sorted in ascending order means:
    [1, 2]
    [1, 3]
 */
package Searching;

import java.util.Arrays;

/**
 *
 * @author xinrong
 */
public class KthSmallestEleinSortedMatrix {

    public int kthSmallest(int[][] matrix, int k) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        // int row = (k - 1) / rows;
        // int col = (k - 1) % rows;
        // return matrix[row][col];
        int[] tmp = new int[rows * cols];
        int ti = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                tmp[ti++] = matrix[i][j];
            }
        }
        Arrays.sort(tmp);
        return tmp[k - 1];
    }
}
