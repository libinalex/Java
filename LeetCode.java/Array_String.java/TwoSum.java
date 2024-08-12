import java.util.*;
/* 
1. Two Sum

Given an array of integers, find two numbers such that they add up to a specific target number.
The function twoSum should return indices of the two numbers such that they add up to
the target, where index1 must be less than index2. Please note that your returned answers
(both index1 and index2) are not zero-based.
You may assume that each input would have exactly one solution.


public class TwoSum {
    static int[] twoSum(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int x = arr[i];
            int expected = target - x;
            if (map.containsKey(expected)) {
                return new int[] { map.get(expected), i };
            }
            map.put(x, i);
        }
        return null;
    }
    public static void main(String[] args) {
        int arr[] = { 23, 9, 5, 12, 8, 7, 3 };
        int target = 11;
        int[] ans = twoSum(arr, target);
        System.out.println("The indices of the two no. such that they add to target is: " + ans[0] + ", " + ans[1]);
    }
}

*/
/* 
2. Two Sum - Given sorted array
Logic: Binary search the required element; time - O(n log n), space - O(1)
Logic: Use 2 pointers - O(n)
*/
public class TwoSum {
    static int[] twoSum(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            int j = Arrays.binarySearch(arr, target - arr[i]);
            if (j > 0) {
                return new int[] { i, j };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int arr[] = { 2, 3, 5, 6, 9, 11, 14, 15 };
        int target = 180;
        int[] ans = twoSum(arr, target);
        System.out.println(Arrays.toString(arr));
        System.out.println("The indices of the two no. such that they add to target is: " + ans[0] + ", " + ans[1]);
    }
}
