import java.util.*;

// 1. Write a Java program to find smallest and second greatest elements of a given array.
/*

public class Array_ex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements in Array:");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the array elements: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Given array: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        for (int i = 0; i < arr.length - 1; i++) {      // Sorting an array
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        // Arrays.sort(arr);
        
        System.out.println("The SMALLEST element in given array is: " + arr[0]);
        System.out.println("The SECOND LARGEST element in given array is: " + arr[arr.length - 2]);
    }
}
*/

/* 
// 2. Write a Java program to separate even and odd numbers of a given array of integers. Put all odd numbers first, and then even numbers. 
*/
public class Array_ex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements in Array:");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the array elements: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Given array: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();


    }
}




// 3. Write a Java program to find all combination of a three-digit number(triplets) and store into an array. Display the elements of the array whose sum is equal to a given value.
/*
import java.util.*;

public class Array_ex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements in Array:");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter 1-digit array elements: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("\nGiven Array: ");
        for (int element : arr) {
            System.out.print(element + " ");
        }

        int newArr[] = new int[1000];
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                for (int k = 0; k < arr.length; k++) {
                    newArr[count] = 100 * arr[i] + 10 * arr[j] + arr[k];
                    count++;
                }
            }
        }
        System.out.println("\nAll combination of a three-digit number(triplets) are: ");
        for (int i = 0; i < count; i++) {
            System.out.print(newArr[i] + " ");
        }
    }
}
*/
/*
// 4. Write a Java Program to Insert an Element in a Specified Position in a Given Array and print the updated array after insertion. 

import java.util.*;

public class Array_ex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements in Array: ");
        int n = sc.nextInt();

        int arr[] = new int[n + 1];
        System.out.println("Enter array elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        System.out.print("Enter the element you want to insert in the Array: ");
        int key = sc.nextInt();
        System.out.print("Enter the index in which you want to insert the element: ");
        int index = sc.nextInt();

        System.out.print("\nGiven Array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            while (i >= index && i != 0) {
                arr[i] = arr[i - 1];
                i--;
            }
        }
        arr[index] = key;

        System.out.printf("\nInserting number %d at index %d...", key, index);
        System.out.print("\nArray after insertion: ");
        for (int element : arr) {
            System.out.print(element + " ");
        }
    }
}
*/

/*
// 5. Write a Java Program to Delete the Specified Integer from an Array and print the updated array after deletion. 

import java.util.*;

public class Array_ex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements in Array:");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter array elements: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter the number you want to delete from the Array: ");
        int key = sc.nextInt();

        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key)
                index = i;
        }

        System.out.print("\nGiven Array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        if (index == -1) {
            System.out.println("\nThe entered number is not present in the Array.");
            System.exit(0);
        }

        else {
            for (int i = 0; i < arr.length; i++) {
                if (i > index) {
                    arr[i - 1] = arr[i];
                }
            }
        }

        System.out.print("\nArray after deletion: ");
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}
*/

// 6. Given two sorted arrays A and B of size m and n, write a Java program to merge elements of A with B by maintaining the sorted order. 
/*
import java.util.*;

public class Array_ex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements in Array 1:");
        int n1 = sc.nextInt();
        int arr1[] = new int[n1];
        System.out.println("Enter array elements in sorted order: ");
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = sc.nextInt();
        }

        System.out.print("Enter the number of elements in Array 2:");
        int n2 = sc.nextInt();
        int arr2[] = new int[n2];
        System.out.println("Enter array elements in sorted order: ");
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = sc.nextInt();
        }

        int newArr[] = new int[n1 + n2];
        int count1 = 0, count2 = 0;

        for (int i = 0; i < newArr.length; i++) {
            if (count1 >= n1) 
                newArr[i] = arr2[count2++];

            else if(count2 >= n2)
                newArr[i] = arr1[count1++];
            
            else if (arr1[count1] < arr2[count2]) 
                newArr[i] = arr1[count1++];
            
            else 
                newArr[i] = arr2[count2++];
        }

        System.out.println("Given Arrays:");
        System.out.print("Array 1: ");
        for (int i : arr1) {
            System.out.print(i + " ");
        }

        System.out.print("\nArray 2: ");
        for (int i : arr2) {
            System.out.print(i + " ");
        }

        System.out.println("\nSorted Array after merging the two arrays: ");
        for (int element: newArr) {
            System.out.print(element + " ");
        }
    }
}
*/

