import java.util.*;

public class LongestPalindromicSubsequence {
    public static int[][] dp;

    public static String longestPalindrome(String s1, String s2) {
        int n = s1.length();
        dp = new int[n + 1][n + 1];
        
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;

                else if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];

                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        
        StringBuilder lps = new StringBuilder();
        int i = n, j = n;
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                lps.insert(0, s1.charAt(i - 1));
                i--;
                j--;
            }
            else if(dp[i-1][j] > dp[i][j-1])
                i--;
            else
                j--;
        }
        
        return lps.toString();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String s1 = sc.next();
        StringBuilder s2 = new StringBuilder(s1);
        s2.reverse();
        String lps = longestPalindrome(s1, s2.toString());

        System.out.println("The length of longest Palindromic subsequence is: " + dp[s1.length()][s1.length()]);
        System.out.println("The longest palindromic subsequence is: " + lps);
    }
    
}
