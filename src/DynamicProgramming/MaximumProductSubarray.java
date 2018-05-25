/* 152.Maximum Product Subarray
input : nums
output: maximum product subarray's product
 * Thought Process:
The problem is to find the maximum product subarray among nums[0..n-1] 
If we define STATE maxdp[i] as maximum product subarray among nums[0..i-1] ended at nums[i-1]
Then our END STATE is maxdp[n] as maximum product subarray among nums[0..n-1] ended at nums[n-1]

WAIT, WE DON'T REALLY ALWAYS WANT THE maximum product subarray but minimum product subarray

If we define STATE mindp[i] as minimum product subarray among nums[0..i-1] ended at nums[i-1]
Then our END STATE is mindp[n] as minimum product subarray among nums[0..n-1] ended at nums[n-1]

Then our AIM is max(maxdp[i]) (0 <= i <= n-1)

STATE TRANSFER as below :
    if we stand at nums[i-1], we can 
        either be counted as end of previous subarray 
             maxdp[i] = maxdp[i - 1] * nums[i - 1]
                        || mindp[i - 1] * nums[i - 1]
        or be counted as start of new subarray
             maxdp[i] = nums[i - 1]       
    We choose the biggest among them
        maxdp[i] = max(maxdp[i - 1] * nums[i - 1], mindp[i - 1] * nums[i - 1], nums[i - 1])

    if we stand at nums[i-1], we can 
        either be counted as end of previous subarray 
             mindp[i] = mindp[i - 1] * nums[i - 1]
                        || maxdp[i - 1] * nums[i - 1]
        or be counted as start of new subarray
             min[i] = nums[i - 1]
    We choose the smallest among them
        mindp[i] = min(mindp[i - 1] * nums[i - 1], maxdp[i - 1] * nums[i - 1], nums[i - 1])

    we keep track of the biggest maxdp[i] on the fly

    Attention that maxdp[i] depends on mindp[i-1] and mindp[i] depends on maxdp[i-1],
    it's better for us to build them at the same time
 */
package DynamicProgramming;

/**
 *
 * @author xinrong
 */
public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] maxdp = new int[n + 1];
        int[] mindp = new int[n + 1];
        int maxVal = Integer.MIN_VALUE;
        maxdp[0] = 1;
        mindp[0] = 1;
        for (int i = 1; i < n + 1; i++) {
            maxdp[i] = Math.max(maxdp[i - 1] * nums[i - 1], Math.max(mindp[i - 1] * nums[i - 1], nums[i - 1]));
            mindp[i] = Math.min(mindp[i - 1] * nums[i - 1], Math.min(maxdp[i - 1] * nums[i - 1], nums[i - 1]));
            maxVal = Math.max(maxVal, maxdp[i]);
        }
        return maxVal;
    }
}
