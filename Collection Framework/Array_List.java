/*
ArrayList:
• ArrayList is the implementation of List Interface where the elements can be dynamically added or removed from the list. 
• The size of the list is increased dynamically if the elements are added more than the initial size.
• Collection Arraylist can hold homogeneous as well as heterogeneous data elements.
• The elements stored in the ArrayList class can be randomly accessed.
Syntax:
• ArrayList <datatype> object = new ArrayList ();   datatype: wrapper class - > Integer, Double, String ; not primitive types



Methods of ArrayList:

Method	                                            Description
void add(int index, E element)  	It is used to insert the specified element at the specified position in a list.
boolean add(E e)	                It is used to append the specified element at the end of a list.
boolean addAll(Collection<? extends E> c)	It is used to append all of the elements in the specified collection to the end of this list, in the order that they are returned by the specified collection's iterator.
boolean addAll(int index, Collection<? extends E> c)    	It is used to append all the elements in the specified collection, starting at the specified position of the list.
void clear()	                    It is used to remove all of the elements from this list.
void ensureCapacity(int requiredCapacity)	It is used to enhance the capacity of an ArrayList instance.
E get(int index)	            It is used to fetch the element from the particular position of the list.
boolean isEmpty()	            It returns true if the list is empty, otherwise false.
Iterator()	
listIterator()	
int lastIndexOf(Object o)	It is used to return the index in this list of the last occurrence of the specified element, or -1 if the list does not contain this element.
Object[] toArray()          It is used to return an array containing all of the elements in this list in the correct order.
<T> T[] toArray(T[] a)	    It is used to return an array containing all of the elements in this list in the correct order.
Object clone()	            It is used to return a shallow copy of an ArrayList.
boolean contains(Object o)	It returns true if the list contains the specified element.
int indexOf(Object o)	    It is used to return the index in this list of the first occurrence of the specified element, or -1 if the List does not contain this element.
E remove(int index)	        It is used to remove the element present at the specified position in the list.
boolean remove(Object o)	It is used to remove the first occurrence of the specified element.
boolean removeAll(Collection<?> c)	        It is used to remove all the elements from the list.
boolean removeIf(Predicate<? super E> filter)	        It is used to remove all the elements from the list that satisfies the given predicate.
protected void removeRange(int fromIndex, int toIndex)	It is used to remove all the elements lies within the given range.
void replaceAll(UnaryOperator<E> operator)	            It is used to replace all the elements from the list with the specified element.
void retainAll(Collection<?> c)	        It is used to retain all the elements in the list that are present in the specified collection.
E set(int index, E element)	            It is used to replace the specified element in the list, present at the specified position.
void sort(Comparator<? super E> c)	    It is used to sort the elements of the list on the basis of the specified comparator.
Spliterator<E> spliterator()	        It is used to create a spliterator over the elements in a list.
List<E> subList(int fromIndex, int toIndex)	It is used to fetch all the elements that lies within the given range.
int size()	                It is used to return the number of elements present in the list.
void trimToSize()	        It is used to trim the capacity of this ArrayList instance to be the list's current size.





Collection Methods: 
1 add(Object o)         -  To insert an element in the collection.
2 addAll(Collection c)  -  To insert another collection in the present collection.
3 remove(Object o)      -  To remove an element in the collection .
4 removeAll(Collection c)   -  To remove another collection from the present collection if another is inserted.
5 retain(collection c)      -  To remove all the collection elements that are not contained in the specified collection.
6 clear()       -  It removes all the elements from the collection.
7 isEmpty()     -  It checks collection is empty or not and provides true or false.
8 size()        -  It gives the total number of elements present in the collection in form of a numeric value.
9 equals(collection c)      -  It is used to check if the two collections are the same or not.
10 toArray(collection c)    -  It converts collection into an array.
11 contains(Object o)       -  It is used for searching. If an element is present in the collection it returns true or false.
12 contains(collection c)   -  It is used for searching. If elements of another collection are present in the collection or not. If present returns true or false.


ArrayList Methods:
1 get(object o)             -  It prints the value at a specific index.
2 set(index, object o)      -  It updates the value. In that, we need to provide an index.
3 add(index, object o)      -  It adds an element at a specific index.
4 remove(Object o)          -  It removes elements at specific indexes.
5 addAll(Collection c)      -  It is used to add another collection.
6 removeAll(Collection c)   -  It is used to remove another collection.

Other Collections Methods:
binarySearch(list, key)       -      Finds key in a sorted list using binary search.
sort(list)    -       Sorts a list into ascending order.
min(list)         Returns the smallest value in a list.
max(list)         Returns the largest value in a list.
reverse(list)     Reverses the order of elements in a list.
shuffle(list)     Randomly rearranges the elements in a list.
swap(list, p1, p2)          Exchanges the elements at index positions p1 and p2
replaceAll(list, x1, x2)    Replaces all elements matching x1 with x2     
fill(list, x1)           Fill all elements with x1.
copy(des:x1, src:x2)     Copy one list to another list

eg.     Collections.sort(al)
        Collections.max(al)

*/