/* 
// 7. Write a Java program to rearrange a given array of unique elements such that every second element of the array is greater than its left and right elements. 

Example: 
Input : n= { 1, 2, 4, 9, 5, 3, 8, 7, 10, 12, 14 } 
Output: Array with every second element is greater than its left and right elements: [1, 4, 2, 9, 3, 8, 5, 10, 7, 14, 12] 
*/

/*
// 8. Write a Java program to create all possible permutations of a given array of distinct integers. 

import java.util.*;

public class Array_ex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements in Array:");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter distinct array elements: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("\nGiven Array: ");
        for (int element : arr) {
            System.out.print(element + " ");
        }

        


        System.out.println("\nAll possible permutations of the given array are: ");
        
    }
}
*/

// 9. Write a program to find the sum of all odd numbers and product of all even numbers in a Double Dimensional Array (DDA) 

// 10. Write a program to find the row sum, column sum and total sum in a DDA

/*
// 11. Write a Program to reverse an array:

public class Array_ex {
    static void reverseArray(int arr[]) {
        for (int i = 0; i < arr.length/2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length -1 - i] = temp;
        }
    }
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6 };
        
        System.out.print("array before reverse: ");
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();

        reverseArray(arr);

        System.out.print("array after reverse:  ");
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }
}
*/

/*
// 12. Program to count the number of occurances of a particular element in an array

public class Array_ex {

    static int coutOccurances(int arr[], int num) {
        int count = 0;
        for (int i : arr) {
            if (i == num) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = { 12, 43, 67, 23, 8, 23, 98, 12, 67, 12, 8, 23 };

        System.out.print("Enter the element you want the count of: ");
        int num = sc.nextInt();

        int count = coutOccurances(arr, num);
        System.out.println("The element " + num + " occurs " + count + " times in the array.");
    }
}
*/

/*
// 13. Find last occurance of an element in a given array

public class Array_ex {

    static int lastOccurance(int arr[], int num) {
        int index = -1;
        for (int i=0; i<arr.length; i++) {
            if (arr[i] == num) {
                index = i ;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = { 12, 43, 67, 23, 8, 23, 98, 12, 67, 12, 8, 23 };

        System.out.print("Enter the element you want the last occurance of: ");
        int num = sc.nextInt();

        int index = lastOccurance(arr, num);

        if (index == -1) {
            System.out.println("The given element does not occur in the given array.");
        } 
        else {
            System.out.println("The element " + num + " occurs last at " + index + "th index.");
        }
    }
}
*/

/*
// 14. Count the number of elements strictly greater than a given number in an array

public class Array_ex {

    static int countGreater(int arr[], int num) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > num) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = { 12, 43, 67, 23, 8, 23, 98, 12, 67, 12, 8, 23 };

        System.out.print("Enter the number: ");
        int num = sc.nextInt();

        int count = countGreater(arr, num);

        System.out.println("There are " + count + " elements strictly greater than the number " + num + " in the given array.");
        
    }
}
*/

/*
// 15. Program to check if a given array is sorted or not.

public class Array_ex {
    static Boolean checkSorted(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 4, 6, 7, 7 };
        if (checkSorted(arr)) {
            System.out.println("The given array is Sorted!");
        }
        else {
            System.out.println("The given array is NOT Sorted!");
        }
    }
}
*/

