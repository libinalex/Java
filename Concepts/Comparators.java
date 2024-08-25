import java.util.*;
/*
/*Comparator is an interface using which we can give our logic for sorting
We can sort both Collections and Arrays using:
Collections.sort();
Arrays.sort()  -> uses compareTo() method from Comparable interface to sort the array
*/
/*

/* Comparator interface :- 
To define custom sorting order for objects (when natural ordering is not enough)
*/
/*
public class Comparators {
    public static void main(String args[]) {

        Comparator<Integer> com = new Comparator<Integer>() { // here we define our own way of comparison
            public int compare(Integer i, Integer j) {
                if (i % 10 > j % 10) // we are comparing based on last digit of a number
                    return 1;
                return -1;
            }
        };

        List<Integer> ls = new ArrayList<>();
        ls.add(4);
        ls.add(423);
        ls.add(6);
        ls.add(12);
        ls.add(24);
        ls.add(8);

        Collections.sort(ls, com); // we are giving our own custom comparator here
        System.out.println(ls);

    }
}
*/

// Sorting Arrays based on some condition:

public class Comparators {
    public static void main(String[] args) {

        // Custom comparator to compare based on length of string
        Comparator<String> comp_len = new Comparator<String>() {        // anonymous class (can be declared within any class)
            public int compare(String s1, String s2) {              // override the compare method of Comparator 
                if(s1.length() < s2.length())
                    return -1;
                return 1;
            }
        }; // ends with a semi-colon

        // Note that we can give any number of custom comparator anonymous classes, unlike comparable interface
        
        // Custom comparator to compare based on last character
        Comparator<String> comp_last = new Comparator<String>() {        
            public int compare(String s1, String s2) {            
                if(s1.charAt(s1.length()-1) < s2.charAt(s2.length()-1))  
                    return -1;
                return 1;
            }
        };

        // Comparator with lambda:
        // Custom comparator to compare in descending alphabetical order
        Comparator<String> descendingAlphabetic = (s1, s2) -> s2.compareTo(s1);

        // Custom comparator to compare in descending order of length
        Comparator<String> descendingLength = (s1, s2) -> s2.length() - s1.length();
        
        // To compare first according to length, if length same, then alphabetically
        Comparator<String> comp_lenght_alphabetical = (a, b) -> {
            if (a.length() != b.length()) {
                return a.length() - b.length(); // Sort by length
            } else {
                return a.compareTo(b); // If lengths are equal, sort alphabetically
            }
        };



        String arr[] = { "Libin", "Lavesh", "Aruneet", "Ravi", "Adithya", "Jeevan" };
        


        Arrays.sort(arr, comp_len);    // passing our custom comparator as the 2nd argument.
        System.out.println("\nArray after sorting according to length of string: ");
        System.out.println(Arrays.toString(arr));

        Arrays.sort(arr, comp_last);    
        System.out.println("\nArray after sorting according to last character of string: ");
        System.out.println(Arrays.toString(arr));
        
        Arrays.sort(arr, descendingAlphabetic);
        System.out.println("\nArray after sorting according in descending order Alphabetically: ");
        System.out.println(Arrays.toString(arr));

        Arrays.sort(arr, descendingLength);   
        System.out.println("\nArray after sorting according to descending order of length of string: ");
        System.out.println(Arrays.toString(arr));

        Arrays.sort(arr, comp_lenght_alphabetical);
        System.out.println("\nArray after sorting according to length and then Alphabetically: ");
        System.out.println(Arrays.toString(arr));

    }
}



// Comparable interface:-

// We can also use Comparable to compare class based on our logic
// Using Comparable interface we can sort only according to one condition at a time

/*
// Sorting Students based on some parameter:
class Student implements Comparable<Student> {
    String name;
    int marks;
    int age;

    public Student(String name, int marks, int age) {
        this.name = name;
        this.marks = marks;
        this.age = age;
    }

    @Override // Overriding toString() method to display the student details
    public String toString() {
        return "{" +
                " name='" + name + "'" +
                ", marks='" + marks + "'" +
                ", age='" + age + "'" +
                "}" + "\n";
    }

    /*
    // To sort acoording to marks:
    @Override   // Overriding compareTo() method from Comparable interface 
    public int compareTo(Student s) {
        return s.marks - this.marks; // decreasing order of marks
    }
    */
    
    /*
    method to compare Strings: a.compareTo(b)
    a == b => 0
    a < b  => -1
    a > b  => 1
    
    -1 ... 0 ... 1   ---> order of sort
    */
/*
    // To sort according to name:
    @Override   
    public int compareTo(Student s) {
        return this.name.compareTo(s.name); // decreasing order of marks
    }
}

public class Comparators {
    public static void main(String[] args) {
        Student[] student = new Student[5];       // Array of objects
        student[0] = new Student("Libin", 94, 21);
        student[1] = new Student("Aruneet", 97, 19);
        student[2] = new Student("Ravi", 82, 20);
        student[3] = new Student("Anandu", 78, 22);
        student[4] = new Student("Lavesh", 85, 20);

        System.out.println(Arrays.toString(student));
        
        // Now we sort the classes on basis of marks by overriding method in Comparable interface
        // For that, Student class must implement the Comparable interface and specify the natural order
        
        Arrays.sort(student);
        System.out.println("\nStudents after sorting: ");
        System.out.println(Arrays.toString(student));

    }
}

*/