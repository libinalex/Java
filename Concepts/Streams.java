/* 
Stream API is used to process collections of objects. 
A stream in Java is a sequence of objects that supports various methods that can be pipelined to produce the desired result. 
It enable us to perform operations like filtering, mapping, reducing, and sorting.

Filter, Map, will use lambda expressions.
*/


import java.util.*;
import java.util.stream.Collectors;
public class Streams {
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5);

        System.out.println("Current array: " + arr);
        
        // to filter out even numbers:
        List<Integer> evenList = arr.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
        System.out.println(evenList);

        // To print directly:

        arr.stream().filter(n -> n % 2 == 0).forEach(n -> System.out.print(n + " "));
        
        System.out.println();

        // arr.stream().filter(n -> n % 2 == 0).forEach(System.out::println);

    }
}
