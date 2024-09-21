/*
Throwable class is the topmost class in Exception Hierarchy
Methods present in Throwable class:

1. String toString()  --->   returns object value in String format. Invoked when sout(e) is executed
2. String getMessage()   --->   returns the message of the exception
3. void printStackTrace()   --->   displays the root cause of the exception
*/


/*
public class Throwable_class {
    public static void main(String args[]) {
        System.out.println("Start of Program\n");
        try {
            int result = 10 / 0;
            System.out.println(result);
        } catch (Exception e) {
            System.out.println(e); // invokes toString() method implicitly
            System.err.println("toString(): " + e.toString());
            System.out.println("getMessage(): " + e.getMessage());
            System.out.print("printStackTrace(): ");
            e.printStackTrace();
        }
        System.out.println("\nEnd of Program");
    }
}
*/

/*
Exception class extends Throwable class.
So, now we can inherit the Exception class and override these functions according to our needs.
We can make our own custom Exceptions and throw it

3 Ways to print exception messages :
toString()         -    It prints the name and description of the exception.
getMessage()       -    Mostly used. It prints the description of the exception.
printStackTrace()  -    It print the name of the exception, description and complete stack trace including the line where exception occurred.
*/

/*
class MyException extends Exception {
    @Override
    public String toString() {
        // return super.toString();
        return "I am toString() method";
    }

    @Override
    public String getMessage() {
        return "I am getMessage() method";
    }
}


public class Throwable_class {
    public static void main(String[] args) {
        int a = 8;
        if (a < 10) {
            try {
                throw new MyException();
                // throw new ArithmeticException("My new exception!");
            } catch (Exception e) {
                System.out.println(e); // invokes toString() method implicitly
                System.err.println("toString(): " + e.toString());
                System.out.println("getMessage(): " + e.getMessage());
                System.out.print("printStackTrace(): ");
                e.printStackTrace();
                System.out.println("The exception is caught");
            }
        }
        System.out.println("Thank you for programming");
    }
}
*/