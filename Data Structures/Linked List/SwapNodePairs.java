/* 
Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1 -> 2 -> 3 -> 4
you should return the list as: 2 -> 1 -> 4 -> 3

Your algorithm should use only constant space. 
You may not modify the values in the list, only nodes itself can be changed.

If odd no. of nodes, last node shouldn't be swapped.
1 - 2 - 3 - 4 - 5 - 6 - 7
2 - 1 - 4 - 3 - 6 - 5 - 7

*/


public class SwapNodePairs {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    static Node swapNodesInPair(Node head) {
        Node dummy = new Node(0);
        Node prev = dummy;
        Node p = head;
        dummy.next = head;
        while (p != null && p.next != null) {
            Node q = p.next;
            Node r = p.next.next;
            
            prev.next = q;
            q.next = p;
            p.next = r;
            
            prev = p;
            p = r;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node temp = head;
        temp.next = new Node(2);
        temp = temp.next;
        temp.next = new Node(3);
        temp = temp.next;
        temp.next = new Node(4);
        temp = temp.next;
        temp.next = new Node(5);
        temp = temp.next;
        temp.next = new Node(6);
        
        System.out.println("The input List is: ");
        printList(head);

        System.out.println("\nSwapping Nodes in pair now...\n");
        Node swapHead = swapNodesInPair(head);
        System.out.println("List after swapping: ");
        printList(swapHead);
    }
}
