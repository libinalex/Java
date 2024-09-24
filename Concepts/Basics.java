/* 
Primitive data types

Data type    Size      Default value
byte        1 byte      0
short       2 bytes     0
char        2 bytes     ' '
int         4 bytes     0
long        8 bytes     0
float       4 bytes     0.0
double      8 bytes     0.0
boolean     1 bit       false

int -> 4 bytes = 4 x 8 bits = 32 bits = -2^31 to 2^31

Reference data types:
Arrays, Predefined Classes: Sytem, String, Math, Thread, LinkedList, ...
Userdefined Classes: Person, Customer, Student, Employee, Account, ...

Important Points:
- Default values are applicable only to the data members(declared within the class) of the class
  not for local variables (declared within a method)
- Local variables need to be initialized
- Memory allocation for primitive data type is done by declaring the variable: int a; -> 4 byted memory allocated
- Memory allocation for reference data type is done during runtime using new operator
- Default value of reference data type is null

Type casting:
Implicit: converting lower to higher data type
Explicit: converting higher to lower data type
*/
/*
public class Basics {
    int var1; // data member
    String s; // data member

    void printNum() {
        int var2; // local variable :- have to be initialised
        System.out.println(var1); // primitive type: 0 
        System.out.println(s); // reference type: null
        // System.out.println(var2); // error: variable var2 might not have been initialized
    }
    public static void main(String[] args) {
        Basics b = new Basics();
        System.out.println(b.var1); // primitive type: 0
        b.printNum();
        String str; // local variable
        // System.out.println(str); // error: variable str might not have been initialized

        // Type casting
        int n = 125;
        long x = n; // Implicit
        
        char c = 'A';
        int ch = c; // Implicit
        System.out.println(x + " " + ch);

        long y = 185;
        int w = (int) y; // Explicit

        double d = 16.5;
        byte b1 = (byte) d;
        System.out.println(w + " " + b1); // Explicit
    
        // float f = 35.5; // error - In java a value with decimal point is double data type, higher(double) to lower(float) not implicit
        float f1 = (float) 35.5; // Explicit
        float f2 = 38.7f; // Explicit
        System.out.println(f1 + " " + f2);
        

    }
}
*/


/* 
java.lang package 
- imported implicitly to all java programs

Classes under java.lang package:
• Object
    - topmost class in Java Hierarchy
    - Every class in java is a subclass of Object class
    
• String
    - A collection of characters
    - In java, String is immutable

    String str = "hello"; -> "hello" created in Heap memory, and str refers to it {in java, objects get created in heap memory}
    str = "World"; -> a new object "World gets created and now str points to this, "hello" is still present in memory as it is immutable, but is no longer referenced

    - The objects which are no longer referenced are ready for garbage collection and these objects will be destroyed during garbage collection process by the garbage collector.
    - Java has automatic garbage collection.

• StringBuilder 
    - is mutable
    - methods present in StringBuilder are not synchronized 

• StringBuffer
    - is mutable
    - methods present in StringBuffer are synchronized (only 1 thread will be running)

• System
• Math

Wrapper classes
    - For every primitive data type, there is a corresponding reference data type called as wrapper class
    - They are immutable
    - They are final, so we cannot create subclasses for wrapper classes
    - Used to convert reference type into primitive type called as parsing
• Byte
• Short
• Character
• Integer
• Long
• Float
• Double
• Boolean

eg. convert String into int or double:
String s1 = "565";
int n1 = Integer.parseInt(s1); 

String s2 = "53.345";
double n2 = Double.parseDouble(s2);


*/
/* 
String[] args is used to store command line arguments
Eg. in cmd:
> javac Basics.java // Compilation: conversion to byte code(.class file)
> java Basics Hello World
=> Here "Hello" and "World" are command line arguments
args[0] = "Hello" 
args[1] = "World" 

public class Basics {
    public static void main(String[] args) {
        String s1 = args[0];
        String s2 = args[1];
        System.out.println(s1 + " " + s2);
        
    }
}
*/

/* 
toString() Method:

When an object is displayed using sout(), internally toString() method is invoked implicitly
toString() belongs to Object class
toString() of Object class returns the 'class name @ hashcode' of the object
*/
class Product {
    int pid;
    String pname;

    Product(int pid, String pname) {
        this.pid = pid;
        this.pname = pname;
    }

    Product() {
    }

    // public String toString() {
    //     return "Product id: " + pid + "\nProduct Name: " + pname;
    // }
}

public class Basics {
    public static void main(String[] args) {
        Product prod = new Product(101, "Keyboard");
        System.out.println(prod); // Product@3fee733d -> toString() method implicitly

    }
}

/* 
Product class does not have any toString() method explicitly. 
We know that every class in java extends Object class, so the toString() method invoked will be from Object class, which displays Classname along with Hashcode

Thus, in order to represent the object value in String or readable formet, we need to override toString() method in the class.
*/
