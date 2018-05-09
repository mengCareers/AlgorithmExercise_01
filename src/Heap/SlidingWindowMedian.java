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

    PriorityQueue<Long> minPQ; // bigger half
    PriorityQueue<Long> maxPQ; // smaller half

    public double[] medianSlidingWindow(int[] nums, int k) {
        minPQ = new PriorityQueue<>();
        maxPQ = new PriorityQueue<>(Collections.reverseOrder());
        double[] res = new double[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            insertIntoWindow(nums[i]);
        }
        int ri = 0;
        res[ri] = getMedian();
        for (int j = k; j < nums.length; j++) {
            removeFromWindow(nums[j - k]);
            insertIntoWindow(nums[j]);
            res[++ri] = getMedian();
        }
        return res;
    }

    private void removeFromWindow(long n) {
        if (n <= getMedian()) {
            maxPQ.remove(n);
        } else {
            minPQ.remove(n);
        }
    }

    private void insertIntoWindow(long n) {
        maxPQ.add(n);
        minPQ.add(maxPQ.poll());
        if (maxPQ.size() < minPQ.size()) {
            maxPQ.add(minPQ.poll());
        }
    }

    private double getMedian() {
        if (minPQ.size() == maxPQ.size()) {
            return (minPQ.peek() + maxPQ.peek()) / 2.0;
        }
        return maxPQ.peek();
    }

}
