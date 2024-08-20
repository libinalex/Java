/* 
Given two strings S and T, determine if they are both one edit distance apart.

The possible edits are:
Insert a character.
Delete a character.
Replace a character.
*/

public class OneEditDistance {
    public static boolean isOneEditDistance(String s, String t) {
        int m = s.length(), n = t.length();
        // Ensure s is the shorter string
        if (m > n)
            return isOneEditDistance(t, s);

        // If the length difference is greater than 1, they can't be one edit apart
        if (n - m > 1)
            return false;

        int i = 0;
        // Find the first difference between s and t
        while (i < m && s.charAt(i) == t.charAt(i))
            i++;

        // If there's no difference found and the strings are of different lengths, the difference is the extra character at the end of t
        if (i == m)
            return n > m;

        // If lengths are the same, skip the differing character
        if (m == n)
            i++;

        // Continue comparing the remaining characters
        while (i < m && s.charAt(i) == t.charAt(i + (n - m)))
            i++;

        // If we reach the end, they are one edit apart
        return i == m;
    }
    public static void main(String[] args) {
        String s1 = "libin";
        String s2 = "libin";
        boolean isOneEdit = isOneEditDistance(s1, s2);
        System.out.println(isOneEdit);
    }
}
