import java.io.FileWriter;
public class Write {
    public static void main(String[] args) {
        
        try {
            FileWriter f1 = new FileWriter("File1.txt");
            f1.write("This is my new file !\nMy name is Libin Alex. \nHow are you?");
            f1.close();
            System.out.println("Successfully wrote into the file.");
        } catch (Exception e) {
            System.out.println("Unable to write into the file");
        }
    }
}
