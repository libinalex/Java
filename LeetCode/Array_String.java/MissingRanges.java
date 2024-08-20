/* 
N = 5
Arr[] = {62, 8, 34, 5, 332}
Output: 0-4 6-7 9-33 35-61 63-331
Explanation: Elements in the range 0-4, 6-7, 9-33, 35-61 and 63-331 are not present.
*/

import java.util.*;

public class MissingRanges {
    static String give(int from, int to) {
        if (from == to)
            return String.valueOf(from) + " ";
        else
            return from + "->" + to + " ";
    }

    static String findMissing(int[] arr, int n) {
        // code here
        String ans = "";
        TreeSet<Integer> set = new TreeSet<>();
        for (int i : arr)
            set.add(i);

        int start = 0;
        int end = set.last();
        // int curr = 0;
        int prev = start - 1;
        for (int i = 0; i <= n; i++) {
            int curr = (set.isEmpty()) ? end + 1 : set.pollFirst();
            if (curr - prev >= 2) {
                ans = ans + give(prev + 1, curr - 1);
            }
            prev = curr;
        }
        if (ans.isEmpty())
            return "-1";
        return ans;
    }
    public static void main(String[] args) {
        int n = 5;
        int arr[] = { 62, 8, 34, 5, 332 };
        
        String missingRange = findMissing(arr, n);
        System.out.println(missingRange);
    }
}
