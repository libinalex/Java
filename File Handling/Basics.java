/*
File is an Abstract data type.
Stream: Series of data
Byte Stream(input/output stream classes) - 


Character Stream(reader/writer classes) - pass data character by character
Reader class:- abstract class 
bufferReader, charArrayReader, filterReader, piped, stringReader, fileReader

*/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Basics {
    public static void main(String[] args) {
        String filePath = "File1.txt";
        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while (line = bufferedReader) {
                
            }
        } catch (Exception e) {
            
        }
    }
}
