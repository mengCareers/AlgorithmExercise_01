/*
 * Thought Process:
 * 
 */
package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author xinrong
 */
public class Subsets {
    // m = 2, 1 2 3, n = 3

    // ordered              start
    // without duplicate    isValid() or used[i] or while i ++
    
    List<List<Integer>> result;
    public List<List<Integer>> subsetsWODup(int[] nums) {
        result = new ArrayList<>();
        util(nums, new ArrayList<Integer>(), 0);
        return result;
    }
    void util(int[] nums, List<Integer> cur, int start) {
        result.add(new ArrayList<>(cur));
        for (int i = start; i < nums.length; i++) {
            cur.add(nums[i]);
            util(nums, cur, i + 1);
            cur.remove(cur.size() - 1);
        }
    }
    
    
}
