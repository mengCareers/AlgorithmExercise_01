package Backtracking;

import java.util.ArrayList;
import java.util.List;

/* 39. Combination Sum
input : candidates[] target
output: candidate[i] * n 's sum = target
 * Thought Process:
 * we reduce target gradually to save use of cursum
   if backtracking the same element, call util(i, rather than util(i + 1
 */
/**
 *
 * @author xinrong
 */
public class CombinationSum {
    
    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int t = 8;
        List<List<Integer>> res = new CombinationSum().testCombinationSum(candidates, t);
        System.out.println(res.size());
    }

    public List<List<Integer>> testCombinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        combinationSum(candidates, target, new ArrayList<>(), result, 0);
        return result;
    }
    
    /**if for (int i = 0; i < candidates.length; i++) 
     * Would get results [[2,2,3],[2,3,2],[3,2,2],[7]]
     * To MAKE SURE the solution set must not contain duplicate combinations.
     * So we use starti
     * @param candidates
     * @param target
     * @param curcomb
     * @param result 
     */
    private void combinationSum(int[] candidates, int target, List<Integer> curcomb, List<List<Integer>> result, int starti) {
        if (target == 0) {
            result.add(new ArrayList<>(curcomb));
        }
        else if (target < 0) {
           
        }
        else {
            for (int i = starti; i < candidates.length; i++) {
                curcomb.add(candidates[i]);
                combinationSum(candidates, target - candidates[i], curcomb, result, i);
                curcomb.remove(curcomb.size() - 1);
            }
        }
    }
}
