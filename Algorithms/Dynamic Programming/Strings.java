import java.util.*;
/* 
1. Longest Common Subsequences


public class Strings {
    static int lcs_Tabulation(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 0; i <= n1; i++) {
            for (int j = 0; j <= n2; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;

                else if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;

                else
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }
        return dp[n1][n2];
    }

    static int lcs_Memoization(String s1, String s2, int i, int j, int[][] dp) {
        if (i < 0 || j < 0) 
            return 0;
        if(dp[i][j] != -1)
            return dp[i][j];
        else if(s1.charAt(i) == s2.charAt(j))
            return 1 + lcs_Memoization(s1, s2, i - 1, j - 1, dp);
        else
            return dp[i][j] = Math.max(lcs_Memoization(s1, s2, i - 1, j, dp), lcs_Memoization(s1, s2, i, j - 1, dp));
    }

    static int lcs_Recursion(String s1, String s2, int i, int j) {
        if (i < 0 || j < 0) 
            return 0;
        else if(s1.charAt(i) == s2.charAt(j))
            return 1 + lcs_Recursion(s1, s2, i - 1, j - 1);
        else
            return Math.max(lcs_Recursion(s1, s2, i - 1, j), lcs_Recursion(s1, s2, i, j - 1));
    }

    public static void main(String[] args) {
        String s1 = "HIH";
        String s2 = "IH";
        // int lcs = lcs_Recursion(s1, s2, s1.length()-1, s2.length()-1);

        int[][] dp = new int[s1.length()][s2.length()];
        for(int[] i: dp)
            Arrays.fill(i, -1);
        int lcs = lcs_Memoization(s1, s2, s1.length() - 1, s2.length() - 1, dp);
        
        // int lcs = lcs_Tabulation(s1, s2);
        System.out.println(lcs);
    }
}
*/

/* 
2. Print the Longest Common Subsequence

public class Strings {
    static String lcs_Tabulation(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 0; i <= n1; i++) {
            for (int j = 0; j <= n2; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;

                else if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;

                else
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }
        for(int k[]:dp)
            System.out.println(Arrays.toString(k));
        
        int i = n1, j = n2;
        StringBuilder lcs = new StringBuilder();
        while (i > 0 && j > 0) {
            if (s1.charAt(i-1) == s2.charAt(j-1)) {
                lcs.insert(0, s1.charAt(i-1));
                i--;
                j--;
            }
            else if (dp[i - 1][j] > dp[i][j - 1]) 
                i--;
            else
                j--;
        }
        return lcs.toString();
    }

    public static void main(String[] args) {
        String s1 = "sad";
        String s2 = "bsd";

        String lcs = lcs_Tabulation(s1, s2);
        System.out.println(lcs);
    }
}
*/

/*
3. Longest Common Substring

public class Strings {
    static int longestCommonSubstring(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 0; i <= n1; i++) {
            for (int j = 0; j <= n2; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = 0; // if not consecutive, dont count
            }
        }
        
        int max = 0;
        for (int[] i : dp) {
            for (int j : i) {
                if (j > max)
                    max = j;
            }
        }
        
        return max;
    }
    public static void main(String[] args) {
        String s1 = "abcjkl";
        String s2 = "acjkp";
        int lcs = longestCommonSubstring(s1, s2);
        System.out.println(lcs);
    }
}
*/

/* 
4. Longest Palindromic Subsequence
Logic: Reverse the string and find Longest Common Subsequence

public class Strings {
    static int longestPalindromicSubsequence(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 0; i <= n1; i++) {
            for (int j = 0; j <= n2; j++) {
                if(i==0 || j==0)
                    dp[i][j] = 0;
                else if(s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }
        return dp[n1][n2];
    }
    public static void main(String[] args) {
        String s = "rsacadecsafr";
        StringBuilder s2 = new StringBuilder(s);
        s2.reverse();
        int lps = longestPalindromicSubsequence(s, s2.toString());
        System.out.println(lps);
    }
}
*/

