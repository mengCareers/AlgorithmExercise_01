/*
 *  LC:35. Search Insert Position
input : nums, target
output: target's correct idx
 * Get:
Binary Search helps us to shrink searching range, l is always safe.
 */
package Searching;

/**
 *
 * @author xinrong
 */
public class SearchInsertPosition {

    public static void main(String[] args) {
        int[] nums = {1, 3, 14, 16, 20};
        int target = 15;
        int ans = new SearchInsertPosition().searchInsert(nums, target);
        System.out.println(ans);
    }

    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) { 
            int mid = l + (r - l) / 2; 
            if (target < nums[mid]) { // mid is impossible
                r = mid - 1;
            } else if (target > nums[mid]) { // mid is impossible
                l = mid + 1;
            } else
                return mid;
        }
        return l;
    }
}
