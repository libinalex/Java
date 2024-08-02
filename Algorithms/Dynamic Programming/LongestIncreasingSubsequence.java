import java.util.*;
/* 
1. Longest Increasing Subsequence
Given an array, give the length of the longest increasing subsequence

eg.
int[] arr = {10, 9, 2, 5, 3, 7, 101, 18}

ans:4
{2, 3, 7, 101} OR {2, 3, 7, 18}



public class LongestIncreasingSubsequence {
    static int longest_increasing_subsequence_tabulation(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n + 1][n + 1];

        for (int i = n; i >= 0; i--) {
            for (int prev = i-1; prev >= -1; prev--) { 
                if (i == n)
                    dp[i][prev+1] = 0;
                else {
                    int notTake = 0 + dp[i + 1][prev + 1];
                    int take = 0;
                    if (prev == -1 || arr[i] > arr[prev]) {
                        take = 1 + dp[i + 1][i + 1];
                    }
                    dp[i][prev + 1] = Math.max(take, notTake);
                }
            }
        }
        return dp[0][0];

    }
    
    static int longest_increasing_subsequence_memoization(int[] arr, int i, int prev, int[][] dp) { // length of lis, starting from i, wholse previous index is prev
        if (i == arr.length)
            return 0;

        if(dp[i][prev+1] != -1)
            return dp[i][prev + 1];

        int notTake = 0 + longest_increasing_subsequence_memoization(arr, i + 1, prev, dp);
        int take = 0;
        if (prev == -1 || arr[i] > arr[prev]) {
            take = 1 + longest_increasing_subsequence_memoization(arr, i + 1, i, dp);
        }
        return dp[i][prev + 1] = Math.max(take, notTake);
    }
    
    static int longest_increasing_subsequence_recursion(int[] arr, int i, int prev) { // length of lis, starting from index i, whose previous index is prev
        if(i == arr.length)
            return 0;

        int notTake = 0 + longest_increasing_subsequence_recursion(arr, i + 1, prev);
        int take = 0;
        if (prev == -1 || arr[i] > arr[prev]) {
            take = 1 + longest_increasing_subsequence_recursion(arr, i + 1, i);
        }
        return Math.max(take, notTake);
    }
    public static void main(String[] args) {
        int[] arr = { 10, 9, 2, 5, 3, 7, 101, 181 };
        // int lis = longest_increasing_subsequence_recursion(arr, 0, -1);

        int[][] dp = new int[arr.length][arr.length + 1]; // shifiting one index right to store -1 at 0
        for(int[] i: dp)
            Arrays.fill(i, -1);
        int lis = longest_increasing_subsequence_tabulation(arr);

        System.out.println(lis);
    }
}
*/
/*
// #2: with Time Complexity: O(n^2) space: O(n)

public class LongestIncreasingSubsequence {
    static int lis_tabulation(int arr[]) {
        int n = arr.length;
        int dp[] = new int[n];
        // dp[i] signifies the length longest increasing subsequence that ends at index i
        Arrays.fill(dp, 1 );
        for (int i = 0; i < n; i++) {
            for (int prev = 0; prev < i; prev++) {
                if (arr[prev] < arr[i] && dp[prev] + 1 > dp[i])
                    dp[i] = dp[prev] + 1;
            }
        }
        int max = 0;
        for(int i: dp)
            max = Math.max(max, i);
        return max;
    }

    public static void main(String[] args) {
        int[] arr = { 5, 4, 11, 1, 16, 8 };
        int lis = lis_tabulation(arr);
        System.out.println(lis);
    }
}
*/

/* 
2. Print the LIS

public class LongestIncreasingSubsequence {
    static List<Integer> printLIS(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int[] indices = new int[n];
        int max_index = 0;
        int lis_length = 1;

        for (int i = 0; i < n; i++) {
            indices[i] = i;
            for (int prev = 0; prev < i; prev++) {
                if (arr[i] > arr[prev] && dp[prev] + 1 > dp[i]) {
                    dp[i] = dp[prev] + 1;
                    indices[i] = prev;
                }
            }
            if (dp[i] > lis_length) {
                lis_length = dp[i];
                max_index = i;
            }
        }

        List<Integer> list = new ArrayList<>();
        list.add(arr[max_index]);
        while (indices[max_index] != max_index) {
            max_index = indices[max_index];
            list.add(0, arr[max_index]);
        }
        return list;

    }

    public static void main(String[] args) {
        int[] arr = { 10, 9, 2, 5, 3, 7, 101, 18 };
        List<Integer> lis = printLIS(arr);
        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("LIS: " + lis);
    }
}
*/

/* 
3. LIS using Binary Search - Best time complexity - O(n logn)

public class LongestIncreasingSubsequence {

    static int longestIncreasingSubsequence(int[] arr) {
        int n = arr.length;
        List<Integer> temp = new ArrayList<>();
        temp.add(arr[0]);

        int len = 1;

        for (int i = 1; i < n; i++) {
            if (arr[i] > temp.get(temp.size() - 1)) {
                temp.add(arr[i]);
                len++;
            } else {
                int ind = Collections.binarySearch(temp, arr[i]);

                if (ind < 0)
                    ind = -ind - 1;

                temp.set(ind, arr[i]);
            }
        }
        return len;
    }
    public static void main(String[] args) {
        int arr[] = { 10, 9, 2, 5, 3, 7, 101, 18 };
        int lis = longestIncreasingSubsequence(arr);
        System.out.println(lis);
    }
}
*/

