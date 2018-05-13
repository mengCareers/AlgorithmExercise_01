/* 474. Ones and Zeroes
find the maximum number of strings that you can form with given m 0s and n 1s. 
Each 0 and 1 can be used at most once.
Input: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3
Output: 4
Explanation: 
This are totally 4 strings can be formed by the using of 5 0s and 3 1s, 
which are “10,”0001”,”1”,”0”
 * Thought Process:
 * 
 */
package DynamicProgramming;

/**
 *
 * @author xinrong
 */
public class OnesandZeroes {

    private int[][][] memo;

    public int findMaxForm(String[] strs, int m, int n) {
        memo = new int[m + 1][n + 1][strs.length];
        return findMaxFormFrom(strs, m, n, 0);
    }

    private int findMaxFormFrom(String[] strs, int m, int n, int si) {
        if (si == strs.length || (m == 0 && n == 0)) {
            return 0;
        }
        if (memo[m][n][si] > 0) {
            return memo[m][n][si];
        }
        int cntIncludeStr = 0;
        int zeros = countZeros(strs[si]);
        int ones = strs[si].length() - zeros;
        if (m >= zeros && n >= ones) {
            cntIncludeStr = 1 + findMaxFormFrom(strs, m - zeros, n - ones, si + 1);
        }
        int cntExcludeStr = findMaxFormFrom(strs, m, n, si + 1);
        memo[m][n][si] = Math.max(cntIncludeStr, cntExcludeStr);
        return memo[m][n][si];
    }

    private int countZeros(String s) {
        int cntZero = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') {
                cntZero++;
            }
        }
        return cntZero;
    }
}
