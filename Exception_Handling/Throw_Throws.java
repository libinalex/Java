/* 
Handeling Checked Exceptions:
- Other than Runtime Exception, other exceptions like IOException, SQLException, user defined exceptinos, etc. are Checked exceptions
- If a method throws an exception then this method needs to be caught (try-catch)
  or declared to be thrown (throws)


import java.io.IOException;

public class Throw_Throws {
    public static void main(String[] args) throws IOException {
        // int n = System.in.read(); // error: unreported exception IOException; must be caught or declared to be thrown
        
        // #1: 
        try {
            int n = System.in.read();
            System.out.println(n);
        } catch (IOException e) {
                
        }

        int n = System.in.read();
        System.out.println(n);
        System.out.println("End of Program");
    }
}
 
If a method definition has throws Exception
Here, the read method in API, library has throws IOException {Ctrl+click on read()}
#1: Surround with try-catch
#2: Add throws declaration

*/

/*
throw syntax
try{
    throw exception; // user can define their own exception
}
catch(error) {
    expression;     // code for handling exception.
} 

• The exception can be a string, number, object, or boolean value
• With the help of throw statement, users can create their own errors
*/

/*
public class Throw_Throws {
    public static void checkAge(int age) {
        if (age < 18) {
            try {
                throw new ArithmeticException("Not eligible for voting!");
            } catch (Exception e) {
                System.out.println(e);
            }
            
        } else {
            System.out.println("Eligible for voting :)");
        }
    }
    
    public static void main(String[] args) {
        checkAge(4);
        System.out.println("End of Program");
    }
}
*/
/*
import java.util.*;

public class Throw_Throws {
    static void check_length(int size) {
        if (size > 10) {
            try {
                throw new IndexOutOfBoundsException("Size must not be greater than 10!");
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        else
            System.out.println("The size of the PAN no. is appropriate :)");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the PAN number: ");
        String pan = sc.next();
        check_length(pan.length());
        System.out.println("Rest of the program...");
    }
}
*/

// throws keyword:
/*
Used to declare an exception.
- indicate what exception type may be thrown by a method
- used with a method signature 
*/

/*
public class Throw_Throws {
    int division(int a, int b) throws ArithmeticException {
        int t = a / b;
        return t;
    }

    public static void main(String args[]) {
        Throw_Throws obj = new Throw_Throws();
        try {
            System.out.println(obj.division(15, 0));
        } catch (ArithmeticException e) {
            System.out.println("You shouldn't divide number by zero");
        }
    }
}
*/
/*
public class Throw_Throws {
    static void checkAge(int age) throws ArithmeticException {
        if (age < 18) {
            try {
                throw new ArithmeticException("Access denied - You must be at least 18 years old.");
            } catch (Exception e) {
                System.out.println(e);
            }
        } 
        else 
            System.out.println("Access granted - You are old enough!");
    }

    public static void main(String[] args) {
        checkAge(19); // Set age to 15 (which is below 18...)
        System.out.println("Rest of the program...");
    }
}
*/

/*
import java.io.*;

class Example {
    void myMethod(int num) throws IOException, ClassNotFoundException {
        if (num == 1)
            throw new IOException("IOException Occurred");
        else
            throw new ClassNotFoundException("ClassNotFoundException");
    }
}

public class Throw_Throws {
    public static void main(String args[]) {
        try {
            Example obj = new Example();
            obj.myMethod(1);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
*/


