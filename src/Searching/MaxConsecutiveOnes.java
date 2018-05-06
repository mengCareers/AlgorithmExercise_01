/* 485.Max Consecutive Ones
Q: maximum # of consecutive 1s in the array
Input: [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s.
    The maximum number of consecutive 1s is 3.
 * Thought Process:
 * 
 */
package Searching;

/**
 *
 * @author xinrong
 */
public class MaxConsecutiveOnes {
    
    public static void main(String[] args) {
        int[] nums = {1,1,0,1,1,1};
        int maxCnt = new MaxConsecutiveOnes().findMaxConsecutiveOnes(nums);
        System.out.println(maxCnt);
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCnt = 0;
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                cnt++;
            } else {
                maxCnt = Math.max(maxCnt, cnt);
                cnt = 0;
            }
        }
        maxCnt = Math.max(maxCnt, cnt);
        return maxCnt;
    }
}
