/* 327.Count of Range Sum
input : nums, l, u
output: # of range sums lie in [l, u]
range sum = subarray sum
 * Thought Process:
To make rangeSum <= upper
sum[0..j] - sum[0..i] <= upper
sum[0..j] - upper <= sum[0..i]
To make rangeSum >= lower,
sum[0..j] - sum[0..i] >= lower
sum[0..j] - lower >= sum[0..i]
So when we reach nums[j],
we get accumulative sum sum[0..j] accumuSum,
we check if map.containsKey(sum) such that accumuSum - upper < sum < accumuSum - lower. If it contains, valid rangeSum found.
 * 
 */
package Searching;

import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author xinrong
 */
public class CountofRangeSum {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int cnt = new CountofRangeSum().countRangeSum(nums, 2, 5);
        System.out.println(cnt);
    }

    public int countRangeSum(int[] nums, int lower, int upper) {
        TreeMap<Long, Long> sumToCnt = new TreeMap<>();
        sumToCnt.put((long) 0, (long) 1);
        long accumuSum = 0;
        long rangeSumCnt = 0;
        for (int i = 0; i < nums.length; i++) {
            accumuSum += nums[i];
            Map<Long, Long> rangeSumToCnt = sumToCnt.subMap(accumuSum - upper, true, accumuSum - lower, true);
            for (Long cnt : rangeSumToCnt.values()) {
                rangeSumCnt += cnt;
            }
            sumToCnt.put(accumuSum, sumToCnt.getOrDefault(accumuSum, (long) 0) + 1);
        }
        return (int) rangeSumCnt;
    }

    public int countRangeSumNaive(int[] nums, int lower, int upper) {
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) { // [i, j]
            for (int j = i; j < nums.length; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += nums[k];
                }
                if (sum >= lower && sum <= upper) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
