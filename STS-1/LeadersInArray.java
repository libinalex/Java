// An element is leader if it is greater than all the elemets to its right side.
// The rightmost element is always a leader.

// Leaders in Array
import java.util.Scanner;

public class LeadersInArray {
    // Brute force:
    static void leaderBruteForce(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            boolean isLeader = true;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] <= arr[j]) {
                    isLeader = false;
                    break;
                }
            }
            if (isLeader)
                System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
    // Scanning from right:
    static void leaderFromRight(int arr[]) {
        int n = arr.length;
        int max = arr[n - 1];
        System.out.print(max + " ");
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > max) {
                max = arr[i];
                System.out.print(max + " ");
            }
                
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0;i<n;i++)
            arr[i] = sc.nextInt();
        
        System.out.println("The leader elements in given Array are: ");
        leaderBruteForce(arr);
        leaderFromRight(arr);
    }
}


