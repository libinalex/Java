/*
Data abstraction is the process of hiding certain details and showing only essential information to the user.Abstraction can be achieved with either abstract classes or interfaces.

• Abstract class  (0 - 100 %)
• Interface  (100 %)

*/

// Using abstract keyword:
/* 
Abstract Classes

The abstract keyword is a non-access modifier, used for classes and methods:

Abstract class: 
- A restricted class that cannot be used to create objects. (to access it, it must be inherited from another class).
- We can create references referring to the subclass object;
- It is used to form the rules / specifications
- It can have both abstract/non abstract (concrete) methods
- It contains zero or more abstract methods.
- It can have final method
- Forces 'is-a' relationship

Abstract method: 
- can only be used in an abstract class (If it is not defined as abstract, then we will get an error), and it does not have a body. The body is provided by the subclass.
- A method which is declared is called as abstract method
• All subclasses (if they are not abstract) of an abstract class must override the abstract methods present in the abstract class. If they don’t override, then we will get an error.
*/

/*
abstract class Bank {
    void printBank() {
        System.out.println("Welcome to Banks of India!!"); // defined or implemented or concrete method :- has a body
    }
    abstract int getRateOfInterest();       // declared method; Abstract method does not have a body.
}

class SBI extends Bank {
    int getRateOfInterest() {
        return 7;
    }
}

class PNB extends Bank {
    int getRateOfInterest() {
        return 8;
    }

    void printHello() {
        System.out.println("Hello from Punjab National Bank!!");
    }
}

class Abstraction {
    public static void main(String args[]) {
        // Abstract class cannot be used to create objects
        // Bank b = new Bank();  --->  will generate an error as it cannot be instantiated

        Bank b;  // reference of Abstract class    
        b = new SBI(); //referring to subclass object
        System.out.println("Rate of Interest of SBI is: " + b.getRateOfInterest() + " %");

        Bank p = new PNB();
        System.out.println("Rate of Interest of PNB is: " + p.getRateOfInterest() + " %");
        p.printBank();
        // p.printHello();   -- error: can only invoke overridden methods from Child class as Parent class reference used
        PNB p1 = new PNB();
        p1.printHello();

    }
}
*/

// Interfaces
/*
• It is used to achieve abstraction and multiple inheritance in Java.
• We can achieve 100% abstraction (full abstraction) using interfaces.
• Interfaces are similar to abstract classes. While abstract classes can contain both abstract and non-abstract methods, interfaces can contain only abstract methods.
- Does not force 'is-a' relationship

• All data members/variables declared in an interface are public, static and final by default.
• Static variables are stored in the static memory. It's automatically allocated and deallocated when method finishes execution
• Static variables are created when the program starts and destroyed when the program stops.

• All methods defined in an interface are public and abstract by default.
• Since all methods inside an interface are by default public and abstract, there is no need to explicitly declare them as public or abstract.
• If we try to define a non-public or non-abstract method inside an interface, we will get an error.


• An interface can't extend any class but it can extend another interface.
• public interface Shape extends Cloneable{} --> is an example of an interface extending another interface. 
• Actually java provides multiple inheritance in interfaces, what is means is that an interface can extend multiple interfaces

- If a class 'implements' an interface, then we need to override all abstract methods else make the class as abstract.
- We cannot create objects for interfaces but we can create references referring to the subclass object
*/

/*
interface Bicycle {
    boolean isWorking = true; // public static final member

    void applyBrake(int decrement); // public and abstract method
    void speedUp(int increment);
}

class AvonCycle implements Bicycle {
    int speed = 10;

    public void applyBrake(int decrement) {
        speed -= decrement;
    }

    public void speedUp(int increment) {
        speed += increment;
    }

}

public class Abstraction {
    public static void main(String[] args) {
        Bicycle b = new AvonCycle();
        b.speedUp(7);
        // System.out.println(b.speed); // cannot access data member as Parent class reference used

        AvonCycle c = new AvonCycle();
        c.speedUp(5);
        System.out.println(c.speed); 
    }
}
    
class to class => extends
class to interface => implements
interface to interface => extends
interface to class => error: not allowed


Note: While overriding public methods, the overriden method should be public.
So, since all methods in interface is by default public, so while implementing(overriding) interface methods, it should be public.
*/

/*
// Multiple Inheritance using Interface

interface Motorbike {
    int speed = 50;
    void totalDistance();
}

interface Cycle {
    int distance = 150;
    void speed();
}

class TwoWheeler implements Motorbike, Cycle {
    int totalDistance;
    int avgSpeed;

    public void totalDistance() {
        totalDistance = speed * distance;
        System.out.println("Total Distance Travelled: " + totalDistance);
    }

    public void speed() {
        int avgSpeed = totalDistance / speed;
        System.out.println("Total Speed maintained: " + avgSpeed);
    }
}

public class Abstraction {
    public static void main(String[] args) {
        TwoWheeler t1 = new TwoWheeler();
        t1.totalDistance();
        t1.speed();
    }
}
*/

/*
• Multiple inheritance is supported in interface because interface has only 100% abstract methods and abstract method does not have the implementation. So when class implements more than two interfaces and having same abstract methods then complier only checks whether the method has been overridden or not rather than checking method implementation. So there is no compilation ambiguity. 

• The interface does not have a constructor. So there is no constructor chaining ambiguity that’s why multiple inheritance is supported in the interface

*/

/* 
- From Java 8 version, we can define methods in interfaces using default keyword.
- From Java 8 version, we can define static methods in interfaces.
- From Java 9 version, we can define private methods in interfaces.

- abstract and final are illegal combination of modifiers

*/

interface Shape{
    void draw();

    private void print() { // private method
        System.out.println("Printing");
    }

    default void fill() { // default method
        print(); // private method accessible only within this interface
        System.out.println("Filling");
    }

    static void map() { // static method
        System.out.println("Mapping");
    }
}

class Circle implements Shape {
    public void draw() {
        System.out.println("Drawing a Circle");
    }
}


public class Abstraction {
    public static void main(String[] args) {
        Shape s = new Circle();
        s.draw();
        s.fill();
        Shape.map(); // accessing static method directly from interface name
    }
    
}