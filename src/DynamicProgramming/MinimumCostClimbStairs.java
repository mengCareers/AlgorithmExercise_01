/*
 * Thought Process:
dp[j] from 0 to j min cost
return dp[cost.length - 1]
dp[j] =  MIN(
if we not climb to jth step
    dp[j - 1]
if we climb to jth step
    min(dp[j - 2], dp[j - 1]) + cost[j] )

 * 
 */
package DynamicProgramming;

/**
 *
 * @author xinrong
 */
public class MinimumCostClimbStairs {

    public static int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        dp[0] = 0;
        dp[1] = cost[0];
        dp[2] = cost[1];

        for (int i = 3; i < dp.length; i++) {
            if (i == dp.length - 1) {
                dp[i] = Math.min(dp[i - 2] + cost[i - 1], dp[i - 1]);
            } else {
                dp[i] = Math.min(dp[i - 2] + cost[i - 1], dp[i - 1] + cost[i - 1]);
            }
        }

        for (int i : dp) {
            System.out.print(i + " ");
        }
        System.out.println();
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        int[] cost = {2, 3, 1, 5, 6, 4};
        System.out.println(minCostClimbingStairs(cost));
    }
}
