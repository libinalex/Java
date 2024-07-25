// Array Methods:
import java.util.Arrays;
import java.util.Scanner;

public class Array {

    static void printArray(int arr[]) {
        for (int i : arr) 
            System.out.print(i + " ");

        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements in the Array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter the array elements: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("\nThe given Array is: ");
        printArray(arr);
        

        // To copy an Array:      // Deep copy 
        int arr2[] = arr.clone();
        System.out.println("The new copied array is: ");
        printArray(arr2);

        int arr2b[] = Arrays.copyOf(arr, arr.length); // if you pass any n in 2nd parameter, that many elements will be copied in the new array
        printArray(arr2b);
        
        // To sort an array (implements comparable interface):
        Arrays.sort(arr);    // sorts in ascending order (natural ordering)
        System.out.print("\nArray after sorting: ");
        printArray(arr);

        System.out.println("\nThe copy of array in the range 1-4 is:");
        int arr2c[] = Arrays.copyOfRange(arr, 1, 4);
        printArray(arr2c);
        
        // To convert an array to String (To directly print the array without iterating through each element):
        System.out.print("\nThe String representation of the array: " + Arrays.toString(arr2));
        
        // To check if two arrays are equal
        System.out.println("\n\nAre the two arrays equal? : ");
        System.out.println(arr2.equals(arr2b));
        
        System.out.println("\nTo search an element in the array: ");
        System.out.println(Arrays.binarySearch(arr, 3));
        
    }
}


