/*
Inheritance in Java is a mechanism in which one object acquires all the properties and behaviors of a parent object. 
• It is an important concept in OOPs
• It ensures Method overriding and Code Reusability



Super Classes & Sub Classes:
• Class: A class is a group of objects which have common properties. It is a model from which objects are created.
• Sub Class/Child Class: Subclass is a class which inherits the other class. It is also called a derived class, extended class, or child class.
• Super Class/Parent Class: Superclass is the class from where a subclass inherits the features. It is also called a base class or a parent class.

• Reusability: Reusability is a mechanism which enables you to reuse the fields and methods of the existing class when you create a new class. You can use the same fields and methods already defined in the previous class.

Inheritance is declared using the "extends" keyword.
If inheritance is not defined, the class extends a class called Object
*/

/*
Access modifiers
• private - same class only
• public - everywhere
• protected - same class, same package, any subclass
• (default) - same class, same package
*/

/*
Super keyword:
• super can be used to refer immediate parent class instance variable.
• super can be used to invoke immediate parent class method.
• super can be used to invoke immediate parent class constructor.
*/


// super.(dot) – immediate parent class variable
/*
class Animal {
    String color = "white";
}

class Dog extends Animal {
    String color = "black";

    void printColor() {
        System.out.println(color);// prints color of Dog class ---> black
        System.out.println(super.color);// prints color of Animal class ---> white
    }
}

class Inheritance {
    public static void main(String args[]) {
        Dog d = new Dog();
        d.printColor();
    }
}
*/

// super.(dot) – immediate parent class method
/*
class Animal {
    void eat() {
        System.out.println("eating...");
    }
}

class Dog extends Animal {
    void eat() {
        System.out.println("eating bread...");
    }

    void bark() {
        System.out.println("barking...");
    }

    void work() {
        super.eat();
        bark();
    }
}

class Inheritance {
    public static void main(String args[]) {
        Dog d = new Dog();
        d.work();
    }
}
*/

// super() - immediate parent class constructor
/*
class Animal {
    Animal() {
        System.out.println("Animal is created");
    }
}

class Dog extends Animal {
    Dog() {
        super(); // Constructor call must be first statement in a constructor (optional)
        System.out.println("Dog is created");
    }
}

class Inheritance {
    public static void main(String args[]) {
        Dog d = new Dog();
    }
}
*/





/*
// Constructors in Inheritance
When a Derived class is extended from the Base class, the constructor of the Base class is executed first followed by the constructor of the Derived class



If you want to invoke the base class contructor with arguments, then you have to use the super() keyword in derived class.
*/


// Single level Inheritance:
/*
class Base {
    int x;

    Base() {
        System.out.println("I am a Base class Constructor!");
    }

    Base(int a) {
        System.out.println("I am an overloaded Base class Constructor with value of a as: " + a);
    }
}

class Derived extends Base {
    int y;

    Derived() {
        super(2);
        System.out.println("I am a Derived class Constructor!");
    }
}


public class Inheritance {
    public static void main(String[] args) {
        Derived D1 = new Derived();     // Since we did not pass arguments, it will call the constructor with  no    arguments
        
    }
}
*/