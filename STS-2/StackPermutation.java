import java.util.Stack;
import java.util.Scanner;

public class StackPermutation {

    static boolean isStackPermutation(int[] original, int[] target) {
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0;
        for (int element : original) {
            stack.push(element);
            while (!stack.isEmpty() && stack.peek() == target[i]) {
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no of elements in array: ");
        int n = sc.nextInt();
        int[] original = new int[n];
        int[] target = new int[n];
        System.out.println("Enter the original array: ");
        for (int i = 0; i < n; i++) {
            original[i] = sc.nextInt();
        }
        System.out.println("Enter the target array: ");
        for (int i = 0; i < n; i++) {
            target[i] = sc.nextInt();
        }
    
        System.out.println(isStackPermutation(original, target));
    }
}
