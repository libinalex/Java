import java.util.Scanner;

/*
// 1. Program to count the number of digits in a given number 

public class Loops {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        long num = sc.nextLong();
        int count = 0;
        while (num > 0) {
            num = num / 10;
            count++;
        }
        System.out.print("The number of digits in the given number is: " + count);
    }
}
*/

/*
// 2. Program to find the sum of digits of a given number.

public class Loops {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the number: ");
    int num = sc.nextInt();
    int rem, sum = 0;

    while (num > 0) {
      rem = num % 10;
      sum += rem;
      num /= 10;
    }
    
    System.out.println("The sum of digits of the guven number is: " + sum);
  }
}
*/

/*
//3. Program to find the reverse of a number.

public class Loops {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the number: ");
    int num = sc.nextInt();
    int rem, n=num, rev = 0;
    while (num > 0) {
      rem = num % 10;
      rev = rev * 10 + rem;
      num /= 10;
    }
    System.out.println("The reverse of the given number " + n + " is: " + rev);
  }
}
*/

/*
// 4. Program to calculate the sum of digits of a number

public class Loops {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int num = sc.nextInt();
        int rem, n = num, sum = 0;
        while (num > 0) {
            rem = num % 10;
            sum = sum + rem;
            num /= 10;
        }
        System.out.println("The sum of the digits of the number " + n + " is: " + sum);
    }
}
*/

/*
// 5. Find the sum of the series: 1 - 2 + 3 - 4 + 5 - 6 + ... n

public class Loops {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number n: ");
        int n = sc.nextInt();
        int sum = 0;
        
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0)
                sum -= i;

            else
                sum += i;
        }

        System.out.print("The sum of the given series till " + n + " is: " + sum);
    }
}
*/

/*
// 6. Program to print the first n numbers of Fibbonaci Series

public class Loops {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter 'n' to get the first n numbers of Fibbonaci Series: ");
        int n = sc.nextInt();

        int a = 0, b = 1;
        System.out.print(a + " " + b + " ");
        for (int i = 2; i < n; i++) {
            int c = a + b;
            System.out.print(c+ " ");
            a = b;
            b = c;
        }
    }
}
*/

/*
//7. Program to print the first n Factorial numbers

public class Loops {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter 'n' to get the Factorial of first n natural numbers: ");
        int n = sc.nextInt();
        int fact = 1;

        for (int i = 1; i <= n; i++) {
            fact = fact * i;
            System.out.println("Factorial of " + i + " is: " + fact);
        }
    }
}
*/

/*
// 8. Given two numbers a and b. Find a raised to the power b.

public class Loops {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number a and b to calculate a^b : ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int exp = 1;

        for (int i = 0; i < b; i++) {
            exp = exp * a;
        }

        System.out.print("The value of " + a + " raised to the power " + b + " is: " + exp);
    }
}
*/

//  Nested Loops
// Patterns:
/*
// 1. Rectangular Pattern:
a.
* * * * * * 
* * * * * *
* * * * * *

public class Loops {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ener the number of rows and columns: ");
        int r = sc.nextInt();
        int c = sc.nextInt();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
*/

/*
b.
* * * * * * * * * *
*                 *
*                 *
* * * * * * * * * *

public class Loops {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ener the number of rows and columns: ");
        int r = sc.nextInt();
        int c = sc.nextInt();
        for (int i = 0; i < r; i++) {
            System.out.print("* ");
            if (i == 0 || i == r - 1) {
                for (int j = 1; j < c-1; j++) 
                    System.out.print("* ");
            }
            else {
                for (int j = 1; j < c-1; j++) 
                    System.out.print("  ");
            }
        
            System.out.print("*");
            System.out.println();
        }
    }
}
*/

// 2. Triangular Pattern
/*
a.
*         
* *       
* * *     
* * * *   
* * * * * 

public class Loops {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows you want in your triangular pattern: ");
        int num = sc.nextInt();

        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
*/

/*
b.
* * * * *
* * * *
* * * 
* * 
*

public class Loops {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows you want in your triangular pattern: ");
        int num = sc.nextInt();

        for (int i = 1; i <= num; i++) {
            for (int j = num; j >= i; j--) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
*/

/*
- Analyse rows and columns.
- Derive relation between rows and columns.
- Determine what to print and where to print.
*/

/*
c. Pyramid
        *
      * * *
    * * * * *
  * * * * * * *
* * * * * * * * *

public class Loops {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows you want in your triangular pyramid pattern: ");
        int row = sc.nextInt();
        int col = 1;
        
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= row-i; j++) {
                System.out.print("  ");
            }
            
            for (int k = 1; k <= col; k++) {        // for(int k = 1; k <= 2*i-1; k++)
                System.out.print("* ");
            }
            System.out.println();
            col = col + 2;
        }
    }
}
*/

