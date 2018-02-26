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
        List<List<Integer>> result = new SubsetsII().subsets(nums);
        System.out.println(result);
    }

    List<List<Integer>> result;
    List<Integer> cur;

    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        cur = new ArrayList<>();
        Arrays.sort(nums);
        subsetsUtil(0, nums);
        return result;
    }

    void subsetsUtil(int start, int[] nums) {
        result.add(new ArrayList<>(cur));
        int i = start;
        while(i < nums.length) {
            cur.add(nums[i]);
            subsetsUtil(i + 1, nums);
            cur.remove(cur.size() - 1);
            i++;
            while (i < nums.length && nums[i] == nums[i - 1])
                i++;
        }
    }
}
