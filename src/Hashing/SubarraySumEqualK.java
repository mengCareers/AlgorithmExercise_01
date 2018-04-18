/*
 * Thought Process:
e.g. [a, b, c, d, e]
sum[1] = a + b;
sum[4] = a + b + c + d + e;
if sum[4] - sum[1] = k, Subarray [c, d, e] sum equals k (that’s our target)
so for sum[i], we check if sum[i] - k met
Thus, we build hashmap<cummulativeSum, frequencies>
 */
package Hashing;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author xinrong
 */
public class SubarraySumEqualK {

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(); // key : cummulativeSum value : frequencies
        int cntRes = 0;
        int sum = 0;
        // if [1, 1], k = 2, cummulativeSum = k, also valid, should increase cntRes by 1
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                cntRes += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return cntRes;
    }
}
