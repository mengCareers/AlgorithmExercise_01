/*
 * Thought Process:
 * 
 */
package DynamicProgramming;

/**
 *
 * @author xinrong
 */
public class LCS {

    public static void main(String[] args) {
        System.out.println(lcs("abcd", "bede"));
    }

    public static int lcs(String s, String t) {
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
