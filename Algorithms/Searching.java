// Binary Search

import java.util.Arrays;

public class Searching {
    public static int binarySearchIterative(int[] arr, int start, int key) {
        int end = arr.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] < key)
                start = mid + 1;
            else
                end = mid;
        }
        int index = (start == end && arr[start] == key) ? start : -1;
        return index;
    }

    public static int binarySearchRecursive(int[] arr, int start, int end, int key) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (key == arr[mid])
                return mid;
            else if (key < arr[mid])
                return binarySearchRecursive(arr, 0, mid - 1, key);
            else if (key > arr[mid])
                return binarySearchRecursive(arr, mid, end, key);
        }
        return -1;
    }
    public static void main(String[] args) {
        int arr[] = { 12, 43, 634, -3, 0, 7, 23, 9 };
        int key = 23;
        Arrays.sort(arr);
        System.out.println("The array after sorting is: " + Arrays.toString(arr));
        int pos = binarySearchRecursive(arr, 0, arr.length - 1, key);
        
        // int pos = binarySearchIterative(arr, 0, key);
        
        
        if (pos != -1) 
            System.out.println("The key " + key + " is present at position: " + pos);
        else 
            System.out.println("The given key "+ key + " is not present in the array.");
        
        System.out.println(Arrays.binarySearch(arr, key));
    }
}
