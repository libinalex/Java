/* 
1. Subset sum with target
We are given an array with N positive integers. We need to find if there is a subset in given array with a sum equal to K. If there is, return true else return false.

public class SubsetSum {
    static boolean subsetSum_Tabulation(int[] arr, int k, int n) {
        boolean[][] dp = new boolean[arr.length][k + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        if (arr[0] <= k) {
            dp[0][arr[0]] = true;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j <= k; j++) {

                boolean take = false;
                if (j >= arr[i])
                    take = dp[i - 1][j - arr[i]];

                boolean notTake = dp[i - 1][j];
                dp[i][j] = take || notTake;

            }
        }
        return dp[arr.length - 1][k];
    }

    static boolean subsetSum_Memoization(int[] arr, int k, int n, int[][] dp) {
        if (k == 0)
            return true;
        if (n == 0)
            return (arr[n] == k);

        if (dp[n][k] != -1)
            return dp[n][k] == 0 ? false : true;

        boolean take = false;
        if (k >= arr[n])
            take = subsetSum_Memoization(arr, k - arr[n], n - 1, dp);

        boolean notTake = subsetSum_Memoization(arr, k, n - 1, dp);
        dp[n][k] = take || notTake ? 1 : 0;
        return take | notTake;
    }

    static boolean subsetSum_Recursion(int[] arr, int k, int n) { // is there a subset in arr till index n with sum k
        if (k == 0)
            return true;
        if (n == 0)
            return (arr[n] == k);

        boolean take = false;
        if (k >= arr[n])
            take = subsetSum_Recursion(arr, k - arr[n], n - 1);

        boolean notTake = subsetSum_Recursion(arr, k, n - 1);
        return take || notTake;
    }

    public static void main(String[] args) {
        int[] arr = { 18, 2, 3, 4 };
        int k = 8;
        // boolean ans = subsetSum_Recursion(arr, k, arr.length-1);

        // int[][] dp = new int[arr.length][k + 1];
        // for(int[] i: dp)
        // Arrays.fill(i, -1);
        // boolean ans = subsetSum_Memoization(arr, k, arr.length - 1, dp);

        boolean ans = subsetSum_Tabulation(arr, k, arr.length);
        System.out.println(ans);
    }
}
*/

/* 
2. Partition equal subsets
We are given an array ‘ARR’ with N positive integers. We need to find if we can partition the array into two subsets such that the sum of elements of each subset is equal to the other.

If we can partition, return true else return false.

eg.
arr[] = {2,3,3,3,4,5}
We can partition: {2,3,5}, {3,3,4} -> sum = 10
output: true


public class SubsetSum {

    static boolean partitionSubsets_Tabulation(int[] arr, int k) {
        int n = arr.length;
        boolean[][] dp = new boolean[n][k + 1];
        for (int i = 0; i < n; i++) 
            dp[i][0] = true;

        if(arr[0]<=k)
            dp[0][arr[0]] = true;
        
        for (int i = 1; i < n; i++) {
            for (int target = 1; target <= k; target++) {
                boolean notTake = dp[i - 1][target];
                boolean take = false;
                if (arr[i] <= target) {
                    take = dp[i - 1][target - arr[i]];
                }
                dp[i][target] = notTake || take;
            }
        }
        return dp[n - 1][k];
    }

    public static void main(String[] args) {
        int[] arr = { 2, 3, 3, 3, 4, 5 };
        int sum = 0;
        for(int i:arr)
            sum += i;

        if (sum % 2 == 1) {
            System.out.println("false");
            return;
        }

        boolean ans = partitionSubsets_Tabulation(arr, sum / 2);
        System.out.println(ans);
    }
}
*/

