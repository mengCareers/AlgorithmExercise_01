/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hashing;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author xinrong
 */
public class LongestConsecutiveSubsequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) set.add(i);
        int maxlen = 0;
        for (int i : nums) {
            if (!set.contains(i - 1)) { // i could be the first element
                int len = 1;
                int j = i + 1;
                while (set.contains(j)) {
                    j++;
                    len++;
                }
                maxlen = Math.max(maxlen, len);
            }
        }
        return maxlen;
    }
}
