package Sorting;


import java.util.Arrays;

/* 280. Wiggle Sort
input : nums
output: nums sorted wigglely, that is, a <= b >= c <= d >= e
 * Thought Process:
- What does it mean by wiggle?
e.g. 3 5 2 1 6 4
sort it, 1 2 3 4 5 6
         i         j
1 6 3 4 5 2
1 6 2 4 5 3
- Get:
sort the arr, swap eles pair-wise starting from the 2nd ele
e.g. 1 2 3 4 5 6
     1 3 2 5 4 6
 * 
 */

/**
 *
 * @author xinrong
 */
public class WiggleSort {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int i = 1;
        
        while (i + 1 < nums.length) {
            int j = i + 1;
            swap(nums, i, j);
            i += 2;
        }
    }   
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
