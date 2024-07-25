
//Block Swap
import java.util.Scanner;

public class BlockSwap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        int rotatedArray[] = new int[n];
        int j = 0;
        for (int i = k; i < n; i++) 
            rotatedArray[j++] = arr[i];
        
        for (int i = 0; i < k; i++) 
            rotatedArray[j++] = arr[i];
        
        for(int i: rotatedArray)
            System.out.print(i + " ");
    }
}
