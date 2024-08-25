import java.util.*;
/* 
Overlapping sub problems.
top down - can we divide the big problem into smaller sub problem -> Recursion + Memoization
bottom up - if we know solution to smaller problem, can we find solution to bigger problem -> Tabulation

Top-Down Memoization technique uses an extra recursion stack space, so space complexity is more.

How to know if it's a DP problem?
Problems like:
    1. count total no. of ways....
    2. min/max among various ways to do something....

Whenever "Try all possible ways" --> Recursion

To write recurrance relation of a problem:
    1. Try to represent the problem in terms of index.
    2. Do all possible stuffs on that index according to the problem statement.
    3. If ques asks:
       count all ways -> sum up all stuffs.
       find min/max among all ways -> take min/max among all stuffs. 

       Think about edge cases.

Diminsion of DP will be equal to no. of changing parameters in the recursion.
Filling in tabulation is opposite of that of Memoization.
i.e changing parameters in tabulation will be iterated in opposite manner as that of recursion
*/


/* 
1. Count no. of ways to cover a distance
eg, you can take steps of 1,2,3 at a time and you have to cover a total distance of 5.


public class DynamicProgramming {
    static int noOfWays(int dist) {
        int[] dp = new int[dist + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= dist; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[dist];
    }
    public static void main(String[] args) {
        int dist = 4;
        int ans = noOfWays(dist);
        System.out.println(ans);
    }
}
*/


/* 
2. Fibonacci Sequence
0 1 1 2 3 5 8 13 21 34


public class DynamicProgramming {

    static int fibonacci_tabulation_spaceOptimization(int n) {
        int prev2 = 0;
        int prev = 1;
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            ans = prev + prev2;
            prev2 = prev;
            prev = ans;
        }
        return ans;
    }

    static int fibonacci_tabulation(int n) { // Bottom-Up
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
    
    static int fibonacci_memoization(int n, int[] dp) { // Top-Down
        if(n<=1)
            return n;
        if (dp[n] != -1)
            return dp[n];
        return dp[n] = fibonacci_memoization(n - 1, dp) + fibonacci_memoization(n - 2, dp);
    }

    public static void main(String[] args) {
        int n = 99;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        // int fib = fibonacci_memoization(n, dp);
        // int fib = fibonacci_tabulation(n);
        int fib = fibonacci_tabulation_spaceOptimization(n);
        System.out.println("The " + n + "th Fibonacci number is: " + fib);
    }
}
*/

/* 
3. Count ways to reach the n-th stairs
You have been given a no. of stairs. Initially, you are at the 0th stair, and you need to reach the nth stair. Each time you can either climb one step or two steps. You are supposed to return the no. of distict ways in which you can climb from the 0th step to nth step.


import java.util.Arrays;

public class DynamicProgramming {

    static int countStairs_tabulation(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    static int countStairs_memoization(int n, int[] dp) {
        if (n <= 1)
            return 1;
        if (dp[n] != -1)
            return dp[n];

        int l = countStairs_memoization(n - 1, dp);
        int r = countStairs_memoization(n - 2, dp);
        return dp[n] = l + r;
    }

    static int countStairs_recursion(int n) {
        if (n == 0) 
            return 1;
        if( n == 1)
            return 1;
        
        int l = countStairs_recursion(n - 1);
        int r = countStairs_recursion(n - 2);
        return l + r;
    }

    public static void main(String[] args) {
        int n = 4;
        // int count = countStairs_recursion(n);

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        // int count = countStairs_memoization(n, dp);

        int count = countStairs_tabulation(n);

        System.out.println(count);
    }
}
*/

