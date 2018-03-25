/* 136. Single Number
Given an array of integers, every element appears twice except for one. Find that single one.
 * Thought Process:
    // 1 ^ 0 = 1, 0 ^ 0 = 0 => a ^ 0 = a
    // a ^ b ^ b = a ^ 0 = a
 */
package BitManipulation;

/**
 *
 * @author xinrong
 */
public class SingleNumber {

    public int singleNumber(int[] nums) {
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ans = ans ^ nums[i];
        }
        return ans;
    }


}
