/* 区间dp
Q : 给你m个字符，其中有n种字符，
每种字符都有两个值，分别是增加一个这样的字符的代价，删除一个这样的字符的代价，
让你求将原先给出的那串字符变成回文串的最小代价
 * Thought Process:
We define the dp [i] [j] a minimum cost palindrome into interval i to j.
So for the dp [i] [j] in three cases
First of all: for a string if s [i] ==s [j], dp[i][j]=dp[i+1][j-1] NOT PROMISE TO BE MINIMUM COST FOR IT IS WEIGHTED
Second: if dp [i+1] [j] is a palindrome string, then dp[i][j]=dp[i+1][j]+min(add[i], del[i]),
Finally, if the dp [i] [j-1] is a palindrome string, then dp[i][j]=dp[i][j-1] + min(add[j], del[j]),
 * Get: 区间dp
WHAT ? 是指在一段区间上的dp，通过枚举左右子区间来求出解。
HOW ? 去枚举左右子区间，循环一个变量len，表示区间长度，然后循环左区间从开始到结尾，一般来说是1～n。
      先求出小区间（部分）最优解，然后一个又一个小区间合并成稍微大点的大区间，最后合成答案——即总区间。
for(int len=1;len<=n;len++)
{
    for(int l=1,r;(r=l+len)<=n;l++)
    {
        //do something
        for(int k=l;k<r;k++)
        {
            //update dp array,such as'min(dp[l][r],dp[l][i]+dp[i+1][r])'
        }
    }
}

作者：KingSann
链接：https://www.jianshu.com/p/24feb3ccaf2e
來源：简书
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * 
 */
package DynamicProgramming;

/**
 *
 * @author xinrong
 */
public class CheapestPalindrome {

    public int cheapestPalin(String s, int m, int n, int[] add, int[] del) {
        int[][] dp = new int[m][m];
        int[] cost = new int[256];
        for (int i = 0; i < m; i++) {
            cost[s.charAt(i)] = Math.min(add[s.charAt(i)], del[s.charAt(i)]);
        }
        for (int k = 1; k < m; k++) {
            for (int i = 0, j = k; j < m; i++, j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j] + cost[s.charAt(i)], dp[i][j]);
                    dp[i][j] = Math.min(dp[i][j - 1] + cost[s.charAt(j)], dp[i][j]);
                }
            }
        }
        return dp[0][m - 1];
    }
}