/* 
4. Frog Jump
Given a number of stairs and a frog, the frog wants to climb from the 0th stair to the (N-1)th stair. At a time the frog can climb either one or two steps. A height[N] array is also given. Whenever the frog jumps from a stair i to stair j, the energy consumed in the jump is abs(height[i]- height[j]), where abs() means the absolute difference. We need to return the minimum energy that can be used by the frog to jump from stair 0 to stair N-1.

eg. n=4
[10, 20, 30, 10]


import java.util.Arrays;

public class DynamicProgramming {

    static int frogJump_Tabulation(int n, int[] height) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = Math.abs(height[1] - height[0]);
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + Math.abs(height[i] - height[i - 1]),
                    dp[i - 2] + Math.abs(height[i] - height[i - 2]));
        }
        return dp[n];
    }

    static int frogJump_Memoization(int n, int[] height, int[] dp) {

        if (n == 0)
            return 0;
        if (n == 1)
            return Math.abs(height[1] - height[0]);
        if(dp[n] != -1)
            return dp[n];

        int oneStep = frogJump_Memoization(n - 1, height, dp) + Math.abs(height[n] - height[n - 1]);
        int twoStep = frogJump_Memoization(n - 2, height, dp) + Math.abs(height[n] - height[n - 2]);

        return dp[n] = Math.min(oneStep, twoStep);
    }

    static int frogJump_Recursion(int n, int[] height) {
        if (n == 0) 
            return 0;
        if(n == 1)
            return Math.abs(height[1] - height[0]);
        int oneStep = frogJump_Recursion(n - 1, height) + Math.abs(height[n] - height[n - 1]);
        int twoStep = frogJump_Recursion(n - 2, height) + Math.abs(height[n] - height[n - 2]);
        return Math.min(oneStep, twoStep);
    }

    public static void main(String[] args) {
        int n = 5;
        int[] height = { 30, 10, 60, 10, 60, 50 };
        // int minEnergy = frogJump_Recursion(n, height);

        // int[] dp = new int[n + 1];
        // Arrays.fill(dp, -1);
        // int minEnergy = frogJump_Memoization(n, height, dp) ;

        int minEnergy = frogJump_Tabulation(n, height) ;
        System.out.println("The minimum energy needed by frog: " + minEnergy);
    }
}
*/

/* 
5. Frog jump(above question) with possible k steps jumps, instead of just 1 and 2 steps.

public class DynamicProgramming {
    static int frogJump_k_recursion(int n, int k, int[] heights) {
        if (n == 0)
            return 0;
        int minEnergy = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++) {
            int jump = Integer.MAX_VALUE;
            if(n-i >= 0)
                jump = frogJump_k_recursion(n - i, k, heights) + Math.abs(heights[n] - heights[n - i]);
            minEnergy = Math.min(minEnergy, jump);
        }
        return minEnergy;
    }

    public static void main(String[] args) {
        int n = 5;
        int k = 3;
        int[] heights = { 30, 10, 60, 20, 60, 20 };

        int minEnergy = frogJump_k_recursion(n, k, heights);
        System.out.println(minEnergy);
    }
}
*/

/* 
6. House robber 1
You are given an array/list of 'N' integers. You are supposed to return the maximum sum of the subsequence with the constraint that no two elements are adjacent in the given array/list.


import java.util.Arrays;

public class DynamicProgramming {

    static int houseRobber_Tabulation_spaceOptimised(int n, int[] house) {
        int prev2 = house[0];
        int prev = house[1];
        for (int i = 2; i <= n; i++) {
            int take = house[i] + prev2;
            int notTake = 0 + prev;
            int ans = Math.max(take, notTake);
            prev2 = prev;
            prev = ans;
        }
        return prev;
    }

    static int houseRobber_Tabulation(int n, int[] house) {
        int[] dp = new int[n + 1];
        dp[0] = house[0];

        for (int i = 1; i <= n; i++) {
            int take = house[i];
            if (i > 1)
                take = take + dp[i - 2];
            int notTake = 0 + dp[i - 1];
            dp[i] = Math.max(take, notTake);
        }
        return dp[n];
    }
    
    static int houseRobber_Memoization(int n, int[] house, int[] dp) {
        if (n == 0)
            return house[0];

        if (n < 0)
            return 0;
        
        if(dp[n] != -1)
            return dp[n];

        int take = house[n] + houseRobber_Memoization(n - 2, house, dp);
        int notTake = 0 + houseRobber_Memoization(n - 1, house, dp);
        return dp[n] = Math.max(take, notTake);
    }
    
    static int houseRobber_Recursion(int n, int[] house) {
        if (n == 0) 
            return house[0];
        
        if(n<0)
            return 0;

        int take = house[n] + houseRobber_Recursion(n - 2, house);
        int notTake = 0 + houseRobber_Recursion(n - 1, house);
        return Math.max(take, notTake);
    }
    public static void main(String[] args) {
        int n = 5;
        int[] house = { 1, 5, 2, 1, 6 };
        // int maxSum = houseRobber_Recursion(n - 1, house);
        
        // int[] dp = new int[n];
        // Arrays.fill(dp, -1);
        // int maxSum = houseRobber_Memoization(n-1, house, dp);

        // int maxSum = houseRobber_Tabulation(n-1, house);

        int maxSum = houseRobber_Tabulation_spaceOptimised(n-1, house);

        
        System.out.println(maxSum);
    }
}
*/

