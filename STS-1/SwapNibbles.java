
// Swap Nibbles
import java.util.Scanner;

public class SwapNibbles {
    public static int swapNibbles(int b) {
        // Extract the upper and lower nibbles and shift
        int upperNibble = ((b & 0xF0) >> 4);
        int lowerNibble = ((b & 0x0F) << 4);
        int swappedByte = (lowerNibble | upperNibble);
        
        return swappedByte;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        // int num = (int) 0xAB;  // 1010 1011 in binary
        int num = sc.nextInt();

        // System.out.println("Original byte: " + Integer.toBinaryString(num));

        int swappedByte = swapNibbles(num);
        System.out.println("Swapped byte: " + Integer.toBinaryString(swappedByte));
    }
}

