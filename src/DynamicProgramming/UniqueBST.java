/* 96.
--------- Version_02
input : n
output: # of unique structurally BST that stores 1..n
 * Thought Process:
The problem is to get # of unique structurally BST that stores 1..n
We define the STATE as result[i] as # of unique structurally BST that stores 1..i
Then END STATE as result[n]
STATE TRANSFER like : 
    Each of 1..i can be the root, 
    if we take r as root, then left subtree is [0, r-1], right subtree is [r+1, i]
    If we define another STATE as as dp[s][e] as # of unique structurally BST that stores s..e, the END STATE as dp[1][n], 
    the # of unique structurally BST that stores 1..i with r root for 1 <= r <= i will be dp[1][r-1] * dp[r+1][i].
    We try 1..i each one as root,and get the sum. The sum will be result[i]. 
    That is,
        result[i] = dp[1][1] * dp[3][i] + dp[1][2] * dp[4][i] + ..
                  = sum(dp[1][r-1] * dp[r+1][i])
                  = sum(result[r-1]* result[i-r])

--------- Version_01
 * Q : # of unique structurally BST that stores 1..n
 * State : dp[i, r], # of unique structurally BST that stores 1..i and root r (1 <= r <= i)
 * Aim to : G[i] = sum(dp[i, r]) (1 <= r <= i)
 * Transfer :
e.g. 1      1  dp[1, 1] = 1                              root1 = 1
     1,2    2  dp[2, 1] = 1, dp[2, 2] = 2                root1 + root2 = 1 + 1    
     1,2,3  5  dp[3, 1] = 2, dp[3, 2] = 1, dp[3, 3] = 2, root1 + root2 + root3 = 2 + 1 + 2
 * Mentor:
rootn part is good, we can enumerate 1 .. n as root individually,
why do we do that ? unique promised, if i as root, 0..i-1 is left sub, i+1..n is right sub
                    subproblem exists, right?
think about how do we get 
dp[3,1],    1
             \
             2,3        
dp[3,2],    2
           / \
          1   3
dp[3,3],    3
           /
          1,2
cnt left sub l , cnt right sub r, will be l * r o
                                       or l if r == 0
                                       or r if l == 0
dp[n, r] = G[r - 1] * G[n - r]
transfer : = dp[n, 1] + dp[n, 2] + ... dp[n, i]  (0 <= i <= n
           X= (1 - 1) * (n - 1) + (2 - 1) * (n - 2) + .. + (i - 1) * (n - i)
G[n] = G[1 - 1] * G[n - 1] + G[2 - 1] * G[n - 2] + G[3 - 1] * G[n - 3] + .. + G[n - 1] * G[n - n]
     = G(n) = G(0) * G(n-1) + G(1) * G(n-2) + … + G(n-1) * G(0);
0 <= i <= n
 * Corner case :
if (n == 0), G[0] = 0;
if (n == 1), G[1] = 1;
 * Implementation : 

 */
package DynamicProgramming;

import java.util.Arrays;

/**
 *
 * @author xinrong
 */
public class UniqueBST {

    int[] memo;

    public int numTreesRecur(int n) {
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return numTreesUtil(n);
    }

    public int numTreesUtil(int n) {
        if (memo[n] != -1) {
            return memo[n];
        }
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int cntTrees = 0;
        for (int r = 1; r <= n; r++) {
            int left = numTreesUtil(r - 1);
            int right = numTreesUtil(n - r);
            if (left == 0) {
                cntTrees += right;
            } else if (right == 0) {
                cntTrees += left;
            } else {
                cntTrees += left * right;
            }
        }
        memo[n] = cntTrees;
        return cntTrees;
    }

    public int numTrees(int n) {
        int[] result = new int[n + 1];
        result[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int r = 1; r <= i; r++) {
                result[i] += result[r - 1] * result[i - r];
            }
        }
        return result[n];
    }
}
