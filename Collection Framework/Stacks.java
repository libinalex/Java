/*
Stack
• The stack is the subclass of Vector. 
• It implements the Last-In-First-Out data structure. 
• The stack contains all of the methods of Vector class and also provides its methods like push(), peek(), pop() and empty()

• Stack<data-type> object = new Stack ();

Stack Methods:
Method                           Description
empty()         The Boolean method checks the stack is empty or not.
push(E item)    The method pushes (insert) an element onto the top of the stack.
pop()           The method removes an element from the top of the stack and returns the same element as the value of that function.
peek()          The method looks at the top element of the stack without removing it.
search(Object o)   The method searches the specified object and returns the position of the object.
*/

import java.util.*;

public class Stacks {
    public static void main(String[] args) {
        
        Stack<Integer> stk = new Stack<>();     // creating an instance of Stack class
        
        System.out.println("Is the stack empty? " + stk.empty());  // checking if stack is empty or not
        
        stk.push(78);   // pushing elements into stack
        stk.push(113);
        stk.push(-4);
        stk.push(0);
        stk.push(90);
        stk.push(2);
        stk.push(12);
        System.out.println(stk);

        stk.pop();  // poping elements from stack
        System.out.println(stk.pop());
        System.out.println(stk);

        System.out.println("Is the stack empty? " + stk.isEmpty());

        System.out.println("Topmost element in stack: " + stk.peek());
        System.out.println("Size of stack: " + stk.size());

        System.out.println("Iterating the stack: ");
        for (int i : stk) {
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.println(stk);
        stk.add(3, 5);
        stk.remove(4);
        System.out.println(stk);
        System.out.println(stk.contains(0));
        System.out.println(stk.indexOf(11));
        System.out.println(stk.get(3));



    }
}

