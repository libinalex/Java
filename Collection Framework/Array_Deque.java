/*
Doubly ended queue

METHOD                      DESCRIPTION

add(Element e)	        The method inserts a particular element at the end of the deque.
addAll​(Collection<? extends E> c)	Adds all of the elements in the specified collection at the end of this deque, as if by calling addLast(E) on each one, in the order that they are returned by the collection’s iterator.
addFirst(Element e)	    The method inserts particular element at the start of the deque.
addLast(Element e)  	The method inserts a particular element at the end of the deque. It is similar to the add() method
clear() 	    The method removes all deque elements.
clone()	        The method copies the deque.
contains(Obj)	The method checks whether a deque contains the element or not
element() 	    The method returns element at the head of the deque
forEach​(Consumer<? super E> action)	Performs the given action for each element of the Iterable until all elements have been processed or the action throws an exception.
getFirst()	    The method returns first element of the deque
getLast()	    The method returns last element of the deque
isEmpty()	    The method checks whether the deque is empty or not.
iterator()	    Returns an iterator over the elements in this deque.
offer(Element e)	    The method inserts element at the end of deque.
offerFirst(Element e) 	The method inserts element at the front of deque.
offerLast(Element e)	The method inserts element at the end of the deque.
peek()	        The method returns head element without removing it.
poll()	        The method returns head element and also removes it
pop()	        The method pops out an element for stack represented by deque
push(Element e)	The method pushes an element onto stack represented by deque
remove()	    The method returns head element and also removes it
remove​(Object o)	    Removes a single instance of the specified element from this deque.
removeAll​(Collection<?> c)	        Removes all of this collection’s elements that are also contained in the specified collection (optional operation).
removeFirst()	        The method returns the first element and also removes it
removeFirstOccurrence​(Object o)	Removes the first occurrence of the specified element in this deque (when traversing the deque from head to tail).
removeIf​(Predicate<? super Element> filter)	Removes all of the elements of this collection that satisfy the given predicate.
removeLast()	    The method returns the last element and also removes it
removeLastOccurrence​(Object o)	    Removes the last occurrence of the specified element in this deque (when traversing the deque from head to tail).
retainAll​(Collection<?> c)	        Retains only the elements in this collection that are contained in the specified collection (optional operation).
size()	        Returns the number of elements in this deque.
spliterator()	Creates a late-binding and fail-fast Spliterator over the elements in this deque.
toArray()	    Returns an array containing all of the elements in this deque in proper sequence (from first to the last element).
toArray​(T[] a)     	Returns an array containing all of the elements in this deque in proper sequence (from first to the last element); the runtime type of the returned array is that of the specified array.


containsAll(Collection c)	Returns true if this collection contains all of the elements in the specified collection.
toString()	    Returns a string representation of this collection.


containsAll(Collection c)	Returns true if this collection contains all of the elements in the specified collection.
equals()	        Compares the specified object with this collection for equality.
hashcode()	        Returns the hash code value for this collection.
parallelStream()	Returns a possibly parallel Stream with this collection as its source.
stream()	        Returns a sequential Stream with this collection as its source.
toArray​(IntFunction<T[]> generator)	    Returns an array containing all of the elements in this collection, using the provided generator function to allocate the returned array.
 

descendingIterator()	Returns an iterator over the elements in this deque in reverse sequential order.
peekFirst()	        Retrieves, but does not remove, the first element of this deque, or returns null if this deque is empty.
peekLast()	        Retrieves, but does not remove, the last element of this deque, or returns null if this deque is empty.
pollFirst()	        Retrieves and removes the first element of this deque, or returns null if this deque is empty.
pollLast()	        Retrieves and removes the last element of this deque, or returns null if this deque is empty.
*/


import java.util.*;

public class Array_Deque {
    public static void main(String[] args) {
        ArrayDeque<Integer> adq = new ArrayDeque<>();

        // offer, add -> add element at end
        // push, offerFirst -> add element at beginning
        adq.offer(23);
        adq.add(-3);
        adq.push(8);
        adq.offerFirst(7);
        adq.offerLast(45);
        adq.offer(254);
        adq.push(4);
        System.out.println(adq);

        // peek, get -> to check values at First or Last
        System.out.println(adq.peek());
        System.out.println(adq.peekLast());
        System.out.println(adq.peekFirst());
        System.out.println(adq.getFirst());
        System.out.println(adq.getLast());
        System.out.println(adq);


        // poll, remove -> delete element from First(default) or Last
        
        System.out.println(adq.poll());
        System.out.println(adq);
        System.out.println(adq.pollLast());
        System.out.println(adq);
        System.out.println(adq.pollFirst());
        System.out.println(adq);
        System.out.println(adq.remove());
        System.out.println(adq);
        System.out.println(adq.removeFirst());
        System.out.println(adq);
        System.out.println(adq.removeLast());
        System.out.println(adq);

    }
}