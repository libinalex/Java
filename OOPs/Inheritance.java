/*
Inheritance in Java is a mechanism in which one object acquires all the properties and behaviors of a parent object. 
• It is an important concept in OOPs
• It ensures Method overriding and Code Reusability

- The process of creating a new class from an existing class is called as inheritance.
- Hierarchy of classes is called inheritance.
- In java, 'extends' keyword is used to create a new class from an existing class.
- Through inheritance, we can achieve reusability of code.
- Java doies not support multiple inheritance due to ambiguity, so in java a class can extend only one class.

OOP has two types of relationships:
'is-a' relationship and 'has-a' relationship

- Inheritance is 'is-a' relationship
eg.
Furniture(Table, Chair)
Fruit(Apple, Mango)
Vehicle(Car, Bike, Bus)
Account(SavingsAccount, CurrentAccount)

class Vehicle{}
class Car extends Vehicle{} // Car is a Vehicle


- 'has-a' relationship:
University(Department)
Department(Employee)
Classroom(Student)
Library(Books)

class Department{ // Department has an Employee
    Employee emp;
}

*/
/*
class Base {
    int i;
    int j;

    void setIJ(int i, int j) {
        this.i = i;
        this.j = j;
    }

    void getIJ() {
        System.out.println("i = " + i + ", j = " + j);
    }
}

class Derived extends Base {
    int k;

    void setK(int k) {
        this.k = k;
    }

    void getK() {
        System.out.println("k = " + k);
    }

}

public class Inheritance {

    public static void main(String[] args) {
        Base b = new Base();
        b.setIJ(10, 20);
        b.getIJ(); // i = 10, j = 20

        Derived d = new Derived();
        d.getIJ(); // i = 0, j = 0  : Since they are not set for this object, so will take default values of int
        d.setIJ(40, 50);
        d.setK(60);
        d.getIJ(); // i = 40, j = 50
        d.getK(); // k = 60
    }
}
*/

/*
Super Classes & Sub Classes:
• Class: A class is a group of objects which have common properties. It is a model from which objects are created.
• Super Class / Parent Class / Base class: Superclass is the class from where a subclass inherits the features. 
• Sub class / Child class / Derived class: Subclass is a class which inherits the other class. 

• Reusability: Reusability is a mechanism which enables you to reuse the fields and methods of the existing class when you create a new class. You can use the same fields and methods already defined in the previous class.


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
When a Derived class is extended from the Base class, the constructor of the Base class is executed first followed by the constructor of the Derived class.

If you want to invoke the base class contructor with arguments, then you have to use the super() keyword in derived class.

- super() is the first statement added to every constructor implicitly which invokes the Base class default constructor.
- to call the parameterized constructor from derived class constructor, call is explicitly.
- call to super() must be the first statement in constructors

*/
/* 
// Single level Inheritance:
class Base {
    int i;
    int j;

    Base(int i, int j) {
        this.i = i;
        this.j = j;
    }

    void display() {
        System.out.println("i = " + i + ", j = " + j);
    }
}

class Derived extends Base {
    int k;

    Derived() { // error: As
        // super(); -> added implicitly - invokes Base class Default Constructor. 
        // Since in above base class no default constructor is present, only parameterised constructor is present, so it results in an error.
        this.k = k;
    }
    void display() {
        super.display();
        System.out.println("k = " + k);
    }
}

public class Inheritance {
    public static void main(String[] args) {
        Derived d = new Derived();
        d.display();
    }
    
}
*/

class Base {
    int i;
    int j;

    Base(){} // if creating a parameterized constructor, it is our responsibility to create a default constructor as well.
    Base(int i, int j) {
        this.i = i;
        this.j = j;
    }

    void display() {
        System.out.println("i = " + i + ", j = " + j);
    }
}

class Derived extends Base {
    int k;

    Derived(int i, int j, int k) { 
        super(i, j);
        this.k = k;
    }

    void display() {
        super.display();
        System.out.println("k = " + k);
    }
}

public class Inheritance {
    public static void main(String[] args) {
        Derived d = new Derived(10, 20, 30);
        d.display();
    }

}

/*
class Base {
    int x;

    Base() {
        System.out.println("I am a Base class Default Constructor!");
    }

    Base(int a) {
        System.out.println("I am an overloaded Base class parameterized Constructor with value of a as: " + a);
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
        Derived d = new Derived();     // Since we did not pass arguments, it will call the constructor with  no    arguments
        
    }
}
*/