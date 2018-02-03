/*
weights and values of n items, put these items in a knapsack of capacity W to get maxi value
w[0..n-1] and val[0..n-1] 
either pick the complete item or don't pick it (0-1 property)
 * Thought Process:
 consider all subsets of items and calculate total weight and value
consider only subsets weight <= W, and pick the maximum value subset
1) Optimal Substructure:
  2 cases for every item: included or excluded.
  So maximum value that can be obtained form n items is max of following two values:
    a. [max value obtained by n - 1 items] and [W weight]
    b. [value of nth item PLUS max value obtained by n - 1 items] and [W minus weight of nth item]
  ! if weight of nth items > W, then only case a. possible
2) Overlapping Subproblems
 * Recursion simply cause recomputations of same subproblems, it can be avoided by constructing
   K[i][w] in bottom up manner
*/
package DynamicProgramming;

/**
 *
 * @author xinrong
 */
public class Knapsack01 {
    int knapSack(int W, int[] wt, int[] val, int n) {        
        int K[][] = new int[n + 1][W + 1];
        for (int i = 0 ; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (i == 0 || w == 0) K[i][w] = 0;
                else if (wt[i - 1] > w) K[i][w] = K[i - 1][w] ;
                else K[i][w] = Math.max(val[i - 1] + K[i - 1][w - wt[i - 1]], K[i - 1][w]);
            }
        }
        return K[n][W];
    }
    /*
    int knapSack(int W, int[] wt, int[] val, int n) {
        // Base Case
        if (n == 0 || W == 0) return 0;
        // z!
        if (wt[n - 1] > W) return knapSack(W, wt, val, n - 1);
        
        return Math.max(val[n - 1] + knapSack(W - wt[n - 1], wt, val, n - 1),
                knapSack(W, wt, val, n - 1));
    }
    */
    public static void main(String[] args) {
        int val[] = {60, 100, 120};
        int wt[] = {10, 20, 30};
        int W = 50;
        int n = val.length;
        int ans = new Knapsack01().knapSack(W, wt, val, n);
        System.out.println(ans);
    }
}
