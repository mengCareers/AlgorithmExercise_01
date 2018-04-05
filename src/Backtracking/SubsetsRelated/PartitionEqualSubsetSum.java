/*
Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
 * Thought Process:
 * tuning by 
 */
package Backtracking.SubsetsRelated;

import java.util.Arrays;

/**
 *
 * @author xinrong
 */
public class PartitionEqualSubsetSum {

    public static void main(String[] args) {
        int[] nums = {1, 1, 4};
        int cnt = 0;
        for (int i : nums) {
            if (i == 1) {
                cnt++;
            }
        }
        System.out.println(cnt);
        new PartitionEqualSubsetSum().canPartition(nums);
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int ni : nums) {
            sum += ni;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int targetSum = sum / 2;
        Arrays.sort(nums);
        return search(nums, targetSum, 0);
    }

    private boolean search(int[] nums, int targetSum, int st) {
        if (targetSum == 0) {
            return true;
        }
        for (int i = st; i < nums.length; i++) {

            if (nums[i] <= targetSum) {
                if (search(nums, targetSum - nums[i], i + 1)) {
                    return true;
                }
            }
            i++;
            while (i > 0 && i < nums.length && nums[i] == nums[i - 1]) {
                i++;
            }
            i--;
        }
        return false;
    }
}
