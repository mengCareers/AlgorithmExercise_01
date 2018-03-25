/* 525. Contiguous Array
input : binary array
output: max len of a contiguous subarr with equal # of 0 and 1
 * Thought Process:
 * 0, 1, 0 int cnt = 0, if 0, cnt--; or else, cnt++;
cnt-1 0
does not say start with 0, we can get all subarr, check if satisfy, get the maxlen
get all subarr in maxlen order
or can we use sliding window ?
if 0, is -1
 */
package Searching;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author xinrong
 */
public class ContiguousArray {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 0, 1};
        int ans = new ContiguousArray().findMaxLength(nums);
        System.out.println(ans);
    }

    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();  // sum, idx  
        int sum = 0;
        int maxlen = 0;
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {            
            if (nums[i] == 0)
                nums[i] = -1;
            sum += nums[i];
            if (map.containsKey(sum))
                maxlen = Math.max(maxlen, i - map.get(sum));
            else
                map.put(sum, i);
        }
        
//        for (int i = 1; i < nums.length - 1; i++) {
//            for (int j = i + 1; j < nums.length; j++) { 
//                if (map.get(j) == 0)
//                    continue;
//                if (map.get(i - 1) == map.get(j)) {                    
//                    maxlen = Math.max(j - i + 1, maxlen);
//                }
//            }
//        }
        return maxlen;
//        int l = 0;
//        int r = 0;
//        int cursum = 0;
//        for (; r < nums.length; r++) {
//            cursum += nums[r];
//            if (cursum == 0) {
//                // no no no, we can't decide when to move left.
//            }
//        }
    }
}
