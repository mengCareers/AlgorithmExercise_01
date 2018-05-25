/* 516.Longest Palindromic Subsequence
input : s
output: length of longest palindromic subsequence
 * Thought Process:
 * silimarly, 
state dp[i][j] true if s[i..j] is palindromic
but is not meaningful to use s[i..j] to represent subsequence for we can't tell the length
e.g.cbbbbbbbb
        4 
find last same char
dp[i] = dp[lastPos[ch]] + 1
get maximum overrall
 * Mentor :
dp[i][j] .. 'we can't tell the length'
what length we can't tell? A: palindromic subsequence
it can, we can redefine it
State : 
dp[i][j] : length of longest palindromic subsequence in s[i..j]
Aim State : 
dp[0][slen - 1]
Transfer : 
when we count s[j], there are two conditions, s[j] may or may not equal to s[i].
  if j - i + 1 >= 3
    if (s[j] == s[i])
        dp[i][j] = dp[i + 1][j - 1] + 2
    else
        dp[i][j] = max(dp[i][j - 1], dp[i + 1][j])
  if j - i + 1 == 2
    if (s[j] == s[i])
        dp[i][j] = 2
    else 
        dp[i][j] = 1
  if j - i + 1 == 1
    dp[i][j] = 1
Implementation : Bottom-up DP
 */
package DynamicProgramming;

/**
 *
 * @author xinrong
 */
public class LongestPalindromicSubsequence {

    public int longestPalindromeSubseq(String s) {
        // dp[i][j] length of longest palindromic subsequence in s[i..j] inclusive
        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = 1;
        }
        int j = 0;
        for (int i = dp.length - 1; i >= 0; i--) {
            for (int l = 1; i + l < dp.length; l++) {
                j = i + l;
                if (l == 1) {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = 2;
                    } else {
                        dp[i][j] = 1;
                    }
                } else {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    } else {
                        dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                    }
                }
            }
        }
        return dp[0][s.length() - 1];
    }
}