/*
// 16. Write a method to return the kth smallest and kth largest element from an array

public class Array_ex {
    static int[] kthSmallestLargest(int arr[], int k) {
        Arrays.sort(arr);
        int newArr[] = { arr[k - 1], arr[arr.length - k] };
        return newArr;
    }

    public static void main(String[] args) {
        int arr[] = { 12, 34, 8, 45, 29, 40, 55 };
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter k to get the kth smallest and kth largest element from the array: ");
        int k = sc.nextInt();

        int ans[] = kthSmallestLargest(arr, k);
        System.out.println("The " + k + "th smallest element in the Array is: " + ans[0]);
        System.out.println("The " + k + "th largest element in the Array is: " + ans[1]);
    }
}
*/

/*
// 17. Program to find the total number of pairs in the Array whose sum is equal to a given value

public class Array_ex {
    static void noOfPairs(int arr[], int num) {
        int count = 0;
        System.out.println("The pairs in the Array whose sum is equal to " + num + " are: ");
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i] + arr[j] == num){
                    count++;
                    System.out.printf("(%d, %d) ", arr[i], arr[j]);
                }
            }
        }
        System.out.println();
        System.out.print("The total number of such pairs in the array are: " + count);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int num = sc.nextInt();
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        noOfPairs(arr, num);
    }
}
*/

/*
// 17. Program to find the total number of triplets in the Array whose sum is equal to a given value

public class Array_ex {
    static void noOfTriplets(int arr[], int num) {
        int count = 0;
        System.out.println("The triplets in the Array whose sum is equal to " + num + " are: ");
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                for (int k = j+1; k < arr.length; k++) {
                    if (arr[i] + arr[j] + arr[k] == num) {
                    count++;
                    System.out.printf("(%d, %d, %d) ", arr[i], arr[j], arr[k]);
                    }
                }
            }
        }
        System.out.println();
        System.out.print("The total number of such triplets in the array are: " + count);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int num = sc.nextInt();
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        noOfTriplets(arr, num);
    }
}
*/

/*
//18. Program to find the unique number in a given array where all the elements are being repeated twice with one value being unique

public class Array_ex {
    static int findUnique(int arr[]) {
        int freq[] = new int[arr.length];
        int count, indexOfUnique = -1;
        for (int i = 0; i < arr.length; i++) {
            count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }
            freq[i] = count;
        }
        // for (int i = 0; i < freq.length; i++) {
        //     System.out.printf("Frequency of %d: %d\n", arr[i], freq[i]);
        // }
        // System.out.println();

        for (int i = 0; i < freq.length; i++) {
            if (freq[i] == 1) {
                indexOfUnique = i;
                break;
            }
        }
        return arr[indexOfUnique];
    }
    public static void main(String[] args) {
        int arr[] = { 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 7, 7, 8, 8, 9, 9, 23, 23 };
        int unique = findUnique(arr);
        System.out.println("The unique number in the array is: " + unique);
    }
}
*/
/*
// If there are only +ve elements in the array
public class Array_ex {
    static int findUnique(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] == arr[j]) { 
                    arr[i] = arr[j] = -1;
                }
            }
            
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != -1) {
                return arr[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 1, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 23, 23 };
        int unique = findUnique(arr);
        System.out.println("The unique number in the array is: " + unique);
    }
}
*/

/*
// 19. Program to find the 2nd largest element in the given array:
    9, 8, 9, 6, 9, 5, 8    --->   8
    0, -2, 0, -3, -7, -4   --->   -2

public class Array_ex {
    static int largest(int arr[]) {
        int max = Integer.MIN_VALUE;
        for (int element : arr) {
            if (element > max) {
                max = element;
            }
        }
        return max;
    }

    static int secondLargest(int arr[]) {
        int max = largest(arr);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == max) {
                arr[i] = Integer.MIN_VALUE;
            }
        }
        int second_max = largest(arr);
        return second_max;
    }
    public static void main(String[] args) {
        int arr[] = { 9, 8, 9, 6, 9, 5, 8 };
        int arr2[] = { 0, -2, 0, -3, -7, -4 };
        System.out.println("The second largest element in the given array is: " + secondLargest(arr));
        System.out.println("The second largest element in the given array is: " + secondLargest(arr2));
    }
}
*/

