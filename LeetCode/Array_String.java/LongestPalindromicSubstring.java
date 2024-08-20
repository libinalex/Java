/* 
Given a string S, find the longest palindromic substring in S. You may assume that the
maximum length of S is 1000, and there exists one unique longest palindromic substring.

Eg.
Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.


Input: s = "cbbd"
Output: "bb"

Logic: Expand around centres(2n-1 centres in total) - O(n^2) time
*/

public class LongestPalindromicSubstring {    
    static int expandCentre(String s, int left, int right) {
        int l = left;
        int r = right;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }

    static String longestPalindromicSubstring(String s) {
        int n = s.length();
        int start = 0;
        int end = 0;

        for (int i = 0; i < n; i++) {
            int len1 = expandCentre(s, i, i);
            int len2 = expandCentre(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > (end - start)) {
                start = i - (len - 1) / 2;
                end = i + (len / 2);
            }
        }

        return s.substring(start, end + 1);
    }
    public static void main(String[] args) {
        String s = "werebababc";
        String lps = longestPalindromicSubstring(s);
        System.out.println(lps);
    }
}
