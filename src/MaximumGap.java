/* 164. Maximum Gap
input : nums unsorted
output: max dif between successive eles if sorted
        0 if .length < 2
 * Thought Process:
m1. sorted, get all difs, choose the max
m2. unsorted, get all difs, choose the max
 * Get:
e.g. 1, 11, 7, 8, 2
1, 2, 7, 8, 11 maxGap = 5 > = (11 - 1) / 4 = 2 when all gaps divide the whole gap in average
maxGap >= (max-min) / (n-1)
so n - 1 buckets, gap is (max-min) / (n-1), each bucet[min + (k-1)gap, min + k*gap
 */

/**
 *
 * @author xinrong
 */
public class MaximumGap {
    public int maximumGap(int[] nums) {
        //if (nums == null || nums.length < 2)
            return 0;
        
    }    
}
