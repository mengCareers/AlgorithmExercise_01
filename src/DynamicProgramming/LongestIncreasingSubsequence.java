/*
 * Thought Process:
 * 
 */
package DynamicProgramming;

/**
 *
 * @author xinrong
 */
public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int lengthLIS = 0;
        for (int i = 0; i < dp.length; i++) {
            int maxDPj = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    maxDPj = Math.max(maxDPj, dp[j]);
                }
            }
            dp[i] = maxDPj + 1;
            lengthLIS = Math.max(lengthLIS, dp[i]);
        }
        return lengthLIS;
    }
}
