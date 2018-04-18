/* 442. Find All Duplicates in an Array
Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
Find all the elements that appear twice in this array.
Could you do it without extra space and in O(n) runtime?
 * Thought Process:
Without extra place
=> Marking Original Array
=> when we meet nums[i] = val, makes nums[val - 1] < 0
=> when we meet nums[j] = val, we finds nums[val - 1] < 0, it proves that we met val before
 * 
 */
package Searching;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author xinrong
 */
public class FindAllDuplicatesinArray {

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> dupNums = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int mark = Math.abs(nums[i]);
            if (nums[mark - 1] < 0) {
                dupNums.add(Math.abs(nums[i]));
            } else {
                nums[mark - 1] = -nums[mark - 1];
            }
        }
        return dupNums;
    }
}
