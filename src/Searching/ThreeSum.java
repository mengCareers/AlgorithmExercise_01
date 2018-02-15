/* 15. 3Sum
output : all unique triplets sum = 0
 * Thought Process:
sort, then ignore the same => 去重
 * 
 */
package Searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author xinrong
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int c = -nums[i];
            List<Integer[]> res= twoSum(nums, i + 1, c);
            for (Integer[] r : res) {
                List<Integer> lst = new ArrayList<>();
                lst.add(nums[i]);
                lst.add(r[0]);
                lst.add(r[1]);
                ans.add(lst);
            }
        }
        
        return ans;
    }
    
    private List<Integer[]> twoSum(int[] nums, int start, int target) {
        List<Integer[]> res = new ArrayList<>();
        int i = start, j = nums.length - 1;
        while (i < j) {
            if (nums[i] + nums[j] == target) {
                Integer[] r = new Integer[2];
                r[0] = nums[i];
                r[1] = nums[j];
                res.add(r);
                i++;
                j--;
                while (i < j && i - 1 >= 0 && nums[i] == nums[i - 1])
                    i++;
                while (i < j && j + 1 < nums.length && nums[j] == nums[j + 1])
                    j--;
            }
            else if (nums[i] + nums[j] < target) {
                i++;
            }
            else {
                j--;
            }
        }
        return res;
    }
    
    // sort, 2ptr can 去重 in 2sum
    private List<Integer[]> twoSumWrong(int[] nums, int start, int target) {
        List<Integer[]> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1])
                continue;
            int t = target - nums[i];
            if (set.contains(t)) {
                Integer[] r = new Integer[2];
                r[0] = nums[i];
                r[1] = t;
                res.add(r);
            } 
            else {
                set.add(nums[i]);
            }
        }
        
        return res;
    } 
}
