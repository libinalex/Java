import java.util.*;

class Mystack {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    Mystack() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    void getMin() {
        if (minStack.isEmpty())
            System.out.println("Stack is Empty");
        else
            System.out.println("Minimum element: " + minStack.peek());
    }

    void peek() {
        if (stack.isEmpty()) {
            System.out.println("Stack is Empty");
            return;
        }
        int t = stack.peek();
        System.out.print("Top most element:" + t);
    }

    void pop() {
        int t = stack.pop();
        if (stack.isEmpty()) {
            System.out.println("Stack is Empty");
            return;
        } else {
            System.out.println("Removed element : " + t);
        }
        if (t == minStack.peek())
            minStack.pop();
    }

    void push(int x) {
        if (stack.isEmpty()) {
            stack.push(x);
            minStack.push(x);
            System.out.println("Number Inserted: " + x);
            return;
        } else {
            stack.push(x);
            System.out.println("Number Inserted: " + x);
        }
        if (x <= minStack.peek())
            minStack.push(x);
        return;
    }
};

public class MinimumStack {
    public static void main(String args[]) {
        Mystack s = new Mystack();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no of elements in stack: ");
        int n = sc.nextInt();
        System.out.println("input the elements in stack: ");
        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            s.push(m);
        }
        s.getMin();
        s.pop();
        s.getMin();
        s.pop();
        s.peek();
        sc.close();
    }
}
