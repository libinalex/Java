
import java.util.*;
/*
// 1. Find maximum element in an array:
public class Problems {
    public static int[] createArray() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements int the array: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the Array elements: ");
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }
    public static void main(String args[]) {
        int arr[] = createArray();
        int max = Integer.MIN_VALUE;
        for (int i : arr) {
            if(i>max) {
                max = i;
            }
        }
        System.out.println("The maximum element in the array is: " + max);
    }
}
*/

/*
// 2. Remove duplicates from an array
public class Problems {
    public static void removeDuplicatesUsingSet(int[] arr) {
        Set<Integer> set = new LinkedHashSet<>();
        for (int i : arr) {
            set.add(i);
        }
        System.out.println(set);
    }
    public static void main(String[] args) {
        int arr[] = { 2, 9, 3, 15, 6, 3, 7, 8, 9, 1, 2 };
        System.out.println(Arrays.toString(arr));
        removeDuplicatesUsingSet(arr);
    }
}
*/

/*
// 3. Leaders in an array
public class Problems {
    static void printLeaders(int arr[]) {
        Stack<Integer> st = new Stack<>();
        int max = arr[arr.length - 1];
        st.push(max);
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > max) {
                st.push(arr[i]);
                max = arr[i];
            }
        }

        System.out.println("The leaders in the array are: ");
        int n = st.size();
        for (int i = 0; i < n; i++) {
            System.out.print(st.pop() + " ");
        }
    }
    public static void main(String[] args) {
        int arr[] = { 2, 4, 9, 6, 8, 4, 5, 3 };
        System.out.println(Arrays.toString(arr));
        printLeaders(arr);
    }
}
*/

/*
4. Given an integer array nums, return an array answer such that answer[i]
is equal to the product of all the elements of nums except nums[i].

public class Problems {
    public static int[] solve(int nums[]) {
        int answer[] = new int[nums.length];
        int prod = 1;
        for (int i : nums) {
            prod = prod * i;
        }
        for (int i = 0; i < answer.length; i++) {
            answer[i] = prod / nums[i];
        }
        return answer;
    }
    public static void main(String[] args) {
        int nums[] = { 2, 4, 3, 6, 4, 5 };
        System.out.println(Arrays.toString(nums));
        int answer[] = solve(nums);
        System.out.println(Arrays.toString(answer));
    }
}
*/

/*
5. Given an integer array nums, move all 0's to the end of it while
maintaining the relative order of the non-zero elements.
Note that you must do this in-place without making a copy of the array.

public class Problems {
    public static void move(int nums[]) {

        for (int i = 0, j = 1; j < nums.length; i++, j++) {
            if (nums[i] != 0)
                continue;
            while(nums[j] == 0 && j < nums.length-1) j++;
            if (nums[i] == 0 ) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        
        System.out.println("Array after moving the 0s: " + Arrays.toString(nums));
    }
    public static void main(String[] args) {
        int nums[] = { 0, 2, 0, 0, 0, 3, 4, 0, 5, 0, 0, 7, 0 };
        System.out.println("Original Array: " + Arrays.toString(nums));
        move(nums);
    }
}
*/

/*
6. You are given an array of prices where prices[i] is the price of a given
stock on an ith day. You want to maximise your profit by choosing a
single day to buy one stock and choosing a different day in the future to
sell that stock. Return the maximum profit you can achieve from this
transaction. If you cannot achieve any profit, return 0.

public class Problems {
    public static int calculateProfit(int[] prices) {
        int maxProfit = 0;
        int buy = 0;
        for (int sell = 1; sell < prices.length; sell++) {
            if(prices[sell] < prices[buy])
                buy = sell;
            else{
                if (prices[sell] - prices[buy] > maxProfit)
                maxProfit = prices[sell] - prices[buy];
            }
        }

        return maxProfit;
    }
    public static void main(String[] args) {
        int[] prices = { 100, 86, 120, 105, 64, 78, 99 };
        int maxProfit = calculateProfit(prices);
        System.out.println("The maximum possible profit is: " + maxProfit);
    }
}
*/
/*
7. The next permutation of an array of integers is the next lexicographically
greater permutation of its integer. Given an array of integers nums, find
the next permutation of nums.
The replacement must be in place and use only constant extra memory.
*/

/*
8. Given an array of integers and an integer target, return indices of the two
numbers such that they add up to target.
*/

/*
9. You are given an integer array height of length n. There are n vertical
lines drawn such that the two endpoints of the ith line are (i, 0) and (i,
height[i]). Find two lines that together with the x-axis form a container,
such that the container contains the most water. Return the maximum
amount of water a container can store.
*/

