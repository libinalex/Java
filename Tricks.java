/*
if you wish to switch bw 1 and 0:
a = 1-a;

*/


// We can use labels in java to jump to loops

public class Tricks {
    public static void main(String[] args) {
        loop1: for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(j + " ");
                if (j == 5)
                    continue loop1;
                if (i == 3)
                    break;
            }
            System.out.println();
        }
    }
}
