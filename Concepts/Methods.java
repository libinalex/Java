/*
Methods are functions defined to operate on class data members
• method is a way to perform some task
• method in Java is a collection of instructions that performs a specific task.
• It provides the reusability of code.
• We can also easily modify code using methods.
• It divides the complex computational task into a collection of smaller methods, so that problem becomes easier. (modular programming)
• Occupies less memory space and executes faster
• The most important method in Java is the main() method.


Two types of methods
• Pre-defined - already defined in the Java class libraries known as the standard library method or built-in methods. Example: length(), equals(), compareTo(), sqrt(), max(), min()
• User defined - The method written by the user or programmer is known as a user defined method
*/
/*
import java.util.*;

public class Methods {
    public static void findEvenOdd(int num) { // User-defined method
        if (num % 2 == 0)
            System.out.println(num + " is even");
        else
            System.out.println(num + " is odd");
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int num = scan.nextInt();

        findEvenOdd(num); // method calling     // static method, so can be called without creating object

    }
}
*/

/*
Static / Non-static Methods:

Static:
• A method that has static keyword is known as static method.
• In other words, a method that belongs to a class rather than an instance of a class is known as a static method.
• The main advantage of a static method is that we can call it without creating an object.
• The main method and sub methods compatible to communicate each other.
• The best example of a static method is the main() method.

Non static:
• instance method
• method should be invoked by an object of that class


Note: Static Methods can only call other static methods.
*/

// Example of Non-static Method:
/*
class shape {
    void perimeter(int s) {
        System.out.println("Perimeter of square is " + (4 * s));
    }

    void perimeter(int l, int b) {                                          // Method Overloading
        System.out.println("Perimeter of rectangle is " + (2 * (l + b)));
    }

    void perimeter(int a, int b, int c) {
        System.out.println("Perimeter of triangle is " + (a + b + c));
    }
}

public class Methods {
    public static void main(String args[]) {
        shape s1 = new shape();
        s1.perimeter(5);            // non-static method invocation by object
        s1.perimeter(5, 6);
        s1.perimeter(5, 6, 7);
    }
}


// Example of Static Method:
class Shape {
    static void perimeter(int s) {          // static keyword is used before the method name
        System.out.println(" Perimeter of square is " + (4 * s));
    }

    static void perimeter(int l, int b) {       
        System.out.println(" Perimeter of rectangle is " + (2 * l + 2 * b));
    }

    static void perimeter(int a, int b, int c) {
        System.out.println(" Perimeter of triangle is " + (a + b + c));
    }
}

public class Methods {
    public static void main(String args[]) {
        Shape.perimeter(5);                     // static method invocation by class name
        Shape.perimeter(5, 6);
        Shape.perimeter(5, 6, 7);
    }
}
*/

/*

Different ways of defining a function:

1. Paramerized:
Actual Parameter: Parameter before function call
Formal Parameter: Arguments passed to the methods (parameter during function call). 

a) Receiving value and returning outcome to the caller
Return: Returning the value to its caller. Exit point of the method. It can return only a single value.
b) Receiving value but not returning outcome to the caller.

2. Non-Paramerized:
Neither receiving values nor returning outcome to the caller

*/

// Pass by value: Changes done in the formal parameters does not affect actual parameters.
/*
class Methods {
    int data = 50;

    void change(int data) {
        data = data + 100; // changes will be in the local variable only
    }

    public static void main(String args[]) {
        Methods op = new Methods();
        System.out.println("before change " + op.data); // ---> 50
        op.change(500);
        System.out.println("after change " + op.data); // ---> 50
    }
}
*/

// Pass by reference: Changes done in the formal parameters will reflect on the actual parameters. Both share the same memory location .
/*
class Methods {
    void add (int b[]){
        int i, p = b.length;
        
        for(i=0; i<p; i++)
            b[i] = b[i] + 10;
            
        System.out.print("\nArray inside the method after changing data: ");
        for(i=0; i<p; i++)
            System.out.print(b[i] + " ");

    }

    public static void main(String[] arguments) {
        int a[] = { 2, 4, 6, 8, 15 };
        Methods ob = new Methods();
        
        System.out.print("Array before running the method: ");
        for (int j = 0; j < a.length; j++)
            System.out.print(a[j] + " ");

        ob.add(a); // passing non-primitive data uses pass by reference method

        System.out.print("\nArray after running the method: ");
        for (int j = 0; j < a.length; j++)
            System.out.print(a[j] + " ");

    }
}
*/

// Scope of a variable:
