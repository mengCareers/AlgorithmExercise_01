/* 643. Maximum Average Subarray I
Given an array consisting of n integers, 
find the contiguous subarray of given length k that has the maximum average value. 
And you need to output the maximum average value.
 * Thought Process:
 * 
 */
package TwoPtrs;

/**
 *
 * @author xinrong
 */
public class MaximumAvgSubarrI {

    public double findMaxAverage(int[] nums, int k) {
        int ksum = 0;
        int i = 0;
        for (; i < k; i++) {
            ksum += nums[i];
        }
        int maxSum = ksum;
        while (i < nums.length) {
            ksum -= nums[i - k];
            ksum += nums[i];
            maxSum = Math.max(maxSum, ksum);
            i++;
        }
        return (double) maxSum / k;
    }
}
