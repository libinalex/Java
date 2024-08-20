/* 
You are given two linked lists representing two non-negative numbers. 
The digits are stored in reverse order and each of their nodes contains a single digit. 
Add the two numbers and return it as a linked list.
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8

-> 342 + 465 = 807
*/

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

public class Add2Numbers {

    static Node addNumbers(Node head1, Node head2) {
        Node head = new Node(0);
        Node temp = head;
        int carry = 0;
        while (head1 != null || head2 != null) {
            int n1 = (head1 != null) ? head1.data : 0;
            int n2 = (head2 != null) ? head2.data : 0;

            int sum = n1 + n2 + carry;
            carry = sum / 10;
            sum = sum % 10;
        
            temp.next = new Node(sum);;
            temp = temp.next;

            if(head1 != null) head1 = head1.next;
            if(head2 != null) head2 = head2.next;
        }
        if (carry > 0) {
            temp.next = new Node(carry);;
        }
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
        Node head1 = new Node(9);
        Node temp = head1;
        temp.next = new Node(9);
        temp = temp.next;
        temp.next = new Node(9);
        
        Node head2 = new Node(9);
        temp = head2;
        // temp.next = new Node(9);
        // temp = temp.next;
        // temp.next = new Node(9);
        
        System.out.println("The two numbers(in reverse) are: ");
        printList(head1);
        printList(head2);

        System.out.println("Adding the 2 numbers...");
        Node head = addNumbers(head1, head2);
        System.out.println("The sum is: ");
        printList(head);
    }
}
