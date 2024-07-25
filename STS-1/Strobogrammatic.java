// To check if a given number is a strobogrammatic number or not?
import java.util.*;

public class Strobogrammatic {
    public static boolean checkStrobogrammatic(String num) {
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');

        int start = 0, end = num.length() - 1;
        while (start <= end) {
            // if (num.charAt(start) != map.getOrDefault(num.charAt(end), ' ')) {
            //     return false;
            // }
            if (map.containsKey(num.charAt(start)) == false)
                return false;
            if (map.get(num.charAt(start)) != num.charAt(end))
                return false;

            start++;
            end--;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        String s = sc.next();

        if(checkStrobogrammatic(s))
            System.out.println("YES! the given number is a Strobogrammatic number");
        else
            System.out.println("NO! the given number is not a Strobogrammatic number");
        }
}


// To print all the 'n' digit strobogrammatic number.