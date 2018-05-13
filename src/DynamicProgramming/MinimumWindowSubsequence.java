/* 727. Minimum Window Subsequence
input : S, T
output: minimum substring W of S, so that T is subsequece of W
if there is no W, return ""
if there are multiple minimum-length windows, return the one  with left-most starting index
 * Thought Process:
 * exhausitve, list all windows in S with len >= Tlen, and see if contains T as subsequence
Longest Commong Subsequence
e.g. T = 'ab'
S[j] = 'b' in S, 
look for most recent 'a' that occurred before it, S[i]
and that forms a candidate window S[i]..S[j]
     T = 'abc'
S[k] = 'c' in S
look for most recent window ended at 'b' [i, j]
and that forms a candidate window S[i]..S[k]
     We add characters to T one at a time,
S[k] = T[len - 1] in S
get the length of the candidate window ending at k (using knowledge of the length of the previous windo..w)
GET:
dp[i][j] : For S[0..i] and T[0..j], the largest starting index in S, which matches T.
e.g. S = "acb", T = "cb"

    c    b
a  -1  -1
c  1   -1
b  1    1
start = 1, len = 2
 */
package DynamicProgramming;

/**
 *
 * @author xinrong
 */
public class MinimumWindowSubsequence {

    public String minWindow(String S, String T) {
        int[][] dp = new int[S.length()][T.length()];

        // if j == 0
        for (int i = 0; i < dp.length; i++) {
            if (S.charAt(i) == T.charAt(0)) {
                dp[i][0] = i;
            } else {
                if (i == 0) {
                    dp[i][0] = -1;
                } else {
                    dp[i][0] = dp[i - 1][0];
                }
            }
        }
        // if i == 0
        for (int j = 1; j < dp[0].length; j++) {
            dp[0][j] = -1;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (S.charAt(i) == T.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        int start = 0;
        int len = Integer.MAX_VALUE;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i][T.length() - 1] != -1) {
                if (i - dp[i][T.length() - 1] + 1 < len) {
                    len = i - dp[i][T.length() - 1] + 1;
                    start = dp[i][T.length() - 1];
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : S.substring(start, start + len);

    }
}
