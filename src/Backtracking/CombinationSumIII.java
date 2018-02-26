package Backtracking;


import java.util.ArrayList;
import java.util.List;

/* 216.CombinationSumIII
input : k, n
output: k numbers from 1 to 9 add up to n
 * Thought Process:
 * 
 */
/**
 *
 * @author xinrong
 */
public class CombinationSumIII {
    List<List<Integer>> res;
    List<Integer> cur;
    int kn;

    public List<List<Integer>> combinationSum3(int k, int n) {
        kn = k;
        int[] candidates = new int[9];
        for (int i = 0; i < 9; i++) {
            candidates[i] = i + 1;
        }
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        int curptr = 0;
        res = new ArrayList<>();
        cur = new ArrayList<>();
        util(curptr, candidates, n);
        return res;
    }

    private void util(int curptr, int[] candidates, int target) {
        if (0 > target || cur.size() > kn) {
            return;
        }
        if (0 == target && cur.size() == kn) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = curptr; i < candidates.length; i++) {
            int ele = candidates[i];
            cur.add(ele);
            util(i + 1, candidates, target - ele);
            cur.remove(cur.size() - 1);
        }
    }

}
