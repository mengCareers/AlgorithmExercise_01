/*
 * Thought Process:
 * 
 */
package DynamicProgramming;

/**
 *
 * @author xinrong
 */
public class LIS {

    public int[] getLIS(int[] nums) {
        int len = nums.length;
        int[] lis = new int[len];
        for (int i = 0; i < len; i++) {
            lis[i] = 1;
        }
        for (int i = 0; i < len; i++) {
            int val = nums[i];
            int maxlis = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < val) {
                    maxlis = Math.max(maxlis, lis[j]);
                }
            }
            lis[i] = maxlis + 1;
        }
        return lis;
    }
}
