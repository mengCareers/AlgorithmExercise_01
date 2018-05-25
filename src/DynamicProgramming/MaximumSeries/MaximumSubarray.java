package DynamicProgramming.MaximumSeries;

/* 53. Maximum Subarray
The problem is to get the sum of the maximum subarray among nums[0 .. n - 1]
If we define the state as dp[i], the sum of the maximum subarray among nums[0 .. i], it will be hard to describe the state transformation.
So we try defining the state as dp[i], the sum of the maximum subarray among nums[0 .. i] ended at nums[i].
Then, the result should be max(dp[i]) for 0 <= i <= n - 1.
States will transform as below :
If we stand at nums[i], nums[i] can be counted as either the end of the previous subarray, or it can be the start of a new subarray. We should choose the one can get bigger subarray sum among nums[0 .. i] ended at nums[i]
dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
Meanwhile, we keep track of the maximum subarray sum on the fly.
maxSub = Math.max(maxSub, dp[i]);
To implement the idea above, we apply bottom-up DP as below: * 
 */
/**
 *
 * @author xinrong
 */
public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return Integer.MIN_VALUE;
        }
        if (n == 1) {
            return nums[0];
        }
        int maxSub = Integer.MIN_VALUE;
        int[] dp = new int[n];
        dp[0] = nums[0];
        maxSub = Math.max(maxSub, dp[0]);
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            maxSub = Math.max(maxSub, dp[i]);
        }
        return maxSub;
    }

    public static void main(String[] args) {
        MaximumSubarray inst = new MaximumSubarray();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int sum = inst.maxSubArray(nums);
        System.out.println(sum);
    }
}
