/*
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
package Backtracking.PermutationRelated;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author xinrong
 */
public class NEqualR_NoDupEle {
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> res = new NEqualR_NoDupEle().permute(nums);
        System.out.println(res);
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> allRes = new ArrayList<>();
        int[] oriNums = nums.clone();
        nextPermutation(nums);
        List<Integer> curRes = Arrays.stream(nums).boxed().collect(Collectors.toList());
        allRes.add(new ArrayList<>(curRes));
        while (!Arrays.equals(nums, oriNums)) {
            nextPermutation(nums);
            curRes = Arrays.stream(nums).boxed().collect(Collectors.toList());
            allRes.add(curRes);
        }
        return allRes;
    }

    public void nextPermutation(int[] nums) {
        int pivot = -1;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                pivot = i - 1;
                for (int j = nums.length - 1; j > pivot; j--) {
                    if (nums[j] > nums[pivot]) {
                        swap(j, pivot, nums);
                        break;
                    }
                }
                break;
            }

        }
        reverse(pivot + 1, nums.length - 1, nums);
    }

    private void swap(int i, int j, int[] nums) {
        int tp = nums[i];
        nums[i] = nums[j];
        nums[j] = tp;
    }

    private void reverse(int start, int end, int[] nums) {
        while (start < end) {
            swap(start, end, nums);
            start++;
            end--;
        }
    }

    
    
    
    /**
     * NAIVE
     * 
     * 
     */
    
    
    public List<List<Integer>> permuteNaive(int[] nums) {
        List<List<Integer>> allRes = new ArrayList<>();
        List<Integer> curRes = new ArrayList<>();;
        permuteUtil(curRes, allRes, nums);
        return allRes;
    }

    private void permuteUtil(List<Integer> curRes, List<List<Integer>> allRes, int[] nums) {
        if (nums.length == curRes.size()) {
            allRes.add(new ArrayList<>(curRes));
        }

        for (int i = 0; i < nums.length; i++) {
            if (curRes.contains(nums[i])) {
                continue;
            }
            curRes.add(nums[i]);
            permuteUtil(curRes, allRes, nums);
            curRes.remove(curRes.size() - 1);
        }
    }

}
