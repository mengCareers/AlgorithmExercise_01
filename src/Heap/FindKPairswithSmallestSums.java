/* 373. Find K Pairs with Smallest Sums
You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.

Define a pair (u,v) which consists of one element from the first array and one element from the second array.

Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.
 * Thought Process:
Min Heap saves candidate result pairs.
Instead of adding all candidates beforehand, we add possible candidates on the fly, that is,
for pair(i, j),
we add pair(i, j + 1),
and pair(i + 1, 0) if possible
e.g.
1, 3, 4
2, 5, 6
 * 
 */
package Heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * @author xinrong
 */
public class FindKPairswithSmallestSums {

    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<>();
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return res;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((int[] p1, int[] p2) -> nums1[p1[0]] + nums2[p1[1]] - (nums1[p2[0]] + nums2[p2[1]]));
        pq.add(new int[]{0, 0});
        while (k > 0 && !pq.isEmpty()) {
            int[] pair = pq.poll();
            int i = pair[0], j = pair[1];
            res.add(new int[]{nums1[i], nums2[j]});
            k--;

            if (j + 1 < nums2.length) {
                pq.offer(new int[]{i, j + 1});
            }
            if (j == 0 && i + 1 < nums1.length) {
                pq.offer(new int[]{i + 1, 0});
            }
        }

        return res;
    }
}
