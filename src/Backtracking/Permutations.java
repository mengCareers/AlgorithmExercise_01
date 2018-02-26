/* 46. Permutations
Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
 * 
 */
package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author xinrong
 */
public class Permutations {
    // m = nums.length, n = nums.length

    List<List<Integer>> result;

    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        int len = nums.length;
        int[] res = new int[len];
        int curptr = 0;
        permuteUtil(res, curptr, nums);
        return result;
    }

    private void permuteUtil(int[] res, int curptr, int[] nums) {
        if (curptr == res.length) {
            printResult(nums, res);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (isValid(res, curptr, i)) {
                res[curptr] = i;
                permuteUtil(res, curptr + 1, nums);
            }
        }
    }

    // return true if res[0, curptr) not occur i
    private boolean isValid(int[] res, int curptr, int i) {
        for (int k = 0; k < curptr; k++) {
            if (res[k] == i) {
                return false;
            }
        }
        return true;
    }

    private void printResult(int[] nums, int[] res) {
        List<Integer> cur = new ArrayList<>();
        for (int i : res) {
            cur.add(nums[i]);
        }
        result.add(cur);
    }
}
