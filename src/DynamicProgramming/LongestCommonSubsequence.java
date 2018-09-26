/*
 * Thought Process:
 * 
 */
package DynamicProgramming;

/**
 *
 * @author xinrong
 */
public class LongestCommonSubsequence {

    public static void main(String[] args) {
        System.out.println(lenLCSubsequenceBottomup("abcd", "bede"));
    }

    public static int lenLCSubsequenceBottomup(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (s1.charAt(i - 1) != s2.charAt(j - 1)) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }

    public static int lenLCSubsequence(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int[] tmp : dp) {
            for (int i = 0; i < tmp.length; i++) {
                tmp[i] = -1;
            }
        }
        int ans = lcsutil(s, s.length(), t, t.length(), dp);
        for (int[] tmp : dp) {
            for (int i = 0; i < tmp.length; i++) {
                System.out.print(tmp[i] + " ");
            }
            System.out.println();
        }
        return ans;
    }

    public static int lcsutil(String s, int n, String t, int m, int[][] dp) {
        if (n == 0 || m == 0) {
            return 0;
        }
        if (dp[n][m] != -1) {
            return dp[n][m];
        }
        int result = 0;
        if (s.charAt(n - 1) == t.charAt(m - 1)) {
            result = 1 + lcsutil(s, n - 1, t, m - 1, dp);
        } else {
            result = Math.max(lcsutil(s, n - 1, t, m, dp), lcsutil(s, n, t, m - 1, dp));
        }
        dp[n][m] = result;
        return result;
    }

}
