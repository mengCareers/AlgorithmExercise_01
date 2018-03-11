/*
 * Thought Process:
 * m1 all subarr sum, get max
   m2 sliding window
 */
package Searching;

/**
 *
 * @author xinrong
 */
public class MaximumSubarrSum {
    
    public static void main(String[] args) {
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
        int ans = new MaximumSubarrSum().getSum(arr);
        System.out.println(ans);
    }
    
    public int getSum(int[] arr) {
        int max_ending_here = 0, max_so_far = 0;
        for (int i = 0; i < arr.length; i++) {
            // Kadane's algo focurs on all continuous segments that are positive
//            if (max_ending_here < 0) {
//                max_ending_here = 0;
//            }
//            max_ending_here += arr[i];
            // Dynamic programming focus on each steop's decision, good when all are negative
            if (max_ending_here + arr[i] < arr[i])
                max_ending_here = arr[i];
            else 
                max_ending_here += arr[i];
            max_so_far = Math.max(max_so_far, max_ending_here);
        }
        return max_so_far;
    }
}
