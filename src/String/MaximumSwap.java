/* Q : 670. Maximum Swap
swap two digits at most once to get the maximum valued number
Example 1:
Input: 2736
Output: 7236
Explanation: Swap the number 2 and the number 7.
Example 2:
Input: 9973
Output: 9973
Explanation: No swap.
 * Thought Process:
e.g. 2763 (swap 1st biggest in last position with the first digit)
     7263 (swap 2nd biggest in last position with the snd digit
Alright, let's think about 1993, 9193 is not the biggest as you thought, 9913 is.
 * 
 */
package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author xinrong
 */
public class MaximumSwap {

    public static void main(String[] args) {
        int num = new MaximumSwap().maximumSwap(1993);
        System.out.println(num);
    }

    public int maximumSwap(int num) {
        String snum = String.valueOf(num);
        char[] cnum = snum.toCharArray();
        int[] nums = new int[cnum.length];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = cnum[i] - '0';
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new ArrayList<>());
            }
            map.get(nums[i]).add(i);
        }
        int[] copynums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copynums); 
        int k = 0;
        while (k < nums.length) {
            if (copynums[nums.length - 1 - k] == nums[k]) {
                k++;
                continue;
            }
            List<Integer> idx = map.get(copynums[nums.length - 1 - k]);
            Collections.sort(idx);
            if (idx.get(idx.size() - 1) > k) {
                swap(idx.get(idx.size() - 1), k, nums);
                return toNum(nums);
            }

            k++;
        }
        return num;
    }

    private int toNum(int[] nums) {
        // e.g. 1, 2
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = res * 10 + nums[i];
        }
        return res;
    }

    private void swap(int i, int j, int[] nums) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
