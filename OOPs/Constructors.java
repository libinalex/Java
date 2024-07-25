/*
A member function used to initialise an object while creating it.

Type of Constructor:
• Default Constructor
• Non-Parameterized Constructor
• Parameterized Constructor
• Copy Constructor
*/

class Employee {
    int id;
    String name;

    Employee() {
        id = 101;
        name = "Animesh";
    }

    Employee(int id, String name) {         // Constructor Overloading
        this.id = id;
        this.name = name;
    }

    Employee(Employee e) {      // Copy Constructor
        this.id = e.id;
        this.name = e.name;
    }

    public void printInfo() {
        System.out.println("\nEmployee ID: " + this.id);
        System.out.println("Employee Name: " + this.name);
    }
}



public class Constructors {
    public static void main(String[] args) {
        Employee E1 = new Employee();
        Employee E2 = new Employee(102, "Ravi");
        Employee E3 = new Employee(E2);         // Copy Constructor
        Employee E4 = E2;                       // Copy Constructor
        
        E1.printInfo();
        E2.printInfo();
        E3.printInfo();
        E4.printInfo();
    }
}
// In java there is no need to write a destructor as there is garbage collector which automatically performs the same role.