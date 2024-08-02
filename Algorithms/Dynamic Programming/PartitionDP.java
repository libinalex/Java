import java.util.*;
/* 
1. Matrix Chain Multiplication
Given a chain of matrices A1,..., An denoted by an array of size n+1, 
Find out the minimum number of operations to multiply these n matrices.


public class PartitionDP {
    static int matrixChainMultiplication_tabulation(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = 0;
        }
        for (int i = n - 1; i >= 1; i--) {
            for (int j = i + 1; j < n; j++) {
                int min = (int) 1e9;
                for (int k = i; k < j; k++) {
                    int steps = (arr[i - 1] * arr[k] * arr[j]) + dp[i][k] + dp[k + 1][j];
                    min = Math.min(min, steps);
                }
                dp[i][j] = min;

            }
        }
        for (int[] i : dp)
            System.out.println(Arrays.toString(i));
        return dp[1][n - 1];
    }

    static int matrixChainMultiplication_memoization(int[] arr, int i, int j, int[][] dp) {
        if (i == j)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];

        int min = (int) 1e9;
        for (int k = i; k < j; k++) {
            int steps = (arr[i - 1] * arr[k] * arr[j]) +
                    matrixChainMultiplication_memoization(arr, i, k, dp) +
                    matrixChainMultiplication_memoization(arr, k + 1, j, dp);

            min = Math.min(min, steps);
        }
        return dp[i][j] = min;
    }

    static int matrixChainMultiplication_recursion(int[] arr, int i, int j) {
        if (i == j)
            return 0;
        int min = (int) 1e9;
        for (int k = i; k < j; k++) {
            int steps = arr[i - 1] * arr[k] * arr[j] +
                    matrixChainMultiplication_recursion(arr, i, k) +
                    matrixChainMultiplication_recursion(arr, k + 1, j);

            min = Math.min(min, steps);
        }
        return min;
    }

    public static void main(String[] args) {
        int arr[] = { 10, 20, 30, 40, 50 };
        // int minOps = matrixChainMultiplication_recursion(arr, 1, arr.length - 1);

        // int[][] dp = new int[arr.length][arr.length];
        // for(int[] i: dp)
        // Arrays.fill(i, -1);
        // int minOps = matrixChainMultiplication_memoization(arr, 1, arr.length - 1,
        // dp);

        int minOps = matrixChainMultiplication_tabulation(arr);
        System.out.println(minOps);
    }
}
*/

/*
2. Minimum Cost to cut the Stick
We are given a stick of length N and a CUTS array of size C. The stick has markings as shown, and the CUTS array depicts the marking at which the stick needs to be cut.
It is necessary to make cuts at all the markings.

Whenever we make a cut, we incur a cost. This cost is equal to the length of the stick on which we are making the cut.

We need to find the minimum cost incurred to cut the stick at all the cut points.

eg.
n = 7
cuts[] = {1, 5, 3, 4}

min cost = 16 (7+4+3+2)
*/
public class PartitionDP {

    static int cutSticks_Tabulation(ArrayList<Integer> cuts, int c) {
        int[][] dp = new int[c + 2][c + 2];
        for (int i = c; i >= 1; i--) {
            for (int j = 1; j <= c; j++) {
                if (i > j)
                    continue;

                int min = Integer.MAX_VALUE;

                for (int ind = i; ind <= j; ind++) {
                    int ans = cuts.get(j + 1) - cuts.get(i - 1) + dp[i][ind - 1] + dp[ind + 1][j];
                    min = Math.min(min, ans);
                }
                dp[i][j] = min;
            }
        }
        return dp[1][c];
    }

    static int cutSticks_Memoization(ArrayList<Integer> cuts, int i, int j, int[][] dp) {
        if (i > j)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        int min = Integer.MAX_VALUE;

        for (int ind = i; ind <= j; ind++) {
            int ans = cuts.get(j + 1) - cuts.get(i - 1) +
                    cutSticks_Memoization(cuts, i, ind - 1, dp) +
                    cutSticks_Memoization(cuts, ind + 1, j, dp);
            min = Math.min(min, ans);
        }
        return dp[i][j] = min;
    }

    static int cutSticks_Recursion(ArrayList<Integer> cuts, int i, int j) {
        if (i > j)
            return 0;

        int min = Integer.MAX_VALUE;

        for (int ind = i; ind <= j; ind++) {
            int ans = cuts.get(j + 1) - cuts.get(i - 1) +
                    cutSticks_Recursion(cuts, i, ind - 1) +
                    cutSticks_Recursion(cuts, ind + 1, j);
            min = Math.min(min, ans);
        }
        return min;
    }

    public static void main(String[] args) {
        ArrayList<Integer> cuts = new ArrayList<>(Arrays.asList(3, 5, 1, 4));
        int c = cuts.size();
        int n = 7;

        cuts.add(n);
        cuts.add(0);
        Collections.sort(cuts);

        // int minCost = cutSticks_Recursion(cuts, 1, c);

        // int[][] dp = new int[c + 1][c + 1];
        // for(int[] i: dp)
        // Arrays.fill(i, -1);
        // int minCost = cutSticks_Memoization(cuts, 1, c, dp);

        int minCost = cutSticks_Tabulation(cuts, c);

        System.out.println(minCost);
    }
}