/*
Collections are used to collect the elements of variable size.

Arrays vs Collections:
- In Arrays, we can collect elements of fixed size whereas in Collections we can collect elements of variable size
- In Arrays we can collect only similar type of elements whereas in Collections we can collect different types of elements.
- In Arrays we can collect primitive types as well as reference type of elements whereas in Collections we can collect only reference type of elements.

Collection Hierarchy:
<< >> :- interface
                        <<Collection>>
                      /               \
                     /                 \
                <<List>>              <<Set>>
                /     \               /      \
               /       \             /        \
       ArrayList   LinkedList   HashSet     <<SortedSet>>
                                    |           |
                                    |           |
                            LinkedHashSet    TreeSet



                            <<Map>>
                           /       \
                          /         \
                    HashMap     <<SortedMap>>
                        |            |
                        |            |
                  LinkedHashMap    TreeMap


- Collection is used to collect only the elements whereas Map is used to collect elements in form of key-value pair.

- List is ordered whereas Set is unordered.
- List allows duplicates whereas Set does not allow duplicate elements

- In ArrayList, the elements are stored in continuous memory locations whereas in LinkedList the elements are stored in non-continuous memory locations in the form of nodes( a node is divided into two parts: element value and link to the next node)
- The cost of insert and delete operations are more in ArrayList whereas the cost of these operations are less in LinkedList.
- ArrayList occupies less memory than LinkedList.

- HashSet is unordered and no duplicate elements
- LinkedHashSet is ordered and no duplicates
- TreeSet is sorted and no duplicate elements

- HashMap is unordered, based on keys and no duplicate keys
- LinkedHashMap is ordered, based on keys and no duplicate keys.
- TreeMap is sorted, based on keys and no duplicate keys


List Interface
• List interface is implemented by the classes ArrayList, LinkedList, Vector, and Stack.


List Methods:
1 boolean add(Object)        -  adds an element at last
2 void add(int, Object)      -  adds an element at a specific index.
3 void set(int, Object)      -  updates/modifies the element at given index
4 Object get(int)            -  returns the element at given index.
5 boolean remove(Object)     -  removes/deletes the given element.
6 Object remove(int)         -  removes/deletes the elements at given index.

Both ArrayList and LinkedList will these methods common and will give same output as well, just the internal working of inerting and deleting operations will be different.

Generics:
- Generics is added in  Java 5 version
- Generics are used to manage different data types
- When Generics are used in a Collection, we can ensure that only similar type of elements are present in Collection.
- When Generics are used in Collection, we can traverse the elements using Enhanced for loop 

*/

import java.util.*;

public class Basics {
      public static void main(String[] args) {
            ArrayList al = new ArrayList<>();
            al.add(12); // Autoboxing
            al.add(27);
            al.add(-0.054);
            al.add("mango");
            al.add("apple");
            al.add(45.9);
            al.add("Libin Alex");
            System.out.println(al); // [12, 27, -0.054, mango, apple, 45.9, Libin Alex]
            
            al.add(2, 4);
            System.out.println(al); // [12, 27, 4, -0.054, mango, apple, 45.9, Libin Alex]

            al.set(0, -12);
            System.out.println(al); // [-12, 27, 4, -0.054, mango, apple, 45.9, Libin Alex]

            al.remove(45.9);
            System.out.println(al); // [-12, 27, 4, -0.054, mango, apple, Libin Alex]

            al.remove(4);
            System.out.println(al); // [-12, 27, 4, -0.054, apple, Libin Alex]

            String str = (String) al.get(5); // explicit typecast; as get method returns Object, and String is a subclass of Object. In hierarchy, Object is higher than String, so apply typecasing to go from higher to lower
            System.out.println(str); // Libin Alex

            System.out.println("Size: " + al.size()); // 6

            List<String> names = List.of("Libin", "Aruneet", "Lavesh", "Ravi", "Jeevan");
            
            System.out.println(names);

      }
}

/* 
In Collections, only Reference type is allowed, still when we gave al.add(5), where 5 is primitive int, it accepted. This is because of a feature called: Autoboxing - added in Java 5 version
- Autoboxing: Converting a primitive type into reference type or vice-versa automatically

Prior to java 5, we would have to write:
al.add(new Integer(5)); BUT now we can directly write al.add(5), and Autoboxing takes care.

- Instead of using .add() method multiple times to add single elements to a collection, We can add all elements together by using Collection Factory method: of() - added in Java 9
*/