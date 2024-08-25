

import java.util.*;

public class practise {
    static int binarySearch_Recursion(int[] arr, int k, int low, int high) {
        
    }
    public static void main(String[] args) {
        int[] arr = { 2, 4, 7, 9, 12, 18, 24, 35, 42, 53 };
        int k = 2;
        int index = binarySearch_Recursion(arr, k);
        // int index = binarySearch_Iteration(arr, k);
        // int index = Arrays.binarySearch(arr, k);

        if(index>=0)
            System.out.println("The key " + k + " is present at index: " + index + " int the given list.");
        else    
            System.out.println("The key " + k + " is NOT present in the given list.");
    }
}