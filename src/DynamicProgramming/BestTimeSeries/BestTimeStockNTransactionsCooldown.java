/* 
 * Thought Process:
max sum of increasing distance WITH ONE MORE STATES
(s1, e1) (s2, e2)
s2 - e1 >= 2
like climbing stairs, 2 steps or 1 step
not choose it or choose it
dp[i] = max(dp[i - 1], dp[i - 2] + dp[i])
NONONO, with 3 statuses :
    buy sell, rest
        2 restrictionsl
    buy before sell, sell before buy
    rest before buy
until ith day, if i .., max profit
    buy[i]   = max(rest[i - 1] - prices[i],              buy[i - 1])    rest     > buy
    sell[i]  = max(buy[i - 1] + prices[i], rest[i - 1], sell[i - 1])    buy/rest > sell
    rest[i]  = max(buy[i - 1], sell[i - 1],             rest[i - 1])    buy/sell > rest
observation : buy[i] <= rest[i], and, this ensure 'buy rest buy not occur'
    rest[i]  = max(sell[i - 1],                         rest[i - 1])    sell > rest
observation : rest[i] <= sell[i]
    rest[i]  = sell[i - 1]                                              
substitution:
    buy[i]   = max(sell[i - 2] - prices[i],              buy[i - 1])    
    sell[i]  = max(buy[i - 1] + prices[i], sell[i - 2], sell[i - 1])    
observation : sell[i - 2] < sell[i - 1] ??? not sure
    buy[i]   = max(sell[i - 2] - prices[i],    buy[i - 1]) 
    sell[i]  = max(buy[i - 1] + prices[i],    sell[i - 1])    
FOR states ONLY rely on previous N states
    prev_sell, prev_buy, buy, sell
 * 
 */
package DynamicProgramming.BestTimeSeries;

/**
 *
 * @author xinrong
 */
public class BestTimeStockNTransactionsCooldown {

    public int maxProfit(int[] prices) {
        int buy = Integer.MIN_VALUE, sell = 0, prev_sell = 0, prev_buy = 0;
        for (int price : prices) {
            prev_buy = buy;
            buy = Math.max(prev_sell - price, buy);
            prev_sell = sell;
            sell = Math.max(prev_buy + price, sell);
        }
        return sell;
    }
}
