/* 647.
input : s
output: # of palindromic substrings in s (different substrings decided by indexes)
 * Thought Process:
State : dp[i], # of palin substr if count s[i]
Aim State : dp[slen - 1]
Transfer : dp[i][j] = dp[i - 1][j + 1] + 2 if (s[i] == d[j])
           dp[i][j] = dp[i - 1][j + 1] + 1 if (s[i] == d[j])
           sum += dp
baa    b a a aa
baab   b a a aa 
       b baab
baac   b a a aa
       c 
 * Mentor :
It is hard to transfer the state, right?
In Longest Palindome String, how do we find the longest? A : exhaustive search, but store state in case duplicate
during the exhaustive search, why can't we count the number?
 * 
 */
package DynamicProgramming;

/**
 *
 * @author xinrong
 */
public class PalindromicSubstrings {

    public int countSubstrings(String s) {
        int cntSub = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = true;
            cntSub++;
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int l = 1; l + i <= s.length() - 1; l++) {
                int j = i + l;
                if (l == 1) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                    if (dp[i][j]) {
                        cntSub++;
                    }
                    continue;
                }
                dp[i][j] = (dp[i + 1][j - 1]) && (s.charAt(i) == s.charAt(j));
                if (dp[i][j]) {
                    cntSub++;
                }
            }
        }
        return cntSub;
    }
}