/* 
5. Minimum Insertions to make a String Palindrome
Logic: calculate string length - Longest Palindromic Subsequence

public class Strings {
    static int longestPalindromicSubsequence(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 0; i <= n1; i++) {
            for (int j = 0; j <= n2; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }
        return dp[n1][n2];
    }

    public static void main(String[] args) {
        String s = "rsacadecsafr";
        StringBuilder s2 = new StringBuilder(s);
        s2.reverse();
        int lps = longestPalindromicSubsequence(s, s2.toString());

        int minInsertions = s.length() - lps;
        System.out.println(minInsertions);
    }
}
*/

/* 
6. Minimum Insertions/Deletions to make String A to String B
Logic: 
Deletions = A.length - LCS
Insertions = B.length - LCS
ans = Insertions + Deletions


public class Strings {
    static int longestCommonSubsequence(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 0; i <= n1; i++) {
            for (int j = 0; j <= n2; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }
        return dp[n1][n2];
    }

    public static void main(String[] args) {
        String s1 = "Libin Alex";
        String s2 = "Aebrin Apebx";
        int lps = longestCommonSubsequence(s1, s2);
        int minOps = (s1.length() - lps) + (s2.length() - lps);
        System.out.println(minOps);
    }
}
*/

/* 
7. Shortest Common SuperSequence
We are given two strings ‘S1’ and ‘S2’. We need to return their shortest common supersequence. 
A supersequence is defined as the string which contains both the strings S1 and S2 as subsequences.


public class Strings {
    static String shortestCommonSupersequence(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 0; i <= n1; i++) {
            for (int j = 0; j <= n2; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }

        int lcs = dp[n1][n2];
        int scs = n1 + n2 - lcs;
        System.out.println("The length of Shortest Common SuperSequence is: " + scs);

        StringBuilder s = new StringBuilder();
        int i = n1, j = n2;
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                s.insert(0, s1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                s.insert(0, s1.charAt(i - 1));
                i--;
            } else {
                s.insert(0, s2.charAt(j - 1));
                j--;
            }
        }

        while (i > 0) {
            s.insert(0, s1.charAt(i - 1));
            i--;
        }

        while (j > 0) {
            s.insert(0, s2.charAt(j - 1));
            j--;
        }

        return s.toString();
    }

    public static void main(String[] args) {
        String s1 = "groot";
        String s2 = "brute";
        String scss = shortestCommonSupersequence(s1, s2);
        System.out.println(scss);
    }
}
*/

/* 
8. Distinct Subsequences
We are given two strings S1 and S2, we want to know how many distinct subsequences of S2 are present in S1.

eg.
S1: "babgbag"
S2: "bag"
ans: String S2("bag") is present as 5 distinct subsequences


public class Strings {
    
    static int distinctSubsequences_Tabulation(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 0; i <= n1; i++) {
            for (int j = 0; j <= n2; j++) {
                if(j == 0)
                    dp[i][0] = 1;
                else if(i == 0)
                    dp[0][j] = 0;
                else{
                    if (s1.charAt(i-1) == s2.charAt(j-1)) {
                        int take = dp[i - 1][j - 1];
                        int notTake = dp[i - 1][j];
                        dp[i][j] = take + notTake;
                    } else { // if both chars not same, dont take s2 char
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }
        return dp[n1][n2];
    }
    
    static int distinctSubsequences_Memoization(String s1, String s2, int i, int j, int[][] dp) { 
        if (j < 0)
            return 1;
        if (i < 0)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];

        if (s1.charAt(i) == s2.charAt(j)) {
            int take = distinctSubsequences_Memoization(s1, s2, i - 1, j - 1, dp); 
            int notTake = distinctSubsequences_Memoization(s1, s2, i - 1, j, dp); 
            return dp[i][j] = take + notTake;
        } else { // if both chars not same, dont take s2 char
            return dp[i][j] = distinctSubsequences_Memoization(s1, s2, i - 1, j, dp);
        }

    }

    static int distinctSubsequences_Recursion(String s1, String s2, int i, int j) { // no. of distinct subsequences of s2[0...j] in s1[0...i]
        if (j < 0)
            return 1;
        if (i < 0)
            return 0;

        if (s1.charAt(i) == s2.charAt(j)) {
            int take = distinctSubsequences_Recursion(s1, s2, i - 1, j - 1); // take the last character of s2 -> j decreases
            int notTake = distinctSubsequences_Recursion(s1, s2, i - 1, j); // not take the last char of s2 -> j remains same
            return take + notTake;
        } else { // if both chars not same, dont take s2 char
            return distinctSubsequences_Recursion(s1, s2, i - 1, j);
        }

    }
    
    public static void main(String[] args) {
        String s1 = "babgbag";
        String s2 = "bag";
        // int count = distinctSubsequences_Recursion(s1, s2, s1.length() - 1, s2.length() - 1);

        // int[][] dp = new int[s1.length()][s2.length()];
        // for(int[] i: dp)
        //     Arrays.fill(i, -1);
        // int count = distinctSubsequences_Memoization(s1, s2, s1.length() - 1, s2.length() - 1, dp);

        int count = distinctSubsequences_Tabulation(s1, s2);

        System.out.println(count);
    }
}
*/

