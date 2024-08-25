import java.util.*;
/*
1. Print first N natural numbers.

public class Recursion {

    public static void printNum(int n) {
        if (n == 0) {
            return;
        }
        printNum(n-1);
        System.out.println(n);
    }

    public static void main(String[] args) {
        int n=5;
        printNum(n);
    }
}

*/

/* 2. Print the factorial of a given number.

public class Recursion {

    public static int fac(int num) {
        if (num == 1) {
            return 1;
        }
        
        return (num * fac(num - 1));
    }
    
    public static void main(String[] args) {
        int num = 6;
        int fac = fac(num);
        System.out.println("The factorial is: " + fac);
    }
}

*/

/* 3. Print sum of first n natural numbers. 

public class Recursion {

    public static int sum(int num) {
        if (num == 1) {
            return 1;
        }

        return (num + sum(num - 1));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int num = sc.nextInt();
        int sum = sum(num);
        System.out.println("The sum of first "+ num + " natural numbers are: " + sum);
    }
}
*/

/*4. Fibonacci Series:  0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, ...
Print Fibonacci Series till n terms

public class Recursion {
    static void fibonacciUtil(int n, int index, int a, int b) {
        if(index == n)
            return;
        System.out.print(a + " ");
        fibonacciUtil(n, index+1, b, a+b);
    }

    public static void printFibonacci(int n) {
        System.out.println("Fibonacci Series till " + n + "th element is: ");
        fibonacciUtil(n, 0, 0, 1);
    }

    public static void main(String[] args) {
        int n = 10;
        printFibonacci(n);
    }
}
*/

/*5. Print nth Fibonacci number
public class Recursion {

    public static int Fibonacci(int n) {
        if (n == 1)
            return 0;
        if (n == 2) 
            return 1;
        
        return Fibonacci(n-1) + Fibonacci(n-2);
    }
    
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the position: ");
        int num = sc.nextInt();
        System.out.println("The "+ num + "th element of the Fibonacci sequence is: " + Fibonacci(num));
    }
}
*/

/* 
6. Find power of a number

public class Recursion {

    static int pow(int a, int b) {
        if (b == 0)
            return 1;
        return pow(a, b - 1) * a;
        
    }
    public static void main(String[] args) {
        int a = 5;
        int b = 0;
        int power = pow(a, b); // a ^ b
        System.out.println("When " + a + " is raised to power of " + b + ", we get: " + power);
    }
}
*/

/* 
7. Find no. of paths in an m x n matrix

public class Recursion {

    static int noOfPaths(int m, int n) {
        if(m==1 || n==1)
            return 1;
        return noOfPaths(m - 1, n) + noOfPaths(m, n - 1);
    }

    public static void main(String[] args) {
        int m = 4;
        int n = 3;
        int paths = noOfPaths(m, n); 
        System.out.println("Total paths: " + paths);
    }
}
*/

/* 
8. FInd the GCD of 2 numbers

public class Recursion {

    static int GCD(int a, int b) {
        if (b == 0)
            return a;
        return GCD(b, a%b);
    }

    public static void main(String[] args) {
        int a = 34;
        int b = 34;
        int gcd = GCD(a, b);
        System.out.println("GCD of the two numbers: " + gcd);
    }
}
*/

/* 
9. Find sum of digits in a number

public class Recursion {

    static int sumOfDigits(int n) {
        if (n == 0)
            return 0;

        return sumOfDigits(n / 10) + n % 10;
    }

    public static void main(String[] args) {
        int num = 245;
        int sum = sumOfDigits(num);
        System.out.println("The sum of digits of the number " + num + " are: " + sum);
    }
}
*/

/* 
10. Tower of Hanoi

public class Recursion {
    
static void towerOfHanoi(int numDisks, String source, String auxiliary, String destination) {
    if (numDisks == 0) {
        return;
    }
    // if (numDisks == 1) {
        //     System.out.println("Move disk 1 from " + source + " to " + destination);
        //     return;
        // }
        towerOfHanoi(numDisks - 1, source, destination, auxiliary);
        System.out.println("Move disk " + numDisks + " from " + source + " to " + destination);
        towerOfHanoi(numDisks - 1, auxiliary, source, destination);
    }
    
    public static void main(String[] args) {
        int numDisks = 3;
        String source = "A";
        String auxiliary = "B";
        String destination = "C";
        towerOfHanoi(numDisks, source, auxiliary, destination);
    }
}
*/

