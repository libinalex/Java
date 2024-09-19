
import java.util.*;

public class practise {
    // practise(float a) {
    // System.out.println("Float " + a);
    // }

    // practise(double a) {
    // System.out.println("Double " + a);
    // }

    public static void main(String[] args) {
        String str = "aaaa";
        String findStr = "a";
        int lastIndex = 0;
        int count = 0;

        while (lastIndex != -1) {
            lastIndex = str.indexOf(findStr, lastIndex);
            
            if (lastIndex != -1) {
                count++;
                lastIndex += findStr.length();
            }

        }
        System.out.println(count);

    }
}

