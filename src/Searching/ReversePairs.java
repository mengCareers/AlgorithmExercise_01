/* 493.Reverse Pairs
reverse pairs: if i < j, and nums[i] > 2 * nums[j]
input : nums
output: # of reverse pairs
 * Thought Process:
 * if we always find the minimum number on the right side of the current element
 * and check if reverse pairs
 * Mentor:
break down the array and solve for subproblems
our questions is : how to construct solution from its subproblems
our principle : if we can find T(i, j) from its subproblems, surely can build solutions to larger array
The relation between subproblems and problems are one of below: 
+ Sequential recurrence relation:
T(i, j) = T(i, j - 1) + C, i.e., elements will be processed sequentially
                                 C denotes the subproblem for processing the last element of subarray nums[i, j]

+ Partition recurrence relation:
T(i, j) = T(i, m) + T(m + 1, j) + C where m = (i + j) / 2, i.e., nums[i, j] will be further partitioned into two parts
                                 C denotes the subproblem for combining the two parts

Attention that if there is overlapping subproblems, DP approach would be preferred.
====
Alright, if sequential recurrence relation, we can set i = 0, i.e., the subarray always starts from beginning
    T(0, j) = T(0, j - 1) + C, then C denotes find # of reverse pairs with the first element coming from subarray nums[0, j - 1] while the 2nd element nums[j]
To form a reverse pairs, 
    p < q                   C meets already
    nums[p] > 2 * nums[q]   to search for all elements within nums[0, j - 1] > 2 * nums[j]
That is how the naive exhuastive search way woks, to improve the searching efficiency, we can sort elements and do a binary search
Array is not good for adding more elements, so we balance searching and insertion -- BST(better self-balanced) or binary indexed tree
====
Let's see partition recurrence relation
set i = 0, j = n - 1, m = (n - 1) / 2
we have
T(0, n - 1) = T(0, m) + T(m + 1, n - 1) + C, then C denotes find # of reverse pairs with the first element coming from subarray nums[0, m] while the 2nd element nums[m + 1, n - 1]
To form a reverse pairs,
    p < q                  C meets already
    nums[p] > 2 * nums[q]  linear search applied for each element in the left(right) subarray
Order of elements doew not matter, either, so we can sort elements in both subarrays
With both subarrays sorted, # of reverse pairs can be found in linear time by so-called two-pointer technique
How do we sort? We needed to partition array into halves anyway, so more natural to Merge-sort,
 */
package Searching;

/**
 *
 * @author xinrong
 */
public class ReversePairs {

    public int reversePairs(int[] nums) {
        return reversePairsUtil(nums, 0, nums.length - 1);
    }

    private int reversePairsUtil(int[] nums, int s, int e) {
        if (s >= e) {
            return 0;
        }
        int m = s + (e - s) / 2;
        int cntPairs = reversePairsUtil(nums, s, m) + reversePairsUtil(nums, m + 1, e);
        // s .. m, m+1 .. e
        // i       j
        int j = m + 1;
        for (int i = s; i <= m; i++) {
            while (j <= e && nums[i] > 2L * nums[j]) {
                j++;
            }
            cntPairs += j - 1 - m;
        }
        merge(nums, s, m, e);
        return cntPairs;
    }

    private void merge(int[] nums, int s, int m, int e) {
        int[] left = new int[m - s + 1];
        int li = 0;
        for (int i = s; i <= m; i++) {
            left[li++] = nums[i];
        }

        int[] right = new int[e - m];
        int ri = 0;
        for (int i = m + 1; i <= e; i++) {
            right[ri++] = nums[i];
        }

        li = 0;
        ri = 0;
        int ni = s;
        while (li < left.length && ri < right.length) {
            if (left[li] <= right[ri]) {
                nums[ni++] = left[li++];
            } else {
                nums[ni++] = right[ri++];
            }
        }
        while (li < left.length) {
            nums[ni++] = left[li++];
        }
        while (ri < right.length) {
            nums[ni++] = right[ri++];
        }
    }
}
