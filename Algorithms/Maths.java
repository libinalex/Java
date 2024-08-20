
/* 
1. Basic built-in functions:

public class Maths {
    public static void main(String[] args) {
        int a = 2;
        int b = 4;
        
        System.out.println("Maximum: " + Math.max(a, b));     // To get the maximum between two numbers
        System.out.println("Minimum: " + Math.min(a, b));     // To get the miniimum between two numbers
        System.out.println("Random value bw 0-1: " + Math.random());     // To get a random number bw 0 and 1
        System.out.println("Random value bw 0-100: " + (int) (Math.random() * 100)); // To get a random number bw 0 and 100
        System.out.println("Square root: " + Math.sqrt(a));     // To get the  square root of a number
        System.out.println("Power : " + Math.pow(a, b)); // To get the value of a raised to power b
        System.out.println("Round off to nearest integer: " + Math.round(2.645)); // To round off a number to nearest integer
        
    }
}
*/
/* 
2. check if given number is a palindrome
Logic: Compare given number with its reverse

public class Maths {
    static boolean isPalindrome(int num) {
        int rev = 0;
        int n = num;
        while (n > 0) {
            int rem = n % 10;
            rev = rev * 10 + rem;
            n /= 10;
        }
        return num == rev;
    }
    public static void main(String[] args) {
        int num = 23432;
        System.out.println("Is the number " + num + " a Palindrome: " + isPalindrome(num));
    }
}
*/

/* 
3. GCD / HCF of a number
Logic: Use euclidean algorithm recursively


public class Maths {
    static int GCD(int a, int b) {
        if(b == 0)
            return a;
        return GCD(b, a % b);
    }

    public static void main(String[] args) {
        int a = 36;
        int b = 24;
        int gcd = GCD(a, b);
        System.out.printf("GCD of the numbers %d and %d is: %d", a, b, gcd);
    }
}
*/

/* 
3. LCM of two numbers
Logic: LCM(a,b) = a*b / HCF(a,b)


public class Maths {

    static int GCD(int a, int b) {
        if (b == 0)
        return a;
        return GCD(b, a % b);
    }
    
    static int LCM(int a, int b) {
        return (a * b) / GCD(a, b);
    }

    public static void main(String[] args) {
        int a = 24;
        int b = 36;
        int lcm = LCM(a, b);
        System.out.printf("LCM of the numbers %d and %d is: %d", a, b, lcm);
    }
}
*/

/* 
4. Calculate the no. of trailing zeros in the factorial of a number.
Logic: a trailing 0 is formed by multiplication of 2 and 5, we have ample of 2s in 2, 4, 6, 8,....
So, we just need to calculate no. of 5s, and we can know no of 0s.
Now in 5, 10, 15, 20 there is one 5. Then in 25, 125, 625, there are mulitple 5s, so we use the genereal formula:
Divide given no. by 5 till the n>0. Sum the quotients to get the answer.


public class Maths {
    static int calcTrailingZeros(int n) {
        int count = 0;
        while (n > 0) {
            count += n / 5;
            n /= 5;
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 25;
        int trailingZeros = calcTrailingZeros(n);
        System.out.println("The no. of trailing zeros in the factorial of given no. is: " + trailingZeros);
    }
}
*/

/* 
5. Calculate the no. of unique paths in a Grid (moving along grid)
Logic: for an mxn grid, total steps to reach goal will be (m+n).
of these, we have to come m times down. so (m+n)Cm
can be simplified as: (m+1)*(m+2)*...(m+n-1)*(m+n) / 1*2*3*...*(n-1)*n


public class Maths {
    static int pathsInGrid(int m, int n) {
        int num = 1;
        int denom = 1;

        for (int i = 1; i <= n; i++) {
            num *= (m + i);
            denom *= i;
        }
        return num / denom;
    }

    public static void main(String[] args) {
        int m = 3;
        int n = 2;
        int totalPaths = pathsInGrid(m, n);
        System.out.println("The no. of paths in grid is: " + totalPaths);
    }
}
*/

/* 
6. Check if a no. is Prime or not


public class Maths {
    static boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int num = 41;
        System.out.println("Is the no. " + num + " a Prime number? : " + isPrime(num));
    }
}

*/

/* 
7. Print all divisors of a number n.


public class Maths {
    static void divisors(int num) {
        for (int i = 1; i <= num; i++) {
            if (num % i == 0)
                System.out.print(i + " ");
        }
    }
    
    static void divisorsEfficient(int num) { 
        int i;
        for (i = 1; i <= Math.sqrt(num); i++) {
            if (num % i == 0)
                System.out.print(i + " ");
        }
        i--;
        for (; i >= 1; i--) {
            if (num % i == 0)
                if(num/i != i)
                    System.out.print(num / i + " ");
        }
    }

    public static void main(String[] args) {
        int num = 36;
        System.out.println("The divisors of the no. " + num + " are: ");
        divisorsEfficient(num);
    }
}
*/

/* 
8. Print all prime numbers till n
Sieve of Eratosthenes


import java.util.Arrays;

public class Maths {
    static void sieveOfEratosthenes(int n) {
        boolean primes[] = new boolean[n + 1];
        Arrays.fill(primes, true);
        for (int i = 2; i < Math.sqrt(n); i++) {
            if(primes[i])
                for (int j = i * i; j <= n; j += i) {
                    primes[j] = false;
                }
        }

        for(int i=2; i<=n; i++) {
            if(primes[i])
                System.out.print(i +" ");
        }
    }

    public static void main(String[] args) {
        int n = 100;
        System.out.println("The Prime numbers till " + n + " are: ");
        sieveOfEratosthenes(n);
    }
}
*/

/* 
9. calculate power efficiently (in O(logn))
Logic: using recursion,
    if odd b: a^b = a^b/2 * a^b/2 * a
    if even b: a^b = a^b/2 * a^b/2


public class Maths {
    static int fastPow(int a, int b) {
        if(b == 0)
            return 1;
        
        int halfPow = fastPow(a, b / 2);
        int pow = halfPow * halfPow;
        if(b%2 == 1)
            pow = pow * a;
        return pow;
    }

    public static void main(String[] args) {
        int a = 2;
        int b = 9;
        System.out.printf("When %d is raised to the power %d, we get %d", a, b, fastPow(a,b));
    }
}
*/

/* 
10. Determine whether an integer is a palindrome. Do this without extra space.
*/

public class Maths {
    static boolean checkPalindrome(int n) {
        int div = 1;
        while (n / div >= 10)
            div *= 10;

        while (n != 0) {
            int l = n / div;
            int r = n % 10;
            if (l != r)
            return false;
            n = (n % div) / 10;
            div = div / 100;
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 15;
        boolean isPalindrome = checkPalindrome(n);
        System.out.println(isPalindrome);
    }
}