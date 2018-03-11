/* 327.Count of Range Sum
input : nums, l, u
output: # of range sums lie in [l, u]
range sum = subarray sum
 * Thought Process:
 * 
 */
package Searching;

/**
 *
 * @author xinrong
 */
public class CountofRangeSum {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int cnt = new CountofRangeSum().countRangeSum(nums, 2, 5);
        System.out.println(cnt);
    }
    
    public int countRangeSum(int[] nums, int lower, int upper) {
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) { // [i, j]
            for (int j = i; j < nums.length; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += nums[k];
                }
                if (sum >= lower && sum <= upper) {
                    cnt++;
                }
            }
        }
        return cnt;
    }    
}
