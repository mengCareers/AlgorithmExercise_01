/* 161. One Edit Distance
Given two strings s and t, determine if they are both one edit distance apart.

Note: 

There are 3 possiblities to satisify one edit distance apart:

Insert a character into s to get t
Delete a character from s to get t
Replace a character of s to get t
 * Thought Process:
There are 3 possiblities to satisify one edit distance apart,
Insert a character into s to get t when slen < tlen
Delete a character from s to get t when slen < tlen
Replace a character of s to get t when slen == tlen
So when we need to edit, we try these three possibilities.
 * 
 */
package String;

/**
 *
 * @author xinrong
 */
public class OneEditDistance {

    public boolean isOneEditDistance(String s, String t) {
        int slen = s.length(), tlen = t.length();
        for (int i = 0; i < Math.min(slen, tlen); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                // if replace
                if (s.length() == t.length()) {
                    return s.substring(i + 1).equals(t.substring(i + 1));
                }
                // if delete from s
                if (s.length() > t.length()) {
                    return s.substring(i + 1).equals(t.substring(i));
                }
                // if delete from t
                // if (s.length() < t.length()) {
                return s.substring(i).equals(t.substring(i + 1));
                // }
            }
        }
        return Math.abs(slen - tlen) == 1;
    }
}
