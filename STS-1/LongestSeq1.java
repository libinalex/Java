/*
Write a program that takes a Integer as input and counts the length of the longest sequence of consecutive 1's in that binary number. 
*/
/*
// Longest sequence of 1s
import java.util.Scanner;

public class LongestSeq1 {
    static int LongestSequence1s(int num) {
        int count = 0;
        while (num > 0) {
            num = num & (num << 1);
            count++;
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the numbers you want to count no of 1s: ");
        int num = sc.nextInt();
        System.out.println("The length of the longest sequence of consecutive 1's in the binary representation of given number is: " + LongestSequence1s(num));
    }
}
// 211184 = 110011100011110000

*/
/*
import java.util.Scanner;

public class LongestSeq1 {
    static int LongestSequence_1_afterFlip(int num, int k) {
        String str = Integer.toBinaryString(num);
        int flip = 0;
        int ans = 0;
        int len = str.length();
        // int len = (int) (Math.log10(num) + 1);
        int i = 0; // move forward
        int j = 0; // unflipping when required

        while (i < len) {
            if (str.charAt(i) == '0')
                flip++;

            while (flip > k) {
                // unflipping previous 0
                if (str.charAt(j) == '0') {
                    flip--;
                    j++;
                }
            }
            //length of subsequent

            ans = Math.max(ans, i - j + 1);
            i++;
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the numbers you want to count no of 1s: ");
        int num = sc.nextInt();
        System.out.print("Enter the number of flips allowed: ");
        int k = sc.nextInt();
        System.out.println("The length of the longest sequence of consecutive 1's in the binary representation of given number is: " + LongestSequence_1_afterFlip(num, k));
    }
}
*/
/*
// Longest sequence of 1s after fliping a bit
import java.util.Scanner;
public class LongestSeq1 {
    public static int longestConsecutiveOnes(int n) {
        String binary = Integer.toBinaryString(n);
        int maxLength = 0;
        int currentLength = 0;
        int previousLength = 0;
        for (char bit : binary.toCharArray()) {
            if (bit == '1') {
                currentLength++;
            } else {
                maxLength = Math.max(maxLength, currentLength + previousLength + 1);
                previousLength = currentLength;
                currentLength = 0;
            }
        }
        maxLength = Math.max(maxLength, currentLength + previousLength + 1);
        return maxLength;
    }

    public static void main(String[] args) {
        int n = 0b111011110;
        System.out.println(longestConsecutiveOnes(n));  // Output: 8
    }
}
*/

// Longest sequence of 1s after fliping at most k bits:
// Idea: We have to find the longest subarray with at most k zeroes.
// 211184 = 110011100011110000
import java.util.Scanner;

public class LongestSeq1 {
    static int LongestSequence_1_afterFlip(int num, int k) {
        String str = Integer.toBinaryString(num);
        int len = str.length();
        int zerocount = 0;
        int ans = 0;
        int i = 0; 
        // str[..i...j..]
        for (int j = 0; j < len; j++) {
            if(str.charAt(j)=='0')
                zerocount++;
            while (zerocount > k) {
                if (str.charAt(i) == '0')
                    zerocount--;
                i++;
            }
            // Now zerocount <= k
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the numbers you want to count no of 1s: ");
        int num = sc.nextInt();
        System.out.print("Enter the number of flips allowed: ");
        int k = sc.nextInt();
        System.out.println("The length of the longest sequence of consecutive 1's in the binary representation of given number is: " + LongestSequence_1_afterFlip(num, k));
    }
}