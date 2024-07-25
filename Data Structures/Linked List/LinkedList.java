public class LinkedList {

    public static class Node {
        int data; // value
        Node next; // address of next node

        Node(int data) {
            this.data = data;
        }
    }
    
    // Method to print LL
    public static void display(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    // Method to print LL Recursively
    public static void displayRecursively(Node head) {
        if (head == null) { // base case
            return;
        }
        System.out.print(head.data + " ");
        displayRecursively(head.next);
    }

    // Method to print LL in reverse recursively
    public static void displayReverseRecursively(Node head) {
        if (head == null) { // base case
            return;
        }
        displayReverseRecursively(head.next);
        System.out.print(head.data + " ");
    }

    // Method to find the length of linked list
    public static int length(Node head) {
        int length = 0;
        while (head !=null) {
            length++;
            head = head.next;
        }
        return length;
    }

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(8);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;

        display(a);
        System.out.println();
        displayRecursively(a);
        System.out.println();
        displayReverseRecursively(a);
        System.out.println();

        System.out.println("The length of given LL is: " + length(a));
    }
}
