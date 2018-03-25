/* Q : 26. Remove Duplicates from Sorted Array
input : nums
output: length of not dup, not dup are front
e.g. 1, 1, 2
  to 1, 2, | 1
  return 2;

 * Thought Process:
 * 1 2 1
 *   d i
 * Get :
    inplace can be cover
 */
package TwoPtrs;

/**
 *
 * @author xinrong
 */
public class RemoveDuplicatesfromSortedArray {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3};
        int ans = new RemoveDuplicatesfromSortedArray().removeDuplicates(nums);
        System.out.println(ans);
    }
    
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int di = 1;
        while (i < nums.length) {
            if (i > 0 && nums[i] != nums[i - 1]) {
                nums[di++] = nums[i];
            }
            // swap (di, i, nums);
            i++;
        }
        return di;
    }    
//    private void swap(int i, int j, int[] nums) {
//        int t = nums[i];
//        nums[i] = nums[j];
//        nums[j] = t;
//    }
}
