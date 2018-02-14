/* 392. Is Subsequence
input : s, t
output: true if s in subsequence of t
 * Thought Process:
subsequence is by deleting some chars, the rest relative order doesn't change
 * 
 */
package Searching;

/**
 *
 * @author xinrong
 */
public class IsSubsequence {

    public boolean isSubsequence(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        int slen = s.length(), tlen = t.length();
        if (slen > tlen) {
            return false;
        }
        if (slen == 0) {
            return true;
        }
        int si = 0;
        while (si < slen) {
            int tp = t.indexOf(s.charAt(si));
            if (tp == -1) {
                return false;
            }
            t = t.substring(tp + 1);
            si++;
        }
        return true;
    }
}
