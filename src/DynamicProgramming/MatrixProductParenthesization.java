/*
 * Thought Process:
 * 
 */
package DynamicProgramming;

/**
 *
 * @author xinrong
 */
public class MatrixProductParenthesization {

    // Driver program to test above function
    public static void main(String args[]) {
        int arr[] = new int[]{1, 2, 3, 4};
        int size = arr.length;

        System.out.println("Minimum number of multiplications is "
                + getMinimumMultiply(arr, size));
        System.out.println("Minimum number of multiplications is "
                + getMinimumMultiply(arr, 1, size - 1));
        
    }

    public static int getMinimumMultiply(int[] p, int n) {
        int[][] dp = new int[n][n];
        for (int k = 2; k < n; k++) {
            for (int i = 1; i + k - 1 < n; i++) {
                int j = i + k - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int x = i; x <= j - 1; x++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][x] + dp[x + 1][j] + p[i - 1] * p[x] * p[j]);
                }
            }
        }
        return dp[1][n - 1];
    }

    /**
     * Given an array p[] which represents the chain of matrices such that the
     * ith matrix Ai is of dimension p[i-1] x p[i]
     *
     * @param p
     * @param i
     * @param j
     * @return
     */
    public static int getMinimumMultiply(int[] p, int i, int j) {
        if (i == j) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int cnt = getMinimumMultiply(p, i, k) + getMinimumMultiply(p, k + 1, j) + p[i - 1] * p[k] * p[j];
            if (cnt < min) {
                min = cnt;
            }
        }
        return min;
    }

}
