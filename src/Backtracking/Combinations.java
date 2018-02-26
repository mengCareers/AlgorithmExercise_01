/*
Output : return all possible combinations of m numbers out of 1 ... m in size 2.
If m = 4 and n = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
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
public class Combinations {

    List<List<Integer>> result;

    public List<List<Integer>> combine(int m, int n) {
        result = new ArrayList<>();
        int[] res = new int[n];
        int curptr = 0;

        int[] nums = new int[m];
        for (int i = 0; i < m; i++) {
            nums[i] = i + 1;
        }

        combineUtil(res, curptr, nums, 0);
        return result;
    }

    private void combineUtil(int[] res, int curptr, int[] nums, int start) {
        if (curptr == res.length) {
            // print
            printResult(res, nums);
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (isValid(res, i, curptr)) {
                res[curptr] = i;
                combineUtil(res, curptr + 1, nums, i + 1);
            }
        }
    }

    // true if res [0, curptr) not occur i
    private boolean isValid(int[] res, int targeti, int curptr) {
        for (int i = 0; i < curptr; i++) {
            if (res[i] == targeti) {
                return false;
            }
        }
        return true;
    }

    private void printResult(int[] res, int[] nums) {
        List<Integer> cur = new ArrayList<>();
        for (int i = 0; i < res.length; i++) {
            cur.add(nums[res[i]]);
        }
        result.add(cur);
    }
}