/* 
3. Partition Set into 2 Subsets with min Absolute Sum Difference
We are given an array ‘ARR’ with N positive integers. We need to partition the array into two subsets such that the absolute difference of the sum of elements of the subsets is minimum.

We need to return only the minimum absolute difference of the sum of elements of the two partitions.

eg1.
arr[] = {1,2,3,4}
partition: {1,4} , {2,3}
Min abs diff = (1+4) - (2+3) = 0

eg2.
arr[] = {8,6,5}
partition; {8} , {6,5}
min abs diff = (8) - (6+5) = 3


import java.util.Arrays;

public class SubsetSum {

    static int partitionMinDiff_Tabulation(int[] arr, int target) {
        int n = arr.length;
        boolean[][] dp = new boolean[n][target + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        if(arr[0]<target)
            dp[0][arr[0]] = true;
        
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= target; j++) {
                boolean notTake = dp[i - 1][j];
                boolean take = false;
                if (arr[i] <= j) {
                    take = dp[i - 1][j - arr[i]];
                }
                dp[i][j] = take || notTake;
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= target; i++) { // could also check only till target/2, as after that it'll repeat
            if (dp[n - 1][i] == true) {
                min = Math.min(min, Math.abs(i - (target-i)));
            }
        }
        return min;

    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int sum = 0;
        for(int i: arr)
            sum += i;
        int minDiff = partitionMinDiff_Tabulation(arr, sum);
        System.out.println(minDiff);
    }
}
*/

/* 
4. Count Subsets with sum k
We are given an array arr with N positive integers and an integer K. We need to find the number of subsets whose sum is equal to K.

eg.
arr[] = {1,2,2,3}
k = 3
unique subsets with sum of 3:
{1,2} , {1,2} , {3}
ans = 3


import java.util.Arrays;

public class SubsetSum {

    // static int countSubsets_Memoization(int[] arr, int k, int currSum, int i,
    // int[][] dp) { // how many subsequences in arr till i index with sum k
    // if(currSum == k)
    // return 1;
    // if(currSum>k || i>= arr.length)
    // return 0;
    // if (dp[i][currSum] != -1)
    // return dp[i][currSum];

    // currSum += arr[i];
    // int pick = countSubsets_Memoization(arr, k, currSum, i + 1, dp);
    // currSum -= arr[i];
    // int notpick = countSubsets_Memoization(arr, k, currSum, i + 1, dp);
    // return dp[i][currSum] = pick + notpick;
    // }

    // static int countSubsets_Recursion(int[] arr, int k, int currSum, int i) {
    // if (currSum == k)
    // return 1;
    // if (currSum > k || i >= arr.length)
    // return 0;
    // currSum += arr[i];
    // int pick = countSubsets_Recursion(arr, k, currSum, i + 1);
    // currSum -= arr[i];
    // int notpick = countSubsets_Recursion(arr, k, currSum, i + 1);
    // return pick + notpick;
    // }

    static int countSubsets_Tabulation(int[] arr, int k, int n) {
        int[][] dp = new int[n][k + 1];
        // If 0s included:
        // if(arr[0] == 0)
        //     dp[0][0] = 2;
        // else
        //     dp[0][0] = 1;
        // if(arr[0] != 0 && arr[0]<= k)
        //     dp[0][arr[0] = 1;]
        
        for (int i = 0; i < n; i++)
            dp[i][0] = 1;

        if (arr[0] <= k)
            dp[0][arr[0]] = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                int notPick = dp[i - 1][j];
                int pick = 0;
                if (arr[i] <= j)
                    pick = dp[i - 1][j - arr[i]];
                dp[i][j] = pick + notPick;

            }
        }
        return dp[n - 1][k];
    }
    
    static int countSubsets_Memoization1(int[] arr, int k, int n, int[][] dp) { 
        // if 0's allowed in array:
        // if(n == 0){
        //     if(k == 0 && arr[0] == 0) return 2;
        //     if(k == 0 || k == arr[0]) return 1;
        //     return 0;
        // }
        
        if (k == 0)
            return 1;

        if (n == 0) {
            if (arr[0] == k)
                return 1;
            else
                return 0;
        }
        if(dp[n][k] != -1)
            return dp[n][k];

        int notPick = countSubsets_Memoization1(arr, k, n - 1, dp);
        int pick = 0;
        if (arr[n] <= k)
            pick = countSubsets_Memoization1(arr, k - arr[n], n - 1, dp);
        return dp[n][k] = pick + notPick;
    }
    
    static int countSubsets_Recursion1(int[] arr, int k, int n) { // no of subsets in arr with sum k till index n
        if (k == 0)
            return 1;

        if (n == 0) {
            if (arr[0] == k )
                return 1;
            else
                return 0;
        }

        int notPick = countSubsets_Recursion1(arr, k, n - 1);
        int pick = 0;
        if (arr[n] <= k)
            pick = countSubsets_Recursion1(arr, k - arr[n], n - 1);
        return pick + notPick;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 2, 3 };
        int k = 6;
        // int countSubsets = countSubsets_Recursion(arr, k, 0, 0);
        // int countSubsets = countSubsets_Recursion1(arr, k, arr.length - 1);
        
        // int[][] dp = new int[arr.length][k+1];
        // for (int[] i : dp)
        // Arrays.fill(i, -1);
        // int countSubsets = countSubsets_Memoization(arr, k, 0, 0, dp);
        // int countSubsets = countSubsets_Memoization1(arr, k, arr.length - 1, dp);
        
        int countSubsets = countSubsets_Tabulation(arr, k, arr.length);
        System.out.println(countSubsets);
    }
}
*/

