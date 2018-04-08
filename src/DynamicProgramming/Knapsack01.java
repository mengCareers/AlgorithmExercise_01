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

    int knapSack(int[] weight, int[] value, int limitWeight) {
        int tmp[][] = new int[value.length + 1][limitWeight + 1];
        for (int i = 0; i < tmp.length; i++) {
            for (int j = 0; j < tmp[0].length; j++) {
                if (i == 0 || j == 0) {
                    tmp[i][j] = 0;
                } else if (weight[i - 1] > j) {
                    tmp[i][j] = tmp[i - 1][j];
                } else {
                    tmp[i][j] = Math.max(tmp[i - 1][j - weight[i - 1]] + value[i - 1], tmp[i - 1][j]);
                }
            }
        }
        for (int i = 0; i < tmp.length; i++) {
            for (int j = 0; j < tmp[0].length; j++) {
                System.out.print(tmp[i][j] + " ");
            }
            System.out.println();
        }
        return tmp[tmp.length - 1][tmp[0].length - 1];
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
        int val[] = {7, 12, 10, 15};
        int wt[] = {1, 3, 4, 5};

        int limitWeight = 7;
        int ans = new Knapsack01().knapSack(wt, val, limitWeight);
        System.out.println(ans);
    }
}
