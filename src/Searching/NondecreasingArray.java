/* 665.Non-decreasing Array
input : nums
output : true if it can be non-decreasing by modifying at most 1 element
 * Thought Process:
1 3 2 4
  x
1 1 2 4
  ~
1 3 3 4
    ~
* 
 */
package Searching;

/**
 *
 * @author xinrong
 */
public class NondecreasingArray {

    public static void main(String[] args) {
        int[] nums = {2, 3, 3, 2, 4};
        NondecreasingArray inst = new NondecreasingArray();
        inst.checkPossibility(nums);
    }

    public boolean checkPossibility(int[] nums) {
        boolean decreasing = false;
        int di = 0;
        for (int i = 0; i + 1 < nums.length; i++) {
            if (nums[i] > nums[i + 1]) {
                if (decreasing) {
                    return false;
                }
                di = i;
                decreasing = true;
            }
        }
        return di == 0 || di == nums.length - 2 || di == nums.length - 1 || nums[di - 1] <= nums[di + 1] || nums[di] <= nums[di + 2];
    }
}
