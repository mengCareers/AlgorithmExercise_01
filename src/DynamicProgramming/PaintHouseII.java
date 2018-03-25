/*
 * Thought Process:
 * 
 */
package DynamicProgramming;

/**
 *
 * @author xinrong
 */
public class PaintHouseII {

    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        int cnthouses = costs.length;
        int cntcolors = costs[0].length;
        // dp[i][j] = min total cost for house i painted color j
        int[][] dp = new int[cnthouses][cntcolors];
        for (int i = 0; i < cntcolors; i++) {
            dp[0][i] = costs[0][i];
        }
        for (int i = 1; i < cnthouses; i++) {
            for (int j = 0; j < cntcolors; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int m = 0; m < cntcolors; m++) {
                    if (j != m) {
                        dp[i][j] = Math.min(dp[i - 1][m] + costs[i][j], dp[i][j]);
                    }
                }
            }
        }
        int mincost = Integer.MAX_VALUE;
        for (int i = 0; i < cntcolors; i++) {
            mincost = Math.min(mincost, dp[cnthouses - 1][i]);
        }
        return mincost;
    }
}
