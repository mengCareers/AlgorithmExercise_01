/*
input : arr
output: maximum sum of K consecutive elements 
 * Thought Process:
 * 
 */
package TwoPtrs;

/**
 *
 * @author xinrong
 */
public class WindowSlidingTechnique {
    public static void main(String[] args) {
        int[] arr = {5, 2, -1, 0, 3};
        int ans = getMaxSubsumSizeK(arr, 3);
        System.out.println(ans);
    }
    
    public static int getMaxSubsumSizeK(int[] arr, int k) {
        int window_sum = 0;
        int max_sum = Integer.MIN_VALUE;
        int li = 0, ri = 0;
        for (; ri < k; ri++) {
            window_sum += arr[ri]; 
        }
        max_sum = window_sum;      
        while (ri < arr.length) {
            window_sum -= arr[li];
            li++;
            window_sum += arr[ri];
            ri++;
            max_sum = Math.max(max_sum, window_sum);     
        }
        return max_sum;
    }
}
