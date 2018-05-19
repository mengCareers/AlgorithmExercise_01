/* 747.Largest Number At Least Twice Of Others
input : nums
output: true if largest element is at least twice as much as every other number
 * Thought Process:
 * sort the array, get the max, and check from the right, if one is ok, ok
 */
package Searching;

import java.util.Arrays;

/**
 *
 * @author xinrong
 */
public class LargestNumberAtLeastTwiceOfOthers {

    public int dominantIndex(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int[] hash = new int[101];
        for (int i = 0; i < nums.length; i++) {
            hash[nums[i]] = i;
        }
        Arrays.sort(nums);
        int largest = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] * 2 > largest) {
                return -1;
            }
        }
        return hash[largest];
    }
}
