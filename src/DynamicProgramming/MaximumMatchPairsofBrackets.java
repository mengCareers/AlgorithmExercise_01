/*区间dp
Q: Given a brackets sequence of characters a1a2 … an, 
your goal is to find the length of the longest regular brackets sequence that is a subsequence of s. 
对称的括号匹配数量+2。问最大匹配数
 * Thought Process:
dp[i][j]代表从i到j区间的最大匹配个数, I EXIST FOR NO NEED TO MATCH FROM THE BEGINNING
对于dp[i][j]，如果i和j匹配，dp[i][j]=dp[i+1][j-1]+2.
然后依次枚举i到j之间的中间值dp[i][j] = max(dp[i][j], dp[i][k] + dp[k+1][j])

 * 
 */
package DynamicProgramming;

import java.util.Stack;

/**
 *
 * @author xinrong
 */
public class MaximumMatchPairsofBrackets {

    public static void main(String[] args) {

        String s = "([[]])";
        char[] arr = s.toCharArray();

        for (char c : arr) {
            System.out.print(c + " ");
        }
        System.out.println();
        int ans = maxMatch(arr);
        System.out.println(ans);
    }

    public static int maxMatch(char[] arr) {
        int[][] dp = new int[arr.length + 1][arr.length + 1];

        for (int i = 0; i < arr.length - 1; i++) {
            if (isMatch(arr[i], arr[i + 1])) {
                dp[i][i + 1] = 2;
            }
        }
        /**
         * for (int i = 0; i < arr.length; i++) { for(int j = i + 2; j <
         * arr.length; j++) { System.out.println(i + " " + j); } }
         * result would be:
0 2
0 3
0 4
1 3
1 4
2 4 
*         BUT WE WANT
0 2
1 3
2 4
0 3
1 4
0 4
         */
        for (int k = 2; k < arr.length; k++) {
            for (int i = 0, j = k; j < arr.length; i++, j++) {
                // System.out.println(i + " "  + j);
                if (isMatch(arr[i], arr[j])) {
                    dp[i][j] = dp[i + 1][j - 1] + 2; // ( [ ] not work
                }
                for (int m = i + 1; m < j; m++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][m] + dp[m + 1][j]);
                }

            }
        }

        return dp[0][arr.length - 1];
    }

    private static boolean isMatch(char c, char c0) {
        if (c == '(') {
            return c0 == ')';
        }
        if (c == '[') {
            return c0 == ']';
        }
        return false;
    }

}
