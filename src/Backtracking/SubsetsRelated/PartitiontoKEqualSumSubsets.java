/* 698. Partition to K Equal Sum Subsets
Given an array of integers nums and a positive integer k, 
find whether it's possible to divide this array into k non-empty subsets whose sums are all equal.
Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4
Output: True
Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.

* Thought Process:
For each number in nums, 
we could add it into one of k group-sums as long as the group's sum would not exceed the targetSum
true if this action can enable the rest can all to 各得其所

It's okay to Exhaustive Search, however, it's better to exclude impossible AND tidy-up before the work
 */
package Backtracking.SubsetsRelated;

import java.util.Arrays;

/**
 *
 * @author xinrong
 */
public class PartitiontoKEqualSumSubsets {

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int ni : nums) {
            sum += ni;

        }
        int targetSum = sum / k;
        // tidy
        Arrays.sort(nums);
        int ri = nums.length - 1;
        if (nums[ri] > targetSum) {
            return false;
        }
        while (nums[ri] == targetSum) {
            ri--;
            k--;
        }
        int[] groups = new int[k];
        return search(groups, nums, ri, targetSum);
    }

    // true if nums[ri] can be put in one of groups to make each group[i] == target sum
    private boolean search(int[] groups, int[] nums, int ri, int targetSum) {
        if (ri < 0) {
            return true;// as long as can 各得其所
        }
        for (int i = 0; i < groups.length; i++) {
            if (groups[i] + nums[ri] <= targetSum) {
                groups[i] += nums[ri];
                if (search(groups, nums, ri - 1, targetSum)) {
                    return true;
                }
                groups[i] -= nums[ri];
            }
        }
        return false;
    }
}
