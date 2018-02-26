package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 47. Permutations II
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
Get : 
if the first 1 is f1, the second 1 is s1,
we need f1 s1 only, we dont need s1 f1,
we attach attribute visited,
    if f1.visited = true, we add s1
    if f1.visited = false, we don't add s1
in this way, we guarantee the order
 */
/**
 *
 * @author xinrong
 */
public class PermutationsII {

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        List<List<Integer>> res = new PermutationsII().permute(nums);
        System.out.println(res);
    }

    List<List<Integer>> result;

    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        int len = nums.length;
        int[] res = new int[len];
        int curptr = 0;
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        permuteUtil(res, curptr, nums, visited);
        return result;
    }

    private void permuteUtil(int[] res, int curptr, int[] nums, boolean[] visited) {
        if (curptr == res.length) {
            printResult(nums, res);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (i > 0 && nums[i - 1] == nums[i] && !visited[i - 1]) {
                continue;
            }
            res[curptr] = i;
            visited[i] = true;
            permuteUtil(res, curptr + 1, nums, visited);
            visited[i] = false;
        }
    }

    private void printResult(int[] nums, int[] res) {
        List<Integer> cur = new ArrayList<>();
        for (int i : res) {
            cur.add(nums[i]);
        }
        result.add(cur);
    }

}
