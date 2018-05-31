package DynamicProgramming;

import java.util.Arrays;

/*
 *  Q:64. Minimum Path Sum
 */
/**
 *
 * @author xinrong
 */
public class MinimumPathSum {

    /*
It is matrix related, so most likely to be two-dimensional dp,
since we aim to find (0, 0) to (m - 1, n - 1) min path sum,
we define state dp[i][j] : (0, 0) to (i, j) min path sum, 0 <= i <= m - 1, 0 <= j <= n - 1
then out aim is dp[m - 1][ n - 1]
state will transform as below :
dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
We can implement that in either Recursion + Memorization or Bottom-up DP way.
    Recursion + Memorization is as below :

    Bottom-up DP is as below :
Attention: we want to escape extra 'if's to avoid corner cases, so we make dp[grid.length + 1][grid[0].length + 1] rather than dp[grid.length][grid[0].length], now the values of the first row and the first column in dp[][] do not make sense. However, we still need to take care of them in case that they affect the states depending on them.
e.g.
dp[1][3] = grid[0][2] + Math.min(dp[0][3], dp[1][2]);
In this case, dp[0][3] ought to be ignored. So we set dp[0][3] to be Integer.MAX_VALUE, then it will never be used.
Other values of the first row and the first column should be set to Integer.MAX_VALUE for the same reason.
Except for dp[0][0], why ?
dp[1][1] = grid[0][0] + Math.min(dp[0][1], dp[1][0]);
dp[0][1] and dp[1][0] are set to Integer.MAX_VALUE, so dp[1][1] will be out of bounds.
Obviously, dp[1][1] should be grid[0][0] only, we simply set it to grid[0][0]
    
    Or even better, we make it one-dimensional,
for we are promised to fill in the dp[][] array row by row, column by column, and for dp[i][j], we only use its left and upper value， dp【i】 is upper value, dp[i - 1] is left value
dp[i] = grid[r - 1][i - 1] + Math.min(dp【i】, dp[i - 1]);
     */
    private static int[][] memo;

    public int minPathSum(int[][] grid) {
        memo = new int[grid.length][grid[0].length];
        return minPathSum(grid, grid.length - 1, grid[0].length - 1);
    }

    private static int minPathSum(int[][] grid, int i, int j) {
        if (memo[i][j] > 0) {
            return memo[i][j];
        }
        if (i == 0 && j == 0) {
            return grid[i][j];
        }
        if (i == 0) {
            return grid[i][j] + minPathSum(grid, i, j - 1);
        }
        if (j == 0) {
            return grid[i][j] + minPathSum(grid, i - 1, j);
        }
        memo[i][j] = grid[i][j] + Math.min(minPathSum(grid, i - 1, j), minPathSum(grid, i, j - 1));
        return memo[i][j];
    }

    public int minPathSum_02(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            dp[i][0] = Integer.MAX_VALUE;
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 && j == 1) {
                    dp[i][j] = grid[i - 1][j - 1];
                    continue;
                }
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1];
            }
        }
        return dp[m][n];
    }

    public int minPathSum_03(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 && j == 1) {
                    dp[j] = grid[i - 1][j - 1];
                    continue;
                }
                dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i - 1][j - 1];
            }
        }
        return dp[n];
    }
}