/* 
9. Edit Distance
We are given two strings ‘S1’ and ‘S2’. We need to convert S1 to S2. The following three operations are allowed:

Deletion of a character.
Replacement of a character with another one.
Insertion of a character.
We have to return the minimum number of operations required to convert S1 to S2 as our answer.

eg.
S1: "horse"
S2: "ros"

ans: Minimum no. of operations req: 3
1. Replace 'h' at index 0 with 'r'
2. Delete 'r' at index 2 
3. Delete 'e' at index 4


S1: "abcbedd"
S2: "adecbad"
ans: 4

1. Replace 'b' at index 1 with 'd'
2. Insert 'e' at index 2, before 'c'
3. Delete 'e' at index 4
4. Replace 'd' at index 5 with 'a'

In tabulation:
from top -> insert
from diagonal -> replace
from left -> delete

public class Strings {
    static int editDistance_Tabulation(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 0; i <= n1; i++) {
            for (int j = 0; j <= n2; j++) {
                if(i==0)
                    dp[0][j] = j;
                else if(j==0)
                    dp[i][0] = i;
                else if(s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = dp[i - 1][j - 1];
                else 
                    dp[i][j] = 1 + Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1]));
                
            }
        }
        return dp[n1][n2];
    }

    static int editDistance_Memoization(String s1, String s2, int i, int j, int[][] dp) { 
        if (i < 0) {
            return j + 1; 
        }
        if (j < 0) {
            return i + 1; 
        }
        if (dp[i][j] != -1)
            return dp[i][j];

        if (s1.charAt(i) == s2.charAt(j))
            return 0 + editDistance_Memoization(s1, s2, i - 1, j - 1, dp);

        int insert = 1 + editDistance_Memoization(s1, s2, i, j - 1, dp);
        int delete = 1 + editDistance_Memoization(s1, s2, i - 1, j, dp);
        int replace = 1 + editDistance_Memoization(s1, s2, i - 1, j - 1, dp);

        return dp[i][j] = Math.min(insert, Math.min(delete, replace));
    }
    
    static int editDistance_Recursion(String s1, String s2, int i, int j) {  // min edits to convert s1[0..i] to s2[0..j]
        if (i < 0) {
            return j + 1; // insert all remaining chars of s2
        }
        if (j < 0) {
            return i + 1; // delete all remaining chars of s1
        }
        if(s1.charAt(i) == s2.charAt(j))
            return 0 + editDistance_Recursion(s1, s2, i - 1, j - 1);

        int insert = 1 + editDistance_Recursion(s1, s2, i, j - 1);
        int delete = 1 + editDistance_Recursion(s1, s2, i - 1, j);
        int replace = 1 + editDistance_Recursion(s1, s2, i - 1, j - 1);

        return Math.min(insert, Math.min(delete, replace));
    }
    public static void main(String[] args) {
        String s1 = "intention";
        String s2 = "execution";
        
        // int minEdit = editDistance_Recursion(s1, s2, s1.length() - 1, s2.length() - 1);

        // int[][] dp = new int[s1.length()][s2.length()];
        // for(int[] i: dp)
        //     Arrays.fill(i, -1);
        // int minEdit = editDistance_Memoization(s1, s2, s1.length() - 1, s2.length() - 1, dp);

        int minEdit = editDistance_Tabulation(s1, s2);
        System.out.println(minEdit);
    }
}
*/

