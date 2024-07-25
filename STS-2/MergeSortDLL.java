import java.util.Scanner;

public class MergeSortDLL {
    static class Node {
        int data;
        Node next, prev;

        Node(int val) {
            data = val;
        }
    }

    public static Node split(Node head) {
        Node fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        Node temp = slow.next;
        slow.next = null;
        return temp;
    }

    public static Node mergeSort(Node node) {
        if (node == null || node.next == null)
            return node;
        Node right_node = split(node);
        node = mergeSort(node);
        right_node = mergeSort(right_node);
        return merge(node, right_node);
    }

    public static Node merge(Node head1, Node head2) {
        Node merged = new Node(-1);
        Node temp = merged;
        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                temp.next = head1;
                if (temp.data != -1)
                    head1.prev = temp;
                head1 = head1.next;
            } else {
                temp.next = head2;
                if (temp.data != -1)
                    head2.prev = temp;
                head2 = head2.next;
            }
            temp = temp.next;
        }
        while (head1 != null) {
            temp.next = head1;
            head1.prev = temp;
            head1 = head1.next;
            temp = temp.next;
        }
        while (head2 != null) {
            temp.next = head2;
            head2.prev = temp;
            head2 = head2.next;
            temp = temp.next;
        }
        return merged.next;
    }

    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the no. of nodes in the DLL: ");
        int n = sc.nextInt();

        // Creating the DLL:
        System.out.println("Enter the nodes: ");
        int head_val = sc.nextInt();
        Node head = new Node(head_val);
        Node temp = head;
        for (int i = 0; i < n - 1; i++) {
            int data = sc.nextInt();
            Node new_node = new Node(data);
            temp.next = new_node;
            new_node.prev = temp;
            temp = new_node;
        }
        System.out.print("Original Doubly Linked List: ");
        printList(head);

        head = mergeSort(head);
        System.out.print("Linked List after sorting: ");
        printList(head);

        sc.close();
    }
}
