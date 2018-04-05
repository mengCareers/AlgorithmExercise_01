/* 5. Longest Palindromic Substring
Given a string s, find the longest palindromic substring in s. 
You may assume that the maximum length of s is 1000.
 * Thought Process:
区间dp
s[i][j] true if s[i + 1][j - 1] true and Ai = Aj
 * 
 */
package DynamicProgramming;

/**
 *
 * @author xinrong
 */
public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        String ans = longestPalindrome("b");
        System.out.println(ans);
    }

    public static String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        String res = "";
        for (int l = 0; l < s.length(); l++) {
            for (int i = 0; i + l < s.length(); i++) {
                int j = i + l;
                if (s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                }
                if (dp[i][j] && (j - i + 1 > res.length())) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }
}
