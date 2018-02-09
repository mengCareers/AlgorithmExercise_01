/*
 * Thought Process:
 * If without negative - Sliding Window
   If with negative    - Using Set check if encountered (target - curSum)
 */
package Searching;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author xinrong
 */
public class IfExistSubarraywithGivenSum {

    public static void main(String[] args) {
        int[] arr = {1};
        int target = 0;
        boolean ans = new IfExistSubarraywithGivenSum().isExistSubarrWithNegative(arr, target);
        System.out.println(ans);
    }

    /**
     * Check if there is a subarray with sum equals to target in a non-negative
     * array
     *
     * @param arr
     * @param target
     * @return True if exists
     */
    public boolean isExistSubarrWithoutNegative(int[] arr, int target) {
        int curSum = arr[0], start = 0;
        for (int i = 1; i <= arr.length; i++) {
            while (curSum > target && start < i - 1) {
                curSum -= arr[start];
                start++;
            }
            if (curSum == target) {
                return true;
            }
            if (i < arr.length) {
                curSum += arr[i];
            }
        }
        return false;
    }

    /**
     * Check if there is a subarray with sum equals to target in a array
     * containing negative elements
     *
     * @param arr
     * @param target
     * @return True if exists
     */
    public boolean isExistSubarrWithNegative(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        set.add(0);
        int curSum = 0;

        for (int i = 0; i < arr.length; i++) {
            curSum += arr[i];
            if (set.contains(curSum - target)) {
                return true;
            }
            set.add(curSum);
        }

        return false;
    }
}
