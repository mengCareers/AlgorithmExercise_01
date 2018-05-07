/* 295. Find Median from Data Stream
Design a data structure that supports the following two operations:
void addNum(int num) - Add a integer number from the data stream to the data structure.
double findMedian() - Return the median of all elements so far.
 * Thought Process:
 * keep the entire input sorted is not a requirement
 * both heaps are balanced
 * 
 */
package Heap;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 *
 * @author xinrong
 */
public class FindMedianFromDataStream {

    PriorityQueue<Integer> minPQ; // bigger half poll minimum
    PriorityQueue<Integer> maxPQ; // smaller half poll maximum

    public FindMedianFromDataStream() {
        minPQ = new PriorityQueue<>();
        maxPQ = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addNum(int num) {
        minPQ.add(num);
        maxPQ.add(minPQ.poll());
        if (minPQ.size() < maxPQ.size()) {
            minPQ.add(maxPQ.poll());
            // maintain minPQ to be larger if we add to maxPQ last
            // or else 1, 2, getMedian will return 1.0
        }
    }

    public void addNum2(int num) {
        maxPQ.add(num);
        minPQ.add(maxPQ.poll());
        if (maxPQ.size() < minPQ.size()) {
            maxPQ.add(minPQ.poll());
        }
    }

    public double findMedian() {
        if (minPQ.size() == maxPQ.size()) {
            return (minPQ.peek() + maxPQ.peek()) / 2.0;
        }
        return minPQ.peek();
    }

    public double findMedian2() {
        if (minPQ.size() == maxPQ.size()) {
            return (minPQ.peek() + maxPQ.peek()) / 2.0;
        }
        return maxPQ.peek();
    }
}
