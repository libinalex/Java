/*
- Set is an unordered collection of elements
- Set does not allow duplicate elements

Classes under Set interface:
- 3 Concrete Interfaces:
• HashSet {O(n)} -> data in no particular order
• LinkedHashSet -> data in order of insertion (LinkedList + Hash table)
• TreeSet (impements SortedSet) {O(log n)}  -> data in sorted order (self-balancing BST{Red-Black Tree})


HashSet:
- class that implements 'Set' interface.
- duplicates are not allowed. Thus, used when we want uniqueness.
- insertion order is not maintained, no indexing.
- best for search operations and data stored by hashing.
- data -> hash function -> hash code
- default clone of HashSet is Shallow clone


METHOD                 DESCRIPTION

add(E e)	        Used to add the specified element if it is not present, if it is present then return false.
clear()	            Used to remove all the elements from set.
contains(Object o)	Used to return true if an element is present in set.
remove(Object o)	Used to remove the element if it is present in set.
iterator()	        Used to return an iterator over the element in the set.
isEmpty()	        Used to check whether the set is empty or not. Returns true for empty and false for a non-empty condition for set.
size()	            Used to return the size of the set.
clone()	            Used to create a shallow copy of the set.


Methods inherited from class java.util.AbstractSet
METHOD                  DESCRIPTION

equals()	    Used to verify the equality of an Object with a HashSet and compare them. The list returns true only if both HashSet contains same elements, irrespective of order.
hashcode()	    Returns the hash code value for this set.
removeAll(collection)	This method is used to remove all the elements from the collection which are present in the set. This method returns true if this set changed as a result of the call.


Methods inherited from class java.util.AbstractCollection
METHOD                  DESCRIPTION

addAll(collection) 	        This method is used to append all of the elements from the mentioned collection to the existing set. The elements are added randomly without following any specific order.
containsAll(collection) 	This method is used to check whether the set contains all the elements present in the given collection or not. This method returns true if the set contains all the elements and returns false if any of the elements are missing.
retainAll(collection)	    This method is used to retain all the elements from the set which are mentioned in the given collection. This method returns true if this set changed as a result of the call.
toArray()	This method is used to form an array of the same elements as that of the Set.
toString()	The toString() method of Java HashSet is used to return a string representation of the elements of the HashSet Collection.


Methods declared in interface java.util.Collection
METHOD                            DESCRIPTION

parallelStream()	       Returns a possibly parallel Stream with this collection as its source.
removeIf​(Predicate<? super E> filter)	Removes all of the elements of this collection that satisfy the given predicate.
stream()	                Returns a sequential Stream with this collection as its source.
toArray​(IntFunction<T[]> generator)	Returns an array containing all of the elements in this collection, using the provided generator function to allocate the returned array.



Methods declared in interface java.util.Set
METHOD                                      DESCRIPTION

addAll​(Collection<? extends E> c)	Adds all of the elements in the specified collection to this set if they’re not already present (optional operation).
containsAll​(Collection<?> c)   	Returns true if this set contains all of the elements of the specified collection.
equals​(Object o)	                Compares the specified object with this set for equality.
hashCode()	                       Returns the hash code value for this set.
removeAll​(Collection<?> c)	        Removes from this set all of its elements that are contained in the specified collection (optional operation).
retainAll​(Collection<?> c)	        Retains only the elements in this set that are contained in the specified collection (optional operation).
toArray()	                   Returns an array containing all of the elements in this set.
toArray​(T[] a)	                Returns an array containing all of the elements in this set; the runtime type of the returned array is that of the specified array.




TreeSet:
class that implements SET interface.
red-black tree data structure
no duplicated allowed.
elements will be stored in ascending order.
efficient in searching elements.
it inherits abstract class and navigable set -> interface
first element -> lowest element in the set.(root of tree)
last element -> highest element in the set.

    Methods	                                                        Description

add(Object o)	        This method will add the specified element according to the same sorting order mentioned during the creation of the TreeSet. Duplicate entries will not get added.
addAll(Collection c)	This method will add all elements of the specified Collection to the set. Elements in the Collection should be homogeneous otherwise ClassCastException will be thrown. Duplicate Entries of Collection will not be added to TreeSet.
ceiling?(E e)	        This method returns the least element in this set greater than or equal to the given element, or null if there is no such element.
clear()	                This method will remove all the elements.
clone()	                The method is used to return a shallow copy of the set, which is just a simple copied set.
Comparator comparator()	This method will return the Comparator used to sort elements in TreeSet or it will return null if the default natural sorting order is used.
contains(Object o)	    This method will return true if a given element is present in TreeSet else it will return false.
descendingIterator?()	This method returns an iterator over the elements in this set in descending order.
descendingSet?()	    This method returns a reverse order view of the elements contained in this set.
first()	                This method will return the first element in TreeSet if TreeSet is not null else it will throw NoSuchElementException.
floor?(E e)         	This method returns the greatest element in this set less than or equal to the given element, or null if there is no such element.
headSet(Object toElement)	    This method will return elements of TreeSet which are less than the specified element.
higher?(E e)	        This method returns the least element in this set strictly greater than the given element, or null if there is no such element.
isEmpty()	            This method is used to return true if this set contains no elements or is empty and false for the opposite case.
Iterator iterator()	    Returns an iterator for iterating over the elements of the set.
last()	                This method will return the last element in TreeSet if TreeSet is not null else it will throw NoSuchElementException.
lower?(E e)	            This method returns the greatest element in this set strictly less than the given element, or null if there is no such element.
pollFirst?()	        This method retrieves and removes the first (lowest) element, or returns null if this set is empty.
pollLast?()	            This method retrieves and removes the last (highest) element, or returns null if this set is empty.
remove(Object o)	    This method is used to return a specific element from the set.
size()	                This method is used to return the size of the set or the number of elements present in the set.
spliterator()	        This method creates a late-binding and fail-fast Spliterator over the elements in this set.
subSet(Object fromElement, Object toElement)	This method will return elements ranging from fromElement to toElement. fromElement is inclusive and toElement is exclusive.
tailSet(Object fromElement)                 	This method will return elements of TreeSet which are greater than or equal to the specified element.
*/



