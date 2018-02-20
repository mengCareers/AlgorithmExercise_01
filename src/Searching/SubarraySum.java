/* 560. Subarray Sum Equals K
 * Thought Process:
 * 
 */
package Searching;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author xinrong
 */
public class SubarraySum {

    public static void main(String[] args) {
        int[] arr = {10 ,3};
        int target = 3;
        int ans = new SubarraySum().subarraySum(arr, target);
        System.out.println(ans);
    }
    
    public int subarraySumWithNegative(int[] arr, int target) {        
        if (arr == null || arr.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int curSum = 0, res = 0;
        for (int i = 0; i < arr.length; i++) {
            curSum += arr[i];
            if (map.containsKey(curSum - target)) {
                res += map.get(curSum - target);
            }
            map.put(curSum, map.getOrDefault(curSum, 0) + 1);
        }
        return res;
    }
    
    public int subarraySum(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int curSum = arr[0], start = 0;
        int res = 0;
        for (int i = 1; i <= arr.length; i++) {
            while (curSum > target && start < i) { // if start < i - 1, then [10, 3] target 3, 10 will not be ignored.
                curSum -= arr[start];
                start++;
            }
            if (curSum == target) {
                res++;
            }
            if (i < arr.length) {
                curSum += arr[i];
            }
        }
        return res;
    }
}
