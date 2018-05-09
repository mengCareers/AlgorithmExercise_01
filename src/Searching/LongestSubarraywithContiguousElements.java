/* 
Given an array of distinct integers, find length of the longest subarray which contains numbers that can be arranged in a continuous sequence.

Without duplicates
 * Thought Process:
 * 
 */
package Searching;

/**
 *
 * @author xinrong
 */
public class LongestSubarraywithContiguousElements {

    public int longestSubarrayCanContiguous(int[] vals) {
        int maxLen = 1;
        for (int s = 0; s < vals.length - 1; s++) {
            int min = vals[s], max = vals[s];
            for (int e = s + 1; e < vals.length; e++) {
                min = Math.min(min, vals[e]);
                max = Math.max(max, vals[e]);
                if (max - min == e - s) {
                    maxLen = Math.max(maxLen, e - s + 1);
                }
            }
        }
        return maxLen;
    }

    public int longestSubarrayContiguous(int[] vals) {
        int maxLen = 1;
        for (int s = 0; s < vals.length - 1; s++) {
            int min = vals[s], max = vals[s];
            boolean emin = false, emax = false;
            for (int e = s + 1; e < vals.length; e++) {
                if (vals[e] < min) {
                    if (emax) {
                        break;
                    }
                    emin = true;
                    min = vals[e];
                    if (max - min != e - s) {
                        break;
                    }
                    maxLen = Math.max(maxLen, e - s + 1);
                } else if (vals[e] > max) {
                    if (emin) {
                        break;
                    }
                    emax = true;
                    max = vals[e];
                    if (max - min != e - s) {
                        break;
                    }
                    maxLen = Math.max(maxLen, e - s + 1);
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        LongestSubarraywithContiguousElements inst = new LongestSubarraywithContiguousElements();
        int[] vals = {4, 2, 5, 1, 3};
        int ans = inst.longestSubarrayContiguous(vals);
        System.out.println(ans);
    }
}
