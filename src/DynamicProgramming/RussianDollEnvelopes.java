/* 354. Russian Doll Envelopes
You have a number of envelopes with widths and heights given as a pair of integers (w, h). 
One envelope can fit into another if and only if both the width and height of one envelope 
is smaller than the width and height of the other envelope.
Given envelopes = [[5,4],[6,4],[6,7],[2,3]], the maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
 * Thought Process:
the fit order matters, we cab backtrack, even better, we can dp
GET :
 * Sort the envelopes by weight,
 * Find the Longest Increasing Subsequence among height,
 * Since [x, y] [x, y - 1] is not valid answer, we want [x, y - 1] in front of [x, y]
      So when we sort the envelopes, if weight equals, height is in decreasing order.
*/
package DynamicProgramming;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author xinrong
 */
public class RussianDollEnvelopes {

    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o2[1] - o1[1];
                }
                return o1[0] - o2[0];
            }
        });
        int[] nums = new int[envelopes.length];
        int ni = 0;
        for (int[] envelope : envelopes) {
            nums[ni++] = envelope[1];
        }
        return getLIS(nums);
    }

    public int getLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int lengthLIS = 0;
        for (int i = 0; i < dp.length; i++) {
            int maxDPj = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    maxDPj = Math.max(maxDPj, dp[j]);
                }
            }
            dp[i] = maxDPj + 1;
            lengthLIS = Math.max(lengthLIS, dp[i]);
        }
        return lengthLIS;
    }

}
