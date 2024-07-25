import java.util.*;

public class StockSpan {
    
    public static int[] calculateSpan(int[] stockPrices) {
        int n = stockPrices.length;
        int[] span = new int[n];
        Stack<Integer> stack = new Stack<>();
        // The span of the first day is always 1.
        span[0] = 1;
        stack.push(0);
        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && stockPrices[i] >= stockPrices[stack.peek()]) {
                stack.pop();
            }
            if(stack.isEmpty())
                span[i] = i + 1;
            
            else
                span[i] = i - stack.peek();
            
            // Push the current index onto the stack.
            stack.push(i);
        }
        return span;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no of days: ");
        int n = sc.nextInt();
        int stockPrices[] = new int[n];
        System.out.println("Enter the stock prices of each day: ");
        for (int i = 0; i < n; i++) {
            stockPrices[i] = sc.nextInt();
        }

        // int[] stockPrices = { 100, 80, 60, 70, 60, 75, 85 };
        int[] spans = calculateSpan(stockPrices);
        System.out.println("Stock Prices: " + Arrays.toString(stockPrices));
        System.out.println("Stock Spans: " + Arrays.toString(spans));

        sc.close();
    }
}