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
    List<List<Integer>> res;
    List<Integer> cur;
    
    public List<List<Integer>> subsets(int[] nums) {
        
        res = new ArrayList<>();
        cur = new ArrayList<>();
        
        backtrack(0, nums);
        
        return res;
    }
    void backtrack(int movei, int[] nums) {
        
        res.add(new ArrayList<>(cur));
        
        if (movei == nums.length)
            return;
        
        // for child of movei
        for (int i = movei; i < nums.length; i++) {
            cur.add(nums[i]);
            backtrack(i + 1, nums);
            cur.remove(cur.size() - 1);
        }
        
    }
}
