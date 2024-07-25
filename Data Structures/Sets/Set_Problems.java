// Set_Problems on Sets

/*
1. Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

Input1:
6
100 4 200 1 3 2

Output1:
4  // longest consecutive seq: 1,2,3,4 in given array

Input2:
10
0 3 7 2 5 8 4 6 0 1

Output2:
9


Input3:
12
50 13 47 2 15 18 14 46 0 16 5 12

Output3:
5     // 12,13,14,15,16


import java.util.*;

public class Set_Problems {
    
    public static int longestConsecutiveSequence(int[] arr) {
        HashSet<Integer> hs = new HashSet<>();
        int length;
        int max_length = 0;
        for (int i : arr) {
            hs.add(i);
        }

        for (int num : hs) {
            length = 1;
            int prev = num - 1;
            int next = num + 1;
            if (!hs.contains(prev)) { // to check if given element is starting of any consecutive sequence
                while (hs.contains(next)) {
                    length++;
                    next++;
                }
                max_length = Math.max(max_length, length);
            }
        }

        return max_length;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("The length of the longest consecutive elements sequence in given array is: "
                + longestConsecutiveSequence(arr));
        sc.close();
    }
}
*/

/* 
2. 
You are given n distinct pairs. Each pair is numbered from 1 to n. All these pairs are initially put in a bag. You need to pair up each number. You take numbers one by one from the bag and for each number you look whether the pair of this number has already been taken out of the bag or not. If not (that means the pair of this numebr is still in the bag), you put the current numeber on the table in front of you. Otherwise, you put both numbers from the pair aside. Print the maximum numbers that were on the table at the same time.

Input1:
1
1 1

Output1:
1


Input2:
3
2 1 1 3 2 3

Output:
2
*/
/*
import java.util.*;

public class Set_Problems {

    public static int maxPair(int n, int[] arr) {
        HashSet<Integer> hs = new HashSet<>();
        for(int i=1; i<=n; i++)
            hs.add(i);

        int on_table = 0;
        int max_on_table = 0;

        for (int num : arr) {
            if (hs.contains(num)) {
                on_table++;
                hs.remove(num);
            }
            else {
                on_table--;
            }
            max_on_table = Math.max(max_on_table, on_table);
        }
        return max_on_table;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no. of pairs: ");
        int n = sc.nextInt();
        System.out.println("Enter the order of numbers taken from bag: ");
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("maximum numbers that were on the table at the same time: " + maxPair(n, arr));
        sc.close();
    }
}
*/

/* 
// Set of custom class
3. You have to store Name and Roll no of various students. But Roll numbers must be unique.
*/
import java.util.*;

/*
By default, if we create new object, set will consider them as different and create different hash code for them, but we need to generate same hashcode for student with same roll no. so we will override the equals() function.
*/
class Student {
    String name;
    int roll;

    public Student(String name, int roll) {
        this.name = name;
        this.roll = roll;
    }

    @Override
    public String toString() { // to print appropritate output using sout()
        return "\nRoll no.: " + roll + "  Name: " + name;
    }

    @Override
    public boolean equals(Object o) {
        // if (this == o)
        // return true;
        // if (o == null || getClass() != o.getClass())
        // return false;

        Student student = (Student) o;
        return roll == student.roll;
    }

    @Override
    public int hashCode() {
        return Objects.hash(roll);
    }
}

public class Set_Problems {

    public static void main(String[] args) {
        Set<Student> studentSet = new HashSet<>();
        studentSet.add(new Student("Libin", 21));
        studentSet.add(new Student("Lavesh", 34));
        studentSet.add(new Student("Aruneet", 7));
        studentSet.add(new Student("Ravi", 45));
        studentSet.add(new Student("Jeevan", 34)); // Student with already existing roll no. (should not be stored)

        System.out.println(studentSet);
    }
}