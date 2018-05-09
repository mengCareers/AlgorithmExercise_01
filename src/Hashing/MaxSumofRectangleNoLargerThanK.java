/* 363. Max Sum of Rectangle No Larger Than K
Given a non-empty 2D matrix matrix and an integer k, 
find the max sum of a rectangle in the matrix such that its sum is no larger than k.
Given matrix = [
  [1,  0, 1],
  [0, -2, 3]
]
k = 2
The answer is 2. 
Because the sum of rectangle [[0, 1], [-2, 3]] is 2 and 2 is the max number no larger than k (k = 2).
 * Thought Process:
 * sum each submatrix and find the biggest one no larger than k
 * Get:
for row i
   for row j where j <= i
	   for col k
		    update  sumPerCol
			    sumCurMatrix
			    subRes
		    update result = sumCurMatrix - subRes
 */
package Hashing;

import java.util.TreeSet;

/**
 *
 * @author xinrong
 */
public class MaxSumofRectangleNoLargerThanK {

    public int maxSumSubmatrix(int[][] matrix, int target) {
        int result = Integer.MIN_VALUE;
        int rows = matrix.length, cols = matrix[0].length;
        if (rows == 0) {
            return 0;
        }
        for (int i = 0; i < rows; i++) {
            int[] sumPer = new int[cols];
            for (int j = i; j >= 0; j--) {
                int sumCur = 0;
                TreeSet<Integer> sumSet = new TreeSet<>();
                sumSet.add(0);
                for (int k = 0; k < cols; k++) {
                    sumPer[k] += matrix[j][k];
                    sumCur += sumPer[k];
                    Integer subRes = sumSet.ceiling(sumCur - target);
                    if (subRes != null) {
                        result = Math.max(result, sumCur - subRes);
                    }
                    sumSet.add(sumCur);
                }
            }
        }
        return result;
    }
}
