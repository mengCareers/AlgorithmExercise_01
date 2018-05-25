/* 198. House Robber
cannot rob two adjacent houses
input : nums
output: maximum amount of money able to rob
 * Thought Process:
The problem is to get the maximum amount of money able to rob from house 0 to n - 1 
If we define state dp[i] as the maximum amount of money able to rob from house 0 to i 
The end state will be dp[n - 1] as the maximum amount of money able to rob from house 0 to n - 1
State transfer : 
if we stand at nums[i], 
    we rob it,      dp[i] = dp[i - 2] + nums[i] 
    we not rob it,  dp[i] = dp[i - 1]
we choose the bigger one of it
    dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]) for 2 <= i <= n-1
    dp[0] = nums[0]
    dp[1] = Math.max(nums[1], dp[0])  
I : we fill in the dp array in order, 
and it relates to dp[i - 1], dp[i - 2] only
                  pre        prepre
if we stand at nums[i], 
    we rob it,      cur = prepre + nums[i] 
    we not rob it,  cur = pre
    cur = Math.max(prepre + nums[i] , pre) for 2 <= i <= n-1
    dp[0] = nums[0]
    dp[1] = Math.max(nums[1], dp[0]) 
 * 
 */
package DynamicProgramming;

/**
 *
 * @author xinrong
 */
public class HouseRobber {

    public int robOptimal(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int prepre = nums[0];
        int pre = Math.max(nums[1], prepre);
        int cur = pre;
        for (int i = 2; i < nums.length; i++) {
            cur = Math.max(prepre + nums[i], pre);
            prepre = pre;
            pre = cur;
        }
        return cur;
    }

    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1], dp[0]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }
}
