/* 
1.Best time to buy and sell stock

We are given an array arr[] of length n. It represents the price of a stock on ‘n’ days. The following guidelines need to be followed:

We can buy and sell a stock only once.
We can buy and sell the stock on any day but to sell the stock, we need to first buy it on the same or any previous day.
We need to tell the maximum profit one can get by buying and selling this stock.


public class Stocks {
    static int buy_sell_stock(int[] arr) {
        int n = arr.length;
        int maxProfit = Integer.MIN_VALUE;
        int min = arr[0];
        for (int i = 1; i < n; i++) {
            int profit = arr[i] - min;
            maxProfit = Math.max(maxProfit, profit);
            min = Math.min(arr[i], min);
        }
        return maxProfit;
    }
    public static void main(String[] args) {
        int[] arr = { 7, 1, 5, 3, 5, 4 };
        int maxProfit = buy_sell_stock(arr);
        System.out.println(maxProfit);
    }
}
*/

/* 
2. Buy and Sell Stocks - 2
We are given an array arr[] of length n. It represents the price of a stock on ‘n’ days. The following guidelines need to be followed:

We can buy and sell the stock any number of times.
In order to sell the stock, we need to first buy it on the same or any previous day.
We can't buy a stock again after buying it once. In other words, we first buy a stock and then sell it. After selling we can buy and sell again. But we can’t sell before buying and can’t buy before selling any previously bought stock.

eg.
int[] prices = { 7, 1, 5, 3, 6, 4 };
Max Profit = 7 {(5 - 1) + (6 - 3)}



import java.util.Arrays;

public class Stocks {

    static int buySellStocks2_Tabulation(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];

        dp[n][0] = dp[n][1] = 0; // base case
        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 0; buy <= 1; buy++) {
                int profit = 0;
                if (buy == 1) {
                    int buyStock = -prices[i] + dp[i + 1][0];
                    int notBuyStock = 0 + dp[i + 1][1];
                    profit = Math.max(buyStock, notBuyStock);
                } else {
                    int sellStock = prices[i] + dp[i + 1][1];
                    int notSellStock = 0 + dp[i + 1][0];
                    profit = Math.max(sellStock, notSellStock);
                }
                dp[i][buy] = profit;
            }
        }
        
        // for (int[] i : dp)
        //     System.out.println(Arrays.toString(i));
        return dp[0][1]; // day 0, buy(1)
    }
    
    static int buySellStocks2_Memoization(int[] prices, int i, int buy, int[][] dp) {
       
        if (i == prices.length) { 
            return 0;
        }
        if(dp[i][buy] != -1)
            return dp[i][buy];
        int profit = 0;
        if (buy == 1) { 
            int buyStock = -prices[i] + buySellStocks2_Memoization(prices, i + 1, 0, dp);
            int notBuyStock = 0 + buySellStocks2_Memoization(prices, i + 1, 1, dp);
            profit = Math.max(buyStock, notBuyStock);
        } else { 
            int sellStock = prices[i] + buySellStocks2_Memoization(prices, i + 1, 1, dp);
            int notSellStock = 0 + buySellStocks2_Memoization(prices, i + 1, 0, dp);
            profit = Math.max(sellStock, notSellStock);
        }
        return dp[i][buy] = profit;
    }
    
    static int buySellStocks2_Recursion(int[] prices, int i, int buy) {  
        
        // buy = 1 -> we can buy
        // buy = 0 -> we cannot buy
        // whenever we buy -> we subtract, when we sell -> we add
        // eg. buy on day 0 (7) and sell on day 2(5): profit = 5 - 7
        
        if (i == prices.length) { // after last day
            return 0; // if still you have bought something, you wont make any profit
        }

        int profit = 0;
        if (buy == 1) { // we can buy
            int buyStock = -prices[i] + buySellStocks2_Recursion(prices, i + 1, 0);
            int notBuyStock = 0 + buySellStocks2_Recursion(prices, i + 1, 1);
            profit = Math.max(buyStock, notBuyStock);
        }
        else { // we cannot buy, so we can sell
            int sellStock = prices[i] + buySellStocks2_Recursion(prices, i + 1, 1);
            int notSellStock = 0 + buySellStocks2_Recursion(prices, i + 1, 0);
            profit = Math.max(sellStock, notSellStock);
        }
        return profit;
    }
    public static void main(String[] args) {
        int[] prices = { 5, 2, 7, 3, 6, 1, 2, 4 };
        // int maxProfit = buySellStocks2_Recursion(prices, 0, 1); // starting from day 0, where we can buy(1), what is the max profit

        // int[][] dp = new int[prices.length][2];
        // for(int[] i: dp)
        //     Arrays.fill(i, -1);
        // int maxProfit = buySellStocks2_Memoization(prices, 0, 1, dp); 

        int maxProfit = buySellStocks2_Tabulation(prices); 
        System.out.println(maxProfit);
    }
}
*/

