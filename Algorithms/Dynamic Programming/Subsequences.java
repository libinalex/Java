/* 
1. Minimum Coins
We are given a target sum of ‘X’ and ‘N’ distinct numbers denoting the coin denominations. We need to tell the minimum number of coins required to reach the target sum. We can pick a coin denomination for any number of times we want.

Eg.
target = 7;
arr[] = {1, 2, 3};

ans: we will take 3 coins: {3, 3, 1};


import java.util.Arrays;

public class Subsequences {
    static int minimumCoins_Tabulation(int[] arr, int n, int target) {
        int[][] dp = new int[arr.length][target + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = 0;
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= target; j++) {
                if (i == 0) {
                    if (j % arr[0] == 0)
                        dp[i][j] = j / arr[0];
                    else
                        dp[i][j] = (int) 1e9;

                } else {
                    int notTake = dp[i - 1][j];
                    int take = (int) 1e9;
                    if (arr[i] <= j)
                        take = 1 + dp[i][j - arr[i]];

                    dp[i][j] = Math.min(notTake, take);

                }

            }
        }
        for (int[] i : dp) {
            System.out.println(Arrays.toString(i));
        }
        return dp[arr.length - 1][target];
    }
    
    static int minimumCoins_Memoization(int[] arr, int n, int target, int[][] dp) {
        if (target == 0)
            return 0; // no coin to be taken if target 0
        if (n == 0) {
            if (target % arr[0] == 0)
                return target / arr[0];
            else
                return (int) 1e9;
        }
        if(dp[n][target] != -1)
            return dp[n][target];
        int notTake = minimumCoins_Memoization(arr, n - 1, target, dp);
        int take = (int) 1e9;
        if (arr[n] <= target)
            take = 1 + minimumCoins_Memoization(arr, n, target - arr[n], dp);

        return dp[n][target] = Math.min(notTake, take);
    }

    static int minimumCoins_Recursion(int[] arr, int n, int target) {
        if (target == 0)
            return 0; // no coin to be taken if target 0
        if (n == 0) {
            if (target % arr[0] == 0)
                return target / arr[0];
            else
                return (int) 1e9;
        }
        int notTake = minimumCoins_Recursion(arr, n - 1, target);
        int take = (int) 1e9;
        if (arr[n] <= target)
            take = 1 + minimumCoins_Recursion(arr, n, target - arr[n]);

        return Math.min(notTake, take);
    }

    public static void main(String[] args) {
        int arr[] = { 2, 4, 5};
        int target = 11;
        // int minCoins = minimumCoins_Recursion(arr, arr.length - 1, target);

        // int[][] dp = new int[arr.length][target + 1];
        // for(int[] i: dp)
        //     Arrays.fill(i, -1);
        // int minCoins = minimumCoins_Memoization(arr, arr.length - 1, target, dp);

        int minCoins = minimumCoins_Tabulation(arr, arr.length, target);
        System.out.println(minCoins);
    }
}
*/

/* 
2. Coin change 2
We are given an array arr with N distinct coins and a target. We have an infinite supply of each coin denomination. We need to find the number of ways we sum up the coin values to give us the target.

Each coin can be used any number of times.
eg.
n = 3
arr[] = {1, 2, 3};
target = 4;

ans: 4 ways
{1+1+1+1}, {1+1+2}, {1+3}, {2+2}


import java.util.Arrays;

public class Subsequences {
    static int coinChange_Tabulation(int[] arr, int n, int target) {
        int[][] dp = new int[n][target + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= target; j++) {
                if (i == 0) {
                    if (j % arr[0] == 0)
                        dp[i][j] = 1;
                } else {
                    int take = 0;
                    if (arr[i] <= j)
                        take = dp[i][target - arr[i]];
                    int notTake = dp[i - 1][target];
                    dp[i][j] = take + notTake;

                }
            }
        }
        for (int[] i : dp)
            System.out.println(Arrays.toString(i));
        return dp[n - 1][target];
    }

    static int coinChange_Recursion(int[] arr, int n, int target) { // no. of ways coins can be selected from array selecting coins till n to get target
        if (n == 0) {
            if (target % arr[0] == 0)
                return 1;
        }
        if (target == 0) {
            return 1;
        }
        int notTake = coinChange_Recursion(arr, n - 1, target);
        int take = 0;
        if(arr[n] <= target)
            take = coinChange_Recursion(arr, n, target - arr[n]);
        return take + notTake;
    }
    public static void main(String[] args) {
        int n = 3;
        int arr[] = { 1, 2, 3 };
        int target = 4;
        
        // int ways = coinChange_Recursion(arr, n-1, target);
        int ways = coinChange_Tabulation(arr, n, target);
        System.out.println(ways);
    }
}
*/

/* 
3. Rod-Cutting Problem
We are given a rod of size ‘N’. It can be cut into pieces. Each length of a piece has a particular price given by the price array. Our task is to find the maximum revenue that can be generated by selling the rod after cutting( if required) into pieces.

eg. N = 5;
prices[] = {2, 5, 7, 8, 10};

ans: 12 (2 + 5 + 5)
1 piece of length 1 and 2 pieces of length 2

Logic: Try to pick length in all possible ways and sum them up to make the given length N. -> similar to knapsack
*/

import java.util.Arrays;

public class Subsequences {
    
    static int rodCutting_Tabulation(int[] prices, int i, int n) { // max price that can be generated till index i of length n
        int[][] dp = new int[i][n + 1];

        for (int j = 0; j < i; j++) {
            for (int k = 0; k <= n; k++) {
                if (j == 0) {
                    dp[0][k] = prices[0] * k;
                }
                else {
                    int notTake = 0 + dp[j - 1][k];
                    int take = 0;
                    int rod_length = j + 1;
                    if (rod_length <= k)
                        take = prices[j] + dp[j][k - rod_length];
                    dp[j][k] = Math.max(take, notTake);
                }
            }
        }
        for(int[] j: dp)
            System.out.println(Arrays.toString(j));
        return dp[i - 1][n];
    }
    
    static int rodCutting_Memoization(int[] prices, int i, int n, int dp[][]) { // max price that can be generated till index i of length n
        if (i == 0) // rod of length 1
            return prices[0] * n;

        if(dp[i][n] != -1)
            return dp[i][n];
        int notTake = 0 + rodCutting_Memoization(prices, i - 1, n, dp);
        int take = 0;
        int rod_length = i + 1;
        if (rod_length <= n)
            take = prices[i] + rodCutting_Memoization(prices, i, n - rod_length, dp);
        return dp[i][n] = Math.max(take, notTake);
    }
    
    static int rodCutting_Recursion(int[] prices, int i, int n) { // max price that can be generated till index i of length n
        if (i == 0)  // rod of length 1
            return prices[0] * n;
        
        int notTake = 0 + rodCutting_Recursion(prices, i - 1, n);
        int take = 0;
        int rod_length = i + 1;
        if(rod_length <= n)
            take = prices[i] + rodCutting_Recursion(prices, i, n-rod_length);
        return Math.max(take, notTake);
    }

    public static void main(String[] args) {
        int n = 5;
        int prices[] = { 2, 5, 7, 8, 10 };
        // int maxRevenue = rodCutting_Recursion(prices, n - 1, n);

        // int[][] dp = new int[n][n+1];
        // for(int[] i: dp)
        //      Arrays.fill(i, -1);
        // int maxRevenue = rodCutting_Memoization(prices, n-1, n, dp);

        int maxRevenue = rodCutting_Tabulation(prices, n, n);

        System.out.println(maxRevenue);

    }
}
