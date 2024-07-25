/*
Java's System.out.printf function can be used to print formatted output. The purpose of this exercise is to test 
your understanding of formatting output using printf.

To get you started, a portion of the solution is provided for you in the editor; you must format and print the 
input to complete the solution.

Input Format

Every line of input will contain a String followed by an integer.
Each String will have a maximum of  alphabetic characters, and each integer will be in the inclusive range from  
to .

Output Format

In each line of output there should be two columns:
The first column contains the String and is left justified using exactly  characters.
The second column contains the integer, expressed in exactly  digits; if the original input has less than three 
digits, you must pad your output's leading digits with zeroes.

Sample Input

java 100
cpp 65
python 50
Sample Output

================================
java           100 
cpp            065 
python         050 
================================
Explanation

Each String is left-justified with trailing whitespace through the first  characters. The leading digit of the
integer is the  character, and each integer that was less than  digits now has leading zeroes.
*/

import java.util.Scanner;
public class Format {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        int x = sc.nextInt();
        String b = sc.next();
        int y = sc.nextInt();
        String c = sc.next();
        int z = sc.nextInt();

        System.out.println("================================");
        System.out.printf("%-15s", a);      // %-15s is used to left justify 
        System.out.printf("%03d%n", x);     // %03d is used to 
        System.out.printf("%-15s", b);
        System.out.printf("%03d%n", y);
        System.out.printf("%-15s", c);
        System.out.printf("%03d%n", z);
        System.out.println("================================");

    }
}
