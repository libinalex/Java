import java.util.*;

public class SortBitonicDLL {

    static class Node {
        int data;
        Node next;
        Node prev;
    };

    static Node sort(Node head) {
        if (head == null || head.next == null)
            return head;

        Node front = head;
        Node last = head;
        while (last.next != null)
            last = last.next;

        Node result = new Node();
        Node resultEnd = result;
        Node next;
        
        while (front != last) {
            if (last.data <= front.data) {
                resultEnd.next = last;
                next = last.prev;
                last.prev.next = null;
                last.prev = resultEnd;
                last = next;
                resultEnd = resultEnd.next;
            } else {
                resultEnd.next = front;
                next = front.next;
                front.next = null;
                front.prev = resultEnd;
                front = next;
                resultEnd = resultEnd.next;
            }
        }
        resultEnd.next = front;
        front.prev = resultEnd;
        return result.next;
    }

    static Node push(Node head_ref, int new_data) {
        Node new_node = new Node();
        new_node.data = new_data;
        new_node.prev = null;
        new_node.next = head_ref;
        if (head_ref != null)
            head_ref.prev = new_node;
        head_ref = new_node;
        return head_ref;
    }

    static void printList(Node head) {
        if (head == null)
            System.out.print("Doubly Linked list is empty");
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the no. of nodes in the DLL: ");
        int n = sc.nextInt();
        Node head = null;
        System.out.println("Enter the nodes: ");
        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            head = push(head, m);
        }
        printList(head);
        head = sort(head);
        System.out.println("After sorting:");
        printList(head);
    }
}