/* 
5. Count Partitions with Given Difference
We are given an array arr with N positive integers and an integer D. We need to count the number of ways we can partition the given array into two subsets, S1 and S2 such that S1 - S2 = D and S1 is always greater than or equal to S2.

eg. 
arr[] = {5, 2, 6, 4}
d = 3
we can partition the array in only 1 way: {6 + 4} - {5 + 2} = 3
No. of partitions: 1

Logic:
S1 - S2 = D (s1>s2)
S1 + S2 = Total Sum => S1 = Total Sum - S2
(Total Sum - S2) - S2 = D
Total Sum - 2*S2 = D
2*S2 = Total Sum - D
S2 = (Total Sum - D) / 2
Hemce, ques becomes: Find count of subsets whose subset sum is equal to (total sum - D) / 2

public class SubsetSum {
    static int countPartitions(int[] arr, int sum) {
        int n = arr.length;
        int[][] dp = new int[n][sum + 1];
        for(int i=0; i<n; i++)
            dp[i][0] = 1;

        if (arr[0] <= sum)
            dp[0][arr[0]] = 1;

        for (int i = 1; i < n; i++) {
            for (int target = 1; target <= sum; target++) {
                int notTake = dp[i - 1][target];
                int take = 0;
                if (arr[i] <= target)
                    take = dp[i - 1][target - arr[i]];
                dp[i][target] = take + notTake;
            }
        }
        return dp[n - 1][sum];
    }
    public static void main(String[] args) {
        int[] arr = { 1,2,3,4 };
        int d = 2;

        int sum = 0;
        for(int i: arr)
            sum += i;
        
        int target = (sum - d) / 2;

        if ((sum - d) < 0 || (sum - d) % 2 == 1) {
            System.out.println("Partition not possible");
            return;
        }
        int count = countPartitions(arr, target);
        System.out.println(count);
    }
}
*/

/* 
6. Target Sum
We are given an array arr of size ‘N’ and a number ‘Target’. 
Our task is to build an expression from the given array where we can place a ‘+’ or ‘-’ sign in front of an integer. We want to place a sign in front of every integer of the array and get our required target. 
We need to count the number of ways in which we can achieve our required target.

eg.
arr[] = {1, 2, 3, 1};
Target = 3;

ans: There are 2 ways:
+1 -2 +3 +1 = 3
-1 +2 +3 -1 = 3

Logic:
we can divide the set into 2 subsets: S1 and S2, with S1 having + and S2 having -,
So ques becomes S1 - S2 = Target, which is already solved in previous ques.
*/

public class SubsetSum {

    static int targetSum_Tabulation(int[] arr, int k) {
        int n = arr.length;
        int[][] dp = new int[n][k + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        if(arr[0]<=k)
            dp[0][arr[0]] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                int take = 0;
                if (arr[i] <= k)
                    take = dp[i - 1][k - arr[i]];
                int notTake = dp[i - 1][k];
                dp[i][j] = take + notTake;
            }
        }
        return dp[n - 1][k];
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 1 };
        int target = 3;

        int total_sum = 0;
        for (int i : arr)
            total_sum += i;
        int k = (total_sum - target) / 2;

        if ((total_sum - target) < 0 || k % 2 == 1) {
            System.out.println("Not possible");
        return;
    }

        int ways = targetSum_Tabulation(arr, k);
        System.out.println(ways);
    }
}