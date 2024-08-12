
// interchange the diogonal elements:
import java.util.*;

public class Array2D {

    public static void main(String[] args) {
        int arr[][] = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 1, 2, 3 },
                { 3, 4, 5, 6 }
        };
        int size = 3;
        for (int i = 0; i < 4; i++) {
            int temp = arr[i][i];
            arr[i][i] = arr[i][size - i];
            arr[i][size - i] = temp;
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }
}
