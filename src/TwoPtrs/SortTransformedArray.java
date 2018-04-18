/*
 * Thought Process:
We found that,
In two-pointers approach, x is getting further from two ends
In the graph below :
if a > 0, for ( x, y ), y gets smaller when x gets further from ends
if a < 0, for ( x, y ), y gets bigger when x gets further from ends
image
Thus, if a > 0, we construct res[] from the end, else, we construct res[] from the start.
 * 
 */
package TwoPtrs;

import java.util.Arrays;

/**
 *
 * @author xinrong
 */
public class SortTransformedArray {

    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int i = 0, j = nums.length - 1;
        int[] res = new int[nums.length];
        int ei = nums.length - 1;
        int si = 0;
        while (i <= j) {
            if (a > 0) {
                res[ei--] = getRes(nums[i], a, b, c) > getRes(nums[j], a, b, c) ? getRes(nums[i++], a, b, c) : getRes(nums[j--], a, b, c);
            } else {
                res[si++] = getRes(nums[i], a, b, c) < getRes(nums[j], a, b, c) ? getRes(nums[i++], a, b, c) : getRes(nums[j--], a, b, c);
            }
        }
        return res;
    }

    public int[] sortTransformedArrayNaive(int[] nums, int a, int b, int c) {
        int[] res = new int[nums.length];
        int ri = 0;
        for (int x : nums) {
            res[ri++] = getRes(x, a, b, c);
        }
        Arrays.sort(res);
        return res;
    }

    private static int getRes(int x, int a, int b, int c) {
        return a * x * x + b * x + c;
    }
}
