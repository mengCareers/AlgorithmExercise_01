/*
 * Thought Process:
 * 
 */
package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author xinrong
 */
public class SubsetsWithDuplicate {
    List<List<Integer>> res;
    List<Integer> cur;
    
    public List<List<Integer>> subsets(int[] nums) {
        
        res = new ArrayList<>();
        cur = new ArrayList<>();
        
        Arrays.sort(nums); // 1. presort
        backtrack(0, nums);
        
        return res;
    }
    void backtrack(int movei, int[] nums) {
        
        res.add(new ArrayList<>(cur));
        
        if (movei == nums.length)
            return;
        
        // for child of movei
        int i = movei;
        while (i < nums.length) { // 2. while dup, i++ (using 'while' rather than 'for')
            cur.add(nums[i]);
            backtrack(i + 1, nums);
            cur.remove(cur.size() - 1);
            i++;
            while (i < nums.length && nums[i] == nums[i - 1])
                i++;
        }
        
    }    
}
