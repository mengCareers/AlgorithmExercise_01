/*  DP INSTEAD OF BACKTRACKING
    THAT IS COIN CHANGE
 * Thought Process:
 * 
 */
package Backtracking.Combination;

/**
 *
 * @author xinrong
 */
public class CombinationSumCnt_UniqueEle_UsedMultiTimes_OrderNotMatter {

    public static int combinationSum4_OrderNotMatter(int[] nums, int target) {
        int[][] dp = new int[nums.length + 1][target + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (j < nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - nums[i - 1]];
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
