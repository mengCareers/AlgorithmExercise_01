/*
Given two strings str1 and str2 and below operations that can performed on str1. 
Find minimum number of edits (operations) required to convert ‘str1’ into ‘str2’.

 * Thought Process:
 * think from end to start, usually recursive:
compare the last char m & n, if equal, m - 1 & n - 1
if inequal : min(cost of insert: 1 + m & n - 1
                 cost of delete: 1 + m - 1 & n
                 cost of update: 1 + m - 1 & n - 1
 * think from start to end, usually dp
dp[m][n]: minimum cost required to convert 0..m - 1 in str1 into 0..n - 1 in str2

 */
package DynamicProgramming;

/**
 *
 * @author xinrong
 */
public class EditDistance {
    int editDist(String str1 , String str2 , int m ,int n) {
        if (m == 0) return n;
        if (n == 0) return m;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                // initialization
                if (i == 0) dp[i][j] = j;
                else if (j == 0) dp[i][j] = i;
                else if (str1.charAt(i - 1) == str2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                else {
                    dp[i][j] = 1 + min(dp[i][j - 1], dp[i - 1][j], dp[i - 1][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
    int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }
    
    public static void main(String[] args) {
        String str1 = "sunday";
        String str2 = "saturday";
        int dist = new EditDistance().editDist(str1, str2, 5, 7);
        System.out.println(dist);
    }
}
