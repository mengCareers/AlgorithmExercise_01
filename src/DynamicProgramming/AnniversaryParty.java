/* 树形dp
does not want both an employee and his or her immediate supervisor to be present at the same time
has evaluated conviviality ratings of each employee
Aim is to make a list of guests with the maximal possible sum of guests' conviviality ratings.
 * Thought Process :
定义dp[i][0] 为第i个人不选择所获得的最大欢乐值,dp[i][1] 为第i个人被选择所获得的最大欢乐值
假设 j 是第i个人的下属， 那么有转移方程  ：
dp[i][0]+=max( dp[j][0],dp[j][1]);  注意是+=，因为一个父节点有多个子节点
dp[i][1]+=dp[j][0];
用DFS遍历这棵树，每个顶点被访问，且只被访问一次。
 * 
 */
package DynamicProgramming;

/**
 *
 * @author xinrong
 */
public class AnniversaryParty {

    static int[][] dp;
    static boolean[] visited;

    /**
     *
     * @param son graph
     * @param n # people
     * @return
     */
    public static int getMaxAtmosphere(int[][] son, int[] rating, int n) {
        dp = new int[n][2];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            dp[i][1] = rating[i];
        }
        dfs(0, son);
        int max = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }

    static void dfs(int root, int[][] son) {
        visited[root] = true;
        for (int i = 0; i < son[root].length; i++) {
            int v = son[root][i];
            if (!visited[v]) {
                dfs(v, son);
                dp[root][1] += dp[v][0];
                dp[root][0] += Math.max(dp[v][0], dp[v][1]);
            }
        }
    }

    public static void main(String[] args) {
        int[][] son = {
            {1, 2},
            {3, 4, 5},
            {6},
            {},
            {},
            {},
            {}     
        };
        int n = 7;
        /**
         *      0    
         *   1      2
         * 3 4 5   6
         */
        int[] rating = {
            50, 10, 10, 5, 5, 5, 5
        };
        int ans = getMaxAtmosphere(son, rating, n);
        System.out.println(ans);
    }
}
