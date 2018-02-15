/* input  : s, t
   output : true if s and t are anagram
 * Thought Process:
 * 
 */
package Searching;

/**
 *
 * @author xinrong
 */
public class IsAnagram {
    
    public static void main(String[] args) {
        boolean ans = new IsAnagram().isAnagram("abcc", "abcd");
        System.out.println(ans);
    }
    
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null)
            return false;
        int slen = s.length();
        int tlen = t.length();
        if (slen != tlen)
            return false;
        int[] hash = new int[256];
        for (char c : s.toCharArray()) {
            hash[c]++;
        }
        for (char ct : t.toCharArray()) {
            hash[ct]--;
        }
        for (int i : hash) {
            if (i != 0)
                return false;
        }
        return true;
    }
}
