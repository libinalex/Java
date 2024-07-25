import java.util.Scanner;


//1. Program to calculate sum of two numbers


class Main {
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      System.out.print("Enter 1st number: ");
      int a = sc.nextInt();
      System.out.print("Enter 2nd number: ");
      int b = sc.nextInt();

      int sum = a + b;
      System.out.println("The sum is: " + sum);
        
    }
}


/*
//2. Program to check if a given number is an Armstrong Number

An Armstrong number of three digits is an integer such that the sum of the cubes of its digits
is equal to the number itself. 153, 370, 371 and 407 are the Armstrong numbers.

For a 4 digit number, every digit would be raised to their fourth power to get the desired result.
1634, 8208, 9474 are a few examples of a 4 digit armstrong number.

import java.util.*;

public class Problems {
  public static void main(String args[]) {
      Scanner s = new Scanner(System.in);
      System.out.print("Enter the number: ");
      int num = s.nextInt();
      int n,numb, count = 0, rem, sum = 0, prod;
      n = numb = num ;

      while (n > 0) {
        n = n / 10;
        count++;
      }
      
      while (numb>0) {
        rem = numb%10;
        prod = (int) Math.pow(rem, count);
        sum += prod;
        numb /= 10;
      }
      
      if (sum == num) {
        System.out.println("Yes the given number is an Armstrong number!");
      }

      else {
        System.out.println("No the given number is not an Armstrong number!");
      }
  }
}
*/

/*
// 3. Program to calculate percentage marks 

import java.util.Scanner;

public class Problems {
  public static void main(String[] args) {
    int sum = 0;

    Scanner s = new Scanner(System.in);

    System.out.println("Enter the marks scored by student in 5 subjects: ");
    for (int i = 0; i < 5; i++) {
      System.out.print("Marks in Subject " + (i + 1) + " : ");
      int mrk = s.nextInt();
      sum += mrk;
    }

    double percent = (double) sum / 5;
    System.out.println("The percentage of student is: " + percent + " %");
  }
}
*/

/*
// 4. Conversion of Binary number to Decimal number

public class Problems {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the Binary number: ");
    int num = sc.nextInt();
    int digit, decimal = 0, n = num, i=0; // i -> powwers of 2: 2^0, 2^1, 2^2, ...

    while (n > 0) {
      digit = n % 10;
      decimal += digit * Math.pow(2, i++ );
      n = n / 10;
    }

    System.out.println("The Decimal conversion of the Binary number " + num + " is: " + decimal);
  }
}

*/

/*
// 5. Conversion of Decimal number to Binary number

public class Problems {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the Decimal number: ");
    int decimal = sc.nextInt();
    int digit, n = decimal;

    int binary = 0, i = 0;  // i->powers of 10: 10^0, 10^1, 10^2, ...
    while (n > 0) {
      digit = n % 2;
      binary += digit * Math.pow(10, i++);
      n /= 2;
    }
    System.out.println("The Binary equivalent of the Decimal number " + decimal + " is: " + binary);
  }
}
*/

/*
//6. Program to check if a given number is a perfect square or not.

public class Problems {
  public static void main(String[] args) {
    int num = 14884;
    double root = Math.sqrt(num);

    if (root % 1 == 0) {
      System.out.println("Yes, the given number is a perfect square.");
    }

    else {
      System.out.println("No, the given number is not a perfect square.");
    }
  }
}
*/

// 7. Program to swap two numbers
/*
public class Problems {
  static void swap(int a, int b) {
    System.out.println("Numbers before swap:");
    System.out.println("a = " + a + ", b = " + b);

    int temp = a;
    a = b;
    b = temp;
    System.out.println("\nNumbers after swap:");
    System.out.println("a = " + a + ", b = " + b);
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter two numbers: ");
    int a = sc.nextInt();
    int b = sc.nextInt();
    swap(a, b);
   
  }
}
*/

/*
// 7.b. Swap two numbers without using any temporary variable

public class Problems {
  static void swap(int a, int b) {
    System.out.print("Numbers before swap: ");
    System.out.println("a: " + a + ", b: " + b);

    a = a + b;
    b = a - b;
    a = a - b;

    System.out.print("Numbers after swap:  ");
    System.out.println("a: " + a + ", b: " + b);
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter two numbers: ");
    int a = sc.nextInt();
    int b = sc.nextInt();
    swap(a, b);
  }
}
*/

// 8. Program to reverse a number in logN time 
/*
public class Main {
    static void reverse(int num) {
        int rev = 0;
        while (num > 0) {
            rev <<= 1;
            rev |= (num & 1);
            num >>= 1;
        }
        System.out.println("The reverse of the given number is: " + rev);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int num = sc.nextInt();
        reverse(num);
    }
}
*/