/*
An exception is an event that occurs when a program is executed disrupting the normal flow of instructions.

• An exception is an abnormal code or event that breaks the regular flow of the code in programming terms
• Such exceptions require specific programming constructs for its execution

• Exception handing is a process or method used for handling the anomalous statements in the code and executing them is termed as exception handling
• For example, the Division of a non-zero value with zero will result into infinity always.
• Other examples: ClassNotFoundException, IOException (read in a file that does not exist), SQLException etc.


Types of Errors
• There are three types of errors in the code:
• Syntax Error: A syntax error may appear if there is any mistake in the pre-defined syntax of a programming language.
• Runtime Error: When an error occurs during the execution of the program, such an error is known as Runtime error. The codes which create runtime errors are known as Exceptions.
Thus, exception handlers are used for handling runtime errors.
• Logical Error: Logical mistake in the program that may not produce the desired output, and may terminate unusually.

Runtime Exception -> Unchecked Exception -> Arithmetic, NullPoint, IndexOutOfBound, NumberFormat
Compile Exception -> Checked Exception -> IO, SQL, ClassNotFound

*/



import java.util.Scanner;

public class Errors {
    public static void main(String[] args) {

        // Syntax Errors
        /*
        int a = 8                   --> Semi-colon missing;
        b = 9;                      --> data-type not defined;
        
        IDE can help resolve such syntax errors.
        */

        // Logical Errors
        // Program to print all prime numbers between 1 - 10
        /*
        System.out.println(2);
        for (int i = 1; i < 5; i++) {
            System.out.println(2*i+1);      ---->  The logic to calcultate prime numbers is wrong. This will print 9 also which is not a prime no. This logic prints the odd no. and not prime no.
        }
        */

        // Runtime Errors:
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int k = sc.nextInt();
        System.out.println("The integer when 100 is divided by the given no. is: " + 100 / k);
        int A = 10, B = 5;
        System.out.println(A + B);
        System.out.println("Code successfully executed");

        // This program will give an exception if the user gives input as 0 or any character like a, b, @, ...
        // ArithmeticException: / by zero    ,   InputMismatchException
    }
}


/*
Examples of Run-time exception:
1. int a = 1000/0;    // ArithmeticException

2. String s = null;
   System.out.println(s.length());     // NullPointerException

3. String s = "abc";
   int i=Integer.parseInt(s);      // NumberFormatException

4. int a[] = new int[5];
   a[10]=50;       // ArrayIndexOutOfBoundsException
*/

/*
Exception Handling:
Java provides five keywords that are used to handle the exception. The following table describes each.

Keyword	                                  Description

try	            The "try" keyword is used to specify a block where we should place an exception. 
                It means we can't use try block alone. The try block must be followed by either catch or finally.

catch	        The "catch" block is used to handle the exception. It must be preceded by try block 
                which means we can't use catch block alone. It can be followed by finally block later.

finally	        The "finally" block is used to execute the necessary code of the program. 
                It is executed whether an exception is handled or not.

throw	        The "throw" keyword is used to throw an exception.

throws	        The "throws" keyword is used to declare exceptions. It specifies that there may occur 
                an exception in the method. It doesn't throw an exception. It is always used with method signature.
*/