package String;

/* 494. Target Sum
input  : 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.
output : # ways to assign symbols to make sum of integers equal to target S
e.g.
Input: nums is [1, 1, 1, 1, 1], S is 3. 
Output: 5
Explanation: 

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

There are 5 ways to assign symbols to make the sum of nums be target 3.
 * Thought Process:
for each num(node), with two edges + / -, keep running sum, until the leaf node, if S is 3, cnt ++
 * Get:
in util(), for () can be ignored, for the next step doesn't based on this step, we just try without trimming
 */

/**
 *
 * @author xinrong
 */
public class TargetSum {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int ans = new TargetSum().findTargetSumWays(nums, 3);
        System.out.println(ans);
    }

    int cnt = 0;

    public int findTargetSumWays(int[] nums, int S) {
        util(nums, S, 0, 0);
        return cnt;
    }

    private void util(int[] nums, int S, int curpos, int sum) {
        if (curpos == nums.length) {
            if (sum == S) {
                cnt++;
            }
            return;
        }

        util(nums, S, curpos + 1, sum - nums[curpos]);
        util(nums, S, curpos + 1, sum + nums[curpos]);
    }
}
