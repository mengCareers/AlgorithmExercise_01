/*
 * Thought Process:
 * 
 */
package Backtracking.Combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author xinrong
 */
public class CombinationSum_KUniqElefromRange_UsedOnce_OrderNotMatter {

    public static void main(String[] args) {
        List<List<Integer>> res = combinationSum3(3, 9);
        System.out.println(res);
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> allRes = new ArrayList<>();
        int[] candidates = new int[9];
        for (int i = 0; i < 9; i++) {
            candidates[i] = i + 1;
        }
        getCombUtil(candidates, n, new ArrayList<>(), allRes, 0, k);
        return allRes;
    }

    private static void getCombUtil(int[] candidates, int target, List<Integer> curRes, List<List<Integer>> allRes, int starti, int k) {
        if (target == 0) {
            if (curRes.size() == k) {
                allRes.add(new ArrayList<>(curRes));
            }
        } else if (target < 0) {

        } else {
            int i = starti;
            while (i < candidates.length) {
                if (target < candidates[i]) {
                    break;
                }
                curRes.add(candidates[i]);
                getCombUtil(candidates, target - candidates[i], curRes, allRes, i + 1, k);
                curRes.remove(curRes.size() - 1);
                i++;
            }
        }
    }
}
