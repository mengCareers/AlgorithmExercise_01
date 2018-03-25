/*
 * Thought Process:
 * 
 */
package Hashing;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author xinrong
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        // we can't sort
        Map<Integer, Integer> map = new HashMap<>(); // val, idx
        for (int i = 0; i < nums.length; i++) {
            int jnum = target - nums[i];
            if (map.containsKey(jnum)) {
                int j = map.get(jnum);
                return new int[]{i, j};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
