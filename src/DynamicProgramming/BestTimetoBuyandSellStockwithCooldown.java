package DynamicProgramming;

/* Q: 309.Best Time to Buy and Sell Stock with Cooldown
 * Thought Process:
 * DP, - What are the natural states? 
        buy, sell, (rest is not considered as an action)
       - How do we use states to deduce the trasition func?
        need to build arrs for states: buy[i] maxProfit at day i with buy as last action
                                                    buy[i] does not mean that you must do buy action at day i
                                       sell[i]maxProfit at day i with sell as last action
                                       rest[i]maxProfit at day i with rest as last action
        buy[i] = max(sell[i-2] - price, buy[i-1] )
        sell[i]= max(buy[i-1]  + price, sell[i-1])
        where price is the price of day i
        
       - How do we optimize to use O(1) space?
        DP depends on i-1 and i-2 only, SO
            b1, b0     represent buy[i-1], buy[i]
            s2, s1, s0 represent sell[i-2], sell[i-1], sell[i]
        That is,
        b0 = max(s2 - price, b1)
        s0 = MAX(b1 + price, s1)
       - How do we define intial state i = 0?
            if buy, maxProfit at day 0 with a buy as last action is - prices[0]
            we cant sell, so maxProfit at day 0 with a sell as last action is 0
 */

/**
 *
 * @author xinrong
 */
public class BestTimetoBuyandSellStockwithCooldown {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        
        int b0 = - prices[0], b1 = b0;
        int s0 = 0, s1 = 0, s2 = 0;
        
        for (int i = 1; i < prices.length; i++) {
            int price = prices[i];
            b0 = Math.max(s2 - price, b1);
            s0 = Math.max(b1 + price, s1);
            b1 = b0;
            s2 = s1;
            s1 = s0;
        }
        return Math.max(s0, b0);
    }    
}
