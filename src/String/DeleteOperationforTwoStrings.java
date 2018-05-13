/*
input : word1, word2
output: minimum deletes to make them same, where in each step you can delete one char in either string
 * Thought Process:
Minimum delete operation for two strings = word1.length() + word2.length() - 2 * len(Longest Common String).
To get LCS, we use Recursion with Memorization.
 * 
 */
package String;

import java.util.Arrays;

/**
 *
 * @author xinrong
 */
public class DeleteOperationforTwoStrings {

    public static void main(String[] args) {
        DeleteOperationforTwoStrings inst = new DeleteOperationforTwoStrings();
        int ans = inst.minDistance("abc", "ab");
        System.out.println(ans);
    }

    int[][] memo;

    public int minDistance(String word1, String word2) {
        memo = new int[word1.length()][word2.length()];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return word1.length() + word2.length() - 2 * getLCS(word1, word2, word1.length() - 1, word2.length() - 1);
    }

    private int getLCS(String word1, String word2, int m, int n) {
        if (m < 0 || n < 0) {
            return 0;
        }
        if (memo[m][n] != -1) {
            return memo[m][n];
        }
        if (word1.charAt(m) == word2.charAt(n)) {
            memo[m][n] = 1 + getLCS(word1, word2, m - 1, n - 1);
        } else {
            memo[m][n] = Math.max(getLCS(word1, word2, m - 1, n), getLCS(word1, word2, m, n - 1));
        }
        return memo[m][n];
    }
}
