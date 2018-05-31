/* 312. Burst Balloons
input : nums (number spainted on balloons
        to burst all the balloons, 
        if burst balloon i, will get nums[left] * nums[i] * nums[right] coinst where left, right  are adjacent indices of i
output: maximum coins you can collect by 

 * Thought Process:
Firstly, we add a 1 to the start and the end of nums separately to form a new array nums, which we will use rather than the original nums.
The problem is the maximum coins we can get by bursting balloons from 1 to nums.length - 2.
If we define STATE dp[s][e] as the maximum coins we can get by bursting balloons from s to e (both inclusive), the AIM STATE is dp[1][nums.length - 2].
STATE TRANSFER as below :

Let's think about it reversely. 
The final step will always be : nums[s-1] * nums[k] * nums[e + 1]
nums[k] is chosen at the first step and it divides the balloons into 2 parts, [s, k-1] and [k+1, e].
So the equation is :
dp[s][e] = dp[s][k-1] + dp[k+1][e] + nums[s-1] * nums[k] * nums[e + 1]  (for s <= k <= e)

MENTOR:WHEN IT IS HARD TO IMAGINE HOW WE FILL INTO THE MATRIX, I.E., THE EQUATION IS COMPLICATED
       WE USE RECURSION, OR ELSE, YOU WILL BE CRAZY DOING WITH BOUNDARIES
 * 
 */
package DynamicProgramming;

/**
 *
 * @author xinrong
 */
public class BurstBalloons {

    public static void main(String[] args) {
        BurstBalloons inst = new BurstBalloons();
        int[] nums = {3, 1, 5, 8};
        inst.maxCoins(nums);
    }

    public int maxCoins(int[] nums) {
        int[] nnums = new int[nums.length + 2];
        nnums[0] = 1;
        nnums[nnums.length - 1] = 1;
        int ni = 1;
        for (int num : nums) {
            nnums[ni++] = num;
        }
        int[][] memo = new int[nnums.length][nnums.length];
        return maxCoinsRecur(memo, nnums, 1, nnums.length - 2);
    }

    private int maxCoinsRecur(int[][] memo, int[] nums, int start, int end) {
        if (start > end) {
            return 0;
        }
        if (memo[start][end] > 0) {
            return memo[start][end];
        }
        int maxVal = Integer.MIN_VALUE;
        for (int k = start; k <= end; k++) {
            maxVal = Math.max(maxVal, maxCoinsRecur(memo, nums, start, k - 1) + maxCoinsRecur(memo, nums, k + 1, end) + nums[start - 1] * nums[k] * nums[end + 1]);
        }
        memo[start][end] = maxVal;
        return maxVal;
    }
}
