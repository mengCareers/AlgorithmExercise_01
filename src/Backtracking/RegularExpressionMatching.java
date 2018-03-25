/*
'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true
 * Thought Process:
 * s is hard to build the state space tree, so we try t
 */
package Backtracking;

/**
 *
 * @author xinrong
 */
public class RegularExpressionMatching {

    public boolean isMatch(String s, String p) {
        return isMatchUtil(s.toCharArray(), 0, p.toCharArray(), 0);
    }

    private boolean isMatchUtil(char[] s, int si, char[] p, int pi) {
        if (pi == p.length) {
            return si == s.length;
        }
        if (pi == p.length - 1) {
            if (si < s.length && (p[pi] == '.' || s[si] == p[pi])) {
                return isMatchUtil(s, si + 1, p, pi + 1);
            } else {
                return false;
            }
        }
        if (p[pi + 1] != '*') {
            if (si < s.length && (p[pi] == '.' || s[si] == p[pi])) {
                return isMatchUtil(s, si + 1, p, pi + 1);
            } else {
                return false;
            }
        } else {
            while (si < s.length && (p[pi] == '.' || s[si] == p[pi])) {
                if (isMatchUtil(s, si, p, pi + 2)) {
                    return true;
                }
                si++;
            }
            return isMatchUtil(s, si, p, pi + 2);
        }
    }
}
