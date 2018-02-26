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

    List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        int[] res = new int[nums.length];
        int curptr = 0;
        subsetsUtil(res, curptr, nums);
        return result;
    }

    void subsetsUtil(int[] res, int curptr, int[] nums) {
        if (curptr == res.length) {
            printResult(res, nums);
            return;
        }
        for (int i = 0; i < 2; i++) {
            res[curptr] = i;
            subsetsUtil(res, curptr + 1, nums);
        }
    }

    void printResult(int[] res, int[] nums) {
        List<Integer> cur = new ArrayList<>();
        for (int i = 0; i < res.length; i++) {
            if (res[i] == 1) {
                cur.add(nums[i]);
            }
        }
        result.add(cur);
    }
}
