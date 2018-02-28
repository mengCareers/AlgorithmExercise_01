/*
 *  LC:41. First Missing Positive
 *  Thought Process:
 *    BruteForce: sort, 0 < x < 1st
 *  Get:
related to max but not min: if max <= 0 return 1; 
                            if max > 0:
                                    draw[n] == true if n exists in nums
 */
package Array;

/**
 *
 * @author xinrong
 */
public class FirstMissingPositive {
    public static void main(String[] args) {
        int[] nums = {-2, -1};
        int ans = new FirstMissingPositive().firstMissingPositive(nums);
        System.out.println(ans);
    }
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) 
            return 1;
        
        int max = findMax(nums);
        
        if (max <= 0) 
            return 1; 
        
        boolean[] draw = new boolean[max + 1];
        
        fillDraw(nums, draw);
        
        int number = findEmptyNum(draw, max);
        if (number == max) 
            number++;
        
        return number;
    }
    /* if -1, 0 , 2, 3
       draw[0] = true; draw[2] = true; draw[3] = true;
    */
    private void fillDraw(int[] nums, boolean[] draw) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) 
                continue;
            draw[nums[i]] = true;
        }
    }
    private int findEmptyNum(boolean[] draw, int max) {
        int val = max;
        for (int i = 1; i < draw.length; i++) {
            if (!draw[i]) {
                val = i;
                break;
            }
        }
        return val;
    }
    private int findMax(int[] nums) {
        int max = Integer.MIN_VALUE;
        
        for (int num : nums) 
            max = Math.max(num, max);
        return max;
    }
}