/*
// 20. Given an array of positive integers. Write a program to return the first value that is repeating in this array. If no value is being repeated, return -1.

public class Array_ex {
    static int firstRepeat(int arr[]) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    return arr[i];
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int arr[] = {2, 5, 23, 12, 45, 9, 12, 8, 3};
        System.out.println("The first value that is repeating in the given array is: " + firstRepeat(arr));
    }
}
*/

/* 
// 20. Rotate a given array by 'k' steps.
(k is non-negative and can be greater than array length as well)

public class Array_ex {
    static void printArray(int arr[]) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    static void rotateArray(int arr[], int k) {
        k = k % arr.length;
        int temp;
        for (int i = 0; i < k; i++) {
            temp = arr[arr.length - 1];
            for (int j = arr.length-1; j > 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[0] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 }; 
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the steps by which you want to rotate the array: ");
        int k = sc.nextInt();
        System.out.println("Array before rotation: ");
        printArray(arr);

        rotateArray(arr, k);

        System.out.println("Array after rotation by " + k + " steps: ");
        printArray(arr);
    }
}
*/
/*
// Approach 2:  (Without using extra space)
public class Array_ex {
    static void printArray(int arr[]) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    static void reverseArray(int arr[], int i, int j) {     // method to reverse an array from index i to j
        while(i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++; j--;
        }
    }

    static void rotateArray(int arr[], int k) {
        int n = arr.length;
        k = k % n;
        reverseArray(arr, 0, n-k-1);
        reverseArray(arr, n-k, n - 1);
        reverseArray(arr, 0, n - 1);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 };
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the steps by which you want to rotate the array: ");
        int k = sc.nextInt();
        System.out.println("Array before rotation: ");
        printArray(arr);

        rotateArray(arr, k);

        System.out.println("Array after rotation by " + k + " steps: ");
        printArray(arr);
    }
}
*/

/*
// FREQUENCY ARRAY:-
// 22. Given Q queries, check if the given number is present in the array or not.
Given that, value of all the elements in the array is less than 10^5.


public class Array_ex {
    static int[] makeFrequencyArray(int arr[]) {
        int freqArr[] = new int[100001];
        for (int i : arr) {
            freqArr[i]++;
        }
        return freqArr;
    }

    static void searchFreqArray(int freqArr[], int num) {
        if (freqArr[num] > 0) {
            System.out.println("Yes! " + num + " is present in the array\n");
        } 
        else {
            System.out.println("No! " + num + " is NOT present in the array\n");
        }
    }
    public static void main(String[] args) {
        int arr[] = { 12, 34, 56, 78, 90, 134, 654, 2, 94, 7, 25, 64, 1234, 5674, 863 };

        int freqArr[] = makeFrequencyArray(arr);

        Scanner sc = new Scanner(System.in);
        System.out.print("Ener the number of Queries you have: ");
        int q = sc.nextInt();

        for (int i = 0; i < q; i++) {
            System.out.print("Enter the Query " + (i+1) + ": ");
            int num = sc.nextInt();
            searchFreqArray(freqArr, num);
        }
    }
}
*/

// TWO POINTERS:-
// 23. Sort an Array consisting of only 0s and 1s
/*
public class Array_ex {
    static void swapArr(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void sortWithCount(int arr[]) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0)
                count++;
        }
        for (int i = 0; i < count; i++) {
            arr[i] = 0;
        }
        for (int i = count; i < arr.length; i++) {

            arr[i] = 1;
        }
    }
    
    static void sort(int arr[]) {
        int i = 0, j = arr.length - 1, temp;
        while (i < j) {
            if (i == 1 && j == 0) {
                // swapArr(arr, i, j);
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }

            if (i == 0)
                i++;

            if (j == 1)
                j--;

        }
    }
    public static void main(String[] args) {
        int arr[] = { 1, 1, 0, 1, 0, 0, 0, 1, 1, 0, 1 };
        System.out.print("Array before Sort: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }

        sortWithCount(arr);

        System.out.println();
        System.out.print("Array after Sort:  ");
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }
}
*/