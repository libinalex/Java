/*
Polymorphism is the ability of an object to take on many forms.
• The most common use of polymorphism in OOP occurs when a parent class reference is used to refer to a child class object.
• Inheritance lets us inherit attributes and methods from another class. Polymorphism uses those methods to perform different tasks.
This allows us to perform a single action in different ways.

Types:
- Compile time: Method overloading
- Run time: Method overriding
*/

/* Compile-time Polymorphism (static or early binding):- Method Overloading: 
- Method name is same but the signature is different
signature = number of argument / type of arguments
- Applicable within the same class as well as subclass.
*/
/*
class Object {
    public static double Volume(int side) {
        System.out.println("The object is a Cube");
        return (side * side * side);
    }
        
    public static double Volume(double side) {
        System.out.println("The object is a Cube");
        return (side * side * side);
    }

    public static double Volume(int radius, int height) {
        System.out.println("The object is a Cylinder");
        return (Math.PI * radius * radius * height);
    }

    public static double Volume(int length, int breadth, int height) {
        System.out.println("The object is a Cuboid");
        return (length * breadth * height);
    }
}

public class Polymorphism {
    
    public static void main(String[] args) {
        Object obj1 = new Object();
        int a = 4;
        int b = 6;
        int c = 8;

        // Square - 1 dimension: side
        // Cylinder - 2 dimension: radius, height
        // Cuboid - 3 dimensions: length, breadth, height
        System.out.printf("The volume of the given object is: %.2f", obj1.Volume(a, b, c));
    }
}
*/
/*
// Method Overriding:
- Method name is same and signature is also same.
- Applicable only within subclasses.

If the Child class implements the same method present in the parent class again, it is known as overriding.
i.e., redefining method of super class in sub class.

Subclasses inherit all methods from their superclass. Sometimes, the implementation of the method in the superclass does not provide the functionality required by the subclass. In these cases, the method must be overridden.
Rules:
1.The method must have the same name as in the parent class
2.The method must have the same parameter as in the parent class.
*/
/*
class A {
    int a;

    int meth1() {
        return 4;
    }

    void meth2() {
        System.out.println("I am method 2 of Parent class A!");
    }
}

class B extends A {
    @Override               // This is optional, just to mention that following method is overriding 
    void meth2() {
        System.out.println("I am overriden method 2 of Child class B!");       // ---> meth2 has been overrided
    }

    void meth3() {
        System.out.println("I am method 3 of Child class B!");
    }
}

public class Polymorphism {
    public static void main(String[] args) {
        A a = new A();
        a.meth2(); // I am method 2 of Parent class A!

        B b = new B();
        b.meth2();  // I am overriden method 2 of Child class B!
        b.meth3(); // I am method 3 of Child class B!
    }
}
*/
/*
// Base class: Shape
class Shape {
    void draw() {
        System.out.println("Parent class: Drawing Shapes");
    }
}

// Derived class: Circle
class Circle extends Shape {
    void draw() {
        System.out.println("Subclass: Drawing Circle");
    }
}

// Derived class: Square
class Square extends Shape {
    void draw() {
        System.out.println("Subclass: Drawing Square");
    }
}

// Derived class: Hexagon
class Hexagon extends Shape {
    void draw() {
        System.out.println("Subclass: Drawing Hexagon");
    }
}

// Driver class
public class Polymorphism {
    public static void main(String args[]) {
        Shape obj = new Shape();
        obj.draw(); // Parent class: Drawing Shapes

        Shape obj1 = new Circle();
        obj1.draw(); // Subclass: Drawing Circle

        Shape obj2 = new Square();
        obj2.draw(); // Subclass: Drawing Square

        Hexagon obj3 = new Hexagon();
        obj3.draw(); // Subclass: Drawing Hexagon
    }
}
*/



// Referencing Subclass objects with Subclass vs Superclass reference

/*
//Referencing Subclass objects with Superclass
class PData {
    int data1;
    int data2;
}

class CData extends PData {
    int data3;
    int data4;
}

public class Polymorphism {
    public static void main(String[] args) {
        PData obj = new CData();    // PData obj = new PData();
        obj.data1 = 50;
        obj.data4 = 100;                                        // error
        System.out.println("obj.data1 = " + obj.data1);
        System.out.println("obj.data4 = " + obj.data4);
    }
}
// We can use superclass reference to hold any subclass object derived from it.
*/
/*
// Referencing Superclass objects with Subclass
class PData {
    int data1;
    int data2;
}

class CData extends PData {
    int data3;
    int data4;
}

public class Polymorphism {
    public static void main(String[] args) {
        CData obj = new CData();
        obj.data1 = 50;
        obj.data4 = 100;
        System.out.println("obj.data1 = " + obj.data1);
        System.out.println("obj.data4 = " + obj.data4);
    }
}
*/

/*
// Dynamic Method Dispatch:
If a Base class reference refers to the subclass object then it invokes only the overriden methods of subclass

*/
class Phone {
    int a;

    int getNumber() {
        return 914199002;
    }

    void makeCall() {
        System.out.println("Making call from Phone!");
    }
}

class SmartPhone extends Phone {

    @Override 
    void makeCall() {
        System.out.println("Making call from SmartPhone!"); // ---> makeCall has been overrided
    }

    void connectWiFi() {
        System.out.println("Connecting to Wi-Fi in SmartPhone!");
    }
}

public class Polymorphism {
    public static void main(String[] args) {
        Phone a = new SmartPhone(); // Allowed --> Object of Child class and reference of Parent class.
        // Base class(Phone) reference refers to the subclass(SmartPhone) object

        a.makeCall(); // -----> makeCall of class SmartPhone will run, as it is an overriden method
        // a.connectWiFi(); // error --- Not Allowed as it is not an overriden method

        // SmartPhone b = new Phone(); // error -- Not Allowed
        // Only Parent class can refer to Child class, and Child class cannot refer to Parent class

    }
}
