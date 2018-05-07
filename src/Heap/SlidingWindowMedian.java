/* 480. Sliding Window Median
For example,
Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

Window position                Median
---------------               -----
[1  3  -1] -3  5  3  6  7       1
 1 [3  -1  -3] 5  3  6  7       -1
 1  3 [-1  -3  5] 3  6  7       -1
 1  3  -1 [-3  5  3] 6  7       3
 1  3  -1  -3 [5  3  6] 7       5
 1  3  -1  -3  5 [3  6  7]      6

Therefore, return the median sliding window as [1,-1,-1,3,5,6].
 * Thought Process:
k is odd or even matters
if k is odd, then we return the mid one
or else, we return the mean of mid twos
we get the sliding window first
0 1 2 3 4
|   |
 * Get:
Similar to 295. Find Median from Data Stream :
https://leetcode.com/problems/find-median-from-data-stream/discuss/129248/Java-Self-explanatory-Heap-Code-x-2
We use minPQ and maxPQ to keep track of the medians rather than maintain the entire sorted input. And we make sure both heaps are balanced during the process.
  */
package Heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * @author xinrong
 */
public class SlidingWindowMedian {

    PriorityQueue<Long> minPQ; // bigger half poll minimum
    PriorityQueue<Long> maxPQ; // smaller half poll maximum

    public double[] medianSlidingWindow(int[] nums, int k) {
        minPQ = new PriorityQueue<>();
        maxPQ = new PriorityQueue<>(Collections.reverseOrder());
        double[] res = new double[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            insertToWindow(nums[i]);
        }
        int ri = 0;
        res[ri] = findWindowMedian();
        for (int j = k; j < nums.length; j++) {
            removeFromWindow(nums[j - k]);
            insertToWindow(nums[j]);
            res[++ri] = findWindowMedian();
        }
        return res;
    }

    private void removeFromWindow(long n) {
        if (n <= findWindowMedian()) {
            maxPQ.remove(n);
        } else {
            minPQ.remove(n);
        }
    }

    private void insertToWindow(long n) {
        maxPQ.add(n);
        minPQ.add(maxPQ.poll());
        if (maxPQ.size() < minPQ.size()) {
            maxPQ.add(minPQ.poll());
        }
    }

    private double findWindowMedian() {
        if (minPQ.size() == maxPQ.size()) {
            return (minPQ.peek() + maxPQ.peek()) / 2.0;
        }
        return maxPQ.peek();
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};

        int k = 3;
        SlidingWindowMedian inst = new SlidingWindowMedian();
        double[] result = inst.medianSlidingWindow(nums, k);
        for (double r : result) {
            System.out.println(r);
        }
    }

    public double[] medianSlidingWindowTLE(int[] nums, int k) {
        List<Double> medians = new ArrayList<>();
        int left = 0, right = 0;
        while (right < k) {
            right++;
        }
        if (k % 2 == 0) {
            medians.add(getMedianEven(nums, left, k));
            while (right < nums.length) {
                left++;
                right++;
                medians.add(getMedianEven(nums, left, k));
            }
        } else {
            medians.add(getMedianOdd(nums, left, k));
            while (right < nums.length) {
                left++;
                right++;
                medians.add(getMedianOdd(nums, left, k));
            }
        }
        return generateResult(medians);
    }

    private double getMedianOdd(int[] nums, int left, int k) {
        int[] numsCopy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(numsCopy, left, left + k);
        return numsCopy[left + k / 2];
    }

    private double getMedianEven(int[] nums, int left, int k) {
        int[] numsCopy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(numsCopy, left, left + k);
        return ((long) numsCopy[left + k / 2] + (long) numsCopy[left + k / 2 - 1]) / 2.0;
    }

    private double[] generateResult(List<Double> medians) {
        double[] result = new double[medians.size()];
        int ri = 0;
        for (Double d : medians) {
            result[ri++] = d;
        }
        return result;
    }

}
