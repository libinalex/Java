/* 
- Java stream API is used to operate on the source data structure (Arrays / Collections) and provide pipelined data that we can use to perform specific operations like we can create a stream from the List and filter it based on a condition
- Using Stream API, the performance of the application is increased.
- Stream API is present in java.util.stream package.
*/

/*
import java.util.*;
import java.util.stream.*;

public class Streams {
    public static void main(String[] args) {

        // Different Ways of Traversing a Collection
        List<String> list1 = List.of("Apple", "Mango", "Banana", "Orange", "Grapes", "Pineapple");

        System.out.println(list1); // [Apple, Mango, Banana, Orange, Grapes, Pineapple]

        // 1. Using traditional for loop
        for (int i = 0; i < list1.size(); i++)
            System.out.print(list1.get(i) + " ");
        System.out.println();

        // 2. Using Enhanced for loop - added in Java 5 version
        for (String s : list1)
            System.out.print(s + " ");
        System.out.println();

        // 3. Using forEach() method - added in Java 8 version
        list1.forEach(s -> System.out.print(s + " "));
        System.out.println();

        // 4. Using method reference (::)- added in Java 8
        list1.forEach(System.out::print);

        System.out.println("\n--------STREAMS----------\n");

        // 1. Creating a Stream using List
        Stream<String> stream1 = list1.stream();
        stream1.forEach(System.out::print);
        System.out.println();

        // 2. Creating a Stream using Set
        Set<String> set1 = new HashSet<>(list1);
        Stream<String> stream2 = set1.stream();
        stream2.forEach(System.out::print);
        System.out.println();

        // 3. Creating a Stream using Array
        String[] arr1 = { "a", "b", "c" };
        Stream<String> stream3 = Arrays.stream(arr1);
        stream3.forEach(System.out::print);
        System.out.println();
    }
}
*/

/*
- Stream API is used to process collections of objects. 
- A stream in Java is a sequence of objects that supports various methods that can be pipelined to produce the desired result. 
- It enable us to perform operations like filtering, mapping, reducing, and sorting.

Filter, Map, will use lambda expressions.

Filtering
- filter() is an intermediate operation that reads data from a stream and returns a new stream after transforming the data based on the given condition.

*/

/*
import java.util.*;
import java.util.stream.Collectors;
public class Streams {
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

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
*/
import java.util.*;
import java.util.stream.*;

class Product {
    int pid;
    String pname;
    int price;

    public Product(int pid, String pname, int price) {
        this.pid = pid;
        this.pname = pname;
        this.price = price;
    }

    public Product() {
    }
    
    public String toString() {
        return pid + " " + pname + " " + price;
    }
}


public class Streams {
    private static List<Product> getProducts() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(111, "monitor", 5000));
        productList.add(new Product(112, "mouse", 4000));
        productList.add(new Product(113, "ups", 2500));
        productList.add(new Product(114, "keyboard", 6500));
        productList.add(new Product(115, "speakers", 1000));
        return productList;
    }
    
    public static void main(String[] args) {
        System.out.println("All Products: ");
        for (Product prod : getProducts()) {
            System.out.println(prod);
        }
        System.out.println();

        // Now we wish to create a list which stores the products whose price is greater than 3000 -> filtering
        System.out.println("Products with price > 3000");
        List<Product> list1 = new ArrayList<>();
        for (Product prod : getProducts()) {
            if (prod.price > 3000)
                list1.add(prod); // adding products to list whose price is > 3000
        }
        
        list1.forEach(System.out::println);

        // for large data, performance will degrade if we use the above method, so we use Stream API
        System.out.println("\nUsing Stream API: ");

        List<Product> list2 = getProducts(); // List of all products
        Stream<Product> stream1 = list2.stream(); // Converting List to Stream
        Stream<Product> stream2 = stream1.filter((prod) -> prod.price > 3000); // applying filtering: taking each Product: prod and checking if its price is greeater than 3000
        List<Product> list3 = stream2.collect(Collectors.toList()); // Collect those products and convert to List

        list3.forEach(System.out::println);
        System.out.println();

        // In a single line:
        List<Product> list = getProducts().stream().filter((prod) -> prod.price > 3000).collect(Collectors.toList());

        list.forEach(System.out::println);

    }
    
    
}