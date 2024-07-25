/*
If you use the nextLine() method immediately following the nextInt() method, 
recall that nextInt() reads integer tokens; because of this, 
the last newline character for that line of integer input is still queued in the input buffer and 
the next nextLine() will be reading the remainder of the integer line (which is empty).

*/

/* 
import java.util.*;

public class Remember {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        double b = sc.nextDouble();
        String c = sc.nextLine();

        System.out.println("String: " + c); // This will not give the desired output 
        System.out.println("Double: " + b);
        System.out.println("Int: " + a);

        Scanner sc1 = new Scanner(System.in);
        int a1 = sc1.nextInt();
        double b1 = sc1.nextDouble();
        sc1.nextLine(); // Use this to consume the rest of that line including newline
        String c1 = sc1.nextLine();

        System.out.println("String: " + c1);
        System.out.println("Double: " + b1);
        System.out.println("Int: " + a1);
    }
}

*/

// Java's System.out.printf() function can be used to print formatted output.


/* 
To supress the last space from the output of an array

for (int i = 0; i < arr.length; i++) {
        System.out.print(arr[i] +  (arr.length-1 ? " ": "" ));
    }
*/

// int len = (int) (Math.log10(num) + 1);   // no. of digits in a decimal number
// int len = (int) (Math.log2(num) + 1);   // no. of digits in a binary number
