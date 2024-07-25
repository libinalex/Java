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

*/

public class Stocks {

    public static void main(String[] args) {

    }
}