/*
The Exception class in java has the following important methods:
1. String toString()  --->   executed when sout(e) is ran
2. String getMessage()   --->   prints the Exception message
3. void printStackTrace()   --->   prints Stack Trace

So, now we can inherit this class and override its functions according to our needs.
We can make our own custom Exceptions and throw it

3 Ways to print exception messages :
toString()         -    It prints the name and description of the exception.
getMessage()       -    Mostly used. It prints the description of the exception.
printStackTrace()  -    It print the name of the exception, description and complete stack trace including the 
                        line where exception occurred.
*/

public class Exception_class {
    public static void main(String args[]) {
        try {
            int result = 10 / 0;
            System.out.println(result);
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("toString(): " + e.toString());
            System.out.println("getMessage(): " + e.getMessage());
            System.out.println("StackTrace:");
            e.printStackTrace();
        }
    }
}


/*
class MyException extends Exception {
    @Override
    public String toString() {
        return "I am toString() ";
    }

    @Override
    public String getMessage() {
        return "I am getMessage ";
    }
}


public class Exception_class {
    public static void main(String[] args) {
        int a = 8;
        if (a < 10) {
            try {
                throw new MyException();
                // throw new ArithmeticException("My new exception!");
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println(e.toString());
                e.printStackTrace();
                System.out.println("THe program is finished");
            }
        }
        System.out.println("Thank you for programming");
    }
}
*/