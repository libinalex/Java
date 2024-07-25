
// Karatsuba Algorithm
import java.util.*;

public class KaratsubaAlgo {
    static long Multiply(long x, long y) {
        if (x < 10 || y < 10)
            return x * y;

        int n = Math.max(Long.toString(x).length(), Long.toString(y).length());
        int half = (n + 1) / 2;
        long a = x / (long) Math.pow(10, half);
        long b = x % (long) Math.pow(10, half);
        long c = y / (long) Math.pow(10, half);
        long d = y % (long) Math.pow(10, half);

        long ac = Multiply(a, c);
        long bd = Multiply(b, d);
        long adbc = Multiply(a + b, c + d) - ac - bd;

        return (long) (ac * Math.pow(10, 2 * half) + adbc * Math.pow(10, half) + bd);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the numbers you want to multiply: ");
        long x = sc.nextInt();
        long y = sc.nextInt();
        System.out.println("The Multiplication of the given numbers is: " + Multiply(x, y));
    }
}

// 1026732 * 732912 = 752504203584