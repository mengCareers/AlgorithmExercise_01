/* 644.
input : nums, k
        contiguous subarray whose length >= k that has the maximum average value
output: maximum average value
 * Thought Process:
 * Mentor:
Why do we use Binary Search ?
'The answer with the calculation error less than 10-5 will be accepted.' Binary Search is good when we want to guess the solution and shrink the range to get precise value.
How do we use Binary Search ?
l = minimum result possible, -10001 initially
r = maximum result possible, 10001 initially
we pick the middle value and see if we can find a larger result to do the standard Binary Search.
canFindLargerAverage() helps us check that :
(a1+a2+a3...+aj)/j ≥ mid <=  (a1−mid)+(a2−mid)+(a3−mid)...+(aj−mid) ≥ 0
a[] stores a1-mid, a2-mid, a3-mid ... aj-mid
Similar to Sliding Window technique, for first k elements, we get the cumulative sum among them, cur. If it is smaller than 0, we slide the window. Attention that, prev keeps track of cumulative sum in front of the current window. If prev is smaller than 0, the cumulative sum of current window, which equals to cur - prev, becomes bigger, i.e., is more possible to >= 0.
 */
package Searching;

/**
 *
 * @author xinrong
 */
public class MaximumAverageSubarrayII {

    public double findMaxAverage(int[] nums, int k) {
        double l = -10001, r = 100001;
        while (l + 0.00001 < r) {
            double m = l + (r - l) / 2;
            if (canFindLargerAverage(nums, k, m)) {
                l = m;
            } else {
                r = m;
            }
        }
        return l;
    }

    private boolean canFindLargerAverage(int[] nums, int k, double x) {
        int n = nums.length;
        double[] a = new double[n];
        for (int i = 0; i < n; i++) {
            a[i] = nums[i] - x;
        }
        double cur = 0, prev = 0;
        for (int i = 0; i < k; i++) {
            cur += a[i];
        }
        if (cur >= 0) {
            return true;
        }
        for (int i = k; i < n; i++) {
            cur += a[i];
            prev += a[i - k];
            if (prev < 0) {
                cur -= prev;
                prev = 0;
            }
            if (cur >= 0) {
                return true;
            }
        }
        return false;
    }
}
