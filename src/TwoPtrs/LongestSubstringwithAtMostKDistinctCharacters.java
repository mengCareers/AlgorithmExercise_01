package TwoPtrs;


import java.util.HashMap;
import java.util.Map;

/* 340. Longest Substring with At Most K Distinct Characters
input : s, k
output: length of the longest substr
 * Thought Process:
BF: list all substrs, if contains at most k distinct chars, save length
    return the biggest
eceba
ec
ece
eb
ba
 * 
 */

/**
 *
 * @author xinrong
 */
public class LongestSubstringwithAtMostKDistinctCharacters {
    public static void main(String[] args) {
        new LongestSubstringwithAtMostKDistinctCharacters().lengthOfLongestSubstringKDistinct("eceba", 2);
    }
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int l = 0, r = 0, max = 0;
        while (r < s.length()) {
            char c = s.charAt(r);
            map.put(c, map.getOrDefault(c, 0) + 1);
            while (map.size() > k) {
                char lc = s.charAt(l);
                map.put(lc, map.get(lc) - 1);
                if (map.get(lc) == 0)
                    map.remove(lc);
                l++;
            }
            max = Math.max(max, r - l + 1);
            r++;
        }
        return max;
    }
}
