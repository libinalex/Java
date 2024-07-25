/* 
0 1 1 2 3 5 8 13 21 34 55
*/

// Tabulation approach - bottom up

import java.util.*;

public class Fibonacci {
    public static long fib[];
    
    public static void fibonacci(int n) {
        fib = new long[n + 1];
        fib[0] = 0;
        fib[1] = 1;
        
        if (n <= 1) {
            return;
        }
        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n: ");
        int n = sc.nextInt();
        fibonacci(n);
        System.out.println("The fibonacci series till " + n + " terms is: ");
        for(int i=0; i<=n; i++)
            System.out.print(fib[i] + " ");
        System.out.println("\nThe " + n + "th term of the fibonacci series is: " + fib[n]);
    }
}
