/*

Linked List
• Linked List is a sequence of links which contains items. Each link contains a connection to another link.
• It uses a doubly linked list internally to store the elements. 
• It can store the duplicate elements. 
• It maintains the insertion order and is not synchronized. 
• In LinkedList, the "manipulation" is faster because no shifting is required.
• Syntax: Linkedlist<wrapper class> object = new Linkedlist<>();



        Method	                                            Description
add(int index, E element)	This method Inserts the specified element at the specified position in this list.
add(E e)	                This method Appends the specified element to the end of this list.
addAll(int index, Collection<E> c)	    This method Inserts all of the elements in the specified collection into this list, starting at the specified position.
addAll(Collection<E> c) 	This method Appends all of the elements in the specified collection to the end of this list, in the order that they are returned by the specified collection’s iterator.
addFirst(E e)	        This method Inserts the specified element at the beginning of this list.
addLast(E e)	        This method Appends the specified element to the end of this list.
clear()	            This method removes all of the elements from this list.
clone()	            This method returns a shallow copy of this LinkedList.
contains(Object o)	This method returns true if this list contains the specified element.
descendingIterator()	This method returns an iterator over the elements in this deque in reverse sequential order.
element()	        This method retrieves but does not remove, the head (first element) of this list.
get(int index)	    This method returns the element at the specified position in this list.
getFirst()	        This method returns the first element in this list.
getLast()	        This method returns the last element in this list.
indexOf(Object o)	This method returns the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element.
lastIndexOf(Object o)	    This method returns the index of the last occurrence of the specified element in this list, or -1 if this list does not contain the element.
listIterator(int index)	    This method returns a list-iterator of the elements in this list (in proper sequence), starting at the specified position in the list.
offer(E e)	        This method Adds the specified element as the tail (last element) of this list.
offerFirst(E e)    	This method Inserts the specified element at the front of this list.
offerLast(E e)  	This method Inserts the specified element at the end of this list.
peek()	            This method retrieves but does not remove, the head (first element) of this list.
peekFirst()     	This method retrieves, but does not remove, the first element of this list, or returns null if this list is empty.
peekLast()	        This method retrieves, but does not remove, the last element of this list, or returns null if this list is empty.
poll()	            This method retrieves and removes the head (first element) of this list.
pollFirst()     	This method retrieves and removes the first element of this list, or returns null if this list is empty.
pollLast()	        This method retrieves and removes the last element of this list, or returns null if this list is empty.
pop()	            This method Pops an element from the stack represented by this list.
push(E e)       	This method pushes an element onto the stack represented by this list.
remove()	        This method retrieves and removes the head (first element) of this list.
remove(int index)	This method removes the element at the specified position in this list.
remove(Object o)	This method removes the first occurrence of the specified element from this list if it is present.
removeFirst()	    This method removes and returns the first element from this list.
removeFirstOccurrence(Object o)	This method removes the first occurrence of the specified element in this list (when traversing the list from head to tail).
removeLast()	    This method removes and returns the last element from this list.
removeLastOccurrence(Object o)	        This method removes the last occurrence of the specified element in this list (when traversing the list from head to tail).
set(int index, E element)	    This method replaces the element at the specified position in this list with the specified element.
size()	            This method returns the number of elements in this list.
spliterator()	    This method creates a late-binding and fail-fast Spliterator over the elements in this list.
toArray()	        This method returns an array containing all of the elements in this list in proper sequence (from first to last element).
toArray(T[] a)  	This method returns an array containing all of the elements in this list in proper sequence (from first to last element); the runtime type of the returned array is that of the specified array.
toString()	        This method returns a string containing all of the elements in this list in proper sequence (from first to the last element), each element is separated by commas and the String is enclosed in square brackets.


Methods in LinkedList
• addFirst()
• addLast()
• removeFirst()
• removeLast()
• getFirst()
• getLast()

Iterator Methods to move next and previous
1.public boolean hasNext() – This method returns true if the iterator has more elements.
2.public object next() – It returns the element and moves the cursor pointer to the next element.
3.public boolean hasprevious() – This method returns true if the iterator has previous elements.


*/



import java.util.*;


public class Linked_List {
    public static void main(String[] args) {
        LinkedList<Integer> l1 = new LinkedList<>();
        LinkedList<Integer> l2 = new LinkedList<>();

    
        l1.add(5);
        l1.add(7);
        l1.addFirst(15);
        l1.addFirst(2);
        l1.addLast(4);
        l1.add(1,7);
        l1.add(6);
        l1.add(2, 9);

        for (int i = 0; i < l1.size(); i++) {
            System.out.print(l1.get(i) + " ");
        }
        System.out.println();

        for (int num : l1) {
            System.out.print(num + " ");
        }

        l2.add(23);
        l2.add(43);
        l2.add(13);
        l2.add(19);
        l2.add(36);

        l1.addAll(3, l2);
        System.out.println();
        for (int i = 0; i < l1.size(); i++) {
            System.out.print(l1.get(i) + (i < l1.size() - 1 ? ", " : ""));
        }

        System.out.println();
        System.out.println(l1.contains(23));
        System.out.println(l1.indexOf(27));

        System.out.println(l1);

        Iterator itr = l1.iterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }

        l1.remove(3);  // remove element at index 3
        l1.removeFirst();
        l1.removeLast();
        l1.remove(4);
        l1.remove();   // remove the first element -> FIFO

        l1.sort(null);
        System.out.println("\n" + l1);

        System.out.println("\nLinked List with hetrogeneous data:");
        LinkedList l = new LinkedList();
        l.add(10);
        l.add(20);
        l.add("Libin");
        l.add(null);
        l.add(30);
        l.add(40.5);
        System.out.println(l);
    }
}
