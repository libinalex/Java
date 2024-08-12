import java.util.*;
/*
// 1. Transpose of a square matrix

public class Matrix {
    static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void transposeMatrix(int[][] matrix) {
        for (int i = 0; i < matrix[0].length - 1; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 } };
        System.out.println("Original Matrix: ");
        printMatrix(matrix);

        transposeMatrix(matrix);

        System.out.println("The transpose of Matrix is:");
        printMatrix(matrix);
    }
}
*/

/* 
2. Rotate a square matrix by 90 degree
-> Logic: take transpose of matrix and reverse every row

public class Matrix {
    static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    static void reverseArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[n - i - 1];
            arr[n - i - 1] = temp;
        }
    }

    static void rotateMatrix(int[][] matrix) {
        int n = matrix.length;
        // Taking transpose of matrix:
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Now reversing every row (which is an array): 
        for (int[] row : matrix) {
            reverseArray(row);
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 } };
        System.out.println("Original Matrix: ");
        printMatrix(matrix);

        rotateMatrix(matrix);

        System.out.println("The Matrix after rotating 90 degrees is:");
        printMatrix(matrix);
    }
}
    
*/

/* 
3. Search element in Row-wise and Column-wise sorted matrix in O(m+n)
   where m and n are no. of rows and columns in the matrix


public class Matrix {
    static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int[] search(int[][] matrix, int k) {
        int[] index = new int[]{-1, -1};
        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0;
        int col = n - 1;

        while (row < m && col >= 0) {
            int ele = matrix[row][col];
            System.out.println("row: " + row + " column: " + col + " current element: " + ele);
            if(ele == k){
                index[0] = row;
                index[1] = col;
                break;
            }
            else if(k < ele) {
                col--;
            }
            else{
                row++;
            }
        }
        return index;
    }


    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 3,  5,  9,  13 },
                { 2, 5,  6,  12, 15 },
                { 5, 8,  9,  14, 16 },
                { 7, 10, 11, 15, 18 } };
        int k = 7;
        System.out.println("Original Matrix: ");
        printMatrix(matrix);
        System.out.println("Key to be searched: " + k);

        int[] index = search(matrix, k);

        if(index[0] != -1)
            System.out.println("The given key is present in the matrix at index(row,col): " + index[0]+ "," + index[1]);
        else    
            System.out.println("The given key is not present in the matrix");
    }
}
*/

/* 
4. Print a matrix in spiral order
*/

public class Matrix {
    static void printSpiralMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0, j = 0;
        int ind = m * n;
        int count = 0;
        while (count < ind) {
            
        }

    }
    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 3, 5, 9 },
                { 2, 5, 6, 12 },
                { 5, 8, 9, 14 },
                { 7, 10, 11, 15 } };
        
        printSpiralMatrix(matrix);
    }
}