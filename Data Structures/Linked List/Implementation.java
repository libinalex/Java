public class Implementation {

    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static class linkedList {  // custom Data Structure
        Node head = null;
        Node tail = null;

        // Method to insert a node at end
        void insertAtEnd(int data) {
            Node temp = new Node(data);
            if (head == null) { // if LL is empty
                head = temp;
                tail = temp;
            } else {
                tail.next = temp;
                tail = temp;
            }
        }

        // Method to insert a node at the beginning
        void insertAtBeginning(int data) {
            Node temp = new Node(data);
            if (head == null) { // if LL is empty
                head = tail = temp;
                
            } else {
                temp.next = head;
                head = temp;
            }
        }

        // To insert a node at any given index:
        void insert(int data, int index) {
            Node temp = new Node(data);

            if (index == size()) {
                insertAtEnd(data);
                return;
            }
            else if (index == 0) {
                insertAtBeginning(data);
                return;
            }
            else if (index < 0 || index > size()) {
                System.out.println("Wrong index");
                return;
            }

            Node t = head; // To traverese to the required index
            for (int i = 1; i < index; i++) {
                t = t.next;
            }

            temp.next = t.next;
            t.next = temp;
        }

        // To display the Linked List:
        void display() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }

        // To return the size of the List:
        int size() {
            Node temp = head;
            int size = 0;
            while (temp != null) {
                size++;
                temp = temp.next;
            }
            return size;
        }

        // To return the element at any given index of the List:
        int getElement(int index) {
            if (index < 0 || index > size()) {
                System.out.println("Wrong index");
                return -1;
            }

            Node t = head;
            for (int i = 0; i < index; i++) {
                t = t.next;
            }
            return t.data;
        }

        // To delete a node at a given index:
        void deleteAtIndex(int index) {
            if (index == 0) {
                head = head.next;
                return;
            }
             
            Node t = head;
            for (int i = 1; i < index; i++) {
                t = t.next;
            }
            t.next = t.next.next;
        }
    }
    public static void main(String[] args) {
        linkedList ll = new linkedList();
        ll.insertAtBeginning(3);
        ll.insertAtEnd(2);
        ll.insertAtEnd(8);
        ll.insertAtEnd(12);
        ll.insertAtEnd(5);

        ll.display();
        System.out.println("The size of the LL is: " + ll.size());
        
        ll.insertAtBeginning(6);
        ll.display();
        
        ll.insert(56, 0);
        ll.display();
        
        System.out.println("Element at 4th index: " + ll.getElement(4));
        
        ll.deleteAtIndex(0);
        ll.display();
    }
}
