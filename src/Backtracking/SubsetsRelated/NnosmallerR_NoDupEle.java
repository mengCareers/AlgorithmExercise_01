/*
 * Thought Process:
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 */
package Backtracking.SubsetsRelated;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author xinrong
 */
public class NnosmallerR_NoDupEle {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> res = new NnosmallerR_NoDupEle().subsets(nums);
        System.out.println(res);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> curRes = new ArrayList<>();
        List<List<Integer>> allRes = new ArrayList<>();
        util(curRes, allRes, nums, 0);
        return allRes;
    }

    private static void util(List<Integer> curRes, List<List<Integer>> allRes, int[] nums, int start) {
        allRes.add(new ArrayList<>(curRes));

//        if (start < nums.length) {
//            curRes.add(nums[start]);
//            util(curRes, allRes, nums, start + 1);
//            curRes.remove(curRes.size() - 1);
//            util(curRes, allRes, nums, start + 1);
//        }
        for (int i = start; i < nums.length; i++) {
            curRes.add(nums[i]);
            util(curRes, allRes, nums, i + 1);
            curRes.remove(curRes.size() - 1);
        }
    }

}
