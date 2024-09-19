/* 
Any bit XOR with 0 -> returns same bit
Any bit XOR with 1 -> toggle the bit
To know which bit is present at a position -> AND it with 1

*/

/* 
1. Bitwise Operators:


public class BitManipulation {

    public static void main(String[] args) {
        int a = 4;
        int b = 3;
        System.out.println("a: " + Integer.toBinaryString(a));
        System.out.println("b: " + Integer.toBinaryString(b));
        System.out.println(a|b);
        System.out.println(a&b);
        System.out.println(a^b);
        System.out.println(~a);
        System.out.println(a>>1);
        System.out.println(a<<1);
    }
}
*/
/* 
2. Convert Decimal to Binary and vice versa

public class BitManipulation {

    static int decimalToBinary(int dec) {
        String a = Integer.toBinaryString(dec);
        return Integer.parseInt(a);
    }

    static int binaryToDecimal(int bin) {
        int dec = 0;
        int i = 0;
        while (bin > 0) {
            int rem = bin % 10;
            dec = dec + rem * (int) Math.pow(2, i);
            i++;
            bin = bin / 10;
        }
        return dec;
    }
    public static void main(String[] args) {
        int dec = 8;
        int bin = decimalToBinary(dec);
        System.out.println("The Binary value of " + dec + " is: " + bin);

        dec = binaryToDecimal(bin);
        System.out.println("The Decimal value of " + bin + " is: " + dec);
    }
}
*/

/* 
3. Find ith bit
Logic: Make a mask and perform AND operation

public class BitManipulation {
    static int ithBit(int n, int i) {
        int mask = 1 << i;
        int ans = n & mask;
        if(ans>0)
            return 1;
        return 0;
    }
    public static void main(String[] args) {
        int n = 45;
        int i = 4;
        int bit = ithBit(n, i);
        System.out.println("The number in binary is: " + Integer.toBinaryString(n));
        System.out.printf("The %dth bit in the no. %d is: %d", i, n, bit);
    }
}
*/

/* 
4. Toggle ith bit
Logic: Create mask and perform XOR

public class BitManipulation {
    static int toggleBit(int n, int i) {
        int mask = 1 << i;
        int ans = n ^ mask;
        return ans;
    }

    public static void main(String[] args) {
        int n = 70;
        int i = 0;
        System.out.println("The binary number before toggle: " + Integer.toBinaryString(n));
        
        int afterToggle = toggleBit(n, i);
        System.out.println("The binary number after toggling "+ i + "th bit: " + Integer.toBinaryString(afterToggle)); 
    }
}
*/

/* 
5. Set/Clear the ith bit

public class BitManipulation {
    static int setBit(int n, int i) {
        int mask = 1 << i;
        int ans = n | mask;
        return ans;
    }

    static int clearBit(int n, int i) {
        int mask = ~(1 << i);
        int ans = n & mask;
        return ans;
    }

    public static void main(String[] args) {
        int n = 70;
        int i = 2;
        System.out.println("The binary number before toggle: " + Integer.toBinaryString(n));

        int set = setBit(n, i);
        System.out.println("The binary number after setting " + i + "th bit: " + Integer.toBinaryString(set));
        
        int clear = clearBit(n, i);
        System.out.println("The binary number after clearing " + i + "th bit: " + Integer.toBinaryString(clear));
    }
}
*/

/* 
6. Check if a number is power of 2
Logic: AND the number with number-1, we should get 0

public class BitManipulation {
    static boolean isPower2(int num) {
        int res = num & (num-1);
        return res == 0;
    }
    public static void main(String[] args) {
        int num = 1022;
        System.out.println("Is " + num + " a power of 2?: " + isPower2(num));
    }
}
*/

/* Note:
No. of digits in decimal no. = log10(n) + 1
No. of digits in binary no. = log2(n) + 1
*/

/*
7. Count the no. of set bits in a number.
Logic: for efficient: n & (n-1) turns Least Significant Bit to 0.

public class BitManipulation {

    static int countSetBitsEfficient(int num) {
        int count = 0;
        while (num > 0) {
            count++;
            num = num & (num - 1);
        }
        return count;
    }
    static int countSetBits(int num) {
        int count = 0;
        while (num > 0) {
            int rem = num & 1;
            count += rem;
            num = num >> 1;
        }
        return count;
    }
    

    public static void main(String[] args) {
        int num = 487;
        System.out.println("The binary number : " + Integer.toBinaryString(num));
        int setBits = countSetBits(num);
        System.out.println("The no. of set bits in " + num + " are: " + setBits);
        int setBits1 = countSetBitsEfficient(num);
        System.out.println("The no. of set bits in " + num + " are: " + setBits1);
    }
}
*/

/* 
8. Find the only non-repeating element in an array, where every element repeats twice
Logic: XOR of two same numbers gives 0
# Could also use a HashSet for O(n), but that would use up space

public class BitManipulation {
    static int nonRepeating(int[] arr) {
        int ans = 0;
        for (int i : arr) {
            ans = ans ^ i;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 4, 5, 8, 2, 4, 9, 12, 5, 8, 12, 9 };
        int ans = nonRepeating(arr);
        System.out.println(ans);
    }
}
*/

/* 
9. Find the two non-repeating element in an array, where every element repeats twice
Logic: the XOR will give a^b, now find least significant set bit, 2 groups formed, where it is 1 and 0.
one no. will have 1, other will have 0
The mask( n & ~n ) will give you 1 at least significant set bit. Its XOR with original will give
1 at least significant set bit and 0 at remaining places.

public class BitManipulation {
    static int[] twoNonRepeating(int[] arr) {
        int xor = 0;
        for (int i : arr) {
            xor = xor ^ i;
        }
        int temp = xor;
        int mask = xor & ~(xor - 1);

        for (int i : arr) {
            if ((i & mask) == 0)
                temp = temp ^ i;
        }
        int firstNum = temp;
        int secNum = xor ^ firstNum;
        int res[] = { firstNum, secNum };
        return res;
    }
    public static void main(String[] args) {
        int[] arr = { 4, 5, 8, 2, 4, 9, 12, 5, 8, 12 };
        int[] ans = twoNonRepeating(arr);
        System.out.println("The two non repeating numbers in the array are: " + ans[0] + " " + ans[1]);
    }
}
*/

/* 
10. Find the only non-repeating element in an array, where every element repeats thrice
*/

/* 
11. Swap 2 bits in a given integer


public class BitManipulation {
    static int swapBits(int n, int i, int j) {
        // First find which bit is present at i and j position
        int ati = (n >> i) & 1;
        int atj = (n >> j) & 1;

        // If both bits are same, no need to swap. Else toggle those bits.
        if (ati == atj)
            return n;
        
        int mask = (1 << i) | (1 << j);
        int ans = mask ^ n;
        return ans;
    }

    public static void main(String[] args) {
        int n = 958;
        int i = 3;
        int j = 6;
        System.out.println("The binary number : " + Integer.toBinaryString(n));
        int afterSwap = swapBits(n, i, j);
        System.out.printf("The binary number after swapping %d and %d bits: %s", i, j, Integer.toBinaryString(afterSwap));
        System.out.println(afterSwap);
    }
}
*/

/* 
12. Reverse the bits of a 32 bit unsigned integer
*/