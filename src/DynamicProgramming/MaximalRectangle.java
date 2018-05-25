/* 85. Maximal Rectangle
input : a 2D binary matrix filled with 0's and 1's
output: area of the largest rectangle containing only 1's
 * Thought Process:
The problem is to get the max(right[i] - left[i]) * height[i] 
If we define STATEs 
    left[i] as the left boundary of histogram columns
    right[i] as the right boundary of histogram columns
    height[i] is the height of histogram columns
Then the END STATE, i.e., AIM STATE is max(dp[i])    
STATE TRANSFER as below :
  if mat[i][j] = '1'
    left[i] = max(left[i - 1], cur_left)
    right[i] = min(right[i - 1], cur_right)
    height[i] = height[i - 1] + 1 
  if mat[i] = '0'
    all = 0
    

 * 
 */
package DynamicProgramming;

import java.util.Arrays;

/**
 *
 * @author xinrong
 */
public class MaximalRectangle {

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int rows = matrix.length, cols = matrix[0].length;
        int[] left = new int[cols];
        int[] right = new int[cols];
        Arrays.fill(right, cols);
        int[] height = new int[cols];
        int maxVal = 0;

        for (int i = 0; i < rows; i++) {
            int curLeft = 0, curRight = cols;
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    height[j]++;
                    left[j] = Math.max(left[j], curLeft);
                } else {
                    height[j] = 0;
                    left[j] = 0;
                    curLeft = j + 1;
                }
            }
            for (int j = cols - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    right[j] = Math.min(right[j], curRight);
                } else {
                    right[j] = cols;
                    curRight = j; // j - 1 in fact
                }
            }
            for (int j = 0; j < cols; j++) {
                maxVal = Math.max(maxVal, (right[j] - left[j]) * height[j]);
            }
        }
        return maxVal;
    }
}
