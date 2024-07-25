/* 1. 0/1 Knapsack Problem
A thief wants to rob a store. He is carrying a bag of capacity W. The store has ‘n’ items. Its weight is given by the ‘wt’ array and its value by the ‘val’ array. He can either include the whole item in its knapsack or exclude it but can’t partially have it as a fraction. 
We need to find the maximum value of items that the thief can steal.


import java.util.Arrays;

public class Knapsack {
    static int knapsack_Tabulation(int[] wt, int[] val, int capacity, int n) {
        int[][] dp = new int[n][capacity + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= capacity; j++) {
                if (i == 0) {
                    if (wt[0] <= j)
                        dp[i][j] = val[0];

                } else {
                    int notTake = dp[i - 1][j];
                    int take = 0;
                    if (wt[i] <= j)
                        take = val[i] + dp[i - 1][j - wt[i]];
                    dp[i][j] = Math.max(take, notTake);

                }
            }
        }
        return dp[n - 1][capacity];

    }

    static int knapsack_Memoization(int[] wt, int[] val, int capacity, int n, int[][] dp) {
        if (capacity <= 0)
            return 0;
        if (n == 0) {
            if (wt[0] <= capacity)
                return val[0];
            else
                return 0;
        }

        if (dp[n][capacity] != -1)
            return dp[n][capacity];

        int notTake = knapsack_Memoization(wt, val, capacity, n - 1, dp);
        int take = 0;
        if (wt[n] <= capacity)
            take = val[n] + knapsack_Memoization(wt, val, capacity - wt[n], n - 1, dp);
        return dp[n][capacity] = Math.max(take, notTake);
    }

    static int knapsack_Recursion(int[] wt, int[] val, int capacity, int n) {
        if (capacity <= 0)
            return 0;
        if (n == 0) {
            if (wt[0] <= capacity)
                return val[0];
            else
                return 0;
        }

        int notTake = knapsack_Recursion(wt, val, capacity, n - 1);
        int take = 0;
        if (wt[n] <= capacity)
            take = val[n] + knapsack_Recursion(wt, val, capacity - wt[n], n - 1);
        return Math.max(take, notTake);
    }

    public static void main(String[] args) {
        int capacity = 6;
        int n = 3;
        int[] wt = { 3, 2, 5 };
        int[] val = { 30,40,60 };
        // int maxVal = knapsack_Recursion(wt, val, capacity, n - 1);

        // int[][] dp = new int[n][capacity+1];
        // for(int[] i: dp)
        // Arrays.fill(i, -1);
        // int maxVal = knapsack_Memoization(wt, val, capacity, n-1, dp);

        int maxVal = knapsack_Tabulation(wt, val, capacity, n);
        System.out.println(maxVal);
    }
}
*/

/* 
2. Unbounded Knapsack
A thief wants to rob a store. He is carrying a bag of capacity W. The store has ‘n’ items of infinite supply. Its weight is given by the ‘wt’ array and its value by the ‘val’ array. He can either include an item in its knapsack or exclude it but can’t partially have it as a fraction. We need to find the maximum value of items that the thief can steal. He can take a single item any number of times he wants and put it in his knapsack.

eg.
N = 3
W = 10
wt[] = {2, 4, 6}
val[] = {5, 11, 13}

ans = 27
2*weight 4 + 1*weight 2 = 11 + 11 + 5 = 27
*/

import java.util.Arrays;

public class Knapsack {
    static int unboundedKnapsack_Tabulation(int[] wt, int[] val, int n, int w) { // max value of items till n with capacity w
        int[][] dp = new int[n][w + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= w; j++) {
                if (i == 0) {
                    if (wt[i] <= j) {
                        dp[i][j] = (j / wt[0]) * val[0];
                    }
                } else {
                    int notTake = dp[i - 1][j];
                    int take = 0;
                    if (wt[i] <= j) {
                        take = val[i] + dp[i][j - wt[i]];
                    }
                    dp[i][j] = Math.max(notTake, take);
                }
            }
        }
        return dp[n - 1][w];
    }

    static int unboundedKnapsack_Memoization(int[] wt, int[] val, int n, int w, int[][] dp) { 
        if (w <= 0) {
            return 0;
        }
        if (n == 0) {
            if (wt[n] <= w) {
                return (w / wt[n]) * val[n];
            } else
                return 0;
        }
        if (dp[n][w] != -1)
            return dp[n][w];
        int notTake = unboundedKnapsack_Memoization(wt, val, n - 1, w, dp);
        int take = 0;
        if (wt[n] <= w) {
            take = val[n] + unboundedKnapsack_Memoization(wt, val, n, w - wt[n], dp);
        }
        return dp[n][w] = Math.max(notTake, take);
    }

    static int unboundedKnapsack_Recursion(int[] wt, int[] val, int n, int w) { // max value of items till n with capacity w
        if (w <= 0) {
            return 0;
        }
        if (n == 0) {
            if (wt[n] <= w) {
                return (w / wt[n]) * val[n];
            } else
                return 0;
        }
        int notTake = unboundedKnapsack_Recursion(wt, val, n - 1, w);
        int take = 0;
        if (wt[n] <= w) {
            take = val[n] + unboundedKnapsack_Recursion(wt, val, n, w - wt[n]);
        }
        return Math.max(notTake, take);
    }

    public static void main(String[] args) {
        int n = 3;
        int w = 10;
        int[] wt = { 2, 4, 6 };
        int[] val = { 5, 11, 13 };

        // int maxVal = unboundedKnapsack_Recursion(wt, val, n-1, w);

        // int[][] dp = new int[n][w + 1];
        // for(int[] i: dp)
        // Arrays.fill(i, -1);
        // int maxVal = unboundedKnapsack_Memoization(wt, val, n-1, w, dp);

        int maxVal = unboundedKnapsack_Tabulation(wt, val, n, w);
        System.out.println(maxVal);
    }
}