/*
d. diamond

for 5:
        *
      * * *
    * * * * *
  * * * * * * *
* * * * * * * * *
* * * * * * * * *
  * * * * * * *
    * * * * *
      * * * 
        * 

public class Loops {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of N for your N-star diamond: ");
        int n = sc.nextInt();
        int gaps = n-1;
        int stars = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < gaps; j++) {
                System.out.print("  ");
            }
            for (int j = 0; j < stars; j++) {
                System.out.print("* ");
            }
            System.out.println();
            gaps--;
            stars += 2;
        }
        gaps++;
        stars -= 2;        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < gaps; j++) {
                System.out.print("  ");
            }
            for (int j = 0; j < stars; j++) {
                System.out.print("* ");
            }
            System.out.println();
            gaps++;
            stars -= 2;
        }
    }
}
*/

/*
e. 
5
* * * * * * * * * *
* * * *     * * * *
* * *         * * *
* *             * *
*                 * 
*                 * 
* *             * * 
* * *         * * * 
* * * *     * * * *
* * * * * * * * * *

public class Loops {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows: ");
        int n = sc.nextInt();

        int stars = n;
        int gaps = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < stars; j++) {
                System.out.print("* ");
            }
            for (int j = 0; j < gaps; j++) {
                System.out.print("  ");
            }
            for (int j = 0; j < gaps; j++) {
                System.out.print("  ");
            }
            for (int j = 0; j < stars; j++) {
                System.out.print("* ");
            }
            stars--;
            gaps++;
            System.out.println();
        }
        stars = 1;
        gaps = n-2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < stars; j++) {
                System.out.print("* ");
            }
            for (int j = 0; j <= gaps; j++) {
                System.out.print("  ");
            }
            for (int j = 0; j <= gaps; j++) {
                System.out.print("  ");
            }
            for (int j = 0; j < stars; j++) {
                System.out.print("* ");
            }
            stars++;
            gaps--;
            System.out.println();
        }
    }
}
*/

/*
// 3. Numerical Rectangular Pattern
a.
1 2 3 4 5 6 7 
2 3 4 5 6 7 1
3 4 5 6 7 1 2
4 5 6 7 1 2 3
5 6 7 1 2 3 4
6 7 1 2 3 4 5
7 1 2 3 4 5 6


public class Loops {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows: ");
        int num = sc.nextInt();

        for (int i = 1; i <= num; i++) {
            for (int j = i; j <= num; j++) {
                System.out.print(j + " ");
            }
            for (int k = 1; k < i; k++) {
                System.out.print(k + " ");
            }
            System.out.println();
        }
    }
}
*/

/*
b.
1 2 1 2 1 2 
2 1 2 1 2 1
1 2 1 2 1 2
2 1 2 1 2 1

public class Loops {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int row = sc.nextInt();

        System.out.print("Enter the number of columns: ");
        int col = sc.nextInt();

        
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if((i+j)%2 == 0)
                    System.out.print("1 ");
                
                else
                    System.out.print("2 ");
            }
            System.out.println();
        }
    }
}
*/

/*
// 4. Numerical Triangular Pattern
a.
1 
1 2
1 2 3
1 2 3 4
1 2 3 4 5


public class Loops {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows you want in your triangular pattern: ");
        int num = sc.nextInt();

        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j +" ");
            }
            System.out.println();
        }
    }
}
*/

/*
b. Numerical Pyramid
        1 
      1 2 1
    1 2 3 2 1
  1 2 3 4 3 2 1
1 2 3 4 5 4 3 2 1


public class Loops {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows you want in your triangular pyramid pattern: ");
        int row = sc.nextInt();

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= row-i; j++) 
                System.out.print("  ");
            
            for (int k = 1; k <= i ; k++) 
                System.out.print(k + " ");
            
            for (int m = i-1; m > 0 ; m--) 
                System.out.print(m + " ");
            
            System.out.println();
        }
    }
}
*/

/*
c. 
4 4 4 4 4 4 4
4 3 3 3 3 3 4
4 3 2 2 2 3 4
4 3 2 1 2 3 4
4 3 2 2 2 3 4
4 3 3 3 3 3 4
4 4 4 4 4 4 4
*/
public class Loops {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter N: ");
        int n = sc.nextInt();

        for (int i = 0; i < 2 * n - 1; i++) {
            int num = n;
            for (int j = 0; j < 2 * n - 1; j++) {
                int top = i;
                int left = j;
                int right = (2 * n - 2) - j;
                int bottom = (2 * n - 2) - i;
                System.out.print(n - Math.min(Math.min(top, bottom), Math.min(left, right)));
            }
            System.out.println();
        }
    }
}