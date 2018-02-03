/*
 * Thought Process:
 * divide the problem into subproblems
   conquer each subproblem recursively
   combine solutions
 * Running time
T(n) = 2 T(n/2) + O(n)
2: # of subproblems

 * e.g. Mergesort,
   divide trivial
   conquer recursively sort each subarray
   combine solutions in linear time
 * e.g. Binary Search : find x in sorted arr
Divide: compare x with mid
Conquer:recurse in one subarr
Combine:trivial
 * e.g. Fibonacci
Naive recursive algo
Bottom-up recursive algo:
   Compute F0, F1, F2, F3...Fn
d & c
 */
package DivideandConquer;

/**
 *
 * @author xinrong
 */
public class DivideandConquer {
    
}