/* 
11. Generate all subsets/subsequences of a string
A string formed using original string by removing zero or more characters
Subsequences of abc: "", a, b, c, ab, ac, bc, abc
Logic: starting from empty string "", we either include a character or not at each step.

public class Recursion {

    static void generateSubstringsUtil(String str, int i, String curr, Set<String> set) {
        if (i == str.length()) {
            set.add(curr);
            return;
        }
        generateSubstringsUtil(str, i+1, curr, set); // not take
        generateSubstringsUtil(str, i+1, (curr + str.charAt(i)), set); // take
    }
    static void generateSubstrings(String str) {
        Set<String> set = new HashSet<>();
        generateSubstringsUtil(str, 0, "", set);
        for (var v : set) {
            System.out.print(v + " ");
        }
    }
    public static void main(String[] args) {
        String str = "libin";
        generateSubstrings(str);
    }
}
*/

/* 
12. Recursion on Subsequences
Print all possible subsequences of a given array
Syntax:

f(i, arr[])
{
    if(i >= n)
    {
        print(arr[])
        return
    }
    arr[].add(arr[i]);
    f(i+1, arr[]);      -->  Take

    arr[].remove(arr[i]);
    f(i+1, arr[]);      --> Not Take
}

public class Recursion {
    static void printAllSubsequences(StringBuilder s, String str, int i) {
        if (i >= str.length()) {
            System.out.println(s);
            return;
        }
        s.append(str.charAt(i));
        printAllSubsequences(s, str, i + 1);
        s.deleteCharAt(s.length() - 1);
        printAllSubsequences(s, str, i + 1);
        
    }

    static void printAllSubsequences(ArrayList<Integer> l, int[] arr, int i) {
        if (i == arr.length) {
            System.out.println(l);
            return;
        }
        l.add(arr[i]);
        printAllSubsequences(l, arr, i + 1);
        l.remove(l.size() - 1);
        printAllSubsequences(l, arr, i + 1);
    }

    public static void main(String[] args) {
        int[] arr = { 3, 1, 2 };
        ArrayList<Integer> l = new ArrayList<>();
        printAllSubsequences(l, arr, 0);

        System.out.println();

        String str = "Libin";
        StringBuilder s = new StringBuilder();
        printAllSubsequences(s, str, 0);
    }
}
*/

/* 
13. Print all the subsequences whose sum is equal to a given no. k

public class Recursion {
    static void subsequenceSum(Stack<Integer> list, int[] arr, int k, int i, int sum){
        if (sum == k) {
            System.out.println(list);
            return;
        }
        if (i == arr.length) {
            return;
        }
        list.push(arr[i]);
        sum += list.peek();
        subsequenceSum(list, arr, k, i + 1, sum);
        
        sum -= list.peek();
        list.pop();
        subsequenceSum(list, arr, k, i+1, sum);
    }

    public static void main(String[] args) {
        int[] arr = { 2, 5, 1, 7, 3 };
        int k = 9;
        Stack<Integer> list = new Stack<>();
        System.out.println("The subsequences from given array with target sum of " + k + " are: ");
        subsequenceSum(list, arr, k, 0, 0);
    }
}
*/

/*
14. Print just one of the subsequences of an array whose sum is equal to a given no. k
Logic: In base case, if condition is satisfied, return true. Else, return false.
In function call, use: 
    if(f() == true){
        return true;
    }
    f()
    return false;


public class Recursion {
    static boolean subsequenceSum(Stack<Integer> list, int[] arr, int k, int i, int sum) {
        if (sum == k) {
            System.out.println(list);
            return true;
        }
        if (i == arr.length) {
            return false;
        }
        list.push(arr[i]);
        sum += list.peek();
        if (subsequenceSum(list, arr, k, i + 1, sum))
            return true;

        sum -= list.peek();
        list.pop();
        if (subsequenceSum(list, arr, k, i + 1, sum))
            return true;

        return false;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 5, 1, 7, 3 };
        int k = 9;
        Stack<Integer> list = new Stack<>();
        System.out.println("A subsequence from given array with target sum of " + k + " is: ");
        subsequenceSum(list, arr, k, 0, 0);
    }
}
*/

/* 
15. Give the count of all the subsequences whose sum is equal to a given no. k
Logic:
f(){
    base case:
        return 1 if condition satisfies
        return 0 if condition not satisfies
    l = f();  -> here only 2 as we're dividing into steps(take and not take)
    r = f();     in ques where more steps, you have to make n recursion calls
    return l+r ;
}
*/
public class Recursion {
    static int subsequenceSum(int[] arr, int k, int i, int sum) {
        if (sum == k) {
            return 1;
        }
        if (i == arr.length) {
            return 0;
        }
        sum += arr[i];
        int left = subsequenceSum(arr, k, i + 1, sum);

        sum -= arr[i];
        int right = subsequenceSum(arr, k, i + 1, sum);

        return left + right;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 5, 1, 7, 3 };
        int k = 8;
        int count = subsequenceSum(arr, k, 0, 0);
        System.out.println("The no. of subsequences from given array with target sum of " + k + " is: " + count);
    }
}
