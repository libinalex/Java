
import java.io.*;

/*
IO Package
- IO stands for Input-Output
- Used for:
    - Creating new data files
    - Writing data onto the data files
    - Opening existing data files
    - Reading data from the data files
    - Closing the files

Stream:
- Flow of data is called as Stream
- 2 types of Streams in java:
    - byte streams
    - char streams

IO Hierarchy:
<> => abstract class
java.io package                          streams
                                            |
                ----------------------------------------------------------------
                |                                                              |
            byte stream                                                    char stream
                |                                                              |
    -----------------------------                                      -----------------------
    |                           |                                      |                     |
<InputStream>               <OutputStream>                         <Reader>               <Writer>
    |                           |                                      |                     |
    |- FileInputStream          |- FileOutputStream                    |- FileReader         |- FileWriter
    |- BufferInputStream        |- BufferOutputStream                  |- BufferReader       |- BufferWriter
    |- DataInputStream          |- DataOutputStream
    |- ObjectInputStream        |- ObjectOutputStream
    

In io package, most methods throw IOException, so to address the checked exception add throws in mehthod declaration
*/

/* 
byte stream:
- The topmost two abstract classes under byte stream are:
    -InputStream
    -OutputStream

FileOutputStream class 
- Used to create a data file on our hard disk and write into it.

BufferedOutputStream class
- Used to increase the performance of write operations
*/
/*
public class IO_Package {
    public static void main(String[] args) throws IOException {
        // FileOutputStream fos = new FileOutputStream("file101.txt");
        // String str = "Java is Platform Independent";
        // fos.write(str.getBytes()); // Convert String into byte[]
        // // write() takes byte as input, so we need to do the conversion
        // System.out.println("File Created");
        // fos.close();
        
        // To increase the performance of the write() operation, we use BufferedOutputStream

        FileOutputStream fos = new FileOutputStream("file101.txt");
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        String str = "Java is Platform Independent";
        bos.write(str.getBytes()); // Convert String into byte[]
        // write() takes byte as input, so we need to do the conversion
        System.out.println("File Created");
        bos.close();
        fos.close();
    }
    
}
*/

/* 
FileInputStream class 
- Used to open existing files from our hard disk and read data from that file 

BufferedIntputStream class
- Used to increase the performance of read operations
*/
/*
public class IO_Package {
    public static void main(String[] args) throws IOException {
        // FileInputStream fis = new FileInputStream("file101.txt");
        // int size = fis.available(); // returns the size of the file
        // byte[] buffer = new byte[size]; // creating a byte array buffer equal to size of file
        // fis.read(buffer); // storing content of file into the buffer
        // // System.out.println(Arrays.toString(buffer));
        // // Converting buffer array to String to print
        // String str = new String(buffer); // converts byte[] into String
        // System.out.println(str);
        // fis.close();

        //To increase the performance of the read() operation, we use BufferedInputStream

        FileInputStream fis = new FileInputStream("file101.txt");
        BufferedInputStream bis = new BufferedInputStream(fis);
        int size = fis.available(); 
        byte[] buffer = new byte[size]; 
        bis.read(buffer); 
        String str = new String(buffer); 
        System.out.println(str);
        bis.close();
        fis.close();
    }
}
*/

/* 
DataOutputStream class 
- Used to write different data types onto the data file. Till now we were only writing and reading Strings
*/

/*
public class IO_Package {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("file2.txt");
        // Now in this file, we wish to write differnt data types
        DataOutputStream dos = new DataOutputStream(fos);
        dos.writeInt(100);
        dos.writeUTF("Welcome");
        dos.writeDouble(908.156);
        System.out.println("File Created with different data types");
        dos.close();
        fos.close();
    }
}
*/
// Note: If we're writing into a File using DataOutputStream, then we have to read from that File using DataInputStream only.
/*
DataInputStream class
- Used to read different data types like int, float, double, String, etc. from a data file.
*/
/*
public class IO_Package {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("file2.txt"); 
        DataInputStream dis = new DataInputStream(fis);

        // Read in same order of datatype as written into the file 

        int n = dis.readInt();
        System.out.println(n); // 100

        String str = dis.readUTF();
        System.out.println(str); // Welcome

        Double d = dis.readDouble();
        System.out.println(d); // 908.156

        dis.close();
        fis.close();
    }
}
*/

/* 
char stream
- The topmost two abstract classes under char stream are:
    - Writer
    - Reader

We can directly write Strings in char stream, no need for conversion to byte[]

FileWriter
- Used to create a new data file and write data onto it.
- Similar to FileOutputStream but comes under char stream.

BufferWriter
- Used to increase the performance of the above write operation.
*/
/*
public class IO_Package {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("file102.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        String str = "Hibernate is an ORM Framework";
        bw.write(str); // We can directly write the String here
        System.out.println("File created successfully");
        bw.close();
        fw.close();
    }
}
*/

/*
FileReader
- Used to open an existing file and read content from it.
- using read(), we get int values( UNICODE of chars )

BufferReader
- Used to increase the performance of the above read operation.
*/

/*
public class IO_Package {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("Create.java");
        BufferedReader br = new BufferedReader(fr);
        int n;
        while ((n = br.read()) != -1) // -1 indicates EOF(End of File)
            System.out.print((char) n);
        br.close();
        fr.close();
    }
}
*/

/* 
Serialization
- The process of writing an object onto the data file is called as Serialization.
- The process of reading an object from the data file is calles as Deserialization.

- ObjectOutputStream class is used to write an object onto the data file using writeObject() method.
- ObjectInputStream class is used to read an Object from the data file using readObject() method.

- In order to serialize an object of a class, the class should implement Serializable interface
  else it will throw "NotSerializableException"

Note: When writing objects onto data file, if we don't wish to write some data member, then we use the keyword 'transient' 
*/


class Book implements Serializable {
    int bookId;
    String bookName;
    // double bookPrice;
    transient double bookPrice; // not included during Serialization

    public Book(int bookId, String bookName, double bookPrice) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookPrice = bookPrice;
    }

    public Book() {
    }
    
    public String toString() {
        return "Book ID: " + bookId + "\nBook Name: " + bookName + "\nBook Price: " + bookPrice;
    }
}

public class IO_Package {
    public static void main(String[] args) throws Exception {
        
        // Serialization
        FileOutputStream fos = new FileOutputStream("book.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        Book b = new Book(101, "Harry Potter and the Goblet of Fire", 650.00);
        oos.writeObject(b);
        oos.close();
        fos.close();

        // Deserialization
        FileInputStream fis = new FileInputStream("book.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Book b1 = (Book) ois.readObject();
        System.out.println(b1);
        ois.close();
        fis.close();
    }
}