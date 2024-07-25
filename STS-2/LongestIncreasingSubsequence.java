import java.util.*;

public class LongestIncreasingSubsequence {
    static int lis(int arr[]) {
        int n = arr.length;
        int lis[] = new int[n];
        Arrays.fill(lis, 1);

        for (int i = 1; i < n; i++)
            for (int j = 0; j < i; j++)
                if (arr[i] > arr[j] && lis[i] < lis[j] + 1)
                    lis[i] = lis[j] + 1;

        int max = 0;
        for (int i = 0; i < n; i++)
            if (lis[i] > max)
                max = lis[i];
        return max;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no. of elements in array: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int longestLength = lis(arr);
        System.out.println("Length of longest incresing subsequence in given array: " + longestLength);
    }
}
