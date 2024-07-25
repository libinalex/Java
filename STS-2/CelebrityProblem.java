import java.util.*;
/*
public class CelebrityProblem {
    public static int celebritySolution(int[][] matrix) {
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < matrix.length; i++) {
            stk.push(i);
        }
        while (stk.size() >= 2) {
            int col = stk.pop();
            int row = stk.pop();
            if (matrix[row][col] == 1) {
                stk.push(col);
            } else {
                stk.push(row);
            }
        }
        int x = stk.pop();
        for (int j = 0; j < matrix.length; j++) {
            if (j == x)
                continue;
            if (matrix[x][j] == 1) {
                return -1;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            if (i == x)
                continue;
            if (matrix[i][x] == 0) {
                return -1;
            }
        }
        return x;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the no. of people in party: ");
        int n = sc.nextInt();
        int matrix[][] = new int[n][n];
        System.out.println("Input the matrix depicting who know who:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        
        int result = celebritySolution(matrix);
        if (result == -1) {
            System.out.println("There is No celebrity in the party");
        } else {
            System.out.println(result + " is the celebrity in the party");
        }

        sc.close();
    }
}
*/

public class CelebrityProblem {
    public static int celebritySolution(int M[][]) {
        int candidate = 0;
        for (int i = 1; i < M.length; i++) {
            if (M[candidate][i] == 1) {
                candidate = i;
            }
        }
        
        for (int i = 0; i < M.length; i++) {
            if (i != candidate && (M[candidate][i] == 1 || M[i][candidate] == 0)) {
                return -1;
            }
        }
        return candidate;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the no. of people in party: ");
        int n = sc.nextInt();
        int matrix[][] = new int[n][n];
        System.out.println("Input the matrix depicting who know who:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        int result = celebritySolution(matrix);
        if (result == -1) {
            System.out.println("There is No celebrity in the party");
        } else {
            System.out.println(result + " is the celebrity in the party");
        }

        sc.close();
    }
}