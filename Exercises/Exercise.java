// 1. Check if the given person is eligible to vote
/* 
public class Exercise {

    public static void main(String[] args) {
        int age = 16;
        if (age >= 18) {
            System.out.println("Yes, the person is eligible to vote! ");
        }
        else {
            System.out.println("No, the person is not eligible to vote! ");
        }

    }

}
*/
/*
// 2. Check if the given number is Armstrong number
public class Exercise {

    public static void main(String[] args) {

        int num = 371, originalNumber, remainder, result = 0;

        originalNumber = num;

        while (originalNumber != 0) {
            remainder = originalNumber % 10;
            result += remainder * remainder * remainder ;
            originalNumber /= 10;
        }

        if (result == num)
            System.out.println(num + " is an Armstrong number.");
        else
            System.out.println(num + " is not an Armstrong number.");
    }
}
*/

/* 
// 3. A prime number is said to be 'Twisted Prime', if the new number obtained after 
reversing the digits is also a prime number. Write a Java program to accept a 
number and check whether the number is 'Twisted Prime' or not.
Sample Input: 167
Sample Output: 761
167 is a 'Twisted Prime'.


public class Exercise {

    public static void main(String[] args) {
        int num = 167, flag = 1, revflag = 1;

        for (int i=2; i<num; i++) {
            if (num%i ==0) {
                flag = 0;
                break;
            }
            else {
                flag = 1;
            }
        }

        int originalNumber, result = 0;
        originalNumber = num;

        if ( flag == 1) {
            while (originalNumber != 0) {
                result = result * 10 + originalNumber % 10;
                originalNumber = (int) Math.floor(originalNumber/10);
            }
        }

        for (int i = 2; i < result; i++) {
            if (result % i == 0) {
                revflag = 0;
                break;
            } else {
                revflag = 1;
            }
        }

        if ( flag == 0) {
            System.out.println("The entered number is not a prime number.");
        } 
        else if (revflag == 0) {
            System.out.println("The given number is a prime number but not a twin prime number.");
        }
        else if (flag == 1) {
            System.out.println("The given number is a twin prime number.");
        }
    }
}
*/

// 4. Program to find the sum of digits of a given number
/* 
public class Exercise {

    public static void main(String[] args) {
        int rem, sum = 0, num, number = 234;
        num = number;
        
        while (number != 0) {
            rem = number % 10;
            sum += rem;
            number /= 10;
        }
        
        System.out.println("The sum of digits of the given number " + num + " is: " + sum);

    }

}
*/

/* 5. An Electricity Board charges for electricity per month from their consumers according to the units consumed.The tariff is given below:

Units Consumed                 Charges
Up to 100 units               No charges 
100 to 200 units              ₹3.25/unit 
200 to 300 units              ₹4.50/unit 
300 to 400 units              ₹5.20/unit
More than 400 units           ₹6.10/unit 
Write a program to calculate the electricity bill taking consumer's name and units consumed as inputs.


public class Exercise {

    public static void main(String[] args) {
        
        int units;
        double amt = 0.0;

        units = 120;

        if (units <= 100)
            amt = 0.0;

        else if (units <= 200)
            amt = 3.25 * units;

        else if (units <= 300)
            amt = 4.50 * units;

        else if (units <= 400)
            amt = 5.20 * units;

        else
            amt = 6.10 * units;

        System.out.println(amt);

    }

}
*/
/*
import java.util.*;

public class IPS {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        //1. 
        double cover_price = 24.95;
        double after_disc = 0.6 * cover_price;
        double no_copies = 60.0;
        double cost = (after_disc * no_copies) + (3 + .75*(no_copies - 1)) ;
        System.out.println("The total wholesale cost for 60 copies are: " + cost );
        
        //2.
        double force = sc.nextDouble();
        double mass = sc.nextDouble();
        System.out.println("Acceleration: " + force/mass );
        
        // 3.
        
        double diameter = sc.nextDouble();
        double price =  sc.nextDouble();
        double cost = (price * 4) / (3.14 * diameter * diameter);
        double cost_per_sq = Math.round(cost * 10.0) / 10.0;
        System.out.println("Rs. " + cost_per_sq);
         
        

        /*
        //5. Acctepting 3 numbers and performing operations:
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        
        System.out.println("Concatenation: " + a+b+c );
        int sum = a + b + c;
        System.out.println("Square root of sum: " + Math.sqrt(sum));
        System.out.println("Sum of quotient after dividing all 3 numbers by 2: " + (sum/2));
        float av = (float)(a%5 + b%5 + c%5)/3;
        System.out.println("Average of Remainders after dividing all numbers by 5: " + Math.round(av*100.0)/100.0 );
        double x =  Math.cos(a) * Math.sin(c);
        System.out.println("Multiplication of Cos value of 1st no. with Sine value of 3rd no. : " + Math.round(x*100.0)/100.0);
        
    }
}
*/

