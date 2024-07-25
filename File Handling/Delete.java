import java.io.*;

public class Delete {
    public static void main(String[] args) {
        File myfile = new File("File1.txt");
        if (myfile.delete()) {
            System.out.println("The file " + myfile.getName() + " has been deleted.");
        } else {
            System.out.println("Some problen occued while deleting the file.");
        }
    }
}
