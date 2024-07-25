// Booths Algorithm
import java.util.*;

public class BoothsAlgorithm {
    public int multiply(int n1, int n2) {
        int r = n2;
        int A = n1;
        int P = 0;
        int count = Integer.SIZE;
        while (count > 0) {
            if ((r & 1) == 1) {
                P += A;
            }
            A <<= 1;
            count--;
            r >>= 1;
        }
        return P;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BoothsAlgorithm b = new BoothsAlgorithm();
        System.out.println("Enter two integer numbers: ");
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int result = b.multiply(n1, n2);
        System.out.println("\nResult : " + n1 + " * " + n2 + " = " + result);
    }
}
