/* 368.Largest Divisible Subset
Given a set of distinct positive integers,
find the largest subset such that every pair (Si,Sj)
satisfies Si % Sj = 0 or Sj % Si = 0
 * Thought Process:
if 1,2,3
1,2 valid
include 3 (i, j + 1
exclude 3 (i, j
 * Get:
dp[j + 1] = max ( 1 + dp[i]) if a[j + 1] % a[i] == 0 for 0 <= i <= j
else 1
 */
package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author xinrong
 */
public class LargestDivisibleSubset {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        if (nums.length == 1) {
            result.add(nums[0]);
            return result;
        }

        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        int[] parent = new int[nums.length];
        Arrays.fill(parent, -1);
        int largest = 0, largestAt = 0;

        dp[0] = 1;
        for (int j = 1; j < dp.length; j++) {
            dp[j] = 1;
            for (int i = j - 1; i >= 0; i--) {
                if (nums[j] % nums[i] == 0 && dp[j] < dp[i] + 1) {
                    dp[j] = dp[i] + 1;
                    parent[j] = i;
                }
            }
            if (dp[j] > largest) {
                largest = dp[j];
                largestAt = j;
            }
        }
        for (int i = 0; i < largest; i++) {
            result.add(0, nums[largestAt]);
            largestAt = parent[largestAt];
        }

        return result;
    }
}
