/*
 * Thought Process:
 * 
 */
package Searching;

import java.util.Arrays;

/**
 *
 * @author xinrong
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        
        int len = nums.length;
        int d = Integer.MAX_VALUE;
        int r = nums[0];
        for (int i = 0; i < len - 2; i++) {
            for (int j = i + 1; j < len - 1; j++) {
                for (int k = j + 1; k < len; k++) {
                    int s = nums[i] + nums[j] + nums[k];
                    if (Math.abs(s - target) < d) {
                        r = s;
                        d = Math.abs(s - target);
                    }
                }
            }
        }
        return r;
    }
}
