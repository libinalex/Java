/* 
Rotate an array to the right by k steps in-place without allocating extra space. 
Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]


Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]

Logic: 
Rotate last k elements.
Rotate remaining elements: 1st n-k
Rotate whole array

OR

Rotate whole array.
Rotate 1st k elements.
Rotate remaining elements.
*/

import java.util.Arrays;

public class RotateArray {

    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        // reverse(nums, 0, n - k - 1);
        // reverse(nums, n - k, n - 1);
        // reverse(nums, 0, n - 1);
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    static void reverse(int[] nums, int i, int j) {
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7};
        int k = 3;
        System.out.println("Original array: " + Arrays.toString(arr));
        rotate(arr, k);
        System.out.println("Array after rotating " +k +" steps: " + Arrays.toString(arr));
    }
}

