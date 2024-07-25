/* 
Queue Interface can be implemented by ArrayDeque, LinkedList or PriorityQueue

In queues, elements are removed in a particular order.
LinkedList -> FIFO
ArrayDeque -> both ends( Doubly Ended Queue)
PriorityQueue -> Max/Min

METHODS                   DESCRIPTION
add(element):    Adds an element to the rear of the queue. If the queue is full, it throws an exception.
offer(element):  Adds an element to the rear of the queue. If the queue is full, it returns false.
remove():        Removes and returns the element at the front of the queue. If the queue is empty, it throws an exception.
poll():          Removes and returns the element at the front of the queue. If the queue is empty, it returns null.
element():       Returns the element at the front of the queue without removing it. If the queue is empty, it throws an exception.
peek():          Returns the element at the front of the queue without removing it. If the queue is empty, it returns null.


*/

import java.util.*;

public class Queues {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        System.out.println(q.offer(12));
        System.out.println(q.add(7));
        q.offer(654);
        q.offer(38);
        q.offer(-3);
        q.add(12);
        q.offer(null);
        q.add(234);
        q.add(9);
        System.out.println(q);

        System.out.println(q.poll()); // returns the element removed
        System.out.println(q.poll());
        System.out.println(q.remove(12));  // returns true if element was present while removing, false otherwise
        System.out.println(q.remove(2));
        System.out.println(q.remove());

        System.out.println(q);
        System.out.println(q.peek());
        System.out.println(q.element());
        System.out.println(q);
    }
}
