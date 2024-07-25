
class Employee {
    int id;
    String name;
    int salary;

    Employee() {            // Initialization through constructor
        id = 000;
        name = "No Body";
    }

    public void setDetails(int i, String n) {
        id = i;
        name = n;
    }

    public void printDetails() {
        System.out.println("\nEmployee ID = " + this.id);
        System.out.println("Employee Name = " + this.name);
    }
}

public class ClassesObjects {
    public static void main(String[] args) {
        Employee E1 = new Employee();   // Instantiating a new Employee object
        Employee E2 = new Employee();   
        Employee E3 = new Employee();   
        Employee E4 = new Employee();   

        // Setting Attributes:
        E1.id = 101;                
        E1.name = "Animesh";            // Initialization through reference

        E2.id = 102;
        E2.name = "Ravi";

        E3.setDetails(103, "Darryl");   // Initialization through method

        // Using a method to print the attributes:
        E1.printDetails();
        E2.printDetails();
        E3.printDetails();
        E4.printDetails();
        
    }
}
