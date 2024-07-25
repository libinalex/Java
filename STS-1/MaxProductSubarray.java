// Maximum Product Subarray
import java.util.*;

public class MaxProductSubarray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int max = Integer.MIN_VALUE;
        int currProduct = 1;
        for (int i : arr) {
            if (i == 0) {
                currProduct = 1;
            } else {
                currProduct = currProduct * i;
                if (currProduct > max)
                    max = currProduct;
            }
        }
        System.out.println(max);
    }
}
