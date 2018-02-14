/* 209. Minimum Size Subarray Sum
input : nums, s
output: min length subarray 
 * Thought Process:
 * 
 */
package Searching;

/**
 *
 * @author xinrong
 */
public class MinSzSubarrSum {

    public int subarraySumMinSzNoLessThanTarget(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int minsz = Integer.MAX_VALUE;
        int curSum = arr[0], start = 0;
        int res = 0;
        for (int i = 1; i <= arr.length; i++) {
            while (curSum > target && start <= i - 1) { 
                minsz = Math.min(minsz, i - start);
                curSum -= arr[start];
                start++;
            }
            if (curSum == target) {
                minsz = Math.min(minsz, i - start);
            }
            if (i < arr.length) {
                curSum += arr[i];
            }
        }
        return minsz == Integer.MAX_VALUE ? 0 : minsz;
    }

    public int subarraySumMinSzEqualTarget(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int minsz = Integer.MAX_VALUE;
        int curSum = arr[0], start = 0;
        int res = 0;
        for (int i = 1; i <= arr.length; i++) {
            while (curSum > target && start <= i - 1) { 
                curSum -= arr[start];
                start++;
            }
            if (curSum == target) {
                minsz = Math.min(minsz, i - start);
            }
            if (i < arr.length) {
                curSum += arr[i];
            }
        }
        return minsz == Integer.MAX_VALUE ? 0 : minsz;
    }

}
