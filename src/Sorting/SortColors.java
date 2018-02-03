package Sorting;

/* 75. Sort Colors
input : nums consists of 0s, 1s, 2s
output: group them in order of 0s, 1s, 2s
 * Thought Process:
How do we use ptrs? i - 0, j - 2, 1 put inside
 * Get:
We aim 0 0 0 p0 ... p1 1 1 1

 * 
 */

/**
 *
 * @author xinrong
 */
public class SortColors {
    public void sortColors(int[] nums) {
        int len = nums.length;
        int p0 = 0, p2 = len - 1;
        for (int i = 0; i < len; i++) {
            // move all 2s in tail
            while (nums[i] == 2 && i < p2)
                swap(nums, i, p2--);
            // move all 0s in head
            while (nums[i] == 0 && i > p0)
                swap(nums, i, p0++);
        }
    }    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
