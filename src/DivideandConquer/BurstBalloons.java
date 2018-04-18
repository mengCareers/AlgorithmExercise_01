/*
    [Reverse Thinking]
        The EndState will be:
            nums[-1] * nums[K] * nums[n] // the number of coins collected when the last baloon burst
        Then :
            nums[start]         ...       nums[K]  ...  nums[end]
                       LEFT             <-  |  ->   RIGHT
            total number of coins collected should be 
                    total number of coins collected in part LEFT  
                        + total number of coins collected in part RIGHT
                        + nums[-1] * nums[K] * nums[n]
    [Divide and Conquer]
        LEFT part :
            nums[start] ... nums[LK] ...  nums[K] 
               LLEFT        <- | ->  LRIGHT     
            total number of coins collected in part LEFT should be
                    total number of coins collected in part LLEFT
                        + total number of coins collected in part LRIGHT
                        + nums[-1] * nums[LK] * nums[n]

        RIGHT part : ...same
 */
package DivideandConquer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author xinrong
 */
public class BurstBalloons {

    public static int maxCoins(int[] nums) {
        int[] nnums = new int[nums.length + 2];
        nnums[0] = 1;
        nnums[nnums.length - 1] = 1;
        int ni = 1;
        for (int num : nums) {
            nnums[ni++] = num;
        }
        int[][] memo = new int[nnums.length][nnums.length];
        return maxCoinsUtil(memo, 1, nnums.length - 2, nnums);
    }

    private static int maxCoinsUtil(int[][] memo, int start, int end, int[] nums) {
        if (start > end) {
            return 0;
        }
        if (memo[start][end] > 0) {
            return memo[start][end];
        }
        for (int i = start; i <= end; i++) {
            int tmp = nums[start - 1] * nums[i] * nums[end + 1] + maxCoinsUtil(memo, start, i - 1, nums) + maxCoinsUtil(memo, i + 1, end, nums);
            memo[start][end] = Math.max(memo[start][end], tmp);
        }
        return memo[start][end];
    }
    
    static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        int[] nums = {3, 1, 5, 8};
        int ans = maxCoins(nums);
        System.out.println(ans);
    }

    public static int maxCoinsTLE(int[] nums) {
        int curlen = nums.length;
        if (curlen == 0) {
            return 0;
        }
        if (curlen == 1) {
            return nums[0];
        }
        if (curlen == 2) {
            return nums[0] * nums[1] + Math.max(nums[1], nums[0]);
        }

        int maxv = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int[] newnums = constructNewNums(i, nums);
            //printArr(newnums);
            int calv = 0;
            int newv = (i - 1 < 0 ? 1 : nums[i - 1]) * nums[i] * (i + 1 > nums.length - 1 ? 1 : nums[i + 1]);
            if (map.get(Arrays.toString(newnums)) != null) {
                calv = map.get(Arrays.toString(newnums));
            }
            if (calv == 0) {
                calv = maxCoins(newnums);
                map.put(Arrays.toString(newnums), calv);
            }
            newv += calv;
            if (maxv < newv) {
                maxv = newv;
            }

        }
        return maxv;
    }

    private static int[] constructNewNums(int woi, int[] nums) {
        int[] newnums = new int[nums.length - 1];
        int ni = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == woi) {
                continue;
            }
            newnums[ni++] = nums[i];
        }
        return newnums;
    }
}
