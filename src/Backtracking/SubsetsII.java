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
AFTER backtrack, while ==, ignore (i ++)
so use while instead of for to control i
INIT i = START not to start from beginning every time
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

    List<List<Integer>> res;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        res = new ArrayList<>();
        util(new ArrayList<Integer>(), nums, 0);
        return res;
    }

    private void util(List<Integer> cur, int[] nums, int start) {
        res.add(new ArrayList<>(cur));
        int i = start;
        while (i < nums.length) {
            cur.add(nums[i]);
            util(cur, nums, i + 1);
            cur.remove(cur.size() - 1);
            i++;
            while (i < nums.length && nums[i] == nums[i - 1]) {
                i++;
            }
        }
    }
}
