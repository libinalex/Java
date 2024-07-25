/*
Write a java program that throws a custom exception called "AgeLimitException" with an appropriate error message, if the age entered is below 12.
*/
import java.util.*;

class AgeLimitException extends Exception {
    public AgeLimitException(String message) {
        super(message);
    }
}

// Main program
public class CustomException {

    // Method to validate age and throw exception if below the minimum limit
    public static void bookTicket(int age) throws AgeLimitException {
        int minimumAge = 12;
        if (age < minimumAge) {
            throw new AgeLimitException("Minimum age limit for ticket booking is " + minimumAge + " years.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Enter the age: ");
            int age = sc.nextInt();
            bookTicket(age);
            System.out.println("Ticket Booking Successful.");
        } catch (AgeLimitException e) {
            System.out.println("Age Limit Exceeded: " + e.getMessage());
        }
        catch (Exception e) {
            System.out.println("An error occured: " + e.getMessage());
        }
    }
}
