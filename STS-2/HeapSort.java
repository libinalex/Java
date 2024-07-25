
/* 
Heap Sort:

Example 1:
7
35 17 10 90 24 -3 -8
Sorted array:
-8 -3 10 17 24 35 90

Example 2:
10
2 7 5 3 7 8 4 6 2 9
Sorted Array:
2 2 3 4 5 6 7 7 8 9
*/

import java.util.*;

public class HeapSort {

    static void heapify(int arr[], int N, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < N && arr[left] > arr[largest])
            largest = left;
        if (right < N && arr[right] > arr[largest])
            largest = right;
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, N, largest);
        }
    }
    
    public static void heapSort(int arr[]) {
        int N = arr.length;
        for (int i = N / 2 - 1; i >= 0; i--)   //   N/2 - 1  ->  last non-leaf node
            heapify(arr, N, i);
        for (int i = N - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no. of elements in array: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the array elements: ");
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        heapSort(arr);

        System.out.println("Sorted array: ");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        
        sc.close();
    }
}
