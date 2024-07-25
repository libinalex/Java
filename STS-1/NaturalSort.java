import java.util.*;

public class NaturalSort {
    public static void main(String[] args) {
        List<String> inputList = Arrays.asList("file1.txt", "file10.txt", "file2.txt", "file11.txt");

        Collections.sort(inputList, new NaturalOrderComparator());

        for (String str : inputList) {
            System.out.println(str);
        }
    }

    static class NaturalOrderComparator implements Comparators<String> {
        public int compare(String str1, String str2) {
            int len1 = str1.length();
            int len2 = str2.length();
            int i1 = 0, i2 = 0;

            while (i1 < len1 && i2 < len2) {
                char ch1 = str1.charAt(i1);
                char ch2 = str2.charAt(i2);

                if (Character.isDigit(ch1) && Character.isDigit(ch2)) {
                    int num1 = 0, num2 = 0;

                    while (i1 < len1 && Character.isDigit(str1.charAt(i1))) {
                        num1 = num1 * 10 + (str1.charAt(i1) - '0');
                        i1++;
                    }

                    while (i2 < len2 && Character.isDigit(str2.charAt(i2))) {
                        num2 = num2 * 10 + (str2.charAt(i2) - '0');
                        i2++;
                    }

                    if (num1 != num2) {
                        return Integer.compare(num1, num2);
                    }
                } else {
                    if (ch1 != ch2) {
                        return Character.compare(ch1, ch2);
                    }

                    i1++;
                    i2++;
                }
            }

            return len1 - len2;
        }
    }
}