/* 
7. House Robber - 2
A thief needs to rob money in a street. The houses in the street are arranged in a circular manner. Therefore the first and the last house are adjacent to each other. The security system in the street is such that if adjacent houses are robbed, the police will get notified.

Given an array of integers “Arr'' which represents money at each house, we need to return the maximum amount of money that the thief can rob without alerting the police.

eg. 
N = 3
{2,3,2}
ans = 3

N = 4
{2,1,4,9}
ans = 1 + 9

N=5
{1,5,2,1,6}
ans = 5 + 6


public class DynamicProgramming {
    static int houseRobber(int n, int house[]) {
        int dp[] = new int[n + 1];
        dp[0] = 0;
        dp[1] = house[0];
        for (int i = 2; i <= n; i++) {
            int take = house[i-1] + dp[i - 2];
            int notTake = 0 + dp[i - 1];
            dp[i] = Math.max(take, notTake);
        }
        return dp[n];
    }
    public static void main(String[] args) {
        int n = 3;
        int house[] = { 2,3,2 };
        int[] temp1 = new int[n - 1];
        int[] temp2 = new int[n - 1];
        for (int i = 0; i < n; i++) {
            if (i < n - 1)
                temp1[i] = house[i];
            if(i>0)
                temp2[i-1] = house[i];
        }
        
        int withoutLast = houseRobber(n-1, temp1);
        int withoutFirst = houseRobber(n - 1, temp2);
        int ans = Math.max(withoutLast, withoutFirst);
        if (n == 1)
            ans = house[0];
        System.out.println(ans);
    }
}
*/

/* 
8. Ninja's Training
A Ninja has an ‘N’ Day training schedule. He has to perform one of these three activities (Running, Fighting Practice, or Learning New Moves) each day. There are merit points associated with performing an activity each day. The same activity can’t be performed on two consecutive days. We need to find the maximum merit points the ninja can attain in N Days.

We are given a 2D Array POINTS of size ‘N x 3’ which tells us the merit point of specific activity on that particular day. Our task is to calculate the maximum number of merit points that the ninja can earn.

eg.
days = 3
points = {{10, 40, 70},  day 0
          {20, 50, 80},  day 1
          {30, 60, 90}}; day 2
ans = 210  // 70(day 0) + 50(day 1) + 90(day2)


import java.util.Arrays;

public class DynamicProgramming {

    static int ninjaTraining_Tabulation(int points[][], int days, int task) {
        int[][] dp = new int[days][4];
        
        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for (int i = 1; i < days; i++) {
            for (int j = 0; j <= 3; j++) {
                dp[i][j] = 0;

                for (int k = 0; k < 3; k++) {
                    if (k != task) {
                        int curr = points[i][k] + dp[i - 1][k];

                        dp[i][j] = Math.max(curr, dp[i][j]);
                    }
                }

            }
        }
        for(int[] i:dp)
        System.out.println(Arrays.toString(i));
        
        return dp[days-1][3];
    }
    static int ninjaTraining_Memoization(int points[][], int days, int task, int[][] dp) {
        
        if (days == 0) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < 3; i++) {
                if (i != task) {
                    max = Math.max(max, points[0][i]);
                }
            }
            return max;
        }
        if (dp[days][task] != -1)
            return dp[days][task];

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 3; i++) {
            if (i != task) {
                int curr = points[days][i] + ninjaTraining_Memoization(points, days - 1, i, dp);
                max = Math.max(curr, max);
            }
        }
        return dp[days][task] = max;
    }
    static int ninjaTraining_Recursion(int points[][], int days, int task) {
        if (days == 0) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < 3; i++) {
                if (i != task) {
                    max = Math.max(max, points[0][i]);
                }
            }
            return max;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 3; i++) {
            if (i != task) {
                int curr = points[days][i] + ninjaTraining_Recursion(points, days - 1, i);
                max = Math.max(curr, max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int days = 3;
        int[][] points = {{ 10, 40, 70 },
                          { 20, 50, 80 },
                { 30, 60, 90 } };
        
        // int maxPoints = ninjaTraining_Recursion(points, days - 1, 3);

        // int[][] dp = new int[days][4];
        // for(int[] i:dp)
        //     Arrays.fill(i, -1);
        // int maxPoints = ninjaTraining_Memoization(points, days - 1, 3, dp);

        int maxPoints = ninjaTraining_Tabulation(points, days, 3);
        System.out.println(maxPoints);
    }
}
*/