/*
10. Given an array nums with n objects colored red, white, or blue, sort them
in-place so that objects of the same color are adjacent, with the colors in
the order red, white, and blue.
*/

/*
11. Given an array of positive integers nums and a positive integer target,
return the minimal length of a subarray whose sum is greater than or
equal to target. If there is no such subarray, return 0 instead.
*/

/*
12. You are given two integer arrays nums1 and nums2, sorted in non-
decreasing order, and two integers m and n, representing the number of
elements in nums1 and nums2 respectively.
Merge nums1 and nums2 into a single array sorted in non-decreasing
order.
*/

/* 
13. Maximum Sum Subarray
// Kadane's Algorithm

public class Problems {
    static int maxSumSubarray(int arr[]) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        for (int i : arr) {
            currSum += i;
            if (currSum > maxSum) {
                maxSum = currSum;
            }
            if (currSum < 0)
                currSum = 0;
        }
        return maxSum;
    }
    public static void main(String[] args) {
        int arr[] = { 6, -7, 4, -2, 1, 5, -4 };
        System.out.println(Arrays.toString(arr));
        int maxSum = maxSumSubarray(arr);
        System.out.println("The maximum sum of a subarray in given array is: " + maxSum);
    }
}
*/

/* 
14. Container with most water (sheets are very thin)
// 2-pointer approach

public class Problems {
    static int maxWater(int arr[]) {
        int maxQuantity = 0;
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int qty = (end - start) * Math.min(arr[start], arr[end]);
            maxQuantity = Math.max(maxQuantity, qty);
            if(arr[start] < arr[end])
                start++;
            else
                end--;
        }
        return maxQuantity;
    }
    public static void main(String[] args) {
        int arr[] = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        System.out.println(Arrays.toString(arr));
        int quantity = maxWater(arr);
        System.out.println("The maximum units of water that could be stored is: " + quantity);
    }
}
*/

/* 
15. Trapping Rain water problem. Histogram given - O(n) time and O(n) space

public class Problems {
    static int trapRainWater(int[] arr) {
        int n = arr.length;
        int qty = 0;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = arr[0];
        right[n - 1] = arr[n - 1];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], arr[i]);
        }
        System.out.println(Arrays.toString(left));
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(arr[i], right[i + 1]);
        }
        System.out.println(Arrays.toString(right));
        for (int i = 0; i < n; i++) {
            qty = qty + Math.min(left[i], right[i]) - arr[i];
        }
        return qty;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println(Arrays.toString(arr));
        int totalRainWater = trapRainWater(arr);
        System.out.println("The total trapped rainwater is: " + totalRainWater);
    }
}

// in O(1) space:

*/

/* 
16. Find if there is a subarray with 0 sum
// Prefix-Sum

public class Problems {
    static boolean check0Sum(int[] arr) {
        int[] prefixSum = new int[arr.length];
        prefixSum[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefixSum[i] = arr[i] + prefixSum[i - 1];
        }
        System.out.println("Prefix-sum: " + Arrays.toString(prefixSum));
        // in prefix sum -> if the sum repeats, that means the sum of numbers bw them is 0
        // to check duplicates in the prefix sum array in O(n), we use a Set
        HashSet<Integer> set = new HashSet<>();
        for (int i : prefixSum) {
            if (set.add(i) == false) // set already contains the element -> false
                return true; // subarray with 0 sum
        }
        return false;
        
    }
    public static void main(String[] args) {
        int arr[] = { 2, 13, 1, -4, 3, -2 };
        System.out.println(Arrays.toString(arr));
        if (check0Sum(arr)) 
            System.out.println("Yes, the given array has a subarray with 0 sum.");
        
        else 
            System.out.println("No, the given array doesn't have any subarray with 0 sum.");
        

    }
}
*/

/* 
17. Find intersection of two sorted arrays


public class Problems {
    static void intersectionOfArrays(int[] a1, int[] a2) {
        int n1 = a1.length, n2 = a2.length;
        int i = 0, j = 0;
        while (i < n1 && j < n2) {
            if(a1[i] == a2[j]){
                System.out.print(a1[i] + " ");
                i++;
                j++;
            }
            else if(a1[i]<a2[j])
                i++;
            else
                j++;
        }
        
    }

    public static void main(String[] args) {
        int[] a1 = { 2, 5, 6, 6, 8, 8 };
        int[] a2 = { 1, 1, 2, 3, 6, 6, 9 };
        intersectionOfArrays(a1, a2);
    }
}
*/