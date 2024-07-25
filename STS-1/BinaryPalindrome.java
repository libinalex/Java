
import java.util.*;
/*
public class BinaryPalindrome{
     
    public static boolean isBinaryPalindrome(int x) {
        int reversed = 0;
        int original = x;
        while (x > 0) {
            reversed <<= 1; // Left shift by 1 bit
            reversed |= (x & 1); // Add the least significant bit of 'x' to'reversed'
            x >>= 1; // Right shift by 1 bit
        }
        return reversed == original;
    } 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int x = sc.nextInt(); 
        if (isBinaryPalindrome(x)) {
            System.out.println(x + " has a binary palindrome representation.");
        } else {
            System.out.println(x + " does not have a binary palindrome representation.");
        }
    }
}
*/
public class BinaryPalindrome {

    public static String intoBinary(int num) {
        String s = "";
        while (num > 0) {
            s = Integer.toString(num % 2) + s;
            num = num / 2;
        }
        return s;
    }

    public static String reverseBinary(int num) {
        String s = "";
        while (num > 0) {
            s = s + Integer.toString(num % 2) ;
            num = num / 2;
        }
        return s;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int x = sc.nextInt();
        String binary = intoBinary(x);
        String revbinary = reverseBinary(x);
        System.out.println("The binary form of " + x + " is " + binary);
        System.out.println("The reverse of binary form of " + x + " is " + revbinary);

        if (binary.equals(revbinary)) {
            System.out.println(x + " has a binary palindrome representation.");
        } else {
            System.out.println(x + " does not have a binary palindrome representation.");
        }
    }
}