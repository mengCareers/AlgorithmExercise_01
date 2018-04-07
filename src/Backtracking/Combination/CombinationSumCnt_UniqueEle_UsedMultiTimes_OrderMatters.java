/* DP INSTEAD OF BACKTRACKING
377. Combination Sum IV
Given a set of candidate numbers (C) (without duplicates) and a target number (T), 
find all unique combinations in C where the candidate numbers sums to T.
 * Thought Process:
same elements in different order is counted as DIFFERENT combinationS

e.g.
nums = [1, 2, 3]
target = 4

The possible combination ways are:
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)

return # of solutions
 * Thought Process:
 * 完全背包问题 ： dp[i][v] =Max( dp[i - 1][v]，dp[i][v - w[i]] + c[i] )
 * 体积为v，i种物品，每种无限件
 *      v - target
 *      i - nums.length
 * !不涉及价值最大化，比背包问题简单
 * It is a coin change problem
 */
package Backtracking.Combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author xinrong
 */
public class CombinationSumCnt_UniqueEle_UsedMultiTimes_OrderMatters {

    public static void main(String[] args) {
        int[] nums = {2, 3, 5, 6};
        int target = 10;
        int ans = combinationSum4_OrderMatters(nums, target);
        System.out.println(ans);
    }

    public static int combinationSum4_OrderMatters(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int j = 1; j < dp.length; j++) {
            for (int i = 0; i < nums.length; i++) {
                if (j < nums[i]) {

                } else {
                    dp[j] += dp[j - nums[i]];
                }
            }
        }
        for (int i : dp) {
            System.out.print(i + ", ");
        }
        System.out.println();
        return dp[dp.length - 1];
    }













//  
//                       .::::.  
//                     .::::::::.  
//                    :::::::::::  
//                 ..:::::::::::'  TLE
//              '::::::::::::'  
//                .::::::::::  
//           '::::::::::::::..  
//                ..::::::::::::.  
//              ``::::::::::::::::  
//               ::::``:::::::::'        .:::.  
//              ::::'   ':::::'       .::::::::.  
//            .::::'      ::::     .:::::::'::::.  
//           .:::'       :::::  .:::::::::' ':::::.  
//          .::'        :::::.:::::::::'      ':::::.  
//         .::'         ::::::::::::::'         ``::::.  
//     ...:::           ::::::::::::'              ``::.  
//    ```` ':.          ':::::::::'                  ::::..  
//                       '.:::::'                    ':'````..    

    /**
     * IF DIF ORDER COUNTED AS DIF COMBS JUST EMULATE
     *
     * @param nums
     * @param target
     * @return
     */
    public static int combinationSum4_OrderMattersTLE(int[] nums, int target) {
        if (target == 0) {
            return 1;
        } else if (target < 0) {
            return 0;
        } else {
            int res = 0;
            for (int i = 0; i < nums.length; i++) {
                res += combinationSum4_OrderMattersTLE(nums, target - nums[i]);
            }
            return res;
        }
    }

    /**
     * IF DIF ORDER COUNTED AS ONE COMB
     *
     * @param nums
     * @param target
     * @return
     */
    public static int combinationSum4_OrderNotMatter(int[] nums, int target) {
        int[][] dp = new int[nums.length + 1][target + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (j < nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - nums[i - 1]];
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }

//  
//                       .::::.  
//                     .::::::::.  
//                    :::::::::::  
//                 ..:::::::::::'  TLE
//              '::::::::::::'  
//                .::::::::::  
//           '::::::::::::::..  
//                ..::::::::::::.  
//              ``::::::::::::::::  
//               ::::``:::::::::'        .:::.  
//              ::::'   ':::::'       .::::::::.  
//            .::::'      ::::     .:::::::'::::.  
//           .:::'       :::::  .:::::::::' ':::::.  
//          .::'        :::::.:::::::::'      ':::::.  
//         .::'         ::::::::::::::'         ``::::.  
//     ...:::           ::::::::::::'              ``::.  
//    ```` ':.          ':::::::::'                  ::::..  
//                       '.:::::'                    ':'````..    
    static int cnt = 0;

    public static int combinationSum4TLE(int[] nums, int target) {
        cnt = 0;
        if (nums == null || nums.length == 0) {
            return cnt;
        }
        Arrays.sort(nums);
        getCombUtil(nums, target, new ArrayList<>());
        return cnt;
    }

    private static void getCombUtil(int[] candidates, int target, List<Integer> curRes) {
        if (target == 0) {
            cnt++;
        } else if (target < 0) {

        } else {
            for (int i = 0; i < candidates.length; i++) {
                if (target < candidates[i]) {
                    break;
                }
                curRes.add(candidates[i]);
                getCombUtil(candidates, target - candidates[i], curRes);
                curRes.remove(curRes.size() - 1);
            }
        }
    }
}
