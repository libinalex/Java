// Sorting an array

/*
import java.util.*;

public class practise {

    public static void main(String[] args) {
        
        int arr[] = { 4, 24, 9, 11, 17, 0, 44, 1 };

        System.out.println("Array before sort: ");

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
                // for (int k = 0; k < arr.length; k++) {
                //     System.out.print(arr[k] + " ");
                // }
                // System.out.println();
            }
        }

        System.out.println("Array after sort: ");

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        
    }
}
*/
/*
import java.util.*;

class practise {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no.of elements in array: ");
        int n = sc.nextInt();
        int L[] = new int[n];

        System.out.println("Enter array elements: ");
        for (int i = 0; i < n; i++) {
            L[i] = sc.nextInt();
        }

        for (int i = 0; i < L.length - 1; i++) {
            for (int j = i; j < L.length; j++) {
                if (L[i] > L[j]) {
                    int temp = L[i];
                    L[i] = L[j];
                    L[j] = temp;
                }
            }
        }

        for (int i : L) {
            System.out.print(i + " ");
        }

        
        int flag = 0;

        System.out.print("/nEnter key: ");
        int key = sc.nextInt();
        for (int i = 0; i < n; i++) {
            if (L[i] == key) {
                flag = 1;
            }
        }
        if (flag == 0) {
            System.out.println("empty");
            System.exit(0);
        } else {
            int q = 0;
            int t = 0;
            int[] arr1 = new int[100];
            int[] arr2 = new int[100];
            for (int j = 0; j < n; j++) {
                if (L[j] <= key) {
                    arr1[q] = L[j];
                    q++;
                } else {
                    arr2[t] = L[j];
                    t++;
                }
            }
            
            for (int i = 0; i < q; i++) {
                System.out.print(arr1[i] + " ");
            }

            System.out.println();

            for (int i = 0; i < t; i++) {
                System.out.print(arr2[i] + " ");
            }
        }

    }
}
*/
/*
public class practise {
    public static void main(String[] args) {
        // String str = "Hello my name is Libin. is";
        // String arr[] = str.split(" ");

        // for (String stri : arr) {
        //     System.out.println(stri);
        System.out.println(9|10);
        // }
    }
}
*/

// public class practise {
//     static int x = 2;
//     static int z;
//     public static void main(String[] args) {
//         System.out.println(x + z);
//     }

//     static {
//         int x = 3;
//         z = x;
//     }
// }

// import java.util.*;

// public class practise {

//     public static void main(String[] args) {
//         char a = 'a';
//         int b = a - 'a';
//         System.out.println(b+1);

//     }

// }
