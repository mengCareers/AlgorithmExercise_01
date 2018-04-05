/*
 * Thought Process:
 * 
 */
package Backtracking.SubsetsRelated;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author xinrong
 */
public class NnosmallerR_DupEle {

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        List<List<Integer>> res = new NnosmallerR_DupEle().subsetsWithDup(nums);
        System.out.println(res);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> curRes = new ArrayList<>();
        List<List<Integer>> allRes = new ArrayList<>();
        Arrays.sort(nums);
        util(curRes, allRes, nums, 0);
        return allRes;
    }

    private static void util(List<Integer> curRes, List<List<Integer>> allRes, int[] nums, int start) {
        allRes.add(new ArrayList<>(curRes));
        for (int i = start; i < nums.length; i++) {
            curRes.add(nums[i]);
            util(curRes, allRes, nums, i + 1);
            curRes.remove(curRes.size() - 1);
            i++;
            while (i > 0 && i < nums.length && nums[i] == nums[i - 1]) {
                i++;
            }
            i--;
        }
    }
}
