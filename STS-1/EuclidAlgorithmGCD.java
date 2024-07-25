
// Euclidean Algorithm
import java.util.*;
public class EuclidAlgorithmGCD {
    static int GCD(int a, int b) {
        if(b==0)
            return a;
        return GCD(b, a % b);
    }
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the numbers you want the GCD of: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println("The GCD of the given numbers is: " + GCD(a,b));
    }
}
