/*
input : a[] rotated sorted arr
output: min
 * Thought Process:
 * 
 */
package Searching;

/**
 *
 * @author xinrong
 */
public class FindMininRotatedSortedArr {

    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < nums[hi]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return nums[hi];
    }
}
