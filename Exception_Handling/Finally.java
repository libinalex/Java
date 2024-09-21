
/*
finally statement:
• An optional block of statements which is executed after the execution of try and catch statements.
• Finally block does not hold for the exception to be thrown.
• Any exception is thrown or not, finally block code, if present, will definitely execute. It does not care for the output too.
• Therefore, we can also use try/throw/catch/finally keyword together for handling complex code.
• We generally do closing or cleanup operations in the finally block.


class Finally {
    public static void main(String args[]) {
        try {
            // below code do not throw any exception
            int data = 25 / 5;
            System.out.println(data);
        }
        // catch won't be executed
        catch (NullPointerException e) {
            System.out.println(e);
        }
        // executed regardless of exception occurred or not
        finally {
            System.out.println("finally block is always executed");
        }
        System.out.println("rest of the code...");
    }
}
*/

/*

public class Finally {
    public static int greet() {
        System.out.println("Hello");
        try {
            int a = 50;
            int b = 2;
            int c = a / b;
            return c; // ----> It is supposed to return here only but since there is a finally block//
                      // later, so it will be executer before returning from the function.
        } catch (Exception e) {
            System.out.println(e);
        } finally { // This finally block will execute no matter what!
            System.out.println("This is the end of the function! ");
        }

        return -1;
    }

    public static void main(String[] args) {
        int k = greet();
        System.out.println(k);
    }
}
*/

/* 
Difference bw final, finally, finalize:
• final keyword
    - variable: value of the variable cannot be modified
    - method: the method cannot be overriden
    - class: the class cannot be inherited

• finally keyword
    - used in exception handling
    - finally block is executed irrespective of exception present in try block.
    - mainly used to do cleanup or closing operations.

• finalize() method
    - It is also used to do the cleanup or closing operations.
    - It is invoked implicitly just prior to the garbage collection.

*/