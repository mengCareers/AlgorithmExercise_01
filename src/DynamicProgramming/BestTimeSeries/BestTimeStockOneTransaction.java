/*
 * Thought Process:
min buy,
max sell
max - min in arr
!! min should in front of max - restriction aggreation - dp
That is, Largest Increasing Distance
 * 
 */
package DynamicProgramming.BestTimeSeries;

/**
 *
 * @author xinrong
 */
public class BestTimeStockOneTransaction {

    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int maxDist = 0;
        for (int i = 0; i < prices.length; i++) {
            int dist = prices[i] - min;
            if (dist > maxDist) {
                maxDist = dist;
            }
            if (prices[i] < min) {
                min = prices[i];
            }
        }
        return maxDist;
    }
}
