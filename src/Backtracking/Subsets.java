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
    // without duplicate    isValid() or used[i]
    
    List<List<Integer>> result;
    
    public List<List<Integer>> subsets(int[] nums) {
        
        result = new ArrayList<>();
        
        util(nums, 0, new ArrayList<Integer>());
        
        return result;
        
    }
    
    void util(int[] nums, int start, List<Integer> cur) {
        if (start > nums.length)
            return;
        result.add(new ArrayList<>(cur));
        for (int i = start; i < nums.length; i++ ) {
            cur.add(nums[i]);
            util(nums, i + 1, cur);
            cur.remove(cur.size() - 1);
        }
    }
}
