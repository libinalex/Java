/*
Array
• Set of same data type variables named as an identifier
• Each variable of the array is called element
• Homogenous elements
• Elements of memory represented by Index
• Fixed in size.
• Index starts from 0
• Elements are retrieved using array index
• Exception: out-of-index element access → Run time Error
• Single or multidimensional array size


Syntax Eg: 
int arr[] = new int[10];
char arr[] = new char[10];
String arr[] = new String[10];
*/
import java.util.*;

public class Basics {
    public static void main(String args[]) {
        // declaration and instantiation
        int a[] = new int[6];

        // initialization
        a[0] = 2;
        a[1] = 3;
        a[2] = 5;
        a[3] = 8;
        a[4] = 9;
        a[5] = 11;
        // or a[]={2,3,5,8,9,11};

        // Traversing array:
        
        // 1. Using for loop:
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

        System.out.println();

        // 2. Using Enhanced for loop:
        for (int i : a) {
            System.out.print(i + " ");
        }

        System.out.println();

        // printing the elements without traversing:
        System.out.println(Arrays.toString(a));
    }
}
