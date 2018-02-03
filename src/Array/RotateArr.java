package Array;



/*
 *  Q:189. Rotate Array
rotate arr to the right by k steps, that is, right rotation
 *  Thought Process: 
- M1 in place
right rotate one by one for k times
nums[2] = nums[1] : nums[i] = nums[i - 1]
save nums[1] first
- M2
e.g. k = 3
from 1 2 3 4 5 6 7
to   7 6 5 4 3 2 1
to   5 6 7 1 2 3 4
 *  Get:
 */

/**
 *
 * @author xinrong
 */
public class RotateArr {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        
        k %= len; 
        reverse(nums, 0, len - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, len - 1);
    }
    public void reverse(int[] nums, int i, int j) {
        while(i < j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
    }
    
    /* M1
    public void rotate(int[] nums, int k) { 
        int len = nums.length;
        k %= len; 
        for (int i = 0; i < k; i++)
            rotateOne(nums);
    }
    public void rotateOne(int[] nums) {
        int len = nums.length;
        int tmp = nums[len - 1];
    
        for (int i = len - 1; i > 0; i--) {
            nums[i] = nums[i - 1];
        }
        nums[0] = tmp;
    }
    */
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        new RotateArr().rotate(nums, 3);
        for (int i : nums)
            System.out.print(i + " ");
    }
}
