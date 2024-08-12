// Binary Search

import java.util.Arrays;

public class Searching {
    public static int binarySearch(int[] arr, int start, int end, int key){
        int mid = end / 2;
        if (key == arr[mid])
            return mid;
        else if (key < arr[mid])
            binarySearch(arr, 0, mid - 1, key);
        else if (key > arr[mid])
            binarySearch(arr, mid, end, key);
        return -1;
    }
    public static void main(String[] args) {
        int arr[] = { 12, 43, 634, -3, 0, 7, 23, 9 };
        int key = 43;
        Arrays.sort(arr);
        System.out.println("The array is: " + Arrays.toString(arr)); 
        int pos = binarySearch(arr, 0, arr.length-1, key);
        if (pos != -1) 
            System.out.println("The key " + key + " is present at position: " + pos);
        else 
            System.out.println("The given key is not present in the array.");
        
    }
}
