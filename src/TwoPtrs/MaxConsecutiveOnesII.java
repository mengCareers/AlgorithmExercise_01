/* 487. Max Consecutive Ones II
input : nums
output: maximum # of consecutive 1s if can flip one 0
 * Get:
To get the max consecutive 1s if we can flip one 0, in fact, is to get the maximum length of window that contains only one 0. After we flip the 0 to 1, the window is with max consecutive ones.
left : start index of the current window
right : end index of the current window
cntWindowZero : number of 0s in the current window
maxWindowLength : maximum length of window that contains only one 0
 * 
 */
package TwoPtrs;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author xinrong
 */
public class MaxConsecutiveOnesII {

    public int findMaxConsecutiveOnes(int[] nums) {
        int cntWindowZero = 0, maxWindowLength = 0, left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                cntWindowZero++;
            }
            while (cntWindowZero == 2) {
                if (nums[left] == 0) {
                    cntWindowZero--;
                }
                left++;
            }
            maxWindowLength = Math.max(maxWindowLength, right - left + 1);
        }
        return maxWindowLength;
    }

    /**
     * I thought the maximum length of consecutive ones in original array should
     * be included in answer, however, it may not e.g. 1 1 1 1 0 0 1 1 1 0 1 1 1
     *
     * @param nums
     * @return
     */
    public int findMaxConsecutiveOnesIncorrect(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxS = 0, maxE = 0, maxOnes = 0;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == 1) {
                int j = i + 1;
                int cntOnes = 1;
                while (j < nums.length) {
                    if (nums[j] == 1) {
                        cntOnes++;
                        j++;
                    } else {
                        break;
                    }
                }
                if (maxOnes > cntOnes) {
                    maxS = i;
                    maxE = j - 1;
                }
                map.put(i, cntOnes);
                i = j;
            } else {
                i++;
            }
        }
        int extraOnes = 0;
        if (nums[map.get(maxE) + 2] == 1) {
            extraOnes = map.get(map.get(maxE) + 1);
        }
        if (nums[map.get(maxS) - 2] == 1) {
            // extraOnes = map.get(map.get(maxS) - 2)
        }
        return maxOnes + 1;
    }
}
