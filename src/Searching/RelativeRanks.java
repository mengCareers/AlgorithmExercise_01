/* 506. Relative Ranks
input : unique scores of N athletes
output: relative ranks and the people with the top 3 highests scores
"Gold Medal", "Silver Medal", "Bronze Medal"
 * Thought Process:
make an copy, compare
 * 
 */
package Searching;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author xinrong
 */
public class RelativeRanks {

    public String[] findRelativeRanks(int[] nums) {
        int len = nums.length;
        int[] cnums = nums.clone();
        Arrays.sort(cnums);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(cnums[i], len - 1 - i);
        }
        String[] result = new String[len];
        int ri = 0;
        for (int score : nums) {
            switch (map.get(score)) {
                case 0:
                    result[ri++] = "Gold Medal";
                    break;
                case 1:
                    result[ri++] = "Silver Medal";
                    break;
                case 2:
                    result[ri++] = "Bronze Medal";
                    break;
                default:
                    result[ri++] = String.valueOf(map.get(score) + 1);
            }
        }
        return result;
    }
}
