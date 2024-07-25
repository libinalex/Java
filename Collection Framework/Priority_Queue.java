
/* 
A PriorityQueue is used when the objects are supposed to be processed based on the priority.

- PriorityQueue doesn’t permit null.
- We can’t create a PriorityQueue of Objects that are non-comparable
- PriorityQueue are unbound queues.
- The head of this queue is the least element with respect to the specified ordering. If multiple elements are - tied for the least value, the head is one of those elements — ties are broken arbitrarily.
- The queue retrieval operations poll, remove, peek, and element access the element at the head of the queue.
- It provides O(log(n)) time for add and poll methods.

    METHOD                              	DESCRIPTION
add(E e)	    Inserts the specified element into this priority queue.
clear()     	Removes all of the elements from this priority queue.
comparator()	Returns the comparator used to order the elements in this queue, or null if this queue is sorted according to the natural ordering of its elements.
contains?(Object o) 	Returns true if this queue contains the specified element.
forEach?(Consumer<? super E> action)	Performs the given action for each element of the Iterable until all elements have been processed or the action throws an exception.
iterator()	         Returns an iterator over the elements in this queue.
offer?(E e)	         Inserts the specified element into this priority queue.
remove?(Object o)	 Removes a single instance of the specified element from this queue, if it is present.
removeAll?(Collection<?> c) 	Removes all of this collection’s elements that are also contained in the specified collection (optional operation).
removeIf?(Predicate<? super E> filter)	Removes all of the elements of this collection that satisfy the given predicate.
retainAll?(Collection<?> c)	Retains only the elements in this collection that are contained in the specified collection (optional operation).
spliterator()	    Creates a late-binding and fail-fast Spliterator over the elements in this queue.
toArray()       	Returns an array containing all of the elements in this queue.
toArray?(T[] a)	    Returns an array containing all of the elements in this queue; the runtime type of the returned array is that of the specified array.

Methods Declared in class java.util.AbstractQueue
METHOD	                                    DESCRIPTION
addAll(Collection<? extends E> c)	Adds all of the elements in the specified collection to this queue.
element()	Retrieves, but does not remove, the head of this queue.
remove()	Retrieves and removes the head of this queue.

Methods Declared in class java.util.AbstractCollection
METHOD	                                DESCRIPTION
containsAll(Collection<?> c)	Returns true if this collection contains all of the elements in the specified collection.
isEmpty()	Returns true if this collection contains no elements.
toString()	Returns a string representation of this collection.


Methods Declared in interface java.util.Collection
METHOD	                                DESCRIPTION
containsAll(Collection<?> c)	Returns true if this collection contains all of the elements in the specified collection.
equals(Object o)	Compares the specified object with this collection for equality.
hashCode()	Returns the hash code value for this collection.
isEmpty()	Returns true if this collection contains no elements.
parallelStream()	Returns a possibly parallel Stream with this collection as its source.
size()	Returns the number of elements in this collection.
stream()	Returns a sequential Stream with this collection as its source.
toArray(IntFunction<T[]> generator)	Returns an array containing all of the elements in this collection, using the provided generator function to allocate the returned array.


Methods Declared in interface java.util.Queue
METHOD	         DESCRIPTION
peek()	    Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
poll()	    Retrieves and removes the head of this queue, or returns null if this queue is empty.



The insertion order is not retained in the PriorityQueue. 
The elements are stored based on the priority order which is ascending by default. 

The required no. Min/Max is present in the 1st index of the queue, so when we remove/poll an element minimum is removed, 
but remaining elements when printed or traversed appear randomly
*/
import java.util.*;

public class Priority_Queue {
    public static void main(String[] args) {
        System.out.println("Priority Queue (default: Min)");
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(278);
        pq.offer(23);
        pq.offer(77);
        pq.offer(456);
        pq.add(-45);
        pq.add(-24);
        pq.add(0);
        pq.add(7);
        System.out.println(pq); // doesn't give correct order - gives a random order
        // Order is maintained while removing/polling elements from the priority queue

        System.out.println(pq.remove()); // removes in ascending order
        System.out.println(pq.remove());
        System.out.println(pq.poll());

        System.out.println(pq);

        System.out.println("Minimum element in queue: " + pq.remove());
        System.out.println(pq.remove());
        System.out.println(pq.remove());

        System.out.println();

        // For descending order:
        System.out.println("Priority queue in descending order ( Max )");
        PriorityQueue<Integer> pq_rev = new PriorityQueue<>(Comparator.reverseOrder());
        pq_rev.offer(23);
        pq_rev.offer(-45);
        pq_rev.offer(7);
        pq_rev.offer(125);
        pq_rev.offer(92);
        System.out.println(pq_rev);

        int n = pq_rev.size();
        System.out.println("Removing elements according to priority: ");
        for (int i = 0; i < n; i++)
            System.out.println(pq_rev.poll());
        

        System.out.println("Is the queue empty?: " + pq_rev.isEmpty());
    }
}
