/* 279.
input : n
output : the least number of perfect square numbers wchich sum to n
 * Thought Process:
The problem is to get the least number of perfect square numbers which sum to n
If we define STATE dp[i] as the least number of perfect square numbers which sum to i
then FINAL STATE dp[n] as the least number of perfect square numbers which sum to n
STATE TRANSFER as below :
    standing at i, dp[i] = min(dp[i - 1*1] + 1, dp[i - 2*2] + 1, .., dp[i - j*j] + 1) for j*j <= i
    
We do exhaustive search,
    12 = 1 
We write down th transition equation and assign values:
    dp[0] = 0
    dp[1] = 1
    dp[2] = dp[1] + 1;
    dp[3] = dp[2] + 2
    dp[4] = min(dp[4 - 1*1] + 1, dp[4 - 2*2] + 1) = 1
    dp[5] = min(dp[5 - 1*1] + 1, dp[5 - 2*2] + 1) = 2
    .. 
    dp[9] = min(dp[9 - 1*1] + 1, dp[9 - 2*2] + 1, dp[9 - 3*3] + 1) = ...
    dp[i] = min(dp[i - 1*1] + 1, dp[i - 2*2] + 1, .., dp[i - j*j] + 1) for j*j <= i
 * 
 */
package DynamicProgramming;

/**
 *
 * @author xinrong
 */
public class PerfectSquares {

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int minVal = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                minVal = Math.min(minVal, dp[i - j * j] + 1);
            }
            dp[i] = minVal;
        }
        return dp[n];
    }
}
