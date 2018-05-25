/*
Given two strings str1 and str2 and below operations that can performed on str1. 
Find minimum number of edits (operations) required to convert ‘str1’ into ‘str2’.
Insert a char.
Delete a char.
Replace a char.

 * Thought Process:
The problem is to find minimum # of edits required to convert str1[0..m-1] into str2[n-1]
We define STATE as dp[i][j] as minimum # of edits required to convert str1[0..i-1] to str2[0..j-1]
Then the END(AIM) STATE as dp[m][n].
STATE TRANSFER as below :
    e.g. ..cd
         ..d
    standing at str1[i-1], 
    if str1[i-1] != str2[j-1] we can
            insert a char dp[i][j] = dp[i][j-1] + 1 // insert 
            delete a char dp[i][j] = dp[i-1][j] + 1
            replace a char dp[i][j] = dp[i-1][j-1] + 1
        we get the minimum among them,
        min(dp[i-1][j-1] + 1, dp[i-1][j] + 1,dp[i][j-1] + 1)
    if str1[i-1] == str2[j-1] 
        dp[i][j] = dp[i-1][j-1];

 */
package DynamicProgramming;

/**
 *
 * @author xinrong
 */
public class EditDistance {

    public int minDistance(String word1, String word2) {
        // corner cases
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i < m + 1; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j < n + 1; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        return dp[m][n];
    }
}
