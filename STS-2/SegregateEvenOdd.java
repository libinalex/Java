import java.util.*;

public class SegregateEvenOdd {
    static class Node {
        int data;
        Node next;
    }

    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static Node segregateEvenOdd(Node head) {
        Node evenStart = null;
        Node evenEnd = null;
        Node oddStart = null;
        Node oddEnd = null;
        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode.data % 2 == 0) {
                if (evenStart == null) {
                    evenStart = currentNode;
                    evenEnd = currentNode;
                } else {
                    evenEnd.next = currentNode;
                    evenEnd = evenEnd.next;
                }
            } else {
                if (oddStart == null) {
                    oddStart = currentNode;
                    oddEnd = currentNode;
                } else {
                    oddEnd.next = currentNode;
                    oddEnd = oddEnd.next;
                }
            }
            currentNode = currentNode.next;
        }
        if (oddStart == null || oddEnd == null) {
            return head;
        }

        evenEnd.next = oddStart;
        oddEnd.next = null;
        head = evenStart;
        return head;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the no. of nodes in Linked List: ");
        int n = sc.nextInt();

        System.out.println("Input the elements of Linked List: ");
        Node head = new Node();
        head.data = sc.nextInt();
        Node temp = head;
        for (int i = 1; i < n; i++) {
            Node new_node = new Node();
            new_node.data = sc.nextInt();
            temp.next = new_node;
            temp = new_node;
        }
        printList(head);

        // Segregate even and odd nodes of Linked List
        head = segregateEvenOdd(head);
        System.out.println("Linked List after the segregation: ");
        printList(head);

        sc.close();
    }
}