/* 5. Longest Palindromic Substring
 * 
 */
package DynamicProgramming;

/**
 *
 * @author xinrong
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        int li = 0, ri = 0;
        int maxLen = 0;
        String longestPalindrome = "";
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = true;
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int l = 1; l + i <= s.length() - 1; l++) {
                int j = i + l;
                if (l == 1) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                    if (dp[i][j] && maxLen < j - i + 1) {
                        li = i;
                        ri = j;
                        maxLen = j - i + 1;
                    }
                    continue;
                }
                dp[i][j] = (dp[i + 1][j - 1]) && (s.charAt(i) == s.charAt(j));
                if (dp[i][j] && maxLen < j - i + 1) {
                    li = i;
                    ri = j;
                    maxLen = j - i + 1;
                }
            }
        }
        return s.substring(li, ri + 1);
    }
}
