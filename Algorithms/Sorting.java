
import java.util.*;

/*
// Bubble Sort

public class Sorting {
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void bubbleSort(int[] arr) {
        System.out.println("\nPerforming Bubble Sort: ");
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
            System.out.println(i +"th iteration: " + Arrays.toString(arr));
        }
    }
    public static void main(String[] args) {
        int[] arr = { 8, 5, 2, 7, 3, 1, 6, 4 };
        System.out.println("Original Array: " + Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println("\nArray after sorting: " + Arrays.toString(arr));
    }
}
*/

/*
// Insertion Sort

public class Sorting {

    static void insertionSort(int[] arr) {
        System.out.println("\nPerforming Insertion Sort: ");

        for(int i=1; i<arr.length; i++){
            int temp = arr[i];
            int j = i-1;
            while (j >= 0 && arr[j] > temp) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
            System.out.println(i + "th iteration: " + Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {
        int[] arr = { 8, 5, 2, 7, 3, 1, 6, 4 };
        System.out.println("Original Array: " + Arrays.toString(arr));
        insertionSort(arr);
        System.out.println("\nArray after Sorting: " + Arrays.toString(arr));
    }
}
*/

/* 
// Selection Sort

public class Sorting {

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void selectionSort(int[] arr) {
        System.out.println("\nPerforming Selection Sort: ");

        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex])
                    minIndex = j;
            }
            swap(arr, i, minIndex);
            System.out.println(i + "th iteration: " + Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {
        int[] arr = { 8, 5, 2, 7, 3, 1, 6, 4 };
        System.out.println("Original Array: " + Arrays.toString(arr));
        selectionSort(arr);
        System.out.println("\nArray after Sorting: " + Arrays.toString(arr));
    }
}
*/

/* 
Q. Sort an array with three types of elements in one iteration
Logic: Dutch Flag sorting algorithm

public class Sorting {
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    static void sort3Elements(int[] arr) {
        int n = arr.length;
        int low = 0, mid = 0, high = n - 1;
        while (mid <= high) {
            if (arr[mid] == 0) {
                swap(arr, low, mid);
                mid++;
                low++;
            }
            else if (arr[mid] == 1) {
                mid++;
            }
            else {
                swap(arr, mid, high);
                high--;
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = { 2, 2, 1, 2, 0, 0, 1, 2, 0, 1, 0 };
        System.out.println("Before Sorting: " + Arrays.toString(arr));
        sort3Elements(arr);
        System.out.println("After Sorting: " + Arrays.toString(arr));
    }
}
*/

/* 
Quick Sort

public class Sorting {
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int partition(int arr[], int start, int end) {
        int i = start;
        int j = end;
        int pivot = arr[end];
        while (i < j) {
            while (i < j && arr[i] < pivot)
                i++;
            while (arr[j] >= pivot)
                j--;
            if (i < j)
                swap(arr, i, j);
        }
        swap(arr, end, i);

        System.out.println(Arrays.toString(arr));
        return i;
    }

    static void quickSort(int arr[], int start, int end) {
        if (start < end) {
            int pivot = partition(arr, start, end);
            quickSort(arr, start, pivot-1);
            quickSort(arr, pivot + 1, end);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 8, 5, 2, 7, 3, 1, 6, 4 };
        System.out.println("Array Before Sorting: " + Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println("\nArray After Sorting: " + Arrays.toString(arr));
    }
}
*/

/* 
Merging two Sorted Arrays

public class Sorting {
    static int[] mergeSortedArrays(int[] a1, int[] a2) {
        int n1 = a1.length;
        int n2 = a2.length;
        int[] merged = new int[n1 + n2];
        int i = 0, j = 0, k = 0;
        while (i < n1 && j < n2) {
            if (a1[i] < a2[j])
                merged[k++] = a1[i++];

            else
                merged[k++] = a2[j++];
        }
        while (i < n1) {
            merged[k++] = a1[i++];
        }
        while (j < n2) {
            merged[k++] = a2[j++];
        }
        return merged;
    }
    public static void main(String[] args) {
        int[] a1 = { 2, 5, 6, 8, 12 };
        int[] a2 = { 3, 5, 7, 10, 11, 14 };
        int[] sorted = mergeSortedArrays(a1, a2);
        System.out.println(Arrays.toString(sorted));
    }
}
*/

/* 
Merge Sort

public class Sorting {

    static void merge(int[] arr, int start, int mid, int end) {
        int[] b = new int[arr.length];
        int i = start, k = start;
        int j = mid + 1;
        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j])
                b[k++] = arr[i++];
            else
                b[k++] = arr[j++];
        }
        while (i <= mid)
            b[k++] = arr[i++];
        while (j <= end)
            b[k++] = arr[j++];
        
        for (i = start; i <= end; i++) {
            arr[i] = b[i];
        }
        System.out.println(Arrays.toString(arr));
    }

    static void mergeSort(int arr[], int start, int end) {
        if(start >= end)
            return;

        int mid = (start + end) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid+1, end);
        merge(arr, start, mid, end);
    }
    
    public static void main(String[] args) {
        int arr[] = { 8, 5, 2, 7, 3, 1, 6, 4 };
        System.out.println("Array Before Sorting: " + Arrays.toString(arr));
        mergeSort(arr, 0, arr.length-1);
        System.out.println("\nArray After Sorting: " + Arrays.toString(arr));
    }
}
*/