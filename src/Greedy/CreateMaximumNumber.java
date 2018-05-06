/*
 * Thought Process:
The final result res[] would be merged from res1[] and res2[], such that res1[] is max subsequence of nums1 of length ki, then res2[] is max subsequence of nums2 with length k - ki.
To get max subsequence of length cnt, we use stack.
To do with merging and update final result, we use util method greater().
 * 
 */
package Greedy;

import java.util.Stack;

/**
 *
 * @author xinrong
 */
public class CreateMaximumNumber {

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] result = new int[k];

        for (int ki = Math.max(0, k - nums2.length); ki <= Math.min(k, nums1.length); ki++) {
            int[] res1 = getMaxSubsequence(nums1, ki); // ki < nums1.length
            int[] res2 = getMaxSubsequence(nums2, k - ki); // k - ki < nums2.length
            int[] resTmp = new int[k];
            int p1 = 0, p2 = 0, pt = 0;
            while (p1 < res1.length || p2 < res2.length) {
                resTmp[pt++] = isGreater(res1, p1, res2, p2) ? res1[p1++] : res2[p2++];
            }
            if (!isGreater(result, 0, resTmp, 0)) {
                result = resTmp;
            }
        }
        return result;
    }

    private int[] getMaxSubsequence(int[] nums, int cnt) {
        Stack<Integer> stack = new Stack<>();
        int remain = cnt;
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && stack.peek() < nums[i] && nums.length - 1 - i >= remain) {
                stack.pop();
                remain++;
            }
            if (remain > 0) {
                stack.push(nums[i]);
                remain--;
            }
        }
        int[] maxSub = new int[cnt];
        int mi = maxSub.length - 1;
        while (!stack.isEmpty()) {
            maxSub[mi--] = stack.pop();
        }
        return maxSub;
    }

    private boolean isGreater(int[] nums1, int p1, int[] nums2, int p2) {
        for (; p1 < nums1.length && p2 < nums2.length; p1++, p2++) {
            if (nums1[p1] > nums2[p2]) {
                return true;
            }
            if (nums1[p1] < nums2[p2]) {
                return false;
            }
        }
        return p1 != nums1.length;
    }
}
