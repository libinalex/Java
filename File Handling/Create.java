import java.io.File;

public class Create {
    public static void main(String[] args) {

        File myFile = new File("File1.txt");
        try {
            myFile.createNewFile();
            System.out.println("Successfully created the file: "+ myFile.getName());
        }
        catch (Exception e) {
            System.out.println("some error occured");
            System.out.println(e);
        }

    }
}