/* 
3. Buy and Sell Stocks - 3
We are given an array Arr[] of length n. It represents the price of a stock on ‘n’ days. The following guidelines need to be followed:

We can buy and sell the stock any number of times.
In order to sell the stock, we need to first buy it on the same or any previous day.
We can’t buy a stock again after buying it once. In other words, we first buy a stock and then sell it. After selling we can buy and sell again. But we can’t sell before buying and can’t buy before selling any previously bought stock.
We can do at most 2 transactions.

eg.
int[] prices = { 3, 3, 5, 0, 0, 3, 1, 4 };
Max Profit = 6 { (3-0) + (4-1) }


import java.util.Arrays;

public class Stocks {
    static int buy_sell_stocks_3_Tabulation(int prices[]) {
        int n = prices.length;
        int[][][] dp = new int[n+1][2][3];

        for (int i = n; i >=0; i--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int cap = 0; cap <= 2; cap++) {
                    if(i==n || cap == 0)
                        dp[i][buy][cap] = 0;
                    else {
                        int profit = 0;
                        if (buy == 1) {
                            int buyStock = -prices[i] + dp[i + 1][0][cap];
                            int notBuyStock = 0 + dp[i + 1][1][cap];
                            profit = Math.max(buyStock, notBuyStock);
                        } else {
                            int sellStock = prices[i] + dp[i + 1][1][cap - 1];
                            int notSellStock = 0 + dp[i + 1][0][cap];
                            profit = Math.max(sellStock, notSellStock);
                        }
                        dp[i][buy][cap] = profit;
                        
                    }
                }
            }
        }
        return dp[0][1][2]; // starting from day 0, allowed to buy(1), with cap of 2
    }
    
    static int buy_sell_stocks_3_Memoization(int prices[], int i, int buy, int cap, int[][][] dp) {
        if (i >= prices.length)
            return 0;
        if (cap == 0)
            return 0;
        if(dp[i][buy][cap] != -1)
            return dp[i][buy][cap];
        
        int profit = 0;
        if (buy == 1) {
            int buyStock = -prices[i] + buy_sell_stocks_3_Memoization(prices, i + 1, 0, cap, dp);
            int notBuyStock = 0 + buy_sell_stocks_3_Memoization(prices, i + 1, 1, cap, dp);
            profit = Math.max(buyStock, notBuyStock);
        } else {
            int sellStock = prices[i] + buy_sell_stocks_3_Memoization(prices, i + 1, 1, cap - 1, dp);
            int notSellStock = 0 + buy_sell_stocks_3_Memoization(prices, i + 1, 0, cap, dp);
            profit = Math.max(sellStock, notSellStock);
        }
        return dp[i][buy][cap] = profit;
    }
    
    static int buy_sell_stocks_3_Recursion(int prices[], int i, int buy, int cap) {
        if(i>=prices.length)
            return 0;
        if(cap == 0)
            return 0;
        
        int profit = 0;
        if (buy == 1) {
            int buyStock = -prices[i] + buy_sell_stocks_3_Recursion(prices, i + 1, 0, cap);
            int notBuyStock = 0 + buy_sell_stocks_3_Recursion(prices, i + 1, 1, cap);
            profit = Math.max(buyStock, notBuyStock);
        }
        else {
            int sellStock = prices[i] + buy_sell_stocks_3_Recursion(prices, i + 1, 1, cap - 1);
            int notSellStock = 0 + buy_sell_stocks_3_Recursion(prices, i + 1, 0, cap);
            profit = Math.max(sellStock, notSellStock);
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] prices = { 3, 3, 5, 0, 0, 3, 1, 4 };  
        // int maxProfit = buy_sell_stocks_3_Recursion(prices, 0, 1, 2);

        // buy -> 0, 1
        // cap -> 0, 1, 2
        int[][][] dp = new int[prices.length][2][3];
        for (int[][] i : dp)
            for(int[] j: i)
                Arrays.fill(j, -1);
        int maxProfit = buy_sell_stocks_3_Memoization(prices, 0, 1, 2, dp);
        
        // int maxProfit = buy_sell_stocks_3_Tabulation(prices);

        System.out.println(maxProfit);
    }
}
*/

/* 
4. Buy and Sell Stocks With Cooldown
We are given an array Arr[] of length n. It represents the price of a stock on ‘n’ days. The following guidelines need to be followed:

We can buy and sell the stock any number of times.
In order to sell the stock, we need to first buy it on the same or any previous day.
We can’t buy a stock again after buying it once. In other words, we first buy a stock and then sell it. After selling we can buy and sell again. But we can’t sell before buying and can’t buy before selling any previously bought stock.
We can’t buy a stock on the very next day of selling it. This is the cooldown clause.

eg. int[] arr = {4,9, 0, 4, 10};
max Profit = 11 {(9-4) +(10-4)}
*/

public class Stocks {
    static int buy_sell_stock_cooldown_Recursion(int[] prices, int i, int buy) {
        if(i>=prices.length)
            return 0;
        int profit = 0;
        if (buy == 1) {
            int buyStock = -prices[i] + buy_sell_stock_cooldown_Recursion(prices, i + 1, 0);
            int notBuyStock = 0 + buy_sell_stock_cooldown_Recursion(prices, i + 1, 1);
            profit = Math.max(buyStock, notBuyStock);
        }
        else {
            int sellStock = prices[i] + buy_sell_stock_cooldown_Recursion(prices, i + 2, 1);
            int notSellStock = 0 + buy_sell_stock_cooldown_Recursion(prices, i + 1, 0);
            profit = Math.max(sellStock, notSellStock);
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] prices = { 4, 9, 0, 4, 10 };
        int maxProfit = buy_sell_stock_cooldown_Recursion(prices, 0, 1);
        System.out.println(maxProfit); 
    }
}