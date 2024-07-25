// To find all prime numbers upto a given limit

/*
// Naive Method:

import java.util.*;

public class SimpleSieve {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the limit upto which you want prime numbers: ");
        int n = sc.nextInt();

        System.out.println("Prime numbers upto " + n + " are: ");
        for (int i = 2; i < n; i++) {
            boolean flag = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0)
                    flag = false;
            }
            if(flag == true)
                System.out.print(i + " ");
        }
    }
}

*/

// Sieve of Eratosthenes

// 1. Prime numbers Using Simple Sieve Algorithm:
import java.util.*;

public class SimpleSieve {

    public static void CalculatePrimes(int limit) {
        boolean[] primes = new boolean[limit + 1];
        for (int i = 2; i <= limit; i++) {
            primes[i] = true;
        }

        // Mark all the multiples of the prime numbers
        for (int p = 2; p <= Math.sqrt(limit); p++) {
            // If prime[p] is not changed, then it is a prime
            if (primes[p] == true) {
                // Update all multiples of p
                for (int i = p * p; i <= limit; i += p) {
                    primes[i] = false;
                }
            }
        }

        for (int j = 2; j <= limit; j++) {
            if (primes[j] == true)
                System.out.print(j + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the limit upto which you want prime numbers: ");
        int n = sc.nextInt();

        CalculatePrimes(n);

    }
}

/*
// 2. Prime Factorisation (Smallest Prime Factors)
/* 
20 = 2 x 2 x 5
45 = 3 x 3 x 5
42 = 2 x 3 x 7
97 = 97
*/

import java.util.*;

public class SimpleSieve {
    public static void primeFactors(int n) {
        int pfactors[] = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            pfactors[i] = i;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (pfactors[i] == i) {
                for (int j = i * i; j <= n; j += i) {
                    if (pfactors[j] == j) {
                        pfactors[j] = i;
                    }
                }
            }
        }
        
        while (n != 1) {
            System.out.print(pfactors[n] + " ");
            n = n / pfactors[n];
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number for which you want the prime factors: ");
        int n = sc.nextInt();
        primeFactors(n);
    }
}

*/