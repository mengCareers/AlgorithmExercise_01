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
    
    public static void main(String[] args) {
        
    }
    
    public void sortColors(int[] nums) {
        int p0 = 0, p2 = nums.length - 1;
        int p = 0;
        while (p < nums.length) {
            while (nums[p] == 2 && p < p2 ) {
                swap(p, p2, nums);
                p2--;  
            }
            while (nums[p] == 0 && p > p0) {
                swap(p, p0, nums);
                p0++;
                
            }
            p++;
        }
    }
    private void swap(int i, int j, int[] nums) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
