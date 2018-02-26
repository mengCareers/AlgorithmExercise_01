/* 40. Combination Sum II
input : candidates[] target
output: candidate[i]'s sum = target
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
public class CombinationSumII {
    
    public static void main(String[] args) {
        int[] candidates = {2, 5, 2, 1, 2};
        int t = 5;
        List<List<Integer>> res = new CombinationSumII().combinationSum2(candidates, t);
        System.out.println(res);
    }

    List<List<Integer>> res;
    List<Integer> cur;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        int curptr = 0;
        res = new ArrayList<>();
        cur = new ArrayList<>();
        Arrays.sort(candidates);
        util(curptr, candidates, target);
        return res;
    }

    private void util(int curptr, int[] candidates, int target) {
        if (0 > target) {
            return;
        }
        if (0 == target) {
            res.add(new ArrayList<>(cur));
            return;
        }
        int i = curptr;
        while (i < candidates.length) {
            
            cur.add(candidates[i]);
            util(i + 1, candidates, target - candidates[i]);
            cur.remove(cur.size() - 1);
            i++;
            while (i <  candidates.length && candidates[i] == candidates[i - 1])
                i++;
        }
    }
}