/* 
4. Longest Divisible Subset
In a subsequence, the elements need to follow the order of the original array whereas in a subset there is no constraint on the order of the elements. 

A divisible subset is the one in which if we pick two elements i and j from the subset, then either arr[i]%arr[j] == 0 or arr[j] % arr[i] == 0. For example, [16,8,4] is a divisible subset.


public class LongestIncreasingSubsequence {
    static List<Integer> longest_divisible_subset(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int[] dp = new int[n];
        int[] indices = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 0; i < n; i++) {
            indices[i] = i;
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    indices[i] = j;
                }
            }
        }

        int max = dp[0];
        int max_index = 0;

        for(int i=1; i<n; i++){
            if (dp[i] > max) {
                max = dp[i];
                max_index = i;
            }
        }

        List<Integer> lds = new ArrayList<>();
        lds.add(arr[max_index]);
        while (indices[max_index] != max_index) {
            max_index = indices[max_index];
            lds.add(0, arr[max_index]);
        }

        return lds;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 7, 8, 4, 16 };
        List<Integer> lds = longest_divisible_subset(arr);
        System.out.println(lds);
    }
}
*/

/* 
5. Longest String Chain
We are given an array of strings (sat words[ ]), and we need to return the longest string chain. This longest string chain is defined as:

A subsequence of words[ ] of the string.
Every element of this subsequence ( a string) except the first one can be formed by inserting a single character into the previous element.
The first element of this subsequence can be any string from the words[ ] array.

eg.
words[] = {"a", "b", "ba", "bca", "bda", "bdca"};

ans: longest string chain: {"a", "ba", "bda", "bdca"} -> 4

We need to print the length of the longest string chain, in this case: 4.

Two consecutive strings in this string chain need to have an insertion of a single character. The character can be added to any place on the string.


public class LongestIncreasingSubsequence {

    // Custom comparison function for sorting strings by length
    static Comparator<String> comp = (s1, s2) -> s1.length() - s2.length();

    static boolean stringDiff(String s1, String s2) { // can we form string s2 by inserting 1 char to s1
        int i = 0;
        int j = 0;

        int n1 = s1.length();
        int n2 = s2.length();

        if ((n2 - n1) != 1) // difference bw s2 and s1 must be 1 char
            return false;

        while (j < n2) {
            if (i<n1 && s1.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
            } else
                j++;
        }
        if(i == n1 && j == n2)
            return true;
        return false;
    }
    static int longestStringChain( String[] words) {
        int n = words.length;
        Arrays.sort(words, comp);
        System.out.println(Arrays.toString(words));
        int[] dp = new int[n]; // length of longest string chain till index i
        Arrays.fill(dp, 1);
        int max = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (stringDiff(words[j], words[i]) && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    System.out.println(words[i]);
                }
            }
            max = Math.max(max, dp[i]);
        }

        System.out.println(Arrays.toString(dp));

        return max;

    }

    public static void main(String[] args) {
        String words[] = { "a", "bda", "efghi", "b", "ba", "bca", "bdca" };
        int lsc = longestStringChain(words);
        System.out.println(lsc);

    }
}
*/

/* 
6. Longest Bitonic Subsequence
A bitonic subsequence is a subsequence of an array in which the elements can be any of these three:

First, increase till a point and then decrease.
Goes on increasing (Longest increasing subsequence)
Goes on decreasing (Longest decreasing subsequence)

eg.
int[] arr = {1, 11, 2, 10, 4, 5, 2, 1}

ans = 6 {1, 2, 10, 4, 2, 1}


public class LongestIncreasingSubsequence {

    static int longestBitonicSubsequence(int[] arr) {
        int n = arr.length;
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        Arrays.fill(dp1, 1);
        Arrays.fill(dp2, 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dp1[j] + 1 > dp1[i]) {
                    dp1[i] = dp1[j] + 1;
                }
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (arr[i] > arr[j] && dp2[j] + 1 > dp2[i]) {
                    dp2[i] = dp2[j] + 1;
                }
            }
        }
        System.out.println(Arrays.toString(dp1));
        System.out.println(Arrays.toString(dp2));

        int sum = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            sum = dp1[i] + dp2[i] - 1;
            max = Math.max(max, sum);
        }
        return max;
    }
    public static void main(String[] args) {
        int[] arr = { 1, 11, 2, 10, 4, 5, 2, 1 };
        int lbs = longestBitonicSubsequence(arr);
        System.out.println(lbs);

    }
}
*/

/* 
7. Number of Longest Increasing Subsequences
*/

public class LongestIncreasingSubsequence {
    static int numLIS(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int[] count = new int[n];
        Arrays.fill(count, 1);

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    count[i] = count[j];
                } else if (arr[i] > arr[j] && dp[j] + 1 == dp[i])
                    count[i] += count[j];
            }
            max = Math.max(max, dp[i]);

        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == max) {
                cnt += count[i];
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        int[] arr = { 1, 3, 5, 4, 7 };
        int count_lis = numLIS(arr);
        System.out.println(count_lis);
    }
}