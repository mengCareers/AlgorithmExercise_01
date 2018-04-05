package DynamicProgramming.MaximumSeries;

/* 53. Maximum Subarray
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.

 * Thought Process:
if Exhaustive Search, [-2, 1, -3]
power set, and get max sum on the fly NONONO, SHOULD BE CONSECUTIVE
which should be 2 ^ n cases NONONO
e.g. 1 -2 3 -4 5 6
 * 
 */

/**
 *
 * @author xinrong
 */
public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int[] tmp = new int[nums.length + 1];
        tmp[0] = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 1; i < tmp.length; i++) {
            tmp[i] = Math.max(tmp[i - 1] + nums[i - 1], nums[i - 1]);
            if (maxSum < tmp[i]) {
                maxSum = tmp[i];
            }
        }
        return maxSum;
    }
}
