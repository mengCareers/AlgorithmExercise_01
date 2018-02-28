package Searching;

/*238.Product of Array Except Self
input : nums
return an array output such that output[i] is equal to the product of all the elements of nums except nums[i]
e.g.
given [1,2,3,4], return [24,12,8,6].
 * Thought Process:
 * Get:
if we cal product of the whole array and divide by each num, it's hard to manage multiple-0 case.
So we avoid to do with it, for each i, we calculate 0..i-1 product and i+1..len product,
and multiply them.
Two loops are fine.
 */

/**
 *
 * @author xinrong
 */
public class ProductofArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int lmul = 1;
        for (int i = 0; i < nums.length; i++) {
            res[i] = lmul;
            lmul *= nums[i];
        }
        int rmul = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] *= rmul;
            rmul *= nums[i];
        }
        return res;
    }    
}
