import java.util.*;

public class SegSieve {
    public static void segmentedSieve(int low, int high) {
        boolean prime[] = new boolean[high + 1];

        for (int i = 2; i < Math.sqrt(high); i++) {
            int sm = (low / i) * i; // to get the number just below low

            if (sm < low)
                sm = sm + i;

            for (int j = sm; j <= high; j += i)
                prime[i] = true;

            for (int j = low; j <= high; j++) {
                if (prime[j] == false)
                    System.out.print(j + " ");
            }

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the range bw which you want the prime numbers: ");
        int l = sc.nextInt();
        int h = sc.nextInt();
        segmentedSieve(l, h);
    }

}