/*
our are given an array of integers prices, for which the i-th element is the price of a given stock on day i; and a non-negative integer fee representing a transaction fee.
You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction. 
You may not buy more than 1 share of a stock at a time 
pay the transaction fee for each transaction.
Input: prices = [1, 3, 2, 8, 4, 9], fee = 2
Output: 8
Explanation: The maximum profit can be achieved by:
Buying at prices[0] = 1
Selling at prices[3] = 8
Buying at prices[4] = 4
Selling at prices[5] = 9
The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 * Thought Process: 
max sum of increasing distance WITH ONE MORE RESTRICTION
dp[t] = Math.max ( dp[t - 1]+w[i], dp[t] ) 
However, here w[i] is not fixed, it is also influenced by previous decisions
Alright, we think as cooldown, how many states do we have?
buy sell hold no_hold
buy[i] = max(sell[i - 1] - prices[i], nohold[i - 1] - prices[i])                                sell / nohold > buy
sell[i]= max(buy[i - 1] + prices[i] - fee, hold[i - 1] + prices[i] - fee)                   buy / hold    > sell
hold[i]= max(hold[i - 1], buy[i - 1])                                                       buy / hold    > hold
nohold[i] = max(nohold[i - 1], sell[i - 1])                                                 sell / nohold > nohold
 * 
 */
package DynamicProgramming.BestTimeSeries;

/**
 *
 * @author xinrong
 */
public class BestTimeStockNTransactionsFee {

    public static int maxProfit(int[] prices, int fee) {
        int maxProf = Integer.MIN_VALUE;
        int buy = -prices[0], sell = 0, hold = -prices[0], nohold = 0;
        int prev_buy = 0, prev_sell = 0;
        for (int i = 1; i < prices.length; i++) {
            prev_buy = buy;
            prev_sell = sell;
            buy = Math.max(sell, nohold) - prices[i];
            System.out.println("buy : " + buy);
            sell = Math.max(prev_buy, hold) + prices[i] - fee;
            System.out.println("sell : " + sell);
            hold = Math.max(hold, prev_buy);
            System.out.println("hold : " + hold);
            nohold = Math.max(nohold, prev_sell);
            System.out.println("nohold : " + nohold);

        }
        maxProf = Math.max(sell, hold);
        return maxProf;
    }

    public static int XmaxProfit(int[] prices, int fee) {
        int maxProf = Integer.MIN_VALUE;
        int buy = 0, sell = 0, hold = Integer.MIN_VALUE, nohold = 0;
        int prev_buy = 0, prev_sell = 0;
        for (int i = 1; i < prices.length; i++) {
            prev_buy = buy;
            prev_sell = sell;
            buy = Math.max(sell, nohold) - prices[i];
            System.out.println("buy : " + buy);
            sell = Math.max(prev_buy, hold) + prices[i] - fee;
            System.out.println("sell : " + sell);
            hold = Math.max(hold, prev_buy);
            System.out.println("hold : " + hold);
            nohold = Math.max(nohold, prev_sell);
            System.out.println("nohold : " + nohold);
        }
        maxProf = Math.max(sell, hold);
        return maxProf;
    }

    public static void main(String[] args) {
        int[] prices = {1, 3, 2, 8, 4, 9};
        int ans = maxProfit(prices, 2);
        System.out.println(ans);
        ans = XmaxProfit(prices, 2);
        System.out.println(ans);
    }
}
