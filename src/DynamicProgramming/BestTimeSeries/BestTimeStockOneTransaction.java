/* 121.
 * Thought Process:
Let's think about it in an exhaustive search way,
e.g. 7, 1, 5, 3, 6, 4
     7  1  1  1  1  1
For each number, we minus its left minimum value, and keep track of the maximum one

the problem is to get the maximum (prices[j] - prices[i]) for j > i from prices[0] to prices[n - 1]
if we define state as dp[i], the maximum (prices[b] - prices[a]) for b > a ended at prices[b] where 0 <= b <= i
the result state will be dp[n - 1]

MENTOR :
That is, Largest Increasing Distance
the values of i, j do not really matter
I :
X
 * 
 */
package DynamicProgramming.BestTimeSeries;

/**
 *
 * @author xinrong
 */
public class BestTimeStockOneTransaction {

    public int maxProfit(int[] prices) {
        int curDif = 0, maxDif = 0;
        for (int i = 1; i < prices.length; i++) {
            curDif = Math.max(0, curDif + prices[i] - prices[i - 1]);
            maxDif = Math.max(maxDif, curDif);
        }
        return maxDif;
    }

    public int maxProfitES(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int minLeftVal = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            minLeftVal = Math.min(minLeftVal, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minLeftVal);
        }
        return maxProfit;
    }

}
