/* 122. Best Time to Buy and Sell Stock II
Design an algorithm to find the maximum profit. 
You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). 
However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * Thought Process:
max sum of increasing distance
 * 
 */
package DynamicProgramming.BestTimeSeries;

/**
 *
 * @author xinrong
 */
public class BestTimeStockNTransactions {

    public int maxProfit(int[] prices) {
        int maxProfMet = 0;
        for (int i = 0; i < prices.length; i++) {
            if (i > 0 && prices[i] > prices[i - 1]) {
                maxProfMet += prices[i] - prices[i - 1];
            }
        }
        return maxProfMet;
    }
}
