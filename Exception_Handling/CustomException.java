// User-Defined Exceptions / Custom Exceptions
/* 
- User defined exceptions are created by creating a class which is a subclass of Exception class.
- In a method when we use 'throw' keyword to throw an exception, for that method we have to specify 'throws' and exception name
*/

/*
eg. Write a java program that throws a custom exception called "AgeLimitException" with an appropriate error message, if the age entered is below 12 or above 60.
*/
import java.util.*;

class AgeLimitException extends Exception {
    AgeLimitException(String message) { // Constructor with String message to display as exception
        super(message);
    }

    AgeLimitException() {
    } // Whenever there is a parameterised constructor, it is advised to create a default constructor as well
}

class Customer {
    // Method to validate age and throw exception if below the minimum limit
    public void bookTicket(int age) throws AgeLimitException { // In this method we used 'throw', so we have to specify 'throws AgeLimitException' as well in this method heading
        int minAge = 12;
        int maxAge = 60;

        if (age < minAge) {
            throw new AgeLimitException("Minimum age limit for ticket booking is " + minAge + " years."); // We use 'throw' and object of Custom Exception class
        } else if (age > maxAge) {
            throw new AgeLimitException("Maximum age limit for ticket booking is " + maxAge + " years.");
        } else {
            System.out.println("Booking ticket for customer with age " + age + " years.");
        }
    }
}

public class CustomException {
    
    public static void main(String[] args) {
        Customer c = new Customer();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the age of customer: ");
        int age = sc.nextInt();
        try {
            c.bookTicket(age);
            System.out.println("Ticket Booking Successful.");
        } catch (AgeLimitException e) {
            System.err.println(e);
        } catch (Exception e) {
            System.err.println("An error occured: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
