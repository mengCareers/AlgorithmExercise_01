/* 90. Subsets II
Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
Note: The solution set must not contain duplicate subsets.
For example,
If nums = [1,2,2], a solution is:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]

 * Thought Process:
after backtrack, while ==, ignore (i ++)
so use while instead of for to control i
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
public class SubsetsII {

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        List<List<Integer>> result = new SubsetsII().subsetsWithDup(nums);
        System.out.println(result);
    }

    List<List<Integer>> result;
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        result = new ArrayList<>();
        
        Arrays.sort(nums);
        util(nums, 0, new ArrayList<Integer>());
        
        return result;
        
    }
    
    void util(int[] nums, int start, List<Integer> cur) {
        if (start > nums.length)
            return;
        result.add(new ArrayList<>(cur));
        int i = start;
        while (i < nums.length) {
            cur.add(nums[i]);
            util(nums, i + 1, cur);
            cur.remove(cur.size() - 1);
            i++;
            while (i < nums.length && nums[i] == nums[i - 1])
                i++;
        }
    }
}
