
/*
// try-catch block
public class Exception_Handling {
    public static void main(String args[]) {
        System.out.println("Begining the program");
        try {
            int data = 100 / 0;
            System.out.println("Data = " + data);
        } catch (ArithmeticException e) {
            System.out.println(e);
            System.err.println("Divide by 0 not allowed"); // .err will display this msg in red color
        }
        System.out.println("rest of the code...");
        int A = 10, B = 5;
        System.out.println(A + B);
        System.out.println("Code successfully executed");
    }
}
*/

/* 
If an exception occurs in try block, the Java runtime will throw an exception which is caught by catch block and handles the exception and the remaining part of try block will not get executed
*/

/* 
// Multiple catch statements:
- The order of catch blocks cannot be from super class to sub class

public class Exception_Handling {
    public static void main(String[] args) {
        try {
            int a[] = new int[5];
            System.out.println(a[10]);
            System.out.println(a[4] / 0);
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic Exception Occured");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBounds Exception Occured");
        } catch (RuntimeException e) {
            System.out.println("Runtime Exception Occured");
        } catch (Exception e) {
            System.out.println("Parent Exception Occured");
        }
        System.out.println("Rest of the code...");
    }
}
*/

/*

public class Try_Catch {
    public static void main(String[] args) {
        int a = 100;
        int b = 0;

        
        // Without try:
        int c = a / b;
        System.out.println("The result is: " + c);      ---> Will raise an error and terminate the program
        

        // With try_catch :
        try {
            int c = a / b;
            System.out.println("The result is: " + c);
        } catch (Exception e) {
            System.out.println("We failed to divide. Reason: ");
            System.out.println(e);
        }

        System.out.println("End of Program.");
    }
}

*/

// Multiple catch blocks
/*
import java.util.Scanner;

public class Try_Catch {
    public static void main(String[] args) {
        int[] arr = new int[] { 1, 2, 3, 4, 5 };
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the index of array you want to divide: ");
        int index = sc.nextInt();

        System.out.println("Enter the number you want to divide the number from: ");
        int num = sc.nextInt();


        try {
            System.out.println("You accessed the number: " + arr[index]);
            System.out.println("The result when the number is divided by the given no. is: " + arr[index] / num);
        } 
        catch (ArithmeticException e) {
            System.out.println("We failed to divide. ");
            System.out.println(e);
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("The index you entered for array is out of bounds. ");
            System.out.println(e);
        }
        catch (Exception e) {
            System.out.println("Some other Exception occured!...  ");
            System.out.println(e);
        }


        System.out.println("End of Program.");
    }
}
*/


/*
import java.util.Scanner;

public class Try_Catch {
    public static void main(String[] args) {
        int[] arr = new int[] { 1, 2, 3, 4, 5 };

        System.out.println("The array is: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter the index of array you want to access: ");
        int index = sc.nextInt();
        boolean flag = true;
        while (flag) {
            try {
                System.out.println("You accessed the number: " + arr[index]);
                flag = false;
            } 
            catch (IndexOutOfBoundsException e) {
                System.out.println("The index you entered for array is out of bounds. Please enter the correct Index: ");
                index = sc.nextInt();
            }
        }
        System.out.println("End of Program.");
        System.out.println("Thank you!!!");

    }
}
*/


// Nested try block

