import java.util.*;

/*
// To perform various arithematic operations
public class Switch_Case {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the numbers a and b: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        char ch = 'N';
        do {
            System.out.println("Choose an option to carry out a specific operation bw a and b: ");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            int option = sc.nextInt();
            
            switch (option) {
                case 1 :
                    System.out.println("You chose: 1. Addition");
                    System.out.println("Addition of given numbers is: " + (a + b));
                    break;

                case 2 : 
                    System.out.println("You chose: 2. Subtraction");
                    System.out.println("Subtraction of given numbers is: " + (a - b));
                    break;

                case 3 : 
                    System.out.println("You chose: 3. Multiplication");
                    System.out.println("Multiplication of given numbers is: " + (a * b));
                    break;

                case 4 : 
                    System.out.println("You chose: 4. Division");
                    System.out.println("Division of given numbers is: " + (a / b));
                    break;

                default:
                    System.out.println("You entered a wrong option!");
            }
            System.out.println("Do you want to continue? (Y/N)");
            ch = sc.next().charAt(0);
        } while (ch == 'Y');
        System.out.println("The END!");
    }
}
*/

// To check if a given input character is vowel or consonant

public class Switch_Case {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a character: ");
        char ch = sc.next().toLowerCase().charAt(0);
        // ch = Character.toLowerCase(ch);
        if (Character.isAlphabetic(ch)) {

            switch (ch) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    System.out.println("Vowel");
                    break;
                default:
                    System.out.println("Consonant");
            }
        }
        else {
            System.out.println("Given input is not an English Alphabet");
        }

    }
    
}