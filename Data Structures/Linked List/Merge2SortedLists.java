
/* 
Merge two sorted linked lists and return it as a new list. 
The new list should be made by splicing together the nodes of the first two lists.

4
12 34 46 87
6
5 9 15 30 55 102
*/
import java.util.*;

public class Merge2SortedLists {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    static Node mergeLists(Node head1, Node head2) {
        Node head = new Node(-1);
        Node temp = head;
        
        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                temp.next = head1;
                head1 = head1.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }

        if (head1 != null)
            temp.next = head1;

        if (head2 != null)
            temp.next = head2;

        return head.next;
    }

    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of elements in 1st List: ");
        int n1 = sc.nextInt();
        System.out.println("Enter elements of 1st sorted list: ");
        int data = sc.nextInt();
        Node head1 = new Node(data);
        Node temp = head1;
        for (int i = 1; i < n1; i++) {
            data = sc.nextInt();
            Node new_node = new Node(data);
            temp.next = new_node;
            temp = temp.next;
        }

        System.out.println("Enter no. of elements in 2nd List: ");
        int n2 = sc.nextInt();
        System.out.println("Enter elements of 2nd sorted list: ");
        data = sc.nextInt();
        Node head2 = new Node(data);
        temp = head2;
        for (int i = 1; i < n2; i++) {
            data = sc.nextInt();
            Node new_node = new Node(data);
            temp.next = new_node;
            temp = temp.next;
        }
        sc.close();

        System.out.println("\nThe 2 given sorted Linked Lists are: ");
        printList(head1);
        printList(head2);

        System.out.println("\nNow merging the 2 sorted Lists...\n");
        Node head = mergeLists(head1, head2);
        System.out.println("List after merging the lists: ");
        printList(head);
    }
}
