

import java.util.Scanner;

class Account {
    int accno;
    int balance;
    Scanner sc = new Scanner(System.in);

    // Default constructor
    Account() {
        System.out.println("\nEnter the account number and balance: ");
        accno = sc.nextInt();
        balance = sc.nextInt();
    }

    void ShowData() {
        System.out.println("Account number: " + accno + "   Balance: " + balance);
    }
}

public class ArrayOfObjects {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of records you want to enter: ");
        int num = sc.nextInt();

        Account customers[] = new Account[num];     // array reference creation

        for (int i = 0; i < num; i++) 
            customers[i] = new Account();        // array object creation
        
        
        for (int i = 0; i < num; i++)
            customers[i].ShowData();
    }
}
