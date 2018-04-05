/* dp降维度
152. Maximum Product Subarray
 * Thought Process:
 * 
 */
package DynamicProgramming.MaximumSeries;

/**
 *
 * @author xinrong
 */
public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        int min = 1;
        int max = 1;
        int lastmin = 0;
        int lastmax = 0;
        int res = Integer.MIN_VALUE;
        // Since, tmp[i] only compare to its previous status
        for (int i = 1; i < nums.length + 1; i++) {
            lastmin = min;
            lastmax = max;
            min = Math.min(min * nums[i - 1], nums[i - 1]);
            max = Math.max(max * nums[i - 1], nums[i - 1]);
            if (nums[i - 1] < 0) {
                max = Math.max(lastmin * nums[i - 1], max);
                min = Math.min(lastmax * nums[i - 1], min);
            }
            res = Math.max(res, max);
        }
        return res;
    }
}