import java.util.*;

public class Sets {
    public static void main(String[] args) {
        System.out.println("HashSet: ");
        HashSet<Integer> st = new HashSet<>();
        // Inserting elements
        st.add(5);
        st.add(6);
        st.add(6);
        st.add(3);
        st.add(3);
        st.add(34);
        st.add(27);
        st.add(null);
        st.add(0);
        st.add(-12);
        st.add(5);
        st.add(45);
        System.out.println(st);

        st.remove(6); // removes the element 6 if present in the set
        System.out.println(st.remove(5)); // returns true if element was present.
        System.out.println(st);

        System.out.println(st.contains(3));
        System.out.println(st.size());
        
        for (var i : st) {
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.println("\nSet Methods(in place on set A):");
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();
        s1.add(4);
        s1.add(5);
        s1.add(-3);
        s1.add(13);
        s1.add(7);
        s1.add(16);

        s2.add(7);
        s2.add(11);
        s2.add(5);
        s2.add(15);
        s2.add(0);
        System.out.println("Set A: " + s1);
        System.out.println("Set B: " + s2);

        System.out.println("Performing A Intersection B: ");
        s1.retainAll(s2);
        System.out.println(s1);

        s1.add(4);
        s1.add(5);
        s1.add(-3);
        s1.add(13);
        s1.add(7);
        s1.add(16);
        
        System.out.println("Performing A - B: ");
        s1.removeAll(s2);
        System.out.println(s1);

        s1.add(4);
        s1.add(5);
        s1.add(-3);
        s1.add(13);
        s1.add(7);
        s1.add(16);

        System.out.println("Performing A Union B: ");
        s1.addAll(s2);
        System.out.println(s1);
        
        System.out.println();


        // Converting Set to array
        Integer[] arr = st.toArray(new Integer[0]); // needs to be converted to type of the Integer
        System.out.println(arr[0]);
        System.out.println(arr[2]);
        System.out.println(arr[5]);

        System.out.println("\nTree Set");
        TreeSet<String> ts = new TreeSet<>();
        ts.add("Mango");
        ts.add("Apple");
        ts.add("Banana");
        ts.add("Mango");
        ts.add("Grapes");
        ts.add("Watermelon");
        ts.add("Apple");
        System.out.println(ts);

        Iterator<String> itr = ts.descendingIterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
        System.out.println();

        for (String s : ts) {
            System.out.print(s + " ");
        }
        System.out.println();

        TreeSet<Integer> s = new TreeSet<>();
        s.add(49);
        s.add(67);
        s.add(35);
        s.add(56);
        s.add(49);
        s.add(12);
        System.out.println(s);
        System.out.println(s.first()); // lowest in the set
        System.out.println(s.last()); // highest in the set
        System.out.println();

        // Navigable set methods:
        TreeSet<String> s3 = new TreeSet<>();
        s3.add("A");
        s3.add("B");
        s3.add("C");
        s3.add("D");
        s3.add("E");
        s3.add("B");
        System.out.println(s3);
        System.out.println(s3.descendingSet());
        System.out.println(s3.headSet("D")); // default, D will not be included
        System.out.println(s3.headSet("D", true));
        System.out.println(s3.subSet("B", "D"));
        System.out.println(s3.subSet("B", false, "D", true)); // not include B and include D
        System.out.println(s3.tailSet("C", true));
    }
}

