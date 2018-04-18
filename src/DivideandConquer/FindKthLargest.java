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
public class FindKthLargest {

    public static void main(String[] args) {
        int[] arr = {6, 5, 3, 1, 2, 7, 8, 4};
        int ans =  findKthLargestElement(arr, 1);
        System.out.println("The 1st largest element is " + ans);
        ans =  findKthLargestElement(arr, 2);
        System.out.println("The 2nd largest element is " + ans);
        ans =  findKthLargestElement(arr, 3);
        System.out.println("The 3rd largest element is " + ans);
        ans =  findKthLargestElement(arr, 4);
        System.out.println("The 4th largest element is " + ans);
        ans =  findKthLargestElement(arr, 5);
        System.out.println("The 5th largest element is " + ans);
        ans =  findKthLargestElement(arr, 6);
        System.out.println("The 6th largest element is " + ans);
        ans =  findKthLargestElement(arr, 7);
        System.out.println("The 7th largest element is " + ans);
        ans =  findKthLargestElement(arr, 8);
        System.out.println("The 8th largest element is " + ans);
    }

    public static int findKthLargestElement(int[] arr, int k) {
        return findKthLargest(arr, 0, arr.length - 1, k);
    }

    private static int findKthLargest(int[] arr, int lo, int hi, int k) {
        // quick sort
        int correctPt = partition(arr, lo, hi);
        if (correctPt == hi + 1 - k) {
            return correctPt;
        } else if (correctPt < hi + 1 - k) {
            return findKthLargest(arr, correctPt + 1, hi, k);
        } else {
            return findKthLargest(arr, lo, correctPt - 1, k - (hi - correctPt + 1));
        }

    }

    // to locate hi correctly
    private static int partition(int[] arr, int lo, int hi) {
        int wall = lo - 1;
        int pi = hi;
        for (int i = lo; i < hi; i++) {
            if (arr[i] <= arr[pi]) {
                wall++;
                swap(arr, wall, i);
            }
        }
        swap(arr, wall + 1, hi);
        return wall + 1;
    }

    private static void swap(int[] arr, int wall, int i) {
        int tp = arr[wall];
        arr[wall] = arr[i];
        arr[i] = tp;
    }
}
