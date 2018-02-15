/* 3. Longest Substring Without Repeating Characters
 * Thought Process:
 * 
 */
package Searching;

/**
 *
 * @author xinrong
 */
public class LongestSubstringWithoutRepeatingCharacters {
    
    public static void main(String[] args) {
        int res = new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("pwwkew");
        System.out.println(res);
    }
    
    public int lengthOfLongestSubstring(String s) {
        int[] hash = new int[256];
        int st = 0;
        int mlen = 0;
        for (int e = 0; e < s.length(); e++) {
            while (hash[s.charAt(e)] != 0){
                // hash-- then st++
                hash[s.charAt(st)]--;
                st++;
            }
            hash[s.charAt(e)]++;
            mlen = Math.max(mlen, e - st + 1);
        }
        return mlen;
    }
}
