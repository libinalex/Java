/* 
1. Find the length of Longest Substring with At Most K Distinct Characters

Input:
S = "aabacbebebe", K = 3
Output: 
7
Explanation: 
"cbebebe" is the longest substring with at most 3 distinct characters.
*/
public class Substring {
    static int longestDistinctKSubstring(String s, int k) {
        int n = s.length();
        int i = 0, numDistinct = 0, maxLen = 0;
        int[] count = new int[256];

        for (int j = 0; j < n; j++) {
            if (count[s.charAt(j)] == 0)
                numDistinct++;
                
            count[s.charAt(j)]++;

            while (numDistinct > k) {
                count[s.charAt(i)]--;

                if (count[s.charAt(i)] == 0)
                    numDistinct--;

                i++;
            }
            maxLen = Math.max(maxLen, j - i + 1);
        }
        return maxLen;
    }
    public static void main(String[] args) {
        String s = "aabacbebebe";
        int k = 3;
        int len = longestDistinctKSubstring(s, k);
        System.out.println(len);
    }
}
