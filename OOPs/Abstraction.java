/*
• Abstract class  (0 - 100 %)
• Interface  (100 %)

Data abstraction is the process of hiding certain details and showing only essential information to the user.Abstraction can be achieved with either abstract classes or interfaces.
*/

// Using abstract keyword:
/* 
The abstract keyword is a non-access modifier, used for classes and methods:
Abstract class: is a restricted class that cannot be used to create objects. (to access it, it must be inherited from another class).
• It can have both abstract/non abstract (concrete) methods
• It can have final method

Abstract method: can only be used in an abstract class (If it is not defined as abstract, then we will get an error), and it does not have a body. The body is provided by the subclass.
• All subclasses (if they are not abstract) of an abstract class must override the abstract method present in the abstract class. If they don’t override, then we will get an error.
*/
/*
abstract class Bank {
    abstract int getRateOfInterest();       // Abstract method does not have a body.
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
}

class Abstraction {
    public static void main(String args[]) {
        // Abstract class cannot be used to create objects
        // Bank b = new Bank();  --->  will generate an error as it cannot be instantiated

        Bank b;            
        b = new SBI();
        System.out.println("Rate of Interest is: " + b.getRateOfInterest() + " %");

        b = new PNB();
        System.out.println("Rate of Interest is: " + b.getRateOfInterest() + " %");
    }
}
*/


// Interfaces
/*
• It is used to achieve abstraction and multiple inheritance in Java.
• We can achieve 100% abstraction (full abstraction) using interfaces.
• Interfaces are similar to abstract classes. While abstract classes can contain both abstract and non-abstract methods, interfaces can contain only abstract methods.

• All methods defined in an interface are public and abstract by default.
• Since all methods inside an interface are by default public and abstract, there is no need to explicitly declare them as public or abstract.
• If we try to define a non-public or non-abstract method inside an interface, we will get an error.
• All variables declared in an interface are public, static and final by default.
• Static variables are stored in the static memory. It's automatically allocated and deallocated when method finishes execution
• Static variables are created when the program starts and destroyed when the program stops.

• An interface can't extend any class but it can extend another interface.
• public interface Shape extends Cloneable{} --> is an example of an interface extending another interface. 
• Actually java provides multiple inheritance in interfaces, what is means is that an interface can extend multiple interface

*/



/*
interface Bicycle {
    void applyBrake(int decrement);
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
        AvonCycle c = new AvonCycle();
        c.speedUp(5);
        System.out.println(c.speed); 
    }
}
*/


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



/*
• Multiple inheritance is supported in interface because interface has only 100% abstract methods and abstract method does not have the implementation. So when class implements more than two interfaces and having same abstract methods then complier only checks whether the method has been overridden or not rather than checking method implementation. So there is no compilation ambiguity. 

• The interface does not have a constructor. So there is no constructor chaining ambiguity that’s why multiple inheritance is supported in the interface

*/