import java.util.*;

public class MaxSlidingWindow {
    static void maximum(int arr[], int N, int K)
	{
		int max;
		for (int i = 0; i <= N - K; i++) {
			max = arr[i];
			for (int j = 1; j < K; j++) {
				if (arr[i + j] > max)
					max = arr[i + j];
			}
			System.out.print(max + " ");
		}
	}

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no. of elements: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the array elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter window size: ");
        int K = sc.nextInt();
        maximum(arr, n, K);
    }
}
