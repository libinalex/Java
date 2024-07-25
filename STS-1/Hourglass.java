/*
6 6
-9 -9 -9  1 1 1 
 0 -9  0  4 3 2
-9 -9 -9  1 2 3
 0  0  8  6 6 0
 0  0  0 -2 0 0
 0  0  1  2 4 0
===> 0+4+3+1+8+6+6 = 28
 

6 6
1 1 1 0 0 0
0 1 0 0 0 0
1 1 1 0 0 0
0 0 2 4 4 0
0 0 0 2 0 0
0 0 1 2 4 0
===>   2+4+4+2+1+2+4 = 19
*/


import java.util.*;

public class Hourglass {
    public static int hourglassSum(int arr[][], int row, int col) {
    // Write your code here
        int max = Integer.MIN_VALUE;
        int sum;
        for(int i=0; i<row-2; i++){
            for(int j=0; j<col-2; j++){
                sum = arr[i][j] + arr[i][j + 1] + arr[i][j + 2]
                    + arr[i + 1][j + 1]
                    + arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2];
                
                if(sum>max)
                    max = sum;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int arr[][] = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println("The maximum sum in hourglass is: " + hourglassSum(arr, row, col));
    }

}