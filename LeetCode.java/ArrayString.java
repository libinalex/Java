/* 
1. Two Sum
Question:
Given an array of integers, find two numbers such that they add up to a specific target number.
The function twoSum should return indices of the two numbers such that they add up to
the target, where index1 must be less than index2. Please note that your returned answers
(both index1 and index2) are not zero-based.
You may assume that each input would have exactly one solution.
*/
public class ArrayString {
    static int[] twoSum(int[] arr, int target) {
        
    }
    public static void main(String[] args) {
        int arr[] = { 23, 9, 5, 12, 8, 7, 3 };
        int target = 11;
        int[] ans = twoSum(arr, target);
        System.out.println("The indices of the two no. such that they add to target is: " + ans[0] + ", " + ans[1]);
    }
}

