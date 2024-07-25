/*
public class Basics {
    
}
*/


// static keyword:
/*
class Student {
    String name;
    static String school;
}

public class Basics {
    public static void main(String[] args) {
        Student.school = "St. Teresa's School"; //  directly by class name
        Student s1 = new Student();
        System.out.println(Student.school);
    }
}
*/

// this keyword
/*
‘this’ is a keyword used as a reference to the object of the current class, method or a constructor.
Common usage of this are as follows:
• this can be used to refer current class instance variable
• this can be passed as argument in the constructor call
• this can be used to return the current class instance from the method
• this can be used to invoke current class method
• this can be used to invoke current class constructor
• this can be passed as an argument in the method call
Note: Name collision over instance and local variable in a method can be resolved by 'this'
*/
// Name collision of instant variable over local variable
/*
class Student {
    String regno;
    String name;
    float fee;

    Student(String regno, String name, float fee) {
        regno = regno;
        name = name;
        fee = fee;
    }

    void display() {
        System.out.println(regno + " " + name + " " + fee);
    }
}

class Basics {
    public static void main(String args[]) {
        Student s1 = new Student("19BCE1034", "RAJU", 50000f);
        Student s2 = new Student("20BLC1053", "ASHA", 70000f);
        s1.display(); //  null null 0.0
        s2.display(); //  null null 0.0
    }
}
*/
// this - resolving instant variable over local variable
/*
class Student {
    String regno;
    String name;
    float fee;

    Student(String regno, String name, float fee) {    // If we used r, n, f as parameters then no need of 'this'
        this.regno = regno;
        this.name = name;
        this.fee = fee;
    }

    void display() {
        System.out.println(regno + " " + name + " " + fee);
    }
}

class Basics {
    public static void main(String args[]) {
        Student s1 = new Student("19BCE1034", "RAJU", 50000f);
        Student s2 = new Student("20BLC1053", "ASHA", 70000f);
        s1.display(); //  19BCE1034 RAJU 50000.0
        s2.display(); //  20BLC1053 ASHA 70000.0
    }
}
*/

// this – to invoke current class method
// If you don't use the this keyword, compiler automatically adds this keyword while invoking the method.
/*
class Student {
    String regno;
    String name;
    float fee;

    Student(String regno, String name, float fee) {
        this.regno = regno;
        this.name = name;
        this.fee = fee;
    }

    void greet() {
        System.out.println("Welcome to VIT Chennai");
    }

    void display() {
        this.greet();   // optional  --> Even if you'd used only greet(), still same result
        System.out.println(regno + " " + name + " " + fee + "\n");
    }
}

public class Basics {
    public static void main(String args[]) {
        Student s1 = new Student("19BCE1034", "RAJU", 50000f);
        Student s2 = new Student("20BLC1053", "ASHA", 70000f);
        s1.display();
        s2.display();
    }
}
*/

// Chaining of Constructors:  Calling one constructor from another constructor
/*
class Student {
    String rollno, name, programme;
    float fee;

    Student(String rollno, String name, String programme) {
        this.rollno = rollno;
        this.name = name;
        this.programme = programme;
    }

    Student(String rollno, String name, String programme, float fee) {
        this(rollno, name, programme); // invoking constructor using this (Student with 3 parameters)
        this.fee = fee;
    }

    void display() {
        System.out.println(rollno + " " + name + " " + programme + " " + fee );
    }
}

public class Basics {
    public static void main(String args[]) {
        Student s1 = new Student("19BCE1101", "Anbu", "Computer Science");
        Student s2 = new Student("20BLC1102", "Suman", "Mechanical", 60000f);
        s1.display();
        s2.display();
    }
}
*/
/*
// this keyword can be used to return current class instance
class Basics {
    void m() {
        System.out.println(this);   // prints same reference ID
    }

    public static void main(String args[]) {
        // Reference obj=new Reference()
        Basics obj = new Basics();
        System.out.println(obj);    // prints the reference ID
        obj.m();
    }
}

*/

// Destructor: A destructor is a special method that gets called automatically as soon as the life-cycle of an object is  finished. A destructor is called to de-allocate and free memory.

/*
Garbage collection:
• The programmer need not to care for all those objects which are no 
longer in use. Garbage collector destroys these objects.
• Garbage collector is best example of Daemon thread as it is always 
running in background.
• Main objective of Garbage Collector is to free heap memory by 
destroying unreachable objects (no reference of the object).
*/

/*
Finalize:
• Just before destroying an object, Garbage Collector calls finalize() method on the object to perform cleanup activities.
• Once finalize() method completes, Garbage Collector destroys that object.
• finalize() method is present in object class with following prototype. public void finalize(){}
• The finalize() method called by Garbage Collector not JVM.
• Depends on our requirement, we can override finalize() method for perform our cleanup activities like closing connection from database.
*/

// gc() method: The gc() method is used to invoke the garbage collector to perform cleanup processing. The gc() is found in System and Runtime classes.
/*
public class Basics {
    public void finalize() {
        System.out.println("object is garbage collected");
    }

    public static void main(String args[]) {
        Basics s1 = new Basics();
        Basics s2 = new Basics();
        s1 = null;
        s2 = null;
        System.gc();
    }
}
*/

/*
Access modifiers
• private - same class only
• public - everywhere
• protected - same class, same package, any subclass
• (default) - same class, same package
*/

/*
Final keyword
Variables: to create Constants
Classes: To prevent Inheritance
Methods: To prevent Method overriding 

*/

