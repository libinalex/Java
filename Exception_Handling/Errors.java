/*
An exception is an event that occurs when a program is executed disrupting the normal flow of instructions.

• An exception is an abnormal code or event that breaks the regular flow of the code in programming terms
• Such exceptions require specific programming constructs for its execution

• Exception handing is a process or method used for handling the anomalous statements in the code and executing them is termed as exception handling
• For example, the Division of a non-zero value with zero will result into infinity always.
• Other examples: ClassNotFoundException, IOException (read in a file that does not exist), SQLException etc.


Types of Errors
There are three types of errors in the code:
• Syntax Error /  Compile time error: 
    - A syntax error may appear if there is any mistake in the pre-defined syntax of a programming language.

• Runtime Error / Exception: 
    - When an error occurs during the execution of the program, such an error is known as Runtime error. 
    - The codes which create runtime errors are known as Exceptions.
    - Thus, exception handlers are used for handling runtime errors.
    - An exception is a runtime error which occurs during program execution and terminates the program abnormally.

• Logical / Semantic Error : 
    - Logical mistake in the program that may not produce the desired output, and may terminate unusually.


Exception Hierarchy:
Serializable(interface) 
Object -> Throwable -> Exception, Error:

Categories of Exceptions:
- Unchecked Exceptions / Runtime Exception
    - All RuntimeExceptions are unchecked exceptions
        - ArithematicException
        - NumberFormatException
        - NullPointerException
        - ArrayIndexOutOfBoundsException, et.
    - has to be taken care by developers.

- Checked Exceptions / Compile time Exception
    - Other than Runtime Exceptions, are all Checked Exceptions.
        - IOException
        - SQLException
        - ClassNotFoundException
        - BrokenBarrierException, 
        - User Defined Exceptions, etc.
    - Taken care by compiler, just follow syntax rule.
    
Categories of Error:
- ThreadDeath; VirtualMachineError: OutOfMemoryError, StackOverflowError; IOError

*/

/*
import java.util.Scanner;

public class Errors {
    public static void main(String[] args) {

        // Syntax Errors
        
        int a = 8                   --> Semi-colon missing;
        b = 9;                      --> data-type not defined;
        
        IDE can help resolve such syntax errors.
        

        // Logical Errors
        // Program to print all prime numbers between 1 - 10
        
        System.out.println(2);
        for (int i = 1; i < 5; i++) {
            System.out.println(2*i+1);      ---->  The logic to calcultate prime numbers is wrong. This will print 9 also which is not a prime no. This logic prints the odd no. and not prime no.
        }
        

        // Runtime Errors / Exceptions:
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
*/

/*
Examples of Run-time exception:
1. ArithmeticException
    int a = 1000/0;    

2. NullPointerException
    String s = null;
    System.out.println(s.length());      

3. NumberFormatException
    String s = "abc";
    int i = Integer.parseInt(s);     

4. ArrayIndexOutOfBoundsException
    int a[] = new int[5];
    a[10]=50;  
    
5. StringIndexOutOfBoundsException
    String str = "Hello";
    System.out.println(str.charAt(8));

6. NegativeArraySizeException
    int[] arr = new int[-5];

*/

/*
Exception Handling:
- Exception handling is used to avoid the abnormal termination of application/program and makes the program Robust.

- Java provides five keywords that are used to handle the exception. The following table describes each.

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

/* 
Exception Propagation
If the exception is unable to handle in a method then it is propagated to the method where it has been invoked
eg.
main(){
    void xxx(){...}
    try{
        xxx();
    } catch(Exception e) {}
    
    void yyy(){
        xxx();
    }
}
*/

/* 
Exceptions in Inheritance
- The overriden method should not throw the exception which is super class of the base class method exception.
- If the Base class method is not throwing any exception then the overriden method should also not throw any exception
*/

/*
import java.io.IOException;

class Base {
    void method1() throws IOException {
    }
}

class Derived extends Base {
    // @Override
    // void method1() throws IOException {} // valid
    // void method1() throws ArithmeticException {} // valid
    // void method1() {} // valid
    // void method1() throws Exception {} // error: Exception is super class of IOException

}
*/