import java.util.*;

public class Array_List {
    public static void main(String[] args) {
        ArrayList<Integer> l1 = new ArrayList<>();
        ArrayList<Integer> l2 = new ArrayList<>(5);
        l1.add(5);
        l1.add(2);
        l1.add(4);
        l1.add(7);
        l1.add(6);
        l1.add(2, 9);

        for (int i = 0; i < l1.size(); i++) {
            System.out.print(l1.get(i) + " ");
        }
        System.out.println();

        for(var num: l1){
            System.out.print(num + " ");
        }

        l2.add(23);
        l2.add(43);
        l2.add(13);
        l2.add(null);
        l2.add(36);

        l1.addAll(3, l2);
        System.out.println();

        for (int i = 0; i < l1.size(); i++) {
            System.out.print(l1.get(i) +  (i < l1.size()-1 ? ", ": "" ));
        }
        
        System.out.println("\n" + l2);
        System.out.println(l1);
        System.out.println(l1.contains(23));
        System.out.println(l1.contains(17));
        System.out.println(l1.indexOf(13));
        System.out.println(l1.indexOf(18));

        Iterator itr = l1.iterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }

        l1.remove(3);
        l1.remove(6);
        System.out.println(l1);

        l1.set(2, 34);
        l1.set(5, 108);
        
        // l2.sort(null);

        Collections.sort(l1);
        System.out.println("\nList in sorted order: " + l1);

        System.out.println("Size of List: " + l1.size());

        Collections.reverse(l1);
        System.out.println("ArrayList after reverse: " + l1);

        System.out.println("Maximum element is: " + Collections.max(l1));

        Collections.shuffle(l1);
        System.out.println("Array after shuffle: " + l1);
        
        Collections.swap(l1, 3, 5);
        System.out.println("Array after Swapping elements: " + l1);
    }
}


/*
ArrayList of objects: 

import java.util.ArrayList;
import java.util.Iterator;

class Student {
    String name;
    int age;
    int marks;

    public Student(String name, int age, int marks) {
        this.name = name;
        this.age = age;
        this.marks = marks;
    }
}

public class Array_List {
    public static void main(String[] args) {
        Student s1 = new Student("Libin", 21, 94);
        Student s2 = new Student("Lavesh", 20, 85);
        Student s3 = new Student("Aruneet", 19, 97);
        Student s4 = new Student("Anandu", 22, 82);
        Student s5 = new Student("Ravi", 20, 89);

        ArrayList<Student> arr = new ArrayList<>();
        arr.add(s1);
        arr.add(s2);
        arr.add(s3);
        arr.add(s4);
        arr.add(s5);

        Iterator itr = arr.iterator();
        while (itr.hasNext()) {
            Student st = (Student) itr.next();
            System.out.println(st.name + " " + st.age + " " + st.marks);
        }
    }
}
*/