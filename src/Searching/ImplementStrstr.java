/*
Return the index of the first occurrence of x in s, or -1 if x is not part of s.
 * Thought Process:
if si == x0, from i, we chk if ok
 * 
 */
package Searching;

/**
 *
 * @author xinrong
 */
public class ImplementStrstr {
    
    public static void main(String[] args) {
        int ans = new ImplementStrstr().strStr("hello", "ll");
        System.out.println(ans);
    }
    
    public int strStr(String s, String x) {
        if (s == null || x == null)
            return -1;
        if (x.length() == 0)
            return 0;
        if (x.length() > s.length())
            return -1;
        int si = 0;
        while (si < s.length()) {
            if (s.charAt(si) == x.charAt(0)) {
                if (isValid(s, si, x))
                    return si;
            }
            si++;
        }
        return -1;
    }
    private boolean isValid(String s, int start, String x) {
        int i = start, j = 0;
        while (i < s.length() && j < x.length()) {
            if (s.charAt(i) == x.charAt(j)) {
                i++;
                j++;
            }
            else
                return false;    
        }
        if ( j == x.length() )
            return true;
        return false;
    }
}