/* 
10. Wildcard Matching
We are given two strings ‘S1’ and ‘S2’. String S1 can have the following two special characters:

‘?’ can be matched to a single character of S2.
‘*’ can be matched to any sequence of characters of S2. (sequence can be of length zero or more).
We need to check whether strings S1 and S2 match or not.

eg.
S1: ?ay
S2: ray
ans: Matches

S1: ab*cd
S2: abdefcd
ans: Matches

S1: **abcd
S2: abcd
ans: Matches

S1: ab?d
S2: abcc
ans: Not Matches



public class Strings {

    static boolean wildcardMatching_Tabulation(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        boolean[][] dp = new boolean[n1 + 1][n2 + 1];

        for (int i = 0; i <= n1; i++) {
            for (int j = 0; j <= n2; j++) {
                if (i == 0 && j == 0)
                    dp[i][j] = true;
                else if (i == 0)
                    dp[i][j] = false;
                else if (j == 0) {
                    if (s1.charAt(i - 1) != '*')
                        dp[i][j] = false;
                    else
                        dp[i][j] = true;
                }
                else {
                    if (s1.charAt(i - 1) == s2.charAt(j - 1) || s1.charAt(i - 1) == '?')
                        dp[i][j] = dp[i - 1][j - 1];
                    else if (s1.charAt(i - 1) == '*') {
                        boolean zeroMatch = dp[i - 1][j];
                        boolean keepMatch = dp[i][j - 1];
                        dp[i][j] = zeroMatch || keepMatch;
                    } else
                        dp[i][j] = false;
                }
            }
        }

        return dp[n1][n2];
    }
    
    
    static int wildcardMatching_Memoization(String s1, String s2, int i, int j, int[][] dp) {
        if (i < 0 && j < 0)
            return 1;

        else if (i < 0 && j >= 0)
            return 0;

        else if (j < 0 && i >= 0) {
            for (int k = 0; k <= i; k++) {
                if (s1.charAt(k) != '*') {
                    return 0;
                }
            }
            return 1;
        }

        if (dp[i][j] != -1)
            return dp[i][j];

        if (s1.charAt(i) == s2.charAt(j) || s1.charAt(i) == '?') {
            return dp[i][j] = wildcardMatching_Memoization(s1, s2, i - 1, j - 1, dp);
        } else if (s1.charAt(i) == '*') {
            int zeroMatch = wildcardMatching_Memoization(s1, s2, i - 1, j, dp);
            int keepMatch = wildcardMatching_Memoization(s1, s2, i, j - 1, dp);
            return dp[i][j] = (zeroMatch == 1 || keepMatch == 1) ? 1 : 0;
        } else
            return dp[i][j] = 0;
    }
    
    
    static boolean wildcardMatching_Recursion(String s1, String s2, int i, int j) { // is s1[0..i] matching s2[0..j]
        if (i < 0 && j < 0)
            return true;
        else if (i < 0 && j >= 0)
            return false;
        else if (j < 0 && i >= 0) { // will match only if all remaining chars in s1 are '*' as s2 is empty
            for (int k = 0; k <= i; k++) {
                if (s1.charAt(k) != '*')
                    return false;
            }
            return true;
        }

        if(s1.charAt(i) == s2.charAt(j) || s1.charAt(i) == '?')
            return wildcardMatching_Recursion(s1, s2, i - 1, j - 1);
        else if (s1.charAt(i) == '*') {
            boolean zeroMatch = wildcardMatching_Recursion(s1, s2, i - 1, j);
            boolean keepMatch = wildcardMatching_Recursion(s1, s2, i, j - 1);
            return zeroMatch || keepMatch;
        }
        else  // characters do not match
            return false;
    }

    public static void main(String[] args) {
        String s1 = "ab*j";
        String s2 = "abcj";

        // boolean isMatch = wildcardMatching_Recursion(s1, s2, s1.length() - 1, s2.length() - 1);
        
        // int[][] dp = new int[s1.length()][s2.length()];
        // for(int[] i: dp)
        //     Arrays.fill(i, -1);
        // int isMatch = wildcardMatching_Memoization(s1, s2, s1.length() - 1, s2.length() - 1, dp);
        // if (isMatch == 1)
        //     System.out.println("true");
        // else System.out.println("false");
        
        boolean isMatch = wildcardMatching_Tabulation(s1, s2);
        System.out.println(isMatch);

    }
}